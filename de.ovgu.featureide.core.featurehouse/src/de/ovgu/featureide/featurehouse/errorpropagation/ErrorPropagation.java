/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2013  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.featurehouse.errorpropagation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.annotation.CheckForNull;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.ovgu.featureide.core.CorePlugin;
import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.core.fstmodel.FSTClass;
import de.ovgu.featureide.core.fstmodel.FSTField;
import de.ovgu.featureide.core.fstmodel.FSTMethod;
import de.ovgu.featureide.core.fstmodel.FSTModel;
import de.ovgu.featureide.core.fstmodel.FSTRole;
import de.ovgu.featureide.featurehouse.FeatureHouseCorePlugin;
import de.ovgu.featureide.fm.core.Feature;

/**
 * Propagates error markers for composed files to sources files.
 * @author Jens Meinicke
 */
public class ErrorPropagation {
	
	private static final String NO_ATTRIBUTE = "#NO_ATTRIBUTE#";

	/**
	 * A list containing composed files.
	 * These files will be checked for propagation. 
	 */
	/*
	 * TODO Fix problem with java.util.NoSuchElementException maybe volatile fixed it
	 * use a vector
	 * This list needs to be static else there are some problems with getFirst or
	 * get(0) because the element was not found. (This does not fixed the problem)
	 */
	private static volatile LinkedList<IFile> composedFiles = new LinkedList<IFile>();
	
	private synchronized IFile getComposedFile() {
		if (!composedFiles.isEmpty()) {
			IFile composedFile = composedFiles.getFirst();
			composedFiles.remove();
			return composedFile;
		}
		return null;
	}
	
	private void addComposedFile(IFile file) {
		composedFiles.add(file);
	}
	
	/**
	 * The main background job calling the corresponding error propagation class for each file. 
	 */
	public Job job = null;

	private int composedFilesSize = 0;
	
	/**
	 * Propagates error markers for composed files to sources files.<br>
	 * Call <code>addFile(sourceFile)</code> to propagate the markers of the 
	 * given source file, to the corresponding file at the features folder. 
	 */
	public ErrorPropagation() {
		
	}

	/**
	 * Propagates the markers of the given source file, to the corresponding file
	 * at the features folder. 
	 * @param sourceFile The composed file
	 */
	public void addFile(IFile sourceFile) {
		
		String fileExtension = sourceFile.getFileExtension();
		if (fileExtension == null) {
			return;
		}
		if ("java".equals(fileExtension) || "c".equals(fileExtension) ||
				"h".equals(fileExtension)) {
			if (!composedFiles.contains(sourceFile)) {
				addComposedFile(sourceFile);
				composedFilesSize++;
			}
			if (job == null) {
				job = new Job("Propagate problem markers for " + CorePlugin.getFeatureProject(sourceFile)) {
					@Override
					public IStatus run(IProgressMonitor monitor) {
						propagateMarkers(monitor);
						return Status.OK_STATUS;
					}
				};
				job.setPriority(Job.SHORT);
				job.schedule();
			}
			
			if (job.getState() == Job.NONE) {
				job.schedule();
			}
		}
	}

	/**
	 * Calls the corresponding propagation for all files at <code>composedFiles</code>.
	 */
	protected void propagateMarkers(IProgressMonitor monitor) {
		if (composedFiles.isEmpty()) {
			return;
		} 
		int worked = 0;
		int lastSize = composedFilesSize;
		monitor.beginTask("Propagate markers for", composedFilesSize);
		try {
			while (!composedFiles.isEmpty()) {
				if (monitor.isCanceled()) {
					break;
				}
				
				worked++;
				if (composedFilesSize == lastSize) {
					monitor.worked(1);
				} else {
					lastSize = composedFilesSize;
					monitor.beginTask("Propagate markers for", composedFilesSize);
					monitor.worked(worked);
				}
				
				IFile file = getComposedFile();
				monitor.subTask(file.getName());
				
				ErrorPropagation prop = getErrorPropagation(file);
				if (prop != null) {
					prop.propagateMarkers(file);
				}
			}
			composedFilesSize = 0;
		} catch (NoSuchElementException e) {
			FeatureHouseCorePlugin.getDefault().logError(e);
		}
	}

