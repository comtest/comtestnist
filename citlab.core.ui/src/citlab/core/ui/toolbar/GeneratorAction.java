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
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import citlab.core.ext.ICitLabModelProcessor;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.ui.utils.ActiveResourceExtractor;
import citlab.core.ui.views.generator.GeneratorDialog;
import citlab.model.citL.CitModel;

public class GeneratorAction extends Action {
	private Shell parent;
	private IConfigurationElement extension;
	private CitModel citModel = null;
	

	public GeneratorAction(IConfigurationElement extension, Shell parent) {
		super();
		this.extension = extension;
		this.parent = parent;
		 Bundle bundle = Platform.getBundle("citlab.core.ui");

		    ImageDescriptor myImage = ImageDescriptor.createFromURL(
		          FileLocator.find(bundle,
		                           new Path("icons/g.gif"),
		                                    null));
	      this.setImageDescriptor(myImage);

	};

	@Override
	public void run() {

		//final String file = ActiveResourceExtractor.citlFileSelect();
		
		final String file = ActiveResourceExtractor.citlFileConversion();
		
		

		if (file != null && !file.equals(""))
			try {

				final Object o = extension
						.createExecutableExtension("GeneratorPrototype");

				if (o instanceof ICitLabTestGenerator) {
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
						GeneratorDialog genDialog = new GeneratorDialog(parent,0, citModel, extension);
						genDialog.open();

					} else
						showMessage("The citModel is not valid");
				}

			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
	}

	private void showMessage(String message) {
		MessageDialog.openError(parent, "Loading citModel error", message);
	}


}
