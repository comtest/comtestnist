/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.core.ui.views.alternativeeditor;





import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import citlab.core.ext.CitLabException;
import citlab.core.ext.ICitLabAlternativeEditor;
import citlab.core.ext.ICitLabImporter;
import citlab.core.ext.NotValidModelException;
import citlab.model.citL.CitModel;
import citlab.model.citL.util.CitLAdapterFactory;
import citlab.model.simplifier.Simplificator;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class AlternativeEditorDialog extends Dialog {
	private IConfigurationElement element;
	private List<IProject> prjs;
	private Table tableProjects;
	private TableViewer tableViewer;
	private String fileName = "newfile";
	private String projectName= "newProject";
	private Text txtFileName;
	private Text txtProjectName;
	

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AlternativeEditorDialog(Shell parentShell, IConfigurationElement element) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.MAX);
		this.element = element;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		prjs= Arrays.asList(root.getProjects());
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		final Label nameLabel = new Label(container, SWT.NONE);
		nameLabel.setText("New File Name");
		txtFileName = new Text(container, SWT.BORDER);
		txtFileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Button rdBtnCreateProject = new Button(container, SWT.CHECK);
		rdBtnCreateProject.setText("Create Project");
		
		txtProjectName = new Text(container, SWT.BORDER);		
		txtProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Button rdBtnSelectProject = new Button(container, SWT.CHECK);		
		rdBtnSelectProject.setText("Select Project");
		rdBtnCreateProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				rdBtnCreateProject.setSelection(true);
				rdBtnSelectProject.setSelection(false);
				tableProjects.setEnabled(false);
				txtProjectName.setEnabled(true);
			}
		});
		rdBtnCreateProject.setSelection(true);
		rdBtnSelectProject.setSelection(false);
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableProjects = tableViewer.getTable();
		tableProjects.setHeaderVisible(true);
		tableProjects.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableProjects.setEnabled(false);
		txtProjectName.setEnabled(true);
		
		
		rdBtnSelectProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				rdBtnCreateProject.setSelection(false);
				rdBtnSelectProject.setSelection(true);
				tableProjects.setEnabled(true);
				txtProjectName.setEnabled(false);
			}
		});	
		
		TableColumn tblclmnName = new TableColumn(tableProjects, SWT.NONE);
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnNewColumn = new TableColumn(tableProjects, SWT.NONE);
		tblclmnNewColumn.setWidth(403);
		tblclmnNewColumn.setText("Path");
		
		final Button btnOK = new Button(container, SWT.NONE);
		btnOK.setEnabled(false);
		GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 223;
		btnOK.setLayoutData(gd_btnNewButton);
		btnOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	          
				try {
					final Object o = element
							.createExecutableExtension("AlternativeEditorPrototype");

					if (o instanceof ICitLabAlternativeEditor) {
						((ICitLabAlternativeEditor) o).openEditor(txtProjectName.getText(), txtFileName.getText());
					}					
					close();
				} catch (CitLabException e1) {
					MessageBox m =new MessageBox(getShell(),SWT.ERROR);
					m.setMessage("Alternative editor not Valid \n" + e1.getTrace());
					m.open();
					e1.printStackTrace();
				} catch (CoreException e1) {
					MessageBox m =new MessageBox(getShell(),SWT.ERROR);
					m.setMessage("Alternative editor not Valid");
					e1.printStackTrace();
				}
			}			
		});
		btnOK.setText("OK");
		txtProjectName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				toggleButton(btnOK);
			}
		});
		
		txtFileName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				toggleButton(btnOK);			
			}
		});
		
		return container;
	}
	
	protected void toggleButton(Button btn) {
		if(txtProjectName.getText()!=null && 
				!txtProjectName.getText().equals("") &&
				txtProjectName.getText().charAt(0) != ' ' &&
				txtFileName.getText()!=null && 
				!txtFileName.getText().equals("") &&
				txtFileName.getText().charAt(0) != ' ' )
			btn.setEnabled(true);
		else
			btn.setEnabled(false);
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(532, 483);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), IProject.class, new String[]{"name", "locationURI.path"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		WritableList writableList = new WritableList(prjs, IProject.class);
		tableViewer.setInput(writableList);
		//
		IObservableValue tableViewerObserveSingleSelection = ViewersObservables.observeSingleSelection(tableViewer);
		IObservableValue tableViewerAccessibleObserveDetailValue = PojoObservables.observeDetailValue(tableViewerObserveSingleSelection, "name", String.class);
		IObservableValue textTextObserveValue = PojoObservables.observeValue(txtProjectName, "text");
		bindingContext.bindValue(tableViewerAccessibleObserveDetailValue, textTextObserveValue, null, null);
		//
		return bindingContext;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}