/**
 * 
 */
package citlab.core.ui.views.generator;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;

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
		table = tableViewer.getTable();

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		layout = new TableColumnLayout();
	  composite_1.setLayout(layout);
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

	public void setTestsuite(final TestSuite inputlist) {

		this.inputlist = inputlist;
		TableColumn[] columnOfTheModel = new TableColumn[this.inputlist
				.getTests().get(0).getAssignments().size() + 1];
		TableViewerColumn[]  tableViewerColumn = new TableViewerColumn[this.inputlist
		                                               				.getTests().get(0).getAssignments().size() + 1];

		columnOfTheModel[0] = new TableColumn(table, SWT.NONE);
		columnOfTheModel[0].setText("Test");
	
		int n = 1;
		for (Assignment i : this.inputlist.getTests().get(0).getAssignments()) {
			tableViewerColumn[n] = new TableViewerColumn(
					tableViewer, SWT.NONE);

			columnOfTheModel[n] = tableViewerColumn[n].getColumn();
	      

			columnOfTheModel[n].setText(i.getParameter().getName());
			n++;
		}
		int testnumber = 0;
		for (Test test : this.inputlist.getTests()) {
			testnumber++;
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, Integer.toString(testnumber));
			item.setForeground(0, SWTResourceManager.getColor(SWT.COLOR_RED));
			int i = 1;
			for (Assignment assignment : test.getAssignments()) {
				item.setText(i, assignment.getValue());
				i++;

			}
		}
		table.setRedraw(true);
		table.pack();
		for (int i = 0, n1 = columnOfTheModel.length; i < n1; i++) {
			//columnOfTheModel[i].pack();
		 layout.setColumnData(columnOfTheModel[i], new ColumnWeightData(10));
			 
		}
         
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
		btnNewButton.setBounds(397, 33, 271, 25);
		btnNewButton.setText("Export");

		styledText.setText(this.getPartName()+"\n"+
		"\n"+"N-WISE= "+ inputlist.getStrength());

	}
}
