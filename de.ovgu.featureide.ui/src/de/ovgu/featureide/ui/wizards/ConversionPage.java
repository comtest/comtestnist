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
package de.ovgu.featureide.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.swt.widgets.Composite;

import de.ovgu.featureide.ui.UIPlugin;

/**
 * A dialog page for adding the FeatureIDE Nature.
 * 
 * @author Jens Meinicke
 */
@SuppressWarnings("restriction")
public class ConversionPage extends NewFeatureProjectPage {
	
	private IProject p;
	private static final String JAVA_NATURE = "org.eclipse.jdt.core.javanature";
	private static final String MESSAGE = "The build path is set to the java projects source path automatically";

	public ConversionPage(String project, IProject p) {
		super();
		setDescription("Adds the FeatureIDE nature to the project" + project + ".");
		this.p = p;
	}
	
	/* (non-Javadoc)
	 * @see de.ovgu.featureide.ui.wizards.NewFeatureProjectPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		setBuildPath();
	}

	/**
	 * Set the build path to the java projects build path
	 */
	private void setBuildPath() {
		try {
			if (p.hasNature(JAVA_NATURE)) {
				JavaProject javaProject = new JavaProject(p, null);
				for (IClasspathEntry entry : javaProject.getRawClasspath()) {
					if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						String path = entry.getPath().toOSString();
						String fileSeparator = System.getProperty("file.separator");
						
						if (path.contains(fileSeparator)) path = path.substring(path.indexOf(fileSeparator) + 1);
						if (path.contains(fileSeparator)) path = path.substring(path.indexOf(fileSeparator) + 1);
						
						buildPath.setText(path);
						buildPath.setEnabled(false);
						buildLabel.setToolTipText(MESSAGE);
						return;
					}
				}
			}
		} catch (CoreException e) {
			UIPlugin.getDefault().logError(e);
		}
	}
}
