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
 *   Wayman Tan - add this class
 ******************************************************************************/
package citlab.core.ui.toolbar;

/** alternative editor action in the CitLab platform 
 * Author: Wayman Tan
 */


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

import citlab.core.ext.ICitLabAlternativeEditor;
import citlab.core.ext.ICitLabExporter;
import citlab.core.ext.ICitLabImporter;
import citlab.core.ext.ICitLabModelProcessor;
import citlab.core.ui.views.alternativeeditor.AlternativeEditorDialog;
import citlab.core.ui.views.exporter.CoderDialog;
import citlab.core.ui.views.importer.ImporterDialog;
import citlab.core.ui.utils.ActiveResourceExtractor;
import citlab.model.citL.CitModel;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.FeatureModelWriterIFileWrapper;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelWriter;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.wizards.NewFeatureModelWizard;

public class AlternativeEditorAction extends Action {
	private Shell parent;
	private IConfigurationElement extension;
	
	public AlternativeEditorAction(IConfigurationElement extension, Shell parent) {
		super();
		this.extension = extension;
		this.parent = parent;
		Bundle bundle = Platform.getBundle("citlab.core.ui");

		ImageDescriptor myImage = ImageDescriptor.createFromURL(FileLocator
				.find(bundle, new Path("icons/i.gif"), null));
		this.setImageDescriptor(myImage);

	};

	@Override
	public void run() {
		try {
			final Object o = extension
					.createExecutableExtension("AlternativeEditorPrototype");

			if (o instanceof ICitLabAlternativeEditor) {
				AlternativeEditorDialog alternativeEditorDialog = new AlternativeEditorDialog(parent, extension);
				alternativeEditorDialog.open();

			} else
				showMessage("The alternative editor class is not valid");

		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}		
	}

	private void showMessage(String message) {
		MessageDialog.openError(parent, "Loading citModel error", message);
	}

	

}
