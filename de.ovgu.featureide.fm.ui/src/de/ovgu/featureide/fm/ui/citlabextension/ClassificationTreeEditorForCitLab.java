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
package de.ovgu.featureide.fm.ui.citlabextension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import citlab.core.ext.ICitLabAlternativeEditor;
import citlab.core.ext.InvalidAlternativeEditorException;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.FeatureModelWriterIFileWrapper;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelWriter;
import de.ovgu.featureide.fm.ui.FMUIPlugin;

/**
 * TODO description
 * 
 * @author waymantan
 */
public class ClassificationTreeEditorForCitLab extends ICitLabAlternativeEditor { 
	/* (non-Javadoc)
	 * @see citlab.core.ext.ICitLabAlternativeEditor#openEditor(java.lang.String, java.lang.String)
	 */
	@Override
	public void openEditor(String projectName, String fileName)
			throws InvalidAlternativeEditorException {
		FeatureModel featureModel = new FeatureModel();
		featureModel.createDefaultValues("");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		IFolder folder = project.getFolder("src");
		// create an XML file for the new classification tree
		IFile file = folder.getFile(fileName + ".xml");
		if (!project.exists())
			try {
				project.create(null);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (!project.isOpen())
			try {
				project.open(null);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (!folder.exists())
			try {
				folder.create(IResource.NONE, true, null);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		try {
			if(file.exists()) {
				file.delete(true, null);
			} 
				
			featureModel.initFMComposerExtension(file.getProject());
			try {
				new FeatureModelWriterIFileWrapper(new XmlClassificationTreeModelWriter(featureModel)).writeToFile(file);
				file.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				FMUIPlugin.getDefault().logError(e);
			}
			open(file);

		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		
//		try {
//    	   IWorkbench wb = PlatformUI.getWorkbench();
//    	   IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//    	   IDE.openEditor(win.getActivePage(), file);
//    	} catch (PartInitException e1) {
//    		// TODO Auto-generated catch block
//    		e1.printStackTrace();
//    	}
		
	}
	
	private void open(IFile file) {
		IWorkbenchWindow dw = FMUIPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow();
		IWorkbenchPage page = dw.getActivePage();
		if (page != null) {
			IContentType contentType = null;
			try {
				IContentDescription description = file
						.getContentDescription();
				if (description != null) {
					contentType = description.getContentType();
				}
				IEditorDescriptor desc = null;
				if (contentType != null) {
					desc = PlatformUI.getWorkbench().getEditorRegistry()
							.getDefaultEditor(file.getName(), contentType);
				} else {
					desc = PlatformUI.getWorkbench().getEditorRegistry()
							.getDefaultEditor(file.getName());
				}

				if (desc != null) {
					page.openEditor(new FileEditorInput(file), desc.getId());
				}
			} catch (CoreException e) {
				FMUIPlugin.getDefault().logError(e);
			}
		}
	}

}

