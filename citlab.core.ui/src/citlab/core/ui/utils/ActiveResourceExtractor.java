/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.core.ui.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ActiveResourceExtractor {
	private static final String question = "Do you want to open the active file ?";

	public static IResource extractSelection(ISelection sel) {
		if (!(sel instanceof IStructuredSelection))
			return null;
		IStructuredSelection ss = (IStructuredSelection) sel;
		Object element = ss.getFirstElement();
		if (element instanceof IResource)
			return (IResource) element;
		if (!(element instanceof IAdaptable))
			return null;
		IAdaptable adaptable = (IAdaptable) element;
		Object adapter = adaptable.getAdapter(IResource.class);
		return (IResource) adapter;
	}

	public static IResource extractResource() {
		IEditorPart editorPart = ActiveResourceExtractor.extractEditorPart();
		if (editorPart == null)
			return null;
		IEditorInput input = editorPart.getEditorInput();
		if (!(input instanceof IFileEditorInput))
			return null;
		return ((IFileEditorInput) input).getFile();
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
	public static String citlFileSelect() {
	 String file = null;
		  MessageDialog open = new MessageDialog (Display.getCurrent().getActiveShell(), 	"File selection",null , question,MessageDialog.QUESTION_WITH_CANCEL, new String[]{
				IDialogConstants.YES_LABEL, 
				IDialogConstants.NO_LABEL, 
				IDialogConstants.CANCEL_LABEL}, 0);
				
		int choose=-1;
		if (ActiveResourceExtractor.extractResource() != null
				&& ActiveResourceExtractor.extractResource()
						.getFileExtension().equals("citl")
				) {
			choose=open.open();
			 if( choose==0){
			file = ActiveResourceExtractor.extractResource()
					.getLocation().toOSString();
			if (ActiveResourceExtractor.extractEditorPart().isDirty())
				if (  MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
						"File selection", "Do you want to apply the current changes to "
						+ ActiveResourceExtractor.extractResource()
								.getName() + "?"))
					ActiveResourceExtractor.extractEditorPart().doSave(
							new NullProgressMonitor());
		} 
		}
			 if( choose !=2 && choose !=0)  {

			FileDialog ComBFileSelection = new  FileDialog(Display.getCurrent().getActiveShell());
			
			initializedFileDialog(ComBFileSelection);
			file = ComBFileSelection.open();
		}
		return file;
	
	}

	public static String citlFileConversion() {
		String file = null;
		MessageDialog open = new MessageDialog (Display.getCurrent().getActiveShell(), 	"File selection",null , question,MessageDialog.QUESTION_WITH_CANCEL, new String[]{
					IDialogConstants.YES_LABEL, 
					IDialogConstants.NO_LABEL, 
					IDialogConstants.CANCEL_LABEL}, 0);
		
		//Path currentRelativePath = Paths.get("");
		String s = System.getProperty("user.dir");
		
					
		int choose=-1;
		if (ActiveResourceExtractor.extractResource() != null
				&& ActiveResourceExtractor.extractResource()
						.getFileExtension().equals("xml")
				) {
			
			choose = 0;

//			choose=open.open();
//			if( choose==0){
//				file = ActiveResourceExtractor.extractResource()
//					.getLocation().toOSString();
//				if (ActiveResourceExtractor.extractEditorPart().isDirty())
//					if (  MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
//						"File selection", "Do you want to apply the current changes to "
//								+ ActiveResourceExtractor.extractResource().getName() + "?"))
//						ActiveResourceExtractor.extractEditorPart().doSave(new NullProgressMonitor());
//				} 
		}
		
		if( choose !=2 && choose !=0)  {

			FileDialog ComBFileSelection = new  FileDialog(Display.getCurrent().getActiveShell());
			
			initializedFileDialog(ComBFileSelection);
			file = ComBFileSelection.open();
		}
		
		File tempFile = new File("/Users/waymantan/Desktop/citlfiles/Phone.citl");
		PrintWriter writer;
		try {
			writer = new PrintWriter(tempFile);
			writer.println("Model Phone");
			writer.println("Definitions:");
			writer.println("	Number threshold = 27;");
			writer.println("end"); 
			writer.println("Types:");
			writer.println("	EnumerativeType cameraType { 3MP 2MP 1MP NOC };");
			writer.println("end"); 
			writer.println("Parameters:");
			writer.println("	Boolean emailViewer;");
			writer.println("	Range textLines [ 25 .. 27 ];");
			writer.println("	Enumerative display { 16MC 8MC BW };");
			writer.println("	Enumerative rearCamera : cameraType;");
			writer.println("end"); 
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempFile.getAbsolutePath();
				
		// return file;
	
	}	
	
	private static void initializedFileDialog(FileDialog fileDialog) {
		fileDialog.setText("Select CitLab Model");
		final String[] extensions = { "*.citl" };
		fileDialog.setFilterExtensions(extensions);
		fileDialog.setFilterPath(Platform.getLocation().toOSString());

	}

}
