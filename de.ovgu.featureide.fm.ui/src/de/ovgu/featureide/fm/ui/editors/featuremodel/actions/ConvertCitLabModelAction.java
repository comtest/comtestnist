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
package de.ovgu.featureide.fm.ui.editors.featuremodel.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Injector;

import citlab.model.citL.CitModel;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.citlabextension.CitLabModelConverter;
import de.ovgu.featureide.fm.core.citlabextension.UnconvertibleModelException;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.DeleteAllOperation;

/**
 * Action to convert to CitLab model
 * 
 * @author waymantan
 */
public class ConvertCitLabModelAction extends Action {

	private FeatureModel featureModel;
	private Object viewer;
	private static ImageDescriptor objectImage = PlatformUI.getWorkbench()
			.getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_OBJ_FILE);
	private Serializer SERIALIZER;

	/**
	 * 
	 * @param viewer
	 * @param featureModel
	 */
	public ConvertCitLabModelAction(Object viewer, FeatureModel featureModel) {
		super("Convert to CitLab Model");
		this.featureModel = featureModel;
		this.viewer = viewer;
		setImageDescriptor(objectImage);
		
		if (viewer instanceof TreeViewer)	
			((TreeViewer)viewer).addSelectionChangedListener(listener);
		else 
			((GraphicalViewerImpl)viewer).addSelectionChangedListener(listener);
		
		Injector injector = Guice
				.createInjector(new citlab.model.CitLRuntimeModule());
		SERIALIZER = injector.getInstance(Serializer.class);
	}
	
	private ISelectionChangedListener listener = new ISelectionChangedListener() {
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			setEnabled(isValidSelection(selection));
		}
	};
	
	private boolean isValidSelection(IStructuredSelection selection) {
		return true;
	}


	@Override
	public void run() {
//		DeleteAllOperation op = new DeleteAllOperation(featureModel, feature);
//
//		op.addContext((IUndoContext) featureModel.getUndoContext());
//
//		try {
//			PlatformUI.getWorkbench().getOperationSupport()
//					.getOperationHistory().execute(op, null, null);
//		} catch (ExecutionException e) {
//			FMUIPlugin.getDefault().logError(e);
//
//		}
		
		CitLabModelConverter citConverter = new CitLabModelConverter();
		try {
			CitModel citModel = citConverter.convertModel(featureModel);
//			String name = citModel.getName();
			saveModel(citModel);
		} catch (UnconvertibleModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveModel(CitModel model){
		IEditorPart  editorPart = extractEditorPart();
		if (editorPart == null) {
			// TODO throw exception
			return;
		}
		IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput() ;
	    IFile tempFile = input.getFile();
		IProject project = tempFile.getProject();
		IFolder folder = project.getFolder("src");
		IFile file = folder.getFile(model.getName()+".citl");
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
		byte[] bytes = SERIALIZER
				.serialize(model).getBytes();
	
		InputStream source = new ByteArrayInputStream(bytes);
		try {
			if(!file.exists())
			file.create(source, IResource.NONE, null);
			else{
				file.delete(true, null);
			file.create(source, IResource.FORCE, null);}

		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       try {
    	   IWorkbench wb = PlatformUI.getWorkbench();
    	   IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
    	   IDE.openEditor(win.getActivePage(), file);
       } catch (PartInitException e1) {
    	   // TODO Auto-generated catch block
    	   e1.printStackTrace();
       }
	}
	
	public static IEditorPart extractEditorPart(){
		IWorkbench iworkbench = PlatformUI.getWorkbench();
		if (iworkbench == null)
			return null;
		IWorkbenchWindow iworkbenchwindow = iworkbench
				.getActiveWorkbenchWindow();
		if (iworkbenchwindow == null)
			return null;
		IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
		if (iworkbenchpage == null)
			return null;
		IEditorPart editorPart = iworkbenchpage.getActiveEditor();
		return editorPart;
	}
}

