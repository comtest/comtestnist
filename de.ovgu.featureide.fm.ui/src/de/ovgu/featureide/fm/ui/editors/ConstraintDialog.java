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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.internal.dialogs.ViewComparator;
import org.prop4j.Node;
import org.prop4j.NodeReader;
import org.prop4j.NodeWriter;
import org.prop4j.Not;
import org.prop4j.SatSolver;
import org.sat4j.specs.TimeoutException;

import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.core.FeatureConstants;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.FeatureStatus;
import de.ovgu.featureide.fm.core.Operator;
import de.ovgu.featureide.fm.core.editing.Comparison;
import de.ovgu.featureide.fm.core.editing.ModelComparator;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.GUIDefaults;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.ConstraintCreateOperation;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.ConstraintEditOperation;
import de.ovgu.featureide.fm.ui.views.featuremodeleditview.ViewContentProvider;

/**
 * A simple editor for propositional constraints written below the feature
 * diagram.
 * 
 * @author Christian Becker
 * @author Thomas Thuem
 * @author David Broneske
 * @author Fabian Benduhn
 */
public class ConstraintDialog implements GUIDefaults {



	private static final String FILTERTEXT = "type filter text";
	private Shell shell;

	private String initialConstraint;

	private Label errorMarker;
	private Text errorMessage;
	private String titleText;
	private String headerText;
	private Group featureGroup;
	private StyledText searchFeatureText;
	//Commented as we do not use this. We have featureTree now
	//private Table featureTable;
	//Change
	private Tree featureTree;

	private Group buttonGroup;
	private Composite constraintTextComposite;
	private Text constraintText;
	//Abhi
	private Text constraintTextforCitLab;
	private FeatureModel featureModel;
	private int x, y;
	private Button okButton;
	private Constraint constraint;

	/**
	 * 
	 * @param featuremodel
	 * @param constraint
	 */
	public ConstraintDialog(final FeatureModel featuremodel,
			final Constraint constraint) {
		this.constraint = constraint;
		this.featureModel = featuremodel;

		if (constraint == null) {
			titleText = "Create Propositional Constraint";
			headerText = "Create new Constraint";
			initialConstraint = "";

		} else {
			titleText = "Edit Propositional Constraint";
			headerText = "Edit your Constraint";

			initialConstraint = constraint.getConstraintText(); 
					
			//Abhi: We do not need this since we are showing actual constraint text to the user		
			//constraint.getNode().toString(
			//NodeWriter.textualSymbols);
		}

		initShell();
		initHead();
		initFeatureGroup(featuremodel);
		initButtonGroup();
		initConstraintText();
		initBottom(featuremodel, constraint);
		printHeaderText(headerText);
		constraintText.setFocus();
		constraintText.setSelection(constraintText.getCharCount());
		shell.open();
		if (constraint != null)
		{}
			//Abhi: Client decided to validate on CitLab Side
			//validate();
	}

