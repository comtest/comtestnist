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
package de.ovgu.featureide.fm.ui.editors.featuremodel.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.ui.PlatformUI;

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureConnection;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.PropertyConstants;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.FeatureUIHelper;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.renaming.FeatureCellEditorLocator;
import de.ovgu.featureide.fm.ui.editors.featuremodel.commands.renaming.FeatureLabelEditManager;
import de.ovgu.featureide.fm.ui.editors.featuremodel.figures.FeatureFigure;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.FeatureSetMandatoryOperation;
import de.ovgu.featureide.fm.ui.editors.featuremodel.policies.FeatureDirectEditPolicy;

/**
 * An editpart for features. It implements the <code>NodeEditPart</code> that
 * the models of features can provide connection anchors.
 * 
 * @author Thomas Thuem
 */
public class FeatureEditPart extends AbstractGraphicalEditPart implements
		NodeEditPart, PropertyConstants, PropertyChangeListener {

	public FeatureEditPart(Feature feature) {
		super();

		setModel(feature);
	}

	public Feature getFeature() {
		return (Feature) getModel();
	}

	public FeatureFigure getFeatureFigure() {
		return (FeatureFigure) getFigure();
	}

	@Override
	protected IFigure createFigure() {
		return new FeatureFigure(getFeature(), ((ModelEditPart) getParent())
				.getFeatureModel());
	}

	@Override
	protected void createEditPolicies() {
		FeatureModel featureModel = ((ModelEditPart) getParent())
				.getFeatureModel();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new FeatureDirectEditPolicy(featureModel, getFeature()));
	}

	private DirectEditManager manager;

	public void showRenameManager() {
		if (manager == null) {
			ModelEditPart parent = (ModelEditPart) getParent();
			FeatureModel featureModel = parent.getFeatureModel();
			manager = new FeatureLabelEditManager(this, TextCellEditor.class,
					new FeatureCellEditorLocator(getFeatureFigure()),
					featureModel);
		}
		manager.show();
	}

	@Override
	public void performRequest(Request request) {
		
		for (Constraint constraint : getFeature().getFeatureModel().getConstraints()){
			if (constraint.isFeatureSelected()) constraint.setFeatureSelected(false);
		}
		
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			showRenameManager();
		}
		
		/*else if (request.getType() == RequestConstants.REQ_OPEN) 
		{
			Feature feature = getFeature();
			if (feature.isRoot() || !feature.getParent().isAnd()) 
			{
				return;
			}
			FeatureModel featureModel = ((ModelEditPart) this.getParent())
			.getFeatureModel();
			FeatureSetMandatoryOperation op = new FeatureSetMandatoryOperation(feature,featureModel);
			op.addContext((IUndoContext) featureModel.getUndoContext());
			try {
				PlatformUI.getWorkbench().getOperationSupport()
						.getOperationHistory().execute(op, null, null);
			} catch (ExecutionException e) {
				FMUIPlugin.getDefault().logError(e);

			}

			featureModel.handleModelDataChanged();
		} */ //Abhi We do not need this
		else if (request.getType() == RequestConstants.REQ_SELECTION) 
		{
			for (Constraint partOf : getFeature().getRelevantConstraints()){
				partOf.setFeatureSelected(true);
			}
		}
	}

	@Override
	protected List<FeatureConnection> getModelSourceConnections() {
		return ((Feature) getModel()).getSourceConnections();
	}

	@Override
	protected List<FeatureConnection> getModelTargetConnections() {
		return ((Feature) getModel()).getTargetConnections();
	}

	public ConnectionAnchor getSourceConnectionAnchor(
			org.eclipse.gef.ConnectionEditPart connection) {
		return ((FeatureFigure) figure).getSourceAnchor();
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((FeatureFigure) figure).getSourceAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(
			org.eclipse.gef.ConnectionEditPart connection) {
		return ((FeatureFigure) figure).getTargetAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((FeatureFigure) figure).getTargetAnchor();
	}

	@Override
	public void activate() {
		getFeature().addListener(this);
		super.activate();
	}

	@Override
	public void deactivate() {
		super.deactivate();
		getFeature().removeListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String prop = event.getPropertyName();
		if (LOCATION_CHANGED.equals(prop)) {
			getFeatureFigure().setLocation((Point) event.getNewValue());
			for (FeatureConnection connection : getFeature()
					.getTargetConnections()) {
				Map<?, ?> registry = getViewer().getEditPartRegistry();
				ConnectionEditPart connectionEditPart = (ConnectionEditPart) registry
						.get(connection);
				if (connectionEditPart != null) {
					connectionEditPart.refreshSourceDecoration();
					connectionEditPart.refreshTargetDecoration();
					//connectionEditPart.refreshToolTip(); //Abhi 
				}
			}
		} else if (CHILDREN_CHANGED.equals(prop)) {
			getFeatureFigure().setProperties();			
			for (FeatureConnection connection : getFeature()
					.getTargetConnections()) {
				Map<?, ?> registry = getViewer().getEditPartRegistry();
				ConnectionEditPart connectionEditPart = (ConnectionEditPart) registry
						.get(connection);
				if (connectionEditPart != null) {
					connectionEditPart.refreshSourceDecoration();
					connectionEditPart.refreshTargetDecoration();
					//connectionEditPart.refreshToolTip(); //Abhi
				}
			}
		} else if (NAME_CHANGED.equals(prop)) {
			getFeatureFigure().setName(getFeature().getName());
			FeatureUIHelper.setSize(getFeature(), getFeatureFigure()
					.getSize());
		} else if (ATTRIBUTE_CHANGED.equals(prop)) {
			getFeatureFigure().setProperties();
		}
		//Abhi
		else if(VALUE_CHANGED.equals(prop))
		{
			getFeatureFigure().setName(((ClassFeature)getFeature()).getValue());
			FeatureUIHelper.setSize(getFeature(), getFeatureFigure()
					.getSize());
		}
		//Abhi
	}

}
