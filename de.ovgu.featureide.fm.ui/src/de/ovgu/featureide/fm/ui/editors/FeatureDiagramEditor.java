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
package de.ovgu.featureide.fm.ui.editors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.progress.UIJob;

import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.ConstraintAttribute;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.FeatureModelAnalyzer;
import de.ovgu.featureide.fm.core.FeatureStatus;
import de.ovgu.featureide.fm.core.PropertyConstants;
import de.ovgu.featureide.fm.core.StoppableJob;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.GUIDefaults;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.AbstractAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.AlternativeAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.AndAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.AutoLayoutConstraintAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.ChangeFeatureDescriptionAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.ConvertCitLabModelAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateClassLayerAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateClassificationLayerAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateCompositionLayerAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateCompoundAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateConstraintAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.CreateLayerAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.DeleteAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.DeleteAllAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.EditConstraintAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.HiddenAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.LayoutSelectionAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.LegendAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.LegendLayoutAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.MandatoryAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.OrAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.RenameAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.ReverseOrderAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.SelectionAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.SetTypeBooleanAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.SetTypeEnumAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.SetTypeIntegerAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.SetTypeRangeAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.ShowHiddenFeaturesAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.calculations.AutomatedCalculationsAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.calculations.ConstrainsCalculationsAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.calculations.FeaturesOnlyCalculationAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.calculations.RedundantConstrainsCalculationsAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.actions.calculations.RunManualCalculationsAction;
import de.ovgu.featureide.fm.ui.editors.featuremodel.editparts.GraphicalEditPartFactory;
import de.ovgu.featureide.fm.ui.editors.featuremodel.layouts.FeatureDiagramLayoutHelper;
import de.ovgu.featureide.fm.ui.editors.featuremodel.layouts.FeatureDiagramLayoutManager;
import de.ovgu.featureide.fm.ui.properties.FMPropertyManager;
import de.ovgu.featureide.fm.ui.views.outline.FmOutlinePage;

/**
 * An editor based on the Graphical Editing Framework to view and edit feature
 * diagrams and cross-tree constraints.
 * 
 * @author Thomas Thuem
 */
