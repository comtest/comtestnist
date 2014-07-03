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
package de.ovgu.featureide.fm.ui.editors.featuremodel.commands.renaming;

import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolTip;

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.ui.editors.featuremodel.GUIDefaults;
import de.ovgu.featureide.fm.ui.editors.featuremodel.editparts.FeatureEditPart;

/**
 * Initializes the cell editor for feature renamings and adds a listener to show
 * a tooltip if the current name is not allowed.
 * 
 * @author Thomas Thuem
 * @author Florian Proksch
 * @author Stefan Krueger
 */
public class FeatureLabelEditManager extends DirectEditManager implements GUIDefaults {

	private FeatureModel featureModel;
	//Abhi
	private ClassFeature classfeature;

	public FeatureLabelEditManager(FeatureEditPart editpart, Class<?> editorType, 
			FeatureCellEditorLocator locator, FeatureModel featureModel) {
		super(editpart, editorType, locator);
		this.featureModel = featureModel;
	}
	
	//Abhi (Special Handling for the Class Feature since we need to show VALUE instead of NAME)
	public FeatureLabelEditManager(FeatureEditPart editpart, Class<?> editorType, 
			FeatureCellEditorLocator locator, FeatureModel featureModel, ClassFeature classFeature) {
		super(editpart, editorType, locator);
		this.featureModel = featureModel;
		//Abhi
		this.classfeature = classFeature;
	}
	
	
	@Override
	protected void initCellEditor() {
		final CellEditor cellEditor = getCellEditor();
		final Control control = cellEditor.getControl();
		//Abhi we want to set the value based on the KIND of the NODE
		// If class Node we want to show the value and not the name
		
		final String oldValue = (((FeatureEditPart) getEditPart()).getFeature()) instanceof ClassFeature ?
								((ClassFeature) ((FeatureEditPart) getEditPart()).getFeature()).getValue() : ((FeatureEditPart) getEditPart()).getFeature().getName();

		
		control.setFont(DEFAULT_FONT);
		cellEditor.setValue(oldValue);
		
		cellEditor.addListener(new ICellEditorListener() {
			private ToolTip tooltip;
			
			public void editorValueChanged(boolean oldValidState, boolean newValidState) {
				closeTooltip();
				String value = (String) cellEditor.getValue();
				//If we have Class Feature we do not call these rules.
				
				// TODO #Abhi - We might have to add own rules. Need to think about this.
				if (!value.equals(oldValue) && ((FeatureEditPart) getEditPart()).getFeature().kind != FeatureKind.Class
						&& ((FeatureEditPart) getEditPart()).getFeature().kind != FeatureKind.RangeClass) 
				{
					if (value.equalsIgnoreCase(oldValue)) {
						createTooltip("It is not recommended to change upper and lower case. You currently try to rename " + oldValue + " to " + value + ".", SWT.ICON_WARNING, "Invalid Name");
					// TODO #455 wrong usage of extension
					} else if ((!featureModel.getFMComposerExtension().isValidFeatureName(value))) {
						createTooltip(featureModel.getFMComposerExtension().getErroMessage(), SWT.ICON_ERROR, "Invalid Name");
					} else if (featureModel.getFeatureNames().contains(value)) {
						createTooltip("This name is already used for another feature.", SWT.ICON_ERROR, "Invalid Name");
					}
				}
				
				else if(!value.equals(oldValue) && (((FeatureEditPart) getEditPart()).getFeature().kind == FeatureKind.Class
												   || ((FeatureEditPart) getEditPart()).getFeature().kind == FeatureKind.RangeClass ))
				{
					if(isInteger(oldValue))
					{
						if(isInteger(value) == false)
						{
							createTooltip("Invalid Entry. Please enter an Integer", SWT.ICON_ERROR, "Invalid Value");
						}
					}
						
				}
			}
			
			public void cancelEditor() {
				closeTooltip();
			}
			
			public boolean isInteger(String s) {
			    try { 
			        Integer.parseInt(s); 
			    } catch(NumberFormatException e) { 
			        return false; 
			    }
			    // only got here if we didn't return false
			    return true;
			}
			
			public void applyEditorValue() {
				closeTooltip();
			}
			private void createTooltip(String message, int icon, String titleText) {
				tooltip = new ToolTip(control.getShell(), SWT.BALLOON | icon);
				tooltip.setAutoHide(false);
				tooltip.setLocation(control.toDisplay(control.getSize().x/2, control.getSize().y + 5));
				tooltip.setText(titleText);
				tooltip.setMessage(message);
				tooltip.setVisible(true);
			}
			private void closeTooltip() {
				if (tooltip != null) {
					tooltip.setVisible(false);
					tooltip = null;
				}
			}
		});
	}

}
