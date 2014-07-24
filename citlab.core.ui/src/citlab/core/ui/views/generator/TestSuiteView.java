/**
 * 
 */
package citlab.core.ui.views.generator;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.internal.RegEx.REUtil;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import citlab.model.citL.CitLFactory;
import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.testsuite.impl.AssignmentImpl;

import org.eclipse.swt.custom.StyledText;

/**
 * @author vavas726
 * 
 */
public class TestSuiteView extends ViewPart {

	private Table table;
	private TableViewer tableViewer;
	private String secondaryId;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Button btnNewButton;
	private TestSuite inputlist;
	private TableColumnLayout layout;
	private StyledText styledText;
	
	private Integer original_Column_Size;
	private Integer additional_Column_Size;
	private Button addColumnButton;
	private Button removeColumnButton;
	private List<TextCellEditor> cellEditors;
	private List<TableColumn> tableColumns;

	public TestSuiteView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		secondaryId = site.getSecondaryId();
		setPartName(secondaryId.replace("citlab.core.ui.outputSecondaryID", "")
				.replace("__", ":"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_1 = new Composite(parent, SWT.NONE);
		
		
		tableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.H_SCROLL |SWT.V_SCROLL);
		
		tableViewer.setLabelProvider(new MyLabelProvider());
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());


		
		tableViewer.setCellModifier(new MyICellModifier());
		


		TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(
				tableViewer, new FocusCellOwnerDrawHighlighter(tableViewer));
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(
				tableViewer) {
			@Override
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		int feature = ColumnViewerEditor.TABBING_HORIZONTAL
				| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
				| ColumnViewerEditor.TABBING_VERTICAL
				| ColumnViewerEditor.KEYBOARD_ACTIVATION;

		TableViewerEditor.create(tableViewer, focusCellManager, actSupport, feature);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
		table= tableViewer.getTable();
	    composite_1.setLayout(new FillLayout());
	  
	  
	  
	  
	  Composite composite = new Composite(parent, SWT.NONE);
	  composite.setLayout(new FormLayout());
	  
	  		Label lblTime = new Label(composite, SWT.NONE);
	  		FormData fd_lblTime = new FormData();
	  		fd_lblTime.bottom = new FormAttachment(0, 25);
	  		fd_lblTime.right = new FormAttachment(0, 59);
	  		fd_lblTime.top = new FormAttachment(0, 10);
	  		fd_lblTime.left = new FormAttachment(0, 10);
	  		lblTime.setLayoutData(fd_lblTime);
	  		lblTime.setText("Name:");
	  		
	  				text = new Text(composite, SWT.BORDER);
	  				FormData fd_text = new FormData();
	  				fd_text.bottom = new FormAttachment(0, 28);
	  				fd_text.right = new FormAttachment(0, 336);
	  				fd_text.top = new FormAttachment(0, 7);
	  				fd_text.left = new FormAttachment(0, 65);
	  				text.setLayoutData(fd_text);
	  				text.setEditable(false);
	  				
	  				
	  						text_1 = new Text(composite, SWT.BORDER);
	  						FormData fd_text_1 = new FormData();
	  						fd_text_1.left = new FormAttachment(text, 0, SWT.LEFT);
	  						fd_text_1.bottom = new FormAttachment(0, 60);
	  						fd_text_1.right = new FormAttachment(0, 336);
	  						text_1.setLayoutData(fd_text_1);
	  						text_1.setEditable(false);
	  						
	  								Label lblTime_1 = new Label(composite, SWT.NONE);
	  								fd_text_1.top = new FormAttachment(lblTime_1, 0, SWT.TOP);
	  								FormData fd_lblTime_1 = new FormData();
	  								fd_lblTime_1.bottom = new FormAttachment(0, 54);
	  								fd_lblTime_1.right = new FormAttachment(0, 58);
	  								fd_lblTime_1.top = new FormAttachment(0, 39);
	  								fd_lblTime_1.left = new FormAttachment(0, 9);
	  								lblTime_1.setLayoutData(fd_lblTime_1);
	  								lblTime_1.setText("Time:");
	  								
	  										Label labelSize = new Label(composite, SWT.NONE);
	  										FormData fd_labelSize = new FormData();
	  										fd_labelSize.top = new FormAttachment(lblTime_1, 6);
	  										fd_labelSize.right = new FormAttachment(lblTime, 0, SWT.RIGHT);
	  										fd_labelSize.left = new FormAttachment(lblTime, 0, SWT.LEFT);
	  										labelSize.setLayoutData(fd_labelSize);
	  										labelSize.setText("Size:");
	  										
	  												text_2 = new Text(composite, SWT.BORDER);
	  												fd_labelSize.bottom = new FormAttachment(text_2, -12, SWT.BOTTOM);
	  												FormData fd_text_2 = new FormData();
	  												fd_text_2.top = new FormAttachment(text_1, 6);
	  												fd_text_2.right = new FormAttachment(text, 0, SWT.RIGHT);
	  												fd_text_2.left = new FormAttachment(0, 65);
	  												text_2.setLayoutData(fd_text_2);
	  												text_2.setEditable(false);
	  												
	  														btnNewButton = new Button(composite, SWT.NONE);
	  														fd_text_2.bottom = new FormAttachment(btnNewButton, -18);
	  														FormData fd_btnNewButton = new FormData();
	  														fd_btnNewButton.top = new FormAttachment(0, 105);
	  														fd_btnNewButton.left = new FormAttachment(text, 0, SWT.LEFT);
	  														fd_btnNewButton.bottom = new FormAttachment(0, 130);
	  														fd_btnNewButton.right = new FormAttachment(0, 336);
	  														btnNewButton.setLayoutData(fd_btnNewButton);
	  														btnNewButton.setText("Export");
	  														
	  														styledText = new StyledText(composite, SWT.BORDER);
	  														styledText.setEditable(false);
	  														styledText.setAlwaysShowScrollBars(false);
	  														FormData fd_styledText = new FormData();
	  														fd_styledText.bottom = new FormAttachment(btnNewButton, 172, SWT.BOTTOM);
	  														fd_styledText.top = new FormAttachment(btnNewButton, 27);
	  														fd_styledText.left = new FormAttachment(text, 0, SWT.LEFT);
	  														fd_styledText.right = new FormAttachment(0, 297);
	  														styledText.setLayoutData(fd_styledText);
	  														
	  														addColumnButton = new Button(composite, SWT.NONE);
	  														FormData fd_addColumnNewButton = new FormData();
	  														fd_addColumnNewButton.top = new FormAttachment(styledText, 10);
	  														fd_addColumnNewButton.left = new FormAttachment(text, 0, SWT.LEFT);
	  														addColumnButton.setLayoutData(fd_addColumnNewButton);
	  														addColumnButton.setText("Add Column");
	  														
	  														
	  														removeColumnButton = new Button(composite, SWT.NONE);
	  														FormData fd_removeColumnNewButton = new FormData();
	  														fd_removeColumnNewButton.top = new FormAttachment(styledText, 10);
	  														fd_removeColumnNewButton.left = new FormAttachment(addColumnButton, 0, SWT.RIGHT);
	  														removeColumnButton.setLayoutData(fd_removeColumnNewButton);
	  														removeColumnButton.setText("Remove Column");
	  														removeColumnButton.setEnabled(false);
			composite.pack();
		
	}

