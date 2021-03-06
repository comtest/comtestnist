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
package de.ovgu.featureide.ui.mpl.wizards.page;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.ovgu.featureide.ui.mpl.wizards.WizardConstants;

/**
 * A dialog page to specify a feature name.
 * 
 * @author Sebastian Krieter
 */
public class ChooseFeaturePage extends AbstractWizardPage {

	private Text featureName;
	private Label featureLabel;

	private String featureNameString;

	public ChooseFeaturePage() {
		super("Choose Feature");
		setDescription("Choose a Feature");
		this.featureNameString = "";
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		container.setLayout(gridLayout);
		setControl(container);

		GridLayout projGridLayout = new GridLayout();
		projGridLayout.numColumns = 2;

		Group configGroup = new Group(container, SWT.NONE);
		configGroup.setText("");
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 1;

		configGroup.setLayoutData(gridData);
		configGroup.setLayout(projGridLayout);

		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalSpan = 1;
		gridData2.verticalSpan = 1;

		featureLabel = new Label(configGroup, 0);
		featureLabel.setText("Name of Feature: ");
		featureName = new Text(configGroup, SWT.BORDER | SWT.SINGLE);
		featureName.setText(featureNameString);
		featureName.setLayoutData(gridData2);
		addListeners();
		dialogChanged();
	}

	private void addListeners() {
		featureName.addKeyListener(new KeyPressedListener());
	}

	private class KeyPressedListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			dialogChanged();
		}
	}

	protected void dialogChanged() {
		featureNameString = featureName.getText();
		if (featureNameString.isEmpty()) {
			updateStatus("Enter a feature name");
		} else {
			updateStatus(null);
		}
	}

	protected void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	@Override
	public void putData(Map<String, Object> dataMap) {
		dataMap.put(WizardConstants.KEY_FEATURE, featureNameString);
		
	}
}
