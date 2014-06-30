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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.FeatureCreateClassLayerOperation;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.FeatureCreateClassificationLayerOperation;


/**
 * TODO description
 * 
 * @author abhisheksharma
 */
public class CreateClassLayerAction extends SingleSelectionAction{

	public static final String ID = "de.ovgu.featureide.createlayer1";

	private static ImageDescriptor createImage = PlatformUI.getWorkbench()
			.getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);

	private final FeatureModel featureModel;

	private Object diagramEditor;

	public CreateClassLayerAction(Object viewer,
			FeatureModel featureModel, Object diagramEditor) {
		super("Create Class Node", viewer);
		setImageDescriptor(createImage);
		this.featureModel = featureModel;
		this.diagramEditor = diagramEditor;
	}

	@Override
	public void run() {
		//New 
		FeatureCreateClassLayerOperation op = new FeatureCreateClassLayerOperation(
				feature, viewer, featureModel, diagramEditor); //Abhi
		op.addContext((IUndoContext) featureModel.getUndoContext());

		try {
			PlatformUI.getWorkbench().getOperationSupport()
					.getOperationHistory().execute(op, null, null);
		} catch (ExecutionException e) {
			FMUIPlugin.getDefault().logError(e);
		}
	}

	@Override
	protected boolean isValidSelection(IStructuredSelection selection) {
		return super.isValidSelection(selection);
	}

	@Override
	protected void updateProperties() {
		setEnabled(feature.kind == FeatureKind.Classification); //Abhi
		setChecked(false);
	}

}