	// TODO Auto-generated method stub

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	//TODO: Douglas
	public List<String> generate_column_name(){
		List<String> column_name = new ArrayList<String>();
		
		column_name.add("Test");
		int n = 1;
		for (Assignment i : this.inputlist.getTests().get(0).getAssignments()) {
			column_name.add(i.getParameter().getName());
			n++;
		}
	
		return column_name;

	}
	public TestSuite add_in_expected_value_col(final TestSuite inputlist ){
		for (int i = 0; i < inputlist.getTests().size(); i++) {
			if( i == 0 ){
				Assignment assignment = TestsuiteFactory.eINSTANCE
						.createAssignment();       
				Parameter parameter = CitLFactory.eINSTANCE.createParameter();
				parameter.setName("Expected Value_"+additional_Column_Size);
				assignment.setParameter(parameter);
				assignment.setValue("*");
				inputlist.getTests().get(i).getAssignments().add(assignment);
			} else {
				Assignment assignment = TestsuiteFactory.eINSTANCE
						.createAssignment();
				Parameter parameter = CitLFactory.eINSTANCE.createParameter();
				parameter.setName("Expected Value_"+additional_Column_Size);
				assignment.setParameter(parameter);
				assignment.setValue("*");
				inputlist.getTests().get(i).getAssignments().add(assignment);
			}
		
		}
		return inputlist;
	}

