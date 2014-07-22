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
package de.ovgu.featureide.fm.ui.editors.featuremodel.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.LegendHideOperation;
import de.ovgu.featureide.fm.ui.properties.FMPropertyManager;

/**
 * Shows/hides the legend when executed.
 * 
 * @author Fabian Benduhn
 */
public class LegendAction extends Action {

	private final FeatureModel featureModel;

	public LegendAction(GraphicalViewerImpl viewer, FeatureModel featureModel) {
		super();
		this.featureModel = featureModel;
		if (!FMPropertyManager.isLegendHidden()) {
			this.setText("Hide Legend");
		} else {
			this.setText("Show Legend");
		}

	}

	@Override
	public void run() {
		LegendHideOperation op = new LegendHideOperation(featureModel);
		op.addContext((IUndoContext) featureModel.getUndoContext());

		try {
			PlatformUI.getWorkbench().getOperationSupport()
					.getOperationHistory().execute(op, null, null);
		} catch (ExecutionException e) {
			FMUIPlugin.getDefault().logError(e);
		}
	}

	public void refresh() {
		if (!FMPropertyManager.isLegendHidden()) {
			this.setText("Hide Legend");
		} else {
			this.setText("Show Legend");
		}
	}
}
