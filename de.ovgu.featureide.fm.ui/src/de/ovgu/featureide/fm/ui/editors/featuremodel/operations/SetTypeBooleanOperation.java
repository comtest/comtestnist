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
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureConstants;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.renaming.FeatureCellEditorLocator;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.renaming.FeatureLabelEditManager;
import de.ovgu.featureide.fm.ui.editors.featuremodel.editparts.FeatureEditPart;
import de.ovgu.featureide.fm.ui.editors.featuremodel.layouts.FeatureDiagramLayoutHelper;

/**
 * TODO description
 * 
 * @author abhisheksharma
 */
public class SetTypeBooleanOperation extends AbstractFeatureModelOperation {

	private static final String LABEL = "Boolean";
	private Object viewer;
	private Feature feature;
	private Object diagramEditor;
	private Feature newFeature1;
	private Feature newFeature2;
	private ClassificationFeature classificationfeature;

	public SetTypeBooleanOperation(Feature feature,
			Object viewer, FeatureModel featureModel, Object diagramEditor) {
		super(featureModel, LABEL);
		this.viewer = viewer;
		this.diagramEditor = diagramEditor;
		this.feature = feature;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		redo();
		return Status.OK_STATUS;
	}

	@Override
	protected void redo() {
		
		
		
		
		/*
		 * the model must be refreshed here else the new feature will not be found
		 */
		//featureModel.handleModelDataChanged();
		
		int number = 0;
	
		while (featureModel.getFeatureNames().contains("ClassNode" + ++number));
		
		//Create True Node
		newFeature1 = new ClassFeature(featureModel, "ClassNode" + number); //Abhi
		((ClassFeature) newFeature1).setValue("true");
	
		featureModel.addFeature(newFeature1);
		feature = featureModel.getFeature(feature.getName());
		feature.addChild(newFeature1);
		FeatureDiagramLayoutHelper.initializeLayerFeaturePosition(featureModel, newFeature1, feature);
		
		/*
		 * the model must be refreshed here else the new feature will not be found
		 */
		featureModel.handleModelDataChanged();

		// Create False Node
		newFeature2 = new ClassFeature(featureModel, "ClassNode" + number); //Abhi
		((ClassFeature) newFeature2).setValue("false");
	
		featureModel.addFeature(newFeature2);
		feature = featureModel.getFeature(feature.getName());
		feature.addChild(newFeature2);
		FeatureDiagramLayoutHelper.initializeLayerFeaturePosition(featureModel, newFeature2, feature);
		
		this.classificationfeature.setDataType(FeatureConstants.TYPE_BOOLEAN); //Abhi
		/*
		 * the model must be refreshed here else the new feature will not be found
		 */
		featureModel.handleModelDataChanged();
		
	}


	@Override
	protected void undo() {
		this.classificationfeature.setDataType(null);
		
		newFeature1 = featureModel.getFeature(newFeature1.getName());
		featureModel.deleteFeature(newFeature1);
		
		newFeature2 = featureModel.getFeature(newFeature2.getName());
		featureModel.deleteFeature(newFeature2);
	}
}
