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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate;

public class ComBTbAction implements IWorkbenchWindowPulldownDelegate {

	private Shell parent;
	private MenuManager menuManager;
	private IConfigurationElement[] EX;
	private IWorkbenchWindow window;

	@Override
	public void dispose() {
		if (menuManager != null) {
			menuManager.dispose();
		}
	}

	@Override
	public void init(IWorkbenchWindow window) {
		parent = window.getShell();
		this.window = window;

	}

	@Override
	public void run(IAction action) {
		try {
		//	window.getActivePage().showView(
			//		"citlab.core.ui.views.Coders");
			window.getActivePage().showView(
					"citlab.core.ui.views.CitLabView");
		//	window.getActivePage().showView(
			//		"citlab.core.ui.views.Importers");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public Menu getMenu(Control parent) {
		createMenuManager();
		return menuManager.createContextMenu(parent);
	}

	private void createMenuManager() {
		if (menuManager == null) {

			menuManager = new MenuManager();
			menuManager.setRemoveAllWhenShown(true);
			menuManager.addMenuListener(new IMenuListener() {
				@Override
				public void menuAboutToShow(IMenuManager manager) {
					// wayman
					menuManager.add(new Separator("Alternative Editors"));
					ComBTbAction.this.fillContextMenuWithId(manager,
							"citlab.core.AlternativeEditors");
					menuManager.add(new Separator("Importers"));
					ComBTbAction.this.fillContextMenuWithId(manager,
							"citlab.core.importers");
					menuManager.add(new Separator("Generators"));
					ComBTbAction.this.fillContextMenuWithId(manager,
							"citlab.core.generators");
					menuManager.add(new Separator("Coders"));
					ComBTbAction.this.fillContextMenuWithId(manager,
							"citlab.core.coders");
					
				}

			});

		}

	}

	protected void fillContextMenuWithId(IMenuManager manager, String id) {
		EX = Platform.getExtensionRegistry().getConfigurationElementsFor(id);

		for (int i = 0; i < EX.length; i++) {
			if (EX[i] != null) {
				if (id.equals("citlab.core.generators")) {
					GeneratorAction generator = new GeneratorAction(EX[i],
							parent);
					generator.setText(EX[i].getAttribute("Name"));
					menuManager.add(generator);

				} else {
					if (id.equals("citlab.core.coders")) {
						CoderAction coder = new CoderAction(EX[i], parent);
						coder.setText(EX[i].getAttribute("Name"));
						menuManager.add(coder);
					}
					if (id.equals("citlab.core.importers")) {
						ImporterAction importer = new ImporterAction (EX[i], parent);
						importer.setText(EX[i].getAttribute("Name"));
						menuManager.add(importer);
					}
					// wayman
					if (id.equals("citlab.core.AlternativeEditors")) {
						AlternativeEditorAction alternativeEditor = new AlternativeEditorAction (EX[i], parent);
						alternativeEditor.setText(EX[i].getAttribute("Name"));
						menuManager.add(alternativeEditor);
					}
				}

			}
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
