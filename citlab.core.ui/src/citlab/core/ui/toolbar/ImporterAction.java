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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import citlab.core.ext.ICitLabImporter;
import citlab.core.ui.views.importer.ImporterDialog;

public class ImporterAction extends Action {
	private Shell parent;
	private IConfigurationElement extension;

	public ImporterAction(IConfigurationElement e, Shell parent) {
		this.extension = e;
		this.parent = parent;
		
		 Bundle bundle = Platform.getBundle("citlab.core.ui");

		    ImageDescriptor myImage = ImageDescriptor.createFromURL(
		          FileLocator.find(bundle,
		                           new Path("icons/i.gif"),
		                                    null));
	      this.setImageDescriptor(myImage);

	}


	@Override
	public void run() {
		try {
			final Object o = extension
					.createExecutableExtension("ImporterPrototype");

			if (o instanceof ICitLabImporter) {
				ImporterDialog coderDialog = new ImporterDialog(parent,
						extension);
				coderDialog.open();

			} else
				showMessage("The importer class is not valid");

		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}

	}
	private void showMessage(String message) {
		MessageDialog.openError(parent,
				"Loading citModel error", message);
	}

}
