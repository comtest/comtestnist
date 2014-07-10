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
package citlab.core.ui.toolbar;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import citlab.core.ext.ICitLabExporter;
import citlab.core.ext.ICitLabModelProcessor;
import citlab.core.ui.views.exporter.CoderDialog;
import citlab.core.ui.utils.ActiveResourceExtractor;
import citlab.model.citL.CitModel;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.FeatureModelWriterIFileWrapper;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelWriter;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.wizards.NewFeatureModelWizard;

public class CoderAction extends Action {
	private Shell parent;
	private IConfigurationElement extension;
	private CitModel citModel = null;
	

	public CoderAction(IConfigurationElement extension, Shell parent) {
		super();
		this.extension = extension;
		this.parent = parent;
		Bundle bundle = Platform.getBundle("citlab.core.ui");

		ImageDescriptor myImage = ImageDescriptor.createFromURL(FileLocator
				.find(bundle, new Path("icons/c.png"), null));
		this.setImageDescriptor(myImage);

	};

	@Override
	public void run() {

		final String file = ActiveResourceExtractor.citlFileSelect();
		if (file != null && !file.equals(""))
			try {

				final Object o = extension
						.createExecutableExtension("CoderPrototype");

				if (o instanceof ICitLabExporter) {
					ISafeRunnable runnable = new ISafeRunnable() {
						@Override
						public void handleException(Throwable exception) {
							System.out.println("Exception in client");
						}

						@Override
						public void run() throws Exception {
							citModel = ICitLabModelProcessor.getModel(file);

						}
					};
					SafeRunner.run(runnable);
					
					if (citModel != null) {
						CoderDialog genDialog = new CoderDialog(parent,citModel, extension,file.substring(0,file.lastIndexOf(File.separator)));
						genDialog.open();
					} else
						showMessage("The ComB CitModel is not valid");
					
					// Wayman debug
//					String path = file.substring(0,file.lastIndexOf(File.separator));
//					File tempFile = new File(path + File.separator + "newtree.xml");
//					
//					FeatureModel featureModel = new FeatureModel();
//					featureModel.createDefaultValues("");
//					featureModel.initFMComposerExtension(null);
//					
//					// wayman
//					new FeatureModelWriterIFileWrapper(new XmlClassificationTreeModelWriter(featureModel)).writeToFile(tempFile);
//					
//					// Refresh the project workspace in eclipse
//					IWorkspace workspace = ResourcesPlugin.getWorkspace();
//					IWorkspaceRoot root = workspace.getRoot();
//					List<IProject> prjs = Arrays.asList(root.getProjects());
//					if (prjs !=null)
//					for (IProject p : prjs){
//						try {
//							p.refreshLocal(IResource.DEPTH_INFINITE, null);
//						} catch (CoreException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
					
				}

			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		
	}

	private void showMessage(String message) {
		MessageDialog.openError(parent, "Loading citModel error", message);
	}

	

}
