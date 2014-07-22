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

import java.util.List;

import de.ovgu.featureide.ui.mpl.MPLUIPlugin;
import de.ovgu.featureide.ui.mpl.wizards.page.AbstractWizardPage;
import de.ovgu.featureide.ui.mpl.wizards.page.ChooseFolderPage;
import de.ovgu.featureide.ui.mpl.wizards.page.InterfacePage;

/**
 * A wizard for creating MPL interfaces.
 * 
 * @author Reimar Schroeter
 */
public class FeatureInterfaceWizard extends AbstractWizard {
	public static final String ID = MPLUIPlugin.PLUGIN_ID + ".wizards.InterfaceWizard";
	
	private final String defaultFolderString;
	
	public FeatureInterfaceWizard(String title) {
		this(title, null);
	}
	
	public FeatureInterfaceWizard(String title, String defaultFolderString) {
		super(title);
		this.defaultFolderString = defaultFolderString;
	}

	@Override
	protected void initPages(List<AbstractWizardPage> pages) {
		pages.add(new InterfacePage());
		if (defaultFolderString != null) {
			pages.add(new ChooseFolderPage(defaultFolderString));
		}
	}
}
