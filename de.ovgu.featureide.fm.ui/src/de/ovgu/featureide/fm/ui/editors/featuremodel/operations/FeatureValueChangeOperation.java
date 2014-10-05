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

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureConstants;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;

/**
 * TODO description
 * 
 * @author abhisheksharma
 */
public class FeatureValueChangeOperation extends AbstractFeatureModelOperation {

	private static final String LABEL = "Change Value";
	private String oldValue;
	private String newValue;
	private ClassFeature classFeature;

	public FeatureValueChangeOperation(FeatureModel featureModel,Feature feature, String oldValue,
			String newValue) {
		super(featureModel, LABEL);
		this.oldValue = oldValue;
		this.newValue = newValue;
		if(feature instanceof ClassFeature)
		{
			this.classFeature = (ClassFeature) feature;
		}
		else
		{
			this.classFeature = null;
		}

	}

	@Override
	protected void redo() {
		//Abhi
		/*if(classFeature != null)
		{
			classFeature.setValue(newValue);
		}*/
		//featureModel.getRenamingsManager().renameFeature(oldName, newName);
		
		//Abhi
		if(classFeature != null)
		{
			if(classFeature.getParent() instanceof ClassificationFeature)
			{
				String dataType = ((ClassificationFeature) classFeature.getParent()).getDataType();
				if(dataType != null)
				{
					if(dataType.equals(FeatureConstants.TYPE_INTEGER) || dataType.equals(FeatureConstants.TYPE_RANGE))
					{
						if(isInteger(newValue))
							this.classFeature.setValue(newValue);
					}
						
					else
					{
						this.classFeature.setValue(newValue);
					}
				}
						
			}
			else
			{
				this.classFeature.setValue(newValue);
			}
		}
	}

	@Override
	protected void undo() {
		//featureModel.getRenamingsManager().renameFeature(newName, oldName);
		
		//Abhi
		if(classFeature != null)
		{
			classFeature.setValue(oldValue);
		}
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

}
