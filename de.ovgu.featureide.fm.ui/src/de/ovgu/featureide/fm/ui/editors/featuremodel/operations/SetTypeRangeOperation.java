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
package de.ovgu.featureide.fm.ui.editors.featuremodel.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;

/**
 * TODO description
 * 
 * @author abhisheksharma
 */
public class SetTypeRangeOperation extends AbstractFeatureModelOperation {

	private static final String LABEL = "Range";
	private Feature feature;
	private Object viewer;
	private Feature newFeature;
	private Object diagramEditor;
	private ClassificationFeature classificationfeature;

	public SetTypeRangeOperation(Feature feature,
			Object viewer, FeatureModel featureModel, Object diagramEditor) {
		super(featureModel, LABEL);
		this.feature = feature;
		this.viewer = viewer;
		this.diagramEditor = diagramEditor;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		redo();
		return Status.OK_STATUS;
	}

	@Override
	protected void redo() {
		classificationfeature = (ClassificationFeature)feature;
		this.classificationfeature.dataType = null;

	}

	@Override
	protected void undo() {
		String[] name = this.feature.getName().split("*");
		this.classificationfeature.setName(name[0].toString());
		
	}
}

