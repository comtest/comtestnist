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
package de.ovgu.featureide.ui.mpl.wizards;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import de.ovgu.featureide.ui.mpl.actions.interfaces.BuildExtendedModulesAction;
import de.ovgu.featureide.ui.mpl.wizards.page.AbstractWizardPage;

/**
 * Wizard for the {@link BuildExtendedModulesAction}.
 * 
 * @author Reimar Schroeter
 */
public abstract class AbstractWizard extends Wizard implements IWorkbenchWizard {

	private final List<AbstractWizardPage> pages = new LinkedList<AbstractWizardPage>();
	private final Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public AbstractWizard(String title) {
		super();
		setWindowTitle(title);
	}
	
	protected abstract void initPages(List<AbstractWizardPage> pages);

	public final Object getData(String key) {
		return dataMap.get(key);
	}

	@Override
	public void addPages() {
		initPages(pages);
		for (AbstractWizardPage page : pages) {
			addPage(page);
		}
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		for (AbstractWizardPage page : pages) {
			page.putData(dataMap);
		}
		return true;
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}