	/**
	 * Returns the corresponding error propagation class of the given file.
	 *
	 * @return The corresponding <code>ErrorPropagation</code>
	 */
	@CheckForNull
	private ErrorPropagation getErrorPropagation(IFile file) {
		String fileExtension = file.getFileExtension();
		if ("java".equals(fileExtension)) {
			return new JavaErrorPropagation();
		}
		if ("c".equals(fileExtension) || "h".equals(fileExtension)) {
			return new CErrorPropagation();
		} 
		return null;
	}

	/**
	 * Removes the  not composed markers form the given source file and calls <code>propagateMarkers(marker, file)</code>
	 */
	protected void propagateMarkers(IFile file) {
		if (!file.exists()) {
			return;
		}
		try {
			IMarker[] markers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
			if (markers.length != 0) {
				LinkedList<IMarker> marker = new LinkedList<IMarker>();
				for (IMarker m : markers) {
					String message = m.getAttribute(IMarker.MESSAGE, null);
					if (message == null || deleteMarker(message)) {
						m.delete();
					} else if (propagateMarker(m)) {
						marker.add(m);
					}
				}
				if (!marker.isEmpty()) {
					propagateMarkers(marker, file);
				}
			}
		} catch (CoreException e) {
			FeatureHouseCorePlugin.getDefault().logError(e);
		}
	}

	/**
	 * Necessary if a marker should not be removed but also should not be propagated.
	 * <br><code>Needs to be implemented by the Subclass.</code>
	 * @param marker
	 * @return <code>false</code> if the marker should not be propagated. 
	 */
	boolean propagateMarker(IMarker marker) {
		return true;
	}


	/**
	 * Necessary if a marker should be removed and also should not be propagated.
	 * <br><code>Needs to be implemented by the Subclass.</code>
	 * @param message
	 * @return <code>true</code> if the marker should not be removed.
	 */
	protected boolean deleteMarker(String message) {
		return false;
	}


	/**
	 * Propagates all markers of the given file
	 * @param markers
	 * @param file
	 */
	private void propagateMarkers(AbstractCollection<IMarker> markers, IFile file) {
		if (!file.exists()) {
			return;
		}

		String content = getFileContent(file);
		LinkedList<FSTField> fields = new LinkedList<FSTField>();
		LinkedList<FSTMethod> methods = new LinkedList<FSTMethod>();
		IFeatureProject project = CorePlugin.getFeatureProject(file);
		if (project == null) {
			return;
		}
		FSTModel model = project.getFSTModel();
		if (model == null) {
			return;
		}
		FSTClass fstClass = model.getClass(file.getName());
		if (fstClass == null) {
			return;
		}
		
		LinkedList<String> selectedFeatures = getSelectedFeatures(CorePlugin.getFeatureProject(file));
		for (FSTRole role : fstClass.getRoles()) {
			if (!selectedFeatures.contains(role.getFeature())) {
				continue;
			}
			for (FSTField field : role.getClassFragment().getFields()) {
				fields.add(field);
			}
			for (FSTMethod method : role.getClassFragment().getMethods()) {
				methods.add(method);
			}
		}
		
		setElementLines(content, fields, methods);

		for (IMarker marker : markers) {
			if (!marker.exists()) {
				continue;
			}
			
			if (marker.getAttribute(IMarker.MESSAGE, "").startsWith("The import")) {
				propagateUnsupportedMarker(marker, file);
				continue;
			}
			int markerLine = marker.getAttribute(IMarker.LINE_NUMBER, -1);
			if (markerLine == -1) {
				continue;
			}
			
			boolean propagated = false;
			for (FSTField f : fields) {
				if (f.getEndLine() == -1) {
					continue;
				}
				int composedLine = f.getComposedLine();
				if (markerLine >= composedLine
						&& markerLine <= composedLine
								+ (f.getEndLine() - f.getLine())) {
					propagateMarker(marker, f.getFile(), f.getLine()
							+ markerLine - composedLine);
					propagated = true;
					break;
				}
			}

			if (propagated) {
				continue;
			}

			for (FSTMethod m : methods) {
				if (m.getEndLine() == -1) {
					continue;
				}
				int composedLine = m.getComposedLine();
				if (markerLine >= composedLine && 
						markerLine <= composedLine + (m.getEndLine() - m.getLine())) {
					propagateMarker(marker, m.getFile(), m.getLine() + markerLine - m.getComposedLine());
					propagated = true;
					break;
				}
			}
			
			if (propagated) {
				continue;
			}
			
			propagateUnsupportedMarker(marker, file);
		}
	}
	