	public TestSuite removeExpextedValueColumn(final TestSuite inputlist){
		int removal = inputlist.getTests().get(0).getAssignments().size();
		for (int i = 0; i < inputlist.getTests().size(); i++) {
			if( i == 0 ){
				
				inputlist.getTests().get(i).getAssignments().remove(removal-1);
			} else {
				
				inputlist.getTests().get(i).getAssignments().remove(removal-1);
			}
		}
		return inputlist;
	}
	public void setTestsuite(final TestSuite inputlist) {

		this.inputlist = inputlist;
		original_Column_Size = inputlist.getTests().get(0).getAssignments().size();
		additional_Column_Size = 0;
		handleTestSuiteModification();

		text_2.setText((String.valueOf(this.inputlist.getTests().size())));
		text_1.setText((String.valueOf(this.inputlist.getGeneratorTime())));
		text.setText(this.inputlist.getGeneratorName());
		btnNewButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TestSuiteExporterDialog tExDialog = new TestSuiteExporterDialog(
						Display.getCurrent().getActiveShell(), inputlist);
				tExDialog.open();

			}
		});
		btnNewButton.setText("Export");

		
		
		addColumnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				additional_Column_Size++;
				add_in_expected_value_col(inputlist);
				buildColumn();
				
				if(additional_Column_Size > 0){
					removeColumnButton.setEnabled(true);
				}

			}
		});
		//addColumnButton.setBounds(397, 180, 271, 25);
		
		
		removeColumnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(additional_Column_Size > 0){
					removeExpextedValueColumn(inputlist);
					disposeColumn();
					additional_Column_Size--;
					
					if(additional_Column_Size <= 0){
						removeColumnButton.setEnabled(false);
					}
				}
			
				
			}
		});
		
		styledText.setText(this.getPartName()+"\n"+
		"\n"+"N-WISE= "+ inputlist.getStrength());

	}
	
	private void handleTestSuiteModification(){
		
		buildCellEditors();
		
	}
	private void buildCellEditors(){
		String[] columLabels = generate_column_name().toArray(new String[0]);
		cellEditors = new ArrayList<TextCellEditor>();  

		for(int i = 0; i<columLabels.length; i++){
			cellEditors.add(new TextCellEditor(tableViewer.getTable()));
		}

		tableViewer.setCellEditors(cellEditors.toArray(new TextCellEditor[0]));
		tableViewer.setColumnProperties(columLabels);
		
		
		tableColumns = new ArrayList<TableColumn>();
		for (String label : columLabels) {
			createColumnFor(tableViewer, label);
		}
		tableViewer.setInput(createModel());
	
		table.setRedraw(true);
		table.pack();
	}
	
	private void disposeCellEditrors(){
		for(CellEditor editor : tableViewer.getCellEditors()){
			editor.dispose();
		}
		for(TableColumn col : tableViewer.getTable().getColumns() ){
			col.dispose();
		}
		tableViewer.setColumnProperties(null);
		tableViewer.setInput(null);		
	}
	
	private void buildColumn(){
		
		String[] columLabels = generate_column_name().toArray(new String[0]);
		
		// Adding in the new text cell editor in our List
		cellEditors.add( new TextCellEditor(tableViewer.getTable()));
		tableViewer.setCellEditors(cellEditors.toArray(new TextCellEditor[0]));
		tableViewer.setColumnProperties(columLabels);
		createColumnFor(tableViewer, columLabels[columLabels.length-1]);
		tableViewer.setInput(createModel());
		tableViewer.refresh();
	}
	
	private void disposeColumn(){
		// Adding in one because the cellEditors and tableColumns has the TEST column
		int index = inputlist.getTests().get(0).getAssignments().size()+1;
		cellEditors.get(index).dispose();
		tableColumns.get(index).dispose();
		cellEditors.remove(index);
		tableColumns.remove(index);
		
		String[] columLabels = generate_column_name().toArray(new String[0]);
		tableViewer.setColumnProperties(columLabels);
		tableViewer.setInput(createModel());
		tableViewer.refresh();
		
	}
	private void createColumnFor(TableViewer v, String label) {
		TableColumn column = new TableColumn(v.getTable(), SWT.NONE);
		
		column.setMoveable(true);
		column.setText(label);
		column.pack();
		
		tableColumns.add(column);
		
		
	}

	private List<MyModel> createModel() {
		List<MyModel> elements = new ArrayList<MyModel>();
		Integer test_case = inputlist.getTests().size();
		for (int i = 0; i < test_case; i++) {
			elements.add(new MyModel(Integer.toString(i)));
		}
		return elements;
	}
	public class MyModel {
		public String counter;

		public MyModel(String counter) {
			this.counter = counter;
		}

		@Override
		public String toString() {
			return this.counter;
		}
	}

	public class MyICellModifier implements ICellModifier{

		@Override
		public boolean canModify(Object element, String property) {
			return true;
		}

		@Override
		public Object getValue(Object element, String property) {
			//System.out.println("Column " + property + " => " + element.toString());
			if(!property.equals("Test")){
				int index = get_column_index_from_input(property);
				return inputlist.getTests().get(Integer.parseInt(element.toString())).getAssignments().get(index).getValue();	
			}
			return element.toString();
			
		}

		@Override
		public void modify(Object element, String property, Object value) {
//			System.out.println("Element getting modified.");
//			System.out.println("element.toString()   " +  element.toString());
//			System.out.println("property  " + property);
//			System.out.println("value   " + value);
			if(!property.equals("Test")){
				TableItem item = (TableItem) element;
				int testCase_index =  Integer.parseInt(item.getText());
				
				int index = get_column_index_from_input(property);
				inputlist.getTests().get(testCase_index).getAssignments().get(index).setValue((String)value);
				tableViewer.refresh();
			}

		}
		
	}
	
	// TODO : check this!!
	public int get_column_index_from_input(String property){
		int index = 0;
		for(Assignment assignment : inputlist.getTests().get(0).getAssignments()){
			
			if(assignment.getParameter().getName().equals(property)){
				return index;
			}
			index++;
		}
		return index;
	}
	public class MyLabelProvider extends LabelProvider implements
			ITableLabelProvider, ITableFontProvider, ITableColorProvider {
		FontRegistry registry = new FontRegistry();

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			
			String columnText = new String("Error");

			if( columnIndex == 0){   // Print out test cases NUMBERS
				columnText = element.toString();
			} else {
				if (inputlist.getTests().get(Integer.parseInt(element.toString())).getAssignments() != null){
					columnText = inputlist.getTests().get(Integer.parseInt(element.toString())).getAssignments().get(columnIndex-1).getValue();	
				}
				
			}
			
			return columnText;
		}

		@Override
		public Font getFont(Object element, int columnIndex) {
			return null;
		}

		@Override
		public Color getBackground(Object element, int columnIndex) {
			return null;
		}

		@Override
		public Color getForeground(Object element, int columnIndex) {
			return null;
		}

	}
	
}