	/**
	 * initializes the shell
	 */
	private void initShell() {
		shell = new Shell(Display.getCurrent());
		shell.setText(titleText);
		shell.setImage(FEATURE_SYMBOL);
		shell.setSize(550, 520);
		GridLayout shellLayout = new GridLayout();
		//FillLayout shellLayout = new FillLayout();
		shellLayout.marginWidth = 0;
		shellLayout.marginHeight = 0;
		shell.setLayout(shellLayout);

		Monitor primary = shell.getDisplay().getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);
		shell.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_ESCAPE) {

					shell.close();

				}
			}
		});
	}

	/**
	 * initializes the bottom part of the dialog
	 * 
	 * @param featuremodel
	 * @param constraint
	 */
	private void initBottom(final FeatureModel featuremodel,
			final Constraint constraint) {
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);

		Composite lastComposite = new Composite(shell, SWT.NONE);
		lastComposite.setLayoutData(gridData);

		FormLayout lastCompositeLayout = new FormLayout();
		lastCompositeLayout.marginHeight = 5;
		lastCompositeLayout.marginTop = 85;
		lastCompositeLayout.marginWidth = 5;
		lastComposite.setLayout(lastCompositeLayout);
		ToolBar helpButtonBar = new ToolBar(lastComposite, SWT.FLAT);
		ToolItem helpButton = new ToolItem(helpButtonBar, SWT.NONE);
		helpButton.setImage(HELP_IMAGE);
		helpButton
		.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(
					org.eclipse.swt.events.SelectionEvent e) {
				Program.launch("http://www.cs.utexas.edu/~schwartz/ATS/fopdocs/guidsl.html");
			}
		});
		FormData formDataHelp = new FormData();
		formDataHelp.left = new FormAttachment(0, 5);
		helpButtonBar.setLayoutData(formDataHelp);

		Button cancelButton = new Button(lastComposite, SWT.NONE);
		cancelButton.setText("Cancel");
		FormData formDataCancel = new FormData();
		formDataCancel.width = 70;
		formDataCancel.right = new FormAttachment(100, -5);
		formDataCancel.bottom = new FormAttachment(100, -5);
		cancelButton.setLayoutData(formDataCancel);

		okButton = new Button(lastComposite, SWT.NONE);
		okButton.setText("OK");
		FormData formDataOk = new FormData();
		formDataOk.width = 70;
		formDataOk.right = new FormAttachment(cancelButton, -5);
		formDataOk.bottom = new FormAttachment(100, -5);
		okButton.setLayoutData(formDataOk);
		shell.setTabList(new Control[] { featureGroup, buttonGroup,
				constraintTextComposite, lastComposite });

		lastComposite.setTabList(new Control[] { okButton, cancelButton });
		okButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {

				closeShell();

			}

		});
		cancelButton
		.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(
					org.eclipse.swt.events.SelectionEvent e) {

				shell.dispose();
			}
		});

	}

	/**
	 * initializes the upper part of the dialog
	 */
	private void initHead() {
		Composite headComposite = new Composite(shell, SWT.NONE);
		headComposite.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		headComposite.setLayoutData(gridData);

		GridLayout headLayout = new GridLayout();
		headLayout.numColumns = 3;
		headComposite.setLayout(headLayout);

		final Label capture = new Label(headComposite, SWT.NONE);
		FontData fontData = capture.getFont().getFontData()[0];
		Font font = new Font(shell.getDisplay(), new FontData(
				fontData.getName(), 11, SWT.NONE));
		capture.setFont(font);
		capture.setText("Constraint");
		capture.setBackground(shell.getDisplay()
				.getSystemColor(SWT.COLOR_WHITE));

		gridData = new GridData();
		gridData.horizontalSpan = 2;
		capture.setLayoutData(gridData);
		Label imageLabel = new Label(headComposite, SWT.RIGHT | SWT.DOWN);
		imageLabel.setImage(BANNER_IMAGE);
		imageLabel.setBackground(shell.getDisplay().getSystemColor(	SWT.COLOR_WHITE));
		gridData = new GridData(GridData.FILL_VERTICAL | GridData.END
				| GridData.HORIZONTAL_ALIGN_END | GridData.VERTICAL_ALIGN_END);
		gridData.widthHint = 90;
		gridData.verticalSpan = 3;
		imageLabel.setLayoutData(gridData);

		errorMarker = new Label(headComposite, SWT.NONE);
		gridData = new GridData(GridData.BEGINNING);
		gridData.widthHint = 20;
		gridData.heightHint = 20;
		gridData.verticalSpan = 2;
		errorMarker.setBackground(shell.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		errorMarker.setLayoutData(gridData);

		errorMessage = new Text(headComposite, SWT.MULTI);
		errorMessage.setEditable(false);
		errorMessage.setBackground(shell.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalSpan = 2;

		errorMessage.setLayoutData(gridData);
	}

	/**
	 * initializes the Text containing the constraint
	 */
	private void initConstraintText() {
		constraintTextComposite = new Composite(shell, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);

		constraintTextComposite.setLayoutData(gridData);
		FormLayout constraintTextLayout = new FormLayout();
		constraintTextComposite.setLayout(constraintTextLayout);
		constraintText = new Text(constraintTextComposite, SWT.SINGLE | SWT.H_SCROLL 
				| SWT.BORDER);

		//Abhi
		constraintTextforCitLab = new Text(constraintTextComposite, SWT.SINGLE | SWT.BORDER);

		//Abhi _ Not using the adapter currently. We will try to do this later.
		/*ContentProposalAdapter adapter = new ContentProposalAdapter(
				constraintText, new ConstraintContentAdapter(),
				new ConstraintContentProposalProvider(
						featureModel.getFeatureNames()), null, null); //TODO:Abhi -- We need to change code her to getFeature Names we need.


		adapter.setAutoActivationDelay(500);
		adapter.setPopupSize(new Point(250, 85));
		adapter.setLabelProvider(new ConstraintProposalLabelProvider());
		 */

		FormData formDataConstraintText = new FormData();
		formDataConstraintText.right = new FormAttachment(100, -5);
		formDataConstraintText.left = new FormAttachment(0, 5);
		constraintText.setLayoutData(formDataConstraintText);
		constraintText.setText(initialConstraint);
		//Abhi
		constraintText.setEditable(true); //Temporarily set this as False so the User Doesn't know
		constraintText.addListener(SWT.FocusOut, new Listener() {

			@Override
			public void handleEvent(Event event) {

				x = constraintText.getSelection().x;
				y = constraintText.getSelection().y;

			}

		});

		constraintText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				//Abhi: Client decided to validate on CitLab Side
				//validate();

			}

		});

	}

	/**
	 * initializes the Group containing the operator buttons
	 */
	private void initButtonGroup() {
		buttonGroup = new Group(shell, SWT.NONE);
		buttonGroup.setText("Operators");
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		buttonGroup.setLayoutData(gridData);
		GridLayout buttonGroupLayout = new GridLayout();
		buttonGroupLayout.numColumns = 7;
		buttonGroup.setLayout(buttonGroupLayout);

		for (int i = 0; i < Operator.NAMES.length; i++) {

			final Button button = new Button(buttonGroup, SWT.PUSH);
			button.setText(Operator.NAMES[i]);
			//Abhi - We do not want this.
			//button.setGrayed(true);
			gridData = new GridData(GridData.FILL_HORIZONTAL);
			button.setLayoutData(gridData);

			//TODO: Abhi. We need to provide for this. 
			button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

				public void widgetSelected(
						org.eclipse.swt.events.SelectionEvent e) {

					String[] data = constraintText.getText().split(" ");

					if(!Operator.isOperatorName(data[data.length - 1]))
					{
						//Abhi
						StringBuilder tempforBackEnd = new StringBuilder(constraintTextforCitLab.getText());
						StringBuilder tempforFrontEnd = new StringBuilder(constraintText.getText());

						tempforFrontEnd.delete(x, y);

						tempforBackEnd.append(button.getText().toLowerCase(Locale.ENGLISH) + " ");

						tempforFrontEnd.append(button.getText().toLowerCase(Locale.ENGLISH) + " ");

						//temp.insert(x > y ? y : x, /*
						//							 * " " +
						//							 */button.getText().toLowerCase(Locale.ENGLISH) + " "
						//
						///* .replaceAll(" ", "") + " " */);

						constraintTextforCitLab.setText(tempforBackEnd.toString());
						constraintText.setText(tempforFrontEnd.toString()); //NodeReader.reduceWhiteSpaces(temp.toString()));

						constraintText.setFocus();
						constraintText.setSelection(constraintText.getCharCount());

						//Abhi: Client decided to validate on CitLab Side
						//validate();
					}
					else
					{
						printHeaderError("Already selected a Operator. Please select an appropriate Class Node");
					}
				}
			});

		}

	}

	/**
	 * initializes the group containing the searchText and featureTable
	 * 
	 * @param featuremodel
	 */
	private void initFeatureGroup(final FeatureModel featuremodel) {

		featureGroup = new Group(shell, SWT.NONE);
		//Abhi
		featureGroup.setText("Classification Tree:");

		/*GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;*/
		//featureGroup.setLayoutData() 
		GridLayout featureGroupLayout = new GridLayout();
		featureGroupLayout.numColumns = 1;
		featureGroup.setLayout(featureGroupLayout);

		
		searchFeatureText = new StyledText(featureGroup, SWT.SINGLE | SWT.LEFT
				| SWT.BORDER);
		searchFeatureText.setText(FILTERTEXT);
		searchFeatureText.setForeground(shell.getDisplay().getSystemColor(
				SWT.COLOR_GRAY));


		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		searchFeatureText.setLayoutData(gridData);


		Composite tableComposite = new Composite(featureGroup, SWT.NONE);	
		//Abhi
		//tableComposite.setEnabled(false);
		//gridData = new GridData(GridData.FILL_HORIZONTAL);
		//gridData.grabExcessHorizontalSpace = true;
		//gridData.grabExcessVerticalSpace = true;
		//tableComposite.setLayoutData(new FillLayout());



		//Abhi
		//PatternFilter filter = new PatternFilter();
		//featureTree = new FilteredTree(tableComposite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL, filter,  true);

		final TreeViewer featureTreeViewer = new TreeViewer(tableComposite, SWT.FILL_EVEN_ODD | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		featureTreeViewer.setContentProvider(new ViewContentProvider1()); //Need to change here
		featureTreeViewer.setLabelProvider(new ViewLabelProvider1());

		featureTreeViewer.setInput(featureModel.getClassificationNodeList());

		//gridData = new GridData(GridData.FILL_HORIZONTAL);
		//gridData.grabExcessVerticalSpace = true;

		featureTree = featureTreeViewer.getTree();
		featureTree.setLayoutData(new FillLayout());

		TreeViewerColumn tvColumn = new TreeViewerColumn(featureTreeViewer, SWT.NONE);
		TreeColumnLayout tvLayout = new TreeColumnLayout();
		tableComposite.setLayout(tvLayout);
		tvColumn.setLabelProvider(new ViewLabelProvider1());
		tvLayout.setColumnData(tvColumn.getColumn(), new ColumnWeightData(100, 500, true));
		//Abhi

		searchFeatureText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!FILTERTEXT.equalsIgnoreCase(searchFeatureText.getText())) {
					ViewerFilter searchFilter = new ViewerFilter() {

						@Override
						public boolean select(Viewer viewer, Object parentElement, Object element) {
							if(((Feature) element).kind == FeatureKind.Classification)
							{
								return ((Feature) element)
										.getName()
										.toLowerCase(Locale.ENGLISH)
										.contains(
												searchFeatureText.getText()
												.toLowerCase(Locale.ENGLISH));

							}
							if(((Feature) element).kind == FeatureKind.Class || ((Feature) element).kind == FeatureKind.RangeClass)
							{
								return (((ClassFeature) element).getParent())
										.getName()		
										.toLowerCase(Locale.ENGLISH)
										.contains(
												searchFeatureText.getText()
												.toLowerCase(Locale.ENGLISH));
							}
							else
							{
								return ((Feature) element)
										.getName()
										.toLowerCase(Locale.ENGLISH)
										.contains(
												searchFeatureText.getText()
												.toLowerCase(Locale.ENGLISH));
							}
						}

					};
					//featureTableViewer.addFilter(searchFilter);
					featureTreeViewer.addFilter(searchFilter);
				}
			}

		});

		searchFeatureText.addListener(SWT.FocusOut, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (searchFeatureText.getText().isEmpty()) {
					searchFeatureText.setText(FILTERTEXT);
					searchFeatureText.setForeground(shell.getDisplay()
							.getSystemColor(SWT.COLOR_GRAY));

				}

			}
		});
		searchFeatureText.addListener(SWT.FocusIn, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (FILTERTEXT.equals(searchFeatureText.getText())) {
					searchFeatureText.setText("");
				}
				searchFeatureText.setForeground(shell.getDisplay()
						.getSystemColor(SWT.COLOR_BLACK));
			}

		}); 

		//Abhi - New Style of Constraints
		featureTree.addListener(SWT.MouseDoubleClick, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TreeItem[] selectedTreeItem = featureTree.getSelection();

				Feature classFeature = (Feature) selectedTreeItem[0].getData();

				String[] data = constraintText.getText().split(" ");

				if(classFeature.kind == FeatureKind.Class || classFeature.kind == FeatureKind.RangeClass)
				{
					if((constraintTextforCitLab.getText().isEmpty() || Operator.isOperatorName(data[data.length - 1])))
					{

						//Abhi- Trying something out
						StringBuilder tempforBackEnd = new StringBuilder(constraintTextforCitLab.getText());
						StringBuilder tempforFrontEnd = new StringBuilder(constraintText.getText());

						//StringBuilder temp = new StringBuilder(constraintText.getText());

						tempforFrontEnd.delete(x, y);

						//Abhi
						System.out.println(String.valueOf(x) + " " + String.valueOf(y));

						if (selectedTreeItem.length > 0) {
							//temp.insert(x > y ? y : x, " " + (selectedTreeItem[0].getText().contains(" ") || Operator.isOperatorName(selectedTreeItem[0].getText()) ? "\"" + selectedTreeItem[0].getText() + "\"" : selectedTreeItem[0].getText())
							//		+ " ");

							tempforBackEnd.append(" " + classFeature.getName() + " ");

							//tempforFrontEnd.insert(x > y ? y : x, " " + (selectedTreeItem[0].getText().contains(" ") || Operator.isOperatorName(selectedTreeItem[0].getText()) ? "\"" + selectedTreeItem[0].getText() + "\"" : selectedTreeItem[0].getText())+ " ");
						}

						StringBuilder newConstraintText = new StringBuilder();
						
						if( ((ClassificationFeature) classFeature.getParent()).getDataType().equalsIgnoreCase(FeatureConstants.TYPE_ENUM))
							newConstraintText.append(tempforFrontEnd + classFeature.getParent().getName() + " == " + classFeature.getParent().getName() + "." + selectedTreeItem[0].getText() + " ");
						else 
							newConstraintText.append(tempforFrontEnd + classFeature.getParent().getName() + " == " + selectedTreeItem[0].getText() + " ");
							


						constraintTextforCitLab.setText(tempforBackEnd.toString());
						//Abhi - It is very important that this above line is above the line below. 
						//The listener is on ConstraintText variable so we need to make sure this works.

						constraintText.setText(newConstraintText.toString()); //NodeReader.reduceWhiteSpaces(temp.toString()));

						constraintText.setSelection(constraintText.getCharCount());
						searchFeatureText.setText(FILTERTEXT);
						searchFeatureText.setForeground(shell.getDisplay()
								.getSystemColor(SWT.COLOR_GRAY));
						constraintText.setFocus();
						featureTreeViewer.resetFilters();

						//Abhi: Client decided to validate on CitLab Side
						//validate();
					}
					else
					{
						printHeaderWarning("Invalid Selection. Please select an OPERATOR first");
					}
				}
			}
		});


	}

	/**
	 * returns true if constraint is satisfiable otherwise false
	 * 
	 * @param constraint
	 *            the constraint to be evaluated
	 * @param timeout
	 *            timeout in ms
	 */
	public boolean isSatisfiable(String constraint, int timeout) 
	{
		NodeReader nodeReader = new NodeReader();
		SatSolver satsolver = new SatSolver(nodeReader.stringToNode(constraint).clone(), timeout);
		try 
		{
			return satsolver.isSatisfiable();
		} catch (TimeoutException e) 
		{
			FMUIPlugin.getDefault().logError(e);
			return true;
		}

	}

	/**
	 * returns true if the constraint is always true
	 * 
	 * @param constraint
	 *            the constraint to be evaluated
	 * @param timeout
	 *            timeout in ms
	 * 
	 */
	public boolean isTautology(String constraint, int timeout) {
		NodeReader nodeReader = new NodeReader();
		Node node = nodeReader.stringToNode(constraint);

		SatSolver satsolver = new SatSolver(new Not(node.clone()), timeout);

		try {
			return !satsolver.isSatisfiable();
		} catch (TimeoutException e) {

			return true;
		}

	}

	/**
	 * returns true if the constraint causes the feature model to be void
	 * otherwise false
	 * 
	 * @param input
	 *            constraint to be evaluated
	 * @param model
	 *            the feature model
	 * 
	 *            * @throws TimeoutException
	 */
	public boolean voidsModel(String input, FeatureModel model)
			throws TimeoutException {

		if (!model.getAnalyser().isValid()) {

			return false;
		}
		if (input.length() == 0) {

			return false;
		}
		FeatureModel clonedModel = model.clone();
		NodeReader nodeReader = new NodeReader();

		Node propNode = nodeReader.stringToNode(input, clonedModel.getFeatureNames());
		if (propNode != null) {
			if (constraint != null) {
				clonedModel.removeConstraint(constraint);
			}
			clonedModel.addPropositionalNode(propNode);
			clonedModel.handleModelDataChanged();
		}

		return (!clonedModel.getAnalyser().isValid());

	}

	/**
	 * returns a List of all features that are caused to be dead by the
	 * constraint input
	 * 
	 * @param input
	 *            constraint to be evaluated
	 * @param model
	 *            the feature model
	 * @return List of all dead Features, empty if no feature is caused to be
	 *         dead
	 */
	public List<Feature> getDeadFeatures(String input, FeatureModel model) {
		Collection<Feature> deadFeaturesBefore = null;
		FeatureModel clonedModel = model.clone();

		NodeReader nodeReader = new NodeReader();

		Node propNode = nodeReader.stringToNode(input, clonedModel.getFeatureNames());

		if (propNode != null) {
			if (constraint != null) {
				clonedModel.removeConstraint(constraint);
			}
			deadFeaturesBefore = clonedModel.getAnalyser().getDeadFeatures();
			clonedModel.addPropositionalNode(propNode);
			clonedModel.handleModelDataChanged();
		}

		List<Feature> deadFeaturesAfter = new ArrayList<Feature>();
		for (Feature l : clonedModel.getAnalyser().getDeadFeatures()) {
			if (!deadFeaturesBefore.contains(l)) {
				deadFeaturesAfter.add(l);

			}
		}
		return deadFeaturesAfter;
	}

	public List<Feature> getFalseOptional(String input, FeatureModel model){
		List<Feature> list = new ArrayList<Feature>();
		FeatureModel clonedModel = model.clone();

		NodeReader nodeReader = new NodeReader();

		Node propNode = nodeReader.stringToNode(input, clonedModel.getFeatureNames());

		for (Feature feature : model.getFeatures()){
			if (input.contains(feature.getName())){
				if (feature.getFeatureStatus() != FeatureStatus.FALSE_OPTIONAL){
					clonedModel.addPropositionalNode(propNode);
					clonedModel.getAnalyser().analyzeFeatureModel(null);
					if (clonedModel.getFeature(feature.getName())
							.getFeatureStatus() == FeatureStatus.FALSE_OPTIONAL && !list.contains(feature)) 
						list.add(feature);
				}
			}
		}

		return list;
	}

	public String getFalseOptionalString (List<Feature> list){
		String listString = list.toString();
		String featureString = "Constraint causes the following Classification to be false optional: " + '\n';		
		return featureString + listString.substring(1, listString.length()-1);
	}

	/**
	 * validates the current constraint in constraintText
	 * 
	 */
	private boolean validate() {
		NodeReader nodereader = new NodeReader();
		//Abhi - We need to send some other Text
		String con = constraintTextforCitLab.getText().trim();
		//String con = constraintText.getText().trim();
		boolean isWellformed = nodereader.isWellFormed(con, featureModel.getFeatureNames());

		if (!isWellformed) {
			printHeaderError(nodereader.getErrorMessage());	
			return false;
		}

		if (isTautology(con, 1000)) {

			printHeaderWarning("constraint is a tautology");
			return false;
		}
		if (!isSatisfiable(con, 1000)) {

			printHeaderWarning("constraint is unsatisfiable");
			return false;
		}
		try {
			if (featureModel.getAnalyser().isValid() && voidsModel(con, featureModel)) {

				printHeaderWarning("constraint makes classification tree model void");
				return false;
			}
		} catch (TimeoutException e) {
			FMUIPlugin.getDefault().logError(e);
		}

		List<Feature> deadFeatures = getDeadFeatures(con, featureModel);
		if (!deadFeatures.isEmpty()) {
			printHeaderWarning(getDeadFeatureString(deadFeatures));
			return false;
		}


		List<Feature> falseOptionalFeatures = getFalseOptional(con, featureModel);
		if (!falseOptionalFeatures.isEmpty()){
			printHeaderWarning(getFalseOptionalString(falseOptionalFeatures));
			return false;
		}		

		try {
			if (featureModel.getAnalyser().isValid() && redundant(con)) {
				printHeaderWarning("The constraint does not change or restrict anything in the Classification Tree Model.");
				return true;
			}
		} catch (TimeoutException e) {
			FMUIPlugin.getDefault().logError(e);
		}

		printHeaderText(headerText);
		return true;
	}

	/**
	 * Tests if the {@link Constraint} will change the product line. 
	 * @param constraint The actual {@link Constraint}
	 * @return <code>true</code> if the {@link Constraint} is redundant
	 */
	private boolean redundant(String constraint) {
		if (constraint.length() == 0) {
			return false;
		}
		FeatureModel clonedModel = featureModel.clone();
		Node propNode = new NodeReader().stringToNode(constraint, clonedModel.getFeatureNames());
		clonedModel.addPropositionalNode(propNode);
		if (new ModelComparator(20000).compare(featureModel, clonedModel) == Comparison.REFACTORING) {
			return true;
		}
		return false;
	}

	/**
	 * returns a String to be displayed in the dialog header contains the list
	 * of dead features
	 * 
	 * @param deadFeatures
	 *            List of dead Features
	 * */
	private String getDeadFeatureString(List<Feature> deadFeatures) {
		StringBuilder featureString = new StringBuilder();
		featureString.append("Constraint causes the following Classification to be dead: ");
		int count = 0;
		int featureCount = 0;
		boolean isNewLine = false;
		for (Feature l : deadFeatures) {
			count = count + l.toString().length() + 2;

			if (isNewLine == false && count > 35) {
				featureString.append('\n');
				isNewLine = true;
			}
			if (count < 90) {
				featureString.append(l);
				if (featureCount < deadFeatures.size() - 1)
					featureString.append(", ");
				featureCount++;

			}
			if (deadFeatures.indexOf(l) == deadFeatures.size() - 1) {

			}

		}
		if (featureCount < deadFeatures.size()) {
			featureString.append("...");
		}
		return featureString.toString();
	}

	/**
	 * displays a warning in the header
	 * 
	 * @param message
	 *            message to be displayed
	 */
	private void printHeaderWarning(String message) {
		okButton.setEnabled(true);
		errorMarker.setImage(WARNING_IMAGE);
		errorMarker.setVisible(true);
		errorMessage.setText(message);
		errorMessage.pack();
	}

	/**
	 * displays an error in the header
	 * 
	 * @param message
	 *            message to be displayed
	 */
	private void printHeaderError(String message) {
		okButton.setEnabled(false);
		errorMarker.setImage(ERROR_IMAGE);
		errorMarker.setVisible(true);
		errorMessage.setText(message);
	}

	/**
	 * displays a Text in the header
	 * 
	 * @param message
	 *            message to be displayed
	 */
	private void printHeaderText(String message) {
		okButton.setEnabled(true);
		errorMarker.setVisible(false);
		errorMessage.setText(message);

	}

	/**
	 * closes the shell and adds new constraint to the feature model if possible
	 * 
	 * @param featureModel
	 * @param constraint
	 */
	private void closeShell() {
		NodeReader nodeReader = new NodeReader();
		//Abhi - We have build a new String for BackEnd
		//String input = constraintText.getText().trim();
		
		//String input = constraintTextforCitLab.getText().trim();
		
		String input = constraintText.getText().trim();

		if (input.length() == 0) 
		{
			printHeaderError("constraint is empty");
			return;
		}

		
		Node propNode = nodeReader.stringToNode(constraintTextforCitLab.getText().trim(), featureModel.getFeatureNames());		
		
		/* Abhi: We are doing simple text constriants. So we do not need this.
		 * 
		 *
		

		if (propNode == null) {
			printHeaderError(nodeReader.getErrorMessage());
			return;
		}
		if (!isSatisfiable(input, 1000)) {
			printHeaderWarning("constraint is unsatisfiable");			
		}
		*/

		AbstractOperation op = null;
		
		if (constraint != null && featureModel.getConstraints().contains(constraint)) {
			int index = 0;
			for (Constraint c : featureModel.getConstraints()) {
				if (c.getConstraintText().equalsIgnoreCase(constraint.getConstraintText())) {
					op = new ConstraintEditOperation(constraint.getConstraintText(), featureModel, index, propNode);
					break;
				}
				index++;
			}	
		}
		if (op == null) {
			op = new ConstraintCreateOperation(input, featureModel, propNode);
		}
		op.addContext((IUndoContext) featureModel.getUndoContext());
		try {
			PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op, null, null);
		} catch (ExecutionException e) {
			FMUIPlugin.getDefault().logError(e);
		}

		shell.dispose();

	}
}