	// TODO refactor all occurrences of reading features of configurations
	private LinkedList<String> getSelectedFeatures(IFeatureProject featureProject) {
		if (featureProject == null)
			return null;

		final IFile iFile;
		LinkedList<String> list = new LinkedList<String>();
		iFile = featureProject.getCurrentConfiguration();
		
		if (iFile == null || !iFile.exists()) {
			return null;
		}
		
		File file = iFile.getRawLocation().toFile();
		LinkedList<String> configurationFeatures = readFeaturesfromConfigurationFile(file);
		if (configurationFeatures == null)
			return null;
		
		Collection<Feature> features = featureProject.getFeatureModel().getFeatures();
		for (String confFeature : configurationFeatures) {
			for (Feature feature : features) {
				if (feature.getName().equals(confFeature)) {
					list.add(feature.getName());
				}
			}
		}
		return list;
	}
	
	private LinkedList<String> readFeaturesfromConfigurationFile(File file) {
		LinkedList<String> list;
		Scanner scanner = null;
		if (!file.exists())
			return null;
		
		try {
			scanner = new Scanner(file, "UTF-8");
		} catch (FileNotFoundException e) {
			FeatureHouseCorePlugin.getDefault().logError(e);
		}

		if (scanner.hasNext()) {
			list = new LinkedList<String>();
			while (scanner.hasNext()) {
				list.add(scanner.next());
			}
			scanner.close();
			return list;
		} else {
			scanner.close();
			return null;
		}
	}

	/**
	 * Propagates markers outside of methods and fields. 
	 * <br><code>Needs to be implemented by the Subclass.</code>
	 */
	protected void propagateUnsupportedMarker(IMarker marker, IFile file) {
		FeatureHouseCorePlugin.getDefault().logInfo("Marker not propagated: " + marker.getAttribute(IMarker.MESSAGE, ""));
	}

	/**
	 * Sets the composed lines of the given fields and methods.
	 * <br><code>Needs to be implemented by the Subclass.</code>
	 * @param content The content of the composed file
	 */
	protected void setElementLines(String content,
			LinkedList<FSTField> fields, LinkedList<FSTMethod> methods) {
	}

	/**
	 * Propagates the given marker to the given source line
	 * @param marker The marker to propagate
	 * @param file The features file
	 * @param line The marker line at the features file
	 */
	protected void propagateMarker(IMarker marker, IFile file, int line) {
		if (file != null && file.exists()) {
			Object severity = null;
			String message = marker.getAttribute(IMarker.MESSAGE, NO_ATTRIBUTE);
			if (NO_ATTRIBUTE.equals(message)) {
				return;
			}
			try {
				severity = marker.getAttribute(IMarker.SEVERITY);
			} catch (CoreException e) {
				severity = IMarker.SEVERITY_ERROR;
			}
			if (!hasSameMarker(message,line,file)) {
				try {
					IMarker newMarker = file.createMarker(FeatureHouseCorePlugin.BUILDER_PROBLEM_MARKER);
					newMarker.setAttribute(IMarker.LINE_NUMBER, line);
					newMarker.setAttribute(IMarker.MESSAGE, message);
					newMarker.setAttribute(IMarker.SEVERITY, severity);
				} catch (CoreException e) {
					FeatureHouseCorePlugin.getDefault().logError(e);
				}
			}
		}
	}

	/**
	 * Checks if the file already the given marker.
	 */
	private boolean hasSameMarker(String message, int line, IFile file) {
		try {
			IMarker[] markers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
			for (IMarker m : markers) {
				if (m.getAttribute(IMarker.LINE_NUMBER, -1) == line) {
					if (m.getAttribute(IMarker.MESSAGE, "xxx").equals(message)) {
						return true;
					}
				}
			}
		} catch (CoreException e) {

		}
		return false;
	}

	/**
	 * Count the lines of the given substring.
	 */
	protected int countLines(String substring) {
		return (substring + " ").split("[\n]").length;
	}

	/**
	 * @return The content of the given file
	 */
	private String getFileContent(IFile file) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file.getRawLocation().toFile(), "UTF-8");
			StringBuffer buffer = new StringBuffer();
			if (scanner.hasNext()) {
				while (scanner.hasNext()) {
					buffer.append(scanner.nextLine());
					buffer.append('\n');
				}
			}
			return buffer.toString();
		} catch (FileNotFoundException e) {
			CorePlugin.getDefault().logError(e);
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return "";
	}
}
