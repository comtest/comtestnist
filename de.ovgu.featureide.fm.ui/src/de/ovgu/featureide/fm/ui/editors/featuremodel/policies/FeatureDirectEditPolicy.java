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
package de.ovgu.featureide.fm.ui.editors.featuremodel.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.FeatureRenamingCommand;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.FeatureValueChangeCommand;

/**
 * Allows to rename features at the feature diagram.
 * 
 * @author Thomas Thuem
 */
public class FeatureDirectEditPolicy extends DirectEditPolicy {
	
	private final FeatureModel featureModel;

	private final Feature feature;
	
	public FeatureDirectEditPolicy(FeatureModel featureModel, Feature feature) {
		this.featureModel = featureModel;
		this.feature = feature;
	}
	
	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		//Abhi
		String newValue = (String) request.getCellEditor().getValue();
		if(feature.kind == FeatureKind.Class || feature.kind == FeatureKind.RangeClass) //Abhi
			return new FeatureValueChangeCommand(featureModel, feature, ((ClassFeature) feature).getValue(), newValue);
		else 
			return new FeatureRenamingCommand(featureModel, feature.getName(), newValue);
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
	}
	
}
