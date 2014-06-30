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
package de.ovgu.featureide.ui.actions.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.ovgu.featureide.ui.UIPlugin;

/**
 * This {@link Job} compiles all configurations of the corresponding {@link Generator}
 * 
 * @author Jens Meinicke
 */
// TODO use compiler of the given project directly
public class Compiler extends Job implements IConfigurationBuilderBasics {

	private Generator generator;
	private int compiled = 0;

	/**
	 * The parent folder of the generated variants
	 */
	private IFolder tmp;

	private boolean finish;

	/**
	 * @param name
	 */
	public Compiler(int nr, Generator generator) {
		super(nr == 0 ? "Compiler" : "Compiler nr. " + nr);
		this.generator = generator;
		
		tmp = generator.builder.tmp.getFolder(getName());
		if (!tmp.exists()) {
			try {
				tmp.create(true, true, null);
			} catch (CoreException e) {
				UIPlugin.getDefault().logError(e);
			}
		}
	}

	/**
	 * The main method of this {@link Job}. 
	 * It compiles all configurations that are composed by the corresponding {@link Generator}.
	 * 
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		while (true) {
			synchronized (this) {
				if (generator.builder.cancelGeneratorJobs || monitor.isCanceled()) {
					return Status.OK_STATUS;
				}
				
				if (generator.configurations.isEmpty() || generator.builder.cancelGeneratorJobs) {
					monitor.setTaskName(compiled + " produrcts compiled. (Waiting)");
					while (generator.configurations.isEmpty()) {
						/** the job waits for a new configuration to build **/
						try {
							wait(100);
							if ((finish && generator.configurations.isEmpty()) ||
									generator.builder.cancelGeneratorJobs ||
									monitor.isCanceled()) {
								return Status.OK_STATUS;
							}
						} catch (InterruptedException e) {
							UIPlugin.getDefault().logError(e);
						}
					}
				}
			}
			BuilderConfiguration c = generator.getConfiguration();
			if (c == null) {
				continue;
			}
			monitor.setTaskName(compiled + " produrcts compiled. (Running)");
			if (generator.builder.buildType == ConfigurationBuilder.BuildType.ALL_VALID) {
				try {
					generator.builder.folder.getFolder(CONFIGURATION_NAME + c.getName()).refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException e) {
					UIPlugin.getDefault().logError(e);
				}
				compile(CONFIGURATION_NAME + c.getName(), tmp);
			} else {
				try {
					generator.builder.folder.getFolder(c.getName()).refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException e) {
					UIPlugin.getDefault().logError(e);
				}
				compile(c.getName(), tmp);
			}
			monitor.setTaskName(++compiled + " produrcts compiled. (Running)");
		}
	}

	/**
	 * This method is called if the {@link Generator} is finished. 
	 * Then the {@link Compiler} will end if all configurations are processed.
	 */
	void finish() {
		finish = true;
	}

	/**
	 * Compiles the built configuration to create error markers.
	 * The binary files will be placed into an temporary folder.
	 * @param confName
	 */
	void compile(String confName, IFolder tmpFolder) {	
		LinkedList<IFile> files = getJavaFiles(generator.builder.folder.getFolder(confName));
		LinkedList<String> options = new LinkedList<String>();
		options.add("javac");
		options.add("-g");
		options.add("-Xlint");
		options.add("-d");
		options.add(tmpFolder.getRawLocation().toOSString());
		options.add("-classpath");
		options.add(generator.builder.classpath);
		for (IFile file : files) {
			options.add(file.getRawLocation().toOSString());
		}
		
		String output = process(options);
		files = parseJavacOutput(output, files, confName);
		for (IFile file : files) {
			generator.builder.featureProject.getComposer().postCompile(null, file);
		}
	}
	
	private String process(AbstractList<String> command) {
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		BufferedReader input = null;
		BufferedReader error = null;
		StringBuilder output = new StringBuilder();
		try {
			Process process = processBuilder.start();
			input = new BufferedReader(new InputStreamReader(
					process.getInputStream(), Charset.availableCharsets().get("UTF-8")));
			error = new BufferedReader(new InputStreamReader(
					process.getErrorStream(), Charset.availableCharsets().get("UTF-8")));
			boolean x = true;
			while (x) {
				try {
					String line;
					while ((line = input.readLine()) != null) {
						output.append(line);
						output.append("\r\n");
					}
					while ((line = error.readLine()) != null) {
						output.append(line);
						output.append("\r\n");
					}
					try {
						process.waitFor();
					} catch (InterruptedException e) {
						UIPlugin.getDefault().logError(e);
					}
					x = false;
				} catch (IllegalThreadStateException e) {
					UIPlugin.getDefault().logError(e);
				}
			}
		} catch (IOException e) {
//			UIPlugin.getDefault().logError(e);
		} finally {
			try {
				if(input!=null)input.close();
			} catch (IOException e) {
				UIPlugin.getDefault().logError(e);
			} finally {
				if(error!=null)
					try {
						error.close();
					} catch (IOException e) {
						UIPlugin.getDefault().logError(e);
					}
			}
		}
		return output.toString();
	}

	/**
	 * Generates the problem markers from the given compiler output. 
	 * @param output The output from the compiler
	 * @param files The compiled files
	 * @param configurationName Name of the actual configuration
	 * @return 
	 */
	public LinkedList<IFile> parseJavacOutput(String output, LinkedList<IFile> files, String configurationName) {
		LinkedList<IFile> errorFiles = new LinkedList<IFile>();
		if (output.length() == 0)
			return errorFiles;
		TreeMap<String, IFile> sourcePaths = new TreeMap<String, IFile>();
		for (IFile file : files)
			sourcePaths.put(file.getRawLocation().toOSString(), file);

		Scanner scanner = new Scanner(output);
		String currentLine;
		while (scanner.hasNextLine()) {
			currentLine = scanner.nextLine();

			Matcher matcher = errorMessagePattern.matcher(currentLine);
			if (!matcher.find() || !sourcePaths.containsKey(matcher.group(1)))
				continue;
			IFile currentFile = sourcePaths.get(matcher.group(1));
			int line = Integer.parseInt(matcher.group(2));

			String errorMessage = matcher.group(3).substring(1);

			if (CANNOT_FIND_SYMBOL.equals(errorMessage)) {
				errorMessage = parseCannotFindSymbolMessage(scanner);
			}
			if (errorMessage.contains(ERROR_IGNOR_RAW_TYPE) || errorMessage.contains(ERROR_IGNOR_CAST) 
					|| errorMessage.contains(ERROR_IGNOR_SERIIZABLE) 
					|| errorMessage.contains(ERROR_IGNOR_DEPRECATION)) {
				continue;
			}
			if (!errorFiles.contains(currentFile)) {
				errorFiles.add(currentFile);
			}
			IMarker newMarker;
			try {
				newMarker = currentFile.createMarker(PROBLEM_MARKER);
				if (newMarker.exists()) {
					newMarker.setAttribute(IMarker.LINE_NUMBER, line);
					newMarker.setAttribute(IMarker.MESSAGE, configurationName + " " + errorMessage);
					newMarker.setAttribute(IMarker.SEVERITY, errorMessage.contains("warning") ? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_ERROR);
				}
			} catch (CoreException e) {
				UIPlugin.getDefault().logError(e);
			}
		}
		return errorFiles;
	}

	private String parseCannotFindSymbolMessage(Scanner scanner) {
		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			if (currentLine.startsWith("symbol")) {
				String[] tokens = currentLine.split(": ");
				if (tokens.length == 2)
					return CANNOT_FIND_SYMBOL + ": "+ tokens[1];
				break;
			}
		}
		return CANNOT_FIND_SYMBOL;
	}

	/**
	 * Looks for all java files at the given folder.
	 * @param folder The folder containing the java files
	 * @return A list with all java files at the folder
	 */
	private LinkedList<IFile> getJavaFiles(IFolder folder) {
		LinkedList<IFile> files = new LinkedList<IFile>();
		try {
			for (IResource res : folder.members()) {
				if (res instanceof IFolder) {
					files.addAll(getJavaFiles((IFolder)res));
				} else if ("java".equals(res.getFileExtension())) {
					files.add((IFile)res);
				}
			}
		} catch (CoreException e) {
			UIPlugin.getDefault().logError(e);
		}
		return files;
	}
	
}