public class FeatureDiagramEditor extends ScrollingGraphicalViewer implements
		GUIDefaults, PropertyConstants, PropertyChangeListener,
		IFeatureModelEditorPage {

	private static final String PAGE_TEXT = "Feature Diagram";
	private static final String ID = FMUIPlugin.PLUGIN_ID
			+ ".editors.FeatureDiagramEditor";

	private FeatureModelEditor featureModelEditor;
	private ZoomManager zoomManager;

	private ScalableFreeformRootEditPart rootEditPart;

	private SetTypeIntegerAction setTypeIntegerAction; //Abhi
	private SelectionAction selectionAction;//Abhi
	private SetTypeEnumAction setTypeEnumAction; //Abhi
	private SetTypeBooleanAction setTypeBooleanAction; //Abhi
	private SetTypeRangeAction setTypeRangeAction; //Abhi
	private CreateLayerAction createLayerAction; //Abhi
	private CreateClassificationLayerAction createClassfiLayerAction; //Abhi
	private CreateClassLayerAction createClassLayerAction; //Abhi
	private CreateCompositionLayerAction createCompositionLayerAction; //Abhi
	//private CreateCompoundAction createCompoundAction;//Abhi
	private DeleteAction deleteAction;
	private DeleteAllAction deleteAllAction;
	//private MandatoryAction mandatoryAction; //Abhi
	private AbstractAction abstractAction;
	private HiddenAction hiddenAction;
	//private AndAction andAction; //Abhi
	//private OrAction orAction; //Abhi
	private AlternativeAction alternativeAction; //Abhi
	private RenameAction renameAction;
	private ConvertCitLabModelAction convertCitLabModelAction; //Wayman
	private ChangeFeatureDescriptionAction changeFeatureDescriptionAction;
	
	private ShowHiddenFeaturesAction showHiddenFeaturesAction;

	private ZoomInAction zoomIn;
	private ZoomOutAction zoomOut;

	// legend action replaced with property page
	private LegendAction legendAction;
	private LegendLayoutAction legendLayoutAction;

	private EditConstraintAction editConstraintAction;
	private CreateConstraintAction createConstraintAction;

	private ReverseOrderAction reverseOrderAction;

	private LinkedList<LayoutSelectionAction> setLayoutActions;

	private AutoLayoutConstraintAction autoLayoutConstraintAction;

	private int index;

	private Job analyzeJob;

	public FeatureDiagramEditor(FeatureModelEditor featureModelEditor,
			Composite container) {
		super();
		this.featureModelEditor = featureModelEditor;

		setKeyHandler(new GraphicalViewerKeyHandler(this));

		createControl(container);
		initializeGraphicalViewer();
		setEditDomain(new DefaultEditDomain(featureModelEditor));

		zoomManager = rootEditPart.getZoomManager();
		zoomManager.setZoomLevels(new double[] { 0.05, 0.10, 0.25, 0.50, 0.75,
				0.90, 1.00, 1.10, 1.25, 1.50, 2.00, 2.50, 3.00, 4.00 });
	}

	void initializeGraphicalViewer() {
		getControl().addControlListener(new ControlListener() {
			
			@Override
			/**
			 * used to remove the feature model when resizing the window
			 */
			public void controlResized(ControlEvent e) {
				// checks for null are necessary because we cannot prevent this
				// method may be called before the model is loaded correctly
				// (including positions in FeatureUIHelper)
				FeatureModel fm = getFeatureModel();
				if (fm == null)
					return;

				org.eclipse.draw2d.geometry.Point oldLoc = FeatureUIHelper
						.getLocation(fm.getRoot());
				if (oldLoc == null)
					return;
				
				internRefresh(true);

				org.eclipse.draw2d.geometry.Point newLoc = FeatureUIHelper
						.getLocation(fm.getRoot());
				if (newLoc == null)
					return;
				int difX = newLoc.x - oldLoc.x;
				
				//Abhi We do not want the Legend
				/*if (!FMPropertyManager.isLegendHidden()) {
					moveLegend(fm, difX);
				}*/

			}

			/**
			 * moves the legend for the editor associated with feature model fm
			 * horizontally (used to move the legend along with the model when resizing the window)
			 * 
			 * @param fm
			 * @param delta
			 */
			/*
			private void moveLegend(FeatureModel fm, int delta) {
				org.eclipse.draw2d.geometry.Point location = FeatureUIHelper
						.getLegendFigure(fm).getLocation();
				FeatureUIHelper.getLegendFigure(fm).setLocation(
						new org.eclipse.draw2d.geometry.Point(
								location.x + delta, location.y));
			}*/ 

			@Override
			public void controlMoved(ControlEvent e) {
				// do nothing

			}
		});
		getControl().setBackground(
				FMPropertyManager.getDiagramBackgroundColor());
		setEditPartFactory(new GraphicalEditPartFactory());
		rootEditPart = new ScalableFreeformRootEditPart();
		((ConnectionLayer) rootEditPart
				.getLayer(LayerConstants.CONNECTION_LAYER))
				.setAntialias(SWT.ON);
		setRootEditPart(rootEditPart);
	}

	public FeatureModel getFeatureModel() {
		return featureModelEditor.getFeatureModel();
	}

	public void createActions() {
		FeatureModel featureModel = getFeatureModel();

		createLayerAction = new CreateLayerAction(this, featureModel, null);//Abhi
		createClassfiLayerAction = new CreateClassificationLayerAction(this, featureModel, null); //Abhi
		createClassLayerAction = new CreateClassLayerAction(this, featureModel, null); //Abhi
		createCompositionLayerAction = new CreateCompositionLayerAction(this, featureModel, null); //Abhi
		setTypeIntegerAction = new SetTypeIntegerAction(this,featureModel,null);//Abhi
		setTypeEnumAction = new SetTypeEnumAction(this,featureModel,null);//Abhi
		setTypeBooleanAction = new SetTypeBooleanAction(this,featureModel,null);//Abhi
		setTypeRangeAction = new SetTypeRangeAction(this,featureModel,null);//Abhi
		//createCompoundAction = new CreateCompoundAction(this, featureModel,null); //Abhi
		//deleteAction = new DeleteAction(this, featureModel);
		deleteAllAction = new DeleteAllAction(this, featureModel);
		//mandatoryAction = new MandatoryAction(this, featureModel); //Abhi
		hiddenAction = new HiddenAction(this, featureModel);
		abstractAction = new AbstractAction(this, featureModel,
				(ObjectUndoContext) featureModel.getUndoContext());
		changeFeatureDescriptionAction = new ChangeFeatureDescriptionAction(this, featureModel, null);
		//andAction = new AndAction(this, featureModel); //Abhi
		//orAction = new OrAction(this, featureModel); //Abhi 
		alternativeAction = new AlternativeAction(this, featureModel); //Abhi
		renameAction = new RenameAction(this, featureModel, null);
		convertCitLabModelAction = new ConvertCitLabModelAction(this, featureModel); //Wayman

		selectionAction = new SelectionAction(this, featureModel);

		createConstraintAction = new CreateConstraintAction(this, featureModel);
		editConstraintAction = new EditConstraintAction(this, featureModel);
		reverseOrderAction = new ReverseOrderAction(this, featureModel);

		// legendAction = new LegendAction(this, featureModel);
		//legendLayoutAction = new LegendLayoutAction(this, featureModel);
		//legendAction = new LegendAction(this, featureModel);
		showHiddenFeaturesAction = new ShowHiddenFeaturesAction(this,
				featureModel);

		zoomIn = new ZoomInAction(zoomManager);
		zoomOut = new ZoomOutAction(zoomManager);

		setLayoutActions = new LinkedList<LayoutSelectionAction>();
		for (int i = 0; i < 5; i++) {
			setLayoutActions.add(new LayoutSelectionAction(this, featureModel,
					i, 0));
		}
		autoLayoutConstraintAction = new AutoLayoutConstraintAction(this,
				featureModel);
	}

	public void createContextMenu(MenuManager menu) {
		menu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				FeatureDiagramEditor.this.fillContextMenu(manager);
			}
		});
		menu.createContextMenu(getControl());
		setContextMenu(menu);
		// the following line adds package explorer entries into our context
		// menu
		// getSite().registerContextMenu(menu, graphicalViewer);
	}

	public void createKeyBindings() {
		KeyHandler handler = getKeyHandler();
		handler.put(KeyStroke.getPressed(SWT.F2, 0), renameAction);
		//handler.put(KeyStroke.getPressed(SWT.INSERT, 0), createLayerAction); //Abhi
		setKeyHandler(handler);
	}

	private void fillContextMenu(IMenuManager menu) {
		
		IMenuManager subMenuTypeSet = new MenuManager("Set Type");
		subMenuTypeSet.add(setTypeIntegerAction); //Abhi
		subMenuTypeSet.add(setTypeEnumAction);//Abhi
		subMenuTypeSet.add(setTypeBooleanAction);//Abhi
		subMenuTypeSet.add(setTypeRangeAction);//Abhi
		
		/*IMenuManager subMenuCalculations = new MenuManager("Set Calculations");
		subMenuCalculations.add(new AutomatedCalculationsAction(this, getFeatureModel()));
		subMenuCalculations.add(new RunManualCalculationsAction(this, getFeatureModel()));
		subMenuCalculations.add(new Separator());
		subMenuCalculations.add(new FeaturesOnlyCalculationAction(this, getFeatureModel()));
		subMenuCalculations.add(new ConstrainsCalculationsAction(this, getFeatureModel()));
		subMenuCalculations.add(new RedundantConstrainsCalculationsAction(this, getFeatureModel()));
		
		showHiddenFeaturesAction.setChecked(getFeatureModel().getLayout()
				.showHiddenFeatures());

		IMenuManager subMenuLayout = new MenuManager("Set Layout");
		for (int i = 0; i < setLayoutActions.size(); i++) {
			subMenuLayout.add(setLayoutActions.get(i));
			if (i == 0) {
				subMenuLayout.add(autoLayoutConstraintAction);
				subMenuLayout.add(new Separator());
			}
			boolean isChosen = (i == getFeatureModel().getLayout()
					.getLayoutAlgorithm());
			setLayoutActions.get(i).setChecked(isChosen);
			setLayoutActions.get(i).setEnabled(!isChosen);
		}
		*/ //Abhi we do not need these items.
		
		autoLayoutConstraintAction.setEnabled(!getFeatureModel().getLayout()
				.hasFeaturesAutoLayout());

		boolean connectionSelected = alternativeAction.isConnectionSelected();

		// don't show menu to change group type of a feature in case a
		// connection line is selected
		if (createLayerAction.isEnabled() 
				//|| createCompoundAction.isEnabled())
				&& !connectionSelected) {
			//menu.add(createCompoundAction); //Abhi
			//menu.add(createLayerAction);//Abhi
			menu.add(createClassfiLayerAction); //Abhi
			menu.add(createClassLayerAction);//Abhi
			menu.add(createCompositionLayerAction); //Abhi
			menu.add(createConstraintAction);
			menu.add(renameAction);
			//menu.add(deleteAction); //Abhi
			if(selectionAction.isNodeRangeClass == false)
				menu.add(deleteAllAction);
			menu.add(new Separator());
			//connectionEntrys(menu);//Abhi
			//menu.add(mandatoryAction); //Abhi
			menu.add(abstractAction);
			menu.add(hiddenAction);
			menu.add(changeFeatureDescriptionAction);
			menu.add(new Separator());
			menu.add(zoomIn); //Abhi
			menu.add(zoomOut); //Abhi
			//menu.add(subMenuLayout); //Abhi
			//menu.add(subMenuCalculations); //Abhi
			menu.add(new Separator());
			if(selectionAction.isClassificationNodeSelected == true && selectionAction.isTypeSet == false)
				menu.add(subMenuTypeSet);

			//menu.add(reverseOrderAction);
			//menu.add(legendAction);
		} else if (editConstraintAction.isEnabled() && !connectionSelected) {
			menu.add(createConstraintAction);
			menu.add(editConstraintAction);
			menu.add(deleteAction);
		} 
		
		/*else if (legendLayoutAction.isEnabled()) {
			//menu.add(legendLayoutAction);
			//menu.add(legendAction);
		} */
		
		else if(1==2){ //Abhi Purposeful Dead Code
		//else if (andAction.isEnabled() || orAction.isEnabled()
			//	|| alternativeAction.isEnabled()) {
			//connectionEntrys(menu);
		} else {
			menu.add(createConstraintAction);
			menu.add(new Separator());
			//menu.add(subMenuLayout);
			//menu.add(subMenuCalculations);
			menu.add(new Separator());
			//menu.add(reverseOrderAction);
			//menu.add(legendAction);
		}
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		if (featureModelEditor.getFeatureModel().hasHidden()) {
			menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			menu.add(showHiddenFeaturesAction);
		}
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		
		// Wayman: add the citlab conversion action to the menu
		menu.add(convertCitLabModelAction);
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

		// call of the FeatureDiagramExtensions (for features only)
		if (createLayerAction.isEnabled() 
				//|| createCompoundAction.isEnabled()) //Abhi
				&& !connectionSelected) {
			for (FeatureDiagramExtension extension : FeatureDiagramExtension
					.getExtensions()) {
				extension.extendContextMenu(menu, this);
			}
		}
	}

	/* Commented this Method coz I do Not Need it.
	 * private void connectionEntrys(IMenuManager menu) {
		if (andAction.isEnabled() || orAction.isEnabled()
				|| alternativeAction.isEnabled()) {
			boolean connectionSelected = alternativeAction.isConnectionSelected();
			if (andAction.isChecked()) {
				andAction.setText("And");
				if (connectionSelected)
					orAction.setText("Or (Double Click)");
				else
					orAction.setText("Or");
				alternativeAction.setText("Alternative");
			} else if (orAction.isChecked()) {
				andAction.setText("And");
				orAction.setText("Or");
				if (connectionSelected)
					alternativeAction.setText("Alternative (Double Click)");
				else
					alternativeAction.setText("Alternative");
			} else if (alternativeAction.isChecked()) {
				if (connectionSelected)
					andAction.setText("And (Double Click)");
				else
					andAction.setText("And");
				orAction.setText("Or");
				alternativeAction.setText("Alternative");
			}
			menu.add(andAction);
			menu.add(orAction);
			menu.add(alternativeAction);
			menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		}
	}*/

	public IAction getDiagramAction(String workbenchActionID) {
		//if (CreateLayerAction.ID.equals(workbenchActionID))
			//return createLayerAction; //Abhi
		
		if(CreateClassificationLayerAction.ID.equals(workbenchActionID))
			return createClassfiLayerAction; //Abhi
		
		if(CreateClassLayerAction.ID.equals(workbenchActionID))
			return createClassLayerAction; //Abhi

		if(CreateCompositionLayerAction.ID.equals(workbenchActionID))
			return createCompositionLayerAction; //Abhi 
		
		//if (CreateCompoundAction.ID.equals(workbenchActionID))
			//return createCompoundAction; //Abhi
		
		//if (DeleteAction.ID.equals(workbenchActionID))
			//return deleteAction; //Abhi
		
		//if (MandatoryAction.ID.equals(workbenchActionID)) //Abhi
			//return mandatoryAction;
		
		if (AbstractAction.ID.equals(workbenchActionID))
			return abstractAction;
		
		if (HiddenAction.ID.equals(workbenchActionID))
			return hiddenAction;
		
		//if (AndAction.ID.equals(workbenchActionID)) //Abhi
			//return andAction;
		
		//if (OrAction.ID.equals(workbenchActionID)) //Abhi
			//return orAction;
		
		if (AlternativeAction.ID.equals(workbenchActionID))
			return alternativeAction;
		
		if (RenameAction.ID.equals(workbenchActionID))
			return renameAction;
		
		if (GEFActionConstants.ZOOM_IN.equals(workbenchActionID))
			return zoomIn;
		
		if (GEFActionConstants.ZOOM_OUT.equals(workbenchActionID))
			return zoomOut;
		
		return null;
	}

	public void internRefresh(boolean onlyLayout) {
		if (getContents() == null)
			return;

		// TODO is this necessary?
		FmOutlinePage outline = featureModelEditor.getOutlinePage();
		if (!onlyLayout && outline != null) {
			outline.setInput(getFeatureModel());
		}

		// refresh size of all feature figures
		if (!onlyLayout)
			getContents().refresh();

		// layout all features if autoLayout is enabled
		setLayout();

		// refresh position of all feature figures
		if (!onlyLayout)
			getContents().refresh();
	}

	boolean waiting = false;

	private FeatureModelAnalyzer analyzer;

	public void refresh() {
		if (getFeatureModel() == null || getFeatureModel().getRoot() == null||getContents()==null) {
			return;
		}

		internRefresh(false);
		if (waiting) {
			return;
		}
		waiting = true;
		final boolean runAnalysis = featureModelEditor.getFeatureModel().getAnalyser().runCalculationAutomatically 
				&& featureModelEditor.getFeatureModel().getAnalyser().calculateFeatures;
		/**
		 * This extra job is necessary, else the UI will stop.
		 */
		Job waiter = new Job("Analyze feature model (waiting)") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				try {
					if (analyzeJob != null && analyzer != null) {
						// waiting for analyzing job to finish
						analyzer.cancel(true);
						analyzeJob.join();
					}
				} catch (InterruptedException e) {
					FMUIPlugin.getDefault().logError(e);
				} finally {
					// avoid a dead lock
					if (analyzer != null) {
						analyzer.cancel(false);
					}
					waiting = false;
				}
				analyzeJob = new StoppableJob("Analyze feature model") {

					@Override
					protected IStatus execute(IProgressMonitor monitor) {
						if (waiting) {
							return Status.OK_STATUS;
						}
						
						if (!runAnalysis) {
							UIJob refreshGraphics = new UIJob(
									"Updating feature model attributes") {

								@Override
								public IStatus runInUIThread(
										IProgressMonitor monitor) {
									for (Feature f : featureModelEditor.getFeatureModel().getFeatures()) {
										f.setFeatureStatus(FeatureStatus.NORMAL, true);
									}
									for (Constraint c : featureModelEditor.getFeatureModel().getConstraints()) {
										c.setConstraintAttribute(ConstraintAttribute.NORMAL, true);
									}
									getContents().refresh();
									return Status.OK_STATUS;
								}

							};
							refreshGraphics.setPriority(Job.SHORT);
							refreshGraphics.schedule();
							return Status.OK_STATUS;
						}
						
						analyzer = getFeatureModel().getAnalyser();

						final HashMap<Object, Object> changedAttributes = analyzer
								.analyzeFeatureModel(monitor);

						refreshGraphics(changedAttributes);

						monitor.subTask(null);
						monitor.done();
						monitor.setCanceled(true);
						return Status.OK_STATUS;
					}
				};
				analyzeJob.setPriority(Job.LONG);
				analyzeJob.schedule();
				return Status.OK_STATUS;
			}
		};
		waiter.setPriority(Job.DECORATE);
		waiter.schedule();
	}
	
	/**
	 * Refreshes the colors of the feature model.
	 * @param changedAttributes Result of analyis to only refresh special features, or null if all features should be refreshed.
	 */
	private void refreshGraphics(final HashMap<Object, Object> changedAttributes) {
		UIJob refreshGraphics = new UIJob(
				"Updating feature model attributes") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (changedAttributes == null) {
					for (Feature f : featureModelEditor.getFeatureModel().getFeatures()) {
						f.fire(new PropertyChangeEvent(this, ATTRIBUTE_CHANGED,	false, true));
					}
					for (Constraint c : featureModelEditor.getFeatureModel().getConstraints()) {
						c.fire(new PropertyChangeEvent(this, ATTRIBUTE_CHANGED, false, true));
					}
				} else {				
					for (Object f : changedAttributes.keySet()) {
						if (f instanceof Feature) {
							((Feature) f)
									.fire(new PropertyChangeEvent(this, ATTRIBUTE_CHANGED, Boolean.FALSE, true));
						} else if (f instanceof Constraint) {
							((Constraint) f) .fire(new PropertyChangeEvent(this, ATTRIBUTE_CHANGED, false, true));
						}
					}
				}

				// call refresh to redraw legend
				getContents().refresh();
				return Status.OK_STATUS;
			}

		};
		refreshGraphics.setPriority(Job.SHORT);
		refreshGraphics.schedule();
	}

	public void setLayout() {

		FeatureDiagramLayoutManager layoutManager;
		FeatureModel featureModel = getFeatureModel();

		layoutManager = FeatureDiagramLayoutHelper.getLayoutManager(
				featureModel.getLayout().getLayoutAlgorithm(), featureModel);

		int previousLayout = featureModel.getLayout().getLayoutAlgorithm();

		for (int i = 0; i < setLayoutActions.size(); i++) {
			setLayoutActions.set(i, new LayoutSelectionAction(this,
					featureModel, i, previousLayout));
		}

		Point size = getControl().getSize();

		layoutManager.setControlSize(size.x, size.y);
		layoutManager.layout(featureModel);

	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (GraphicalViewer.class.equals(adapter)
				|| EditPartViewer.class.equals(adapter))
			return this;
		if (ZoomManager.class.equals(adapter)) {
			return zoomManager;
		}
		if (CommandStack.class.equals(adapter))
			return getEditDomain().getCommandStack();
		if (EditDomain.class.equals(adapter))
			return getEditDomain();
		return null;
	}

	public void propertyChange(PropertyChangeEvent event) {
		String prop = event.getPropertyName();
		if (MODEL_DATA_CHANGED.equals(prop)) {
			setContents(getFeatureModel());
			refresh();
			featureModelEditor.setPageModified(true);
		} else if (MODEL_DATA_LOADED.equals(prop)) {
			refresh();
		} else if (MODEL_LAYOUT_CHANGED.equals(prop)) {
			featureModelEditor.setPageModified(true);
			refresh();
			refreshGraphics(null);
		} else if (REDRAW_DIAGRAM.equals(prop)) {
			getControl().setBackground(
					FMPropertyManager.getDiagramBackgroundColor());
			setContents(getFeatureModel());
			refresh();
			refreshGraphics(null);
		} else if (REFRESH_ACTIONS.equals(prop)) {
			refresh();
			refreshGraphics(null);
			// additional actions can be refreshed here
			// legendAction.refresh();
			//legendLayoutAction.refresh(); //abhi
		}

		for (IFeatureModelEditorPage page : featureModelEditor.extensionPages) {
			page.propertyChange(event);
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String getPageText() {
		return PAGE_TEXT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#initEditor()
	 */
	@Override
	public void initEditor() {
		createContextMenu();
		createActions();
		createKeyBindings();
	}

	private void createContextMenu() {
		MenuManager menu = new MenuManager("#PopupMenu");
		menu.setRemoveAllWhenShown(true);
		createContextMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#
	 * setFeatureModelEditor
	 * (de.ovgu.featureide.fm.ui.editors.FeatureModelEditor)
	 */
	@Override
	public void setFeatureModelEditor(FeatureModelEditor featureModelEditor) {
		this.featureModelEditor = featureModelEditor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#getPage()
	 */
	@Override
	public IFeatureModelEditorPage getPage(Composite container) {
		return new FeatureDiagramEditor(featureModelEditor, container);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#doSave(org.eclipse
	 * .core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#pageChangeFrom
	 * (int)
	 */
	@Override
	public void pageChangeFrom(int newPage) {
		if (newPage == getIndex()) {
			featureModelEditor.textEditor.updateDiagram();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#pageChangeTo
	 * (int)
	 */
	@Override
	public void pageChangeTo(int oldPage) {
		if (oldPage == featureModelEditor.textEditor.getIndex()) {
			if (!featureModelEditor.textEditor.updateDiagram()) {
				// there are errors in the file, stay at this editor page
				featureModelEditor.isPageModified = false;
				featureModelEditor
						.setActiveEditorPage(featureModelEditor.textEditor
							.getIndex());
				featureModelEditor.oldPageIndex=featureModelEditor.textEditor
						.getIndex();
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.ovgu.featureide.fm.ui.editors.IFeatureModelEditorPage#getID()
	 */
	@Override
	public String getID() {
		return ID;
	}

	/**
	 * Stops the analyzing job when the editor is closed.
	 */
	public void dispose() {
		if (analyzeJob != null) {
			analyzeJob.cancel();
		}
	}

}
