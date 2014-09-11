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

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.RangeClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
/**
 * TODO description
 * 
 * @author abhisheksharma
 */
public class ViewLabelProvider1 extends StyledCellLabelProvider {
	
	@Override
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.StyledCellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
	 */
	public void update(ViewerCell cell) 
	{	
		Object element = cell.getElement();
	    StyledString text = new StyledString();

	      if (((Feature) element).kind == FeatureKind.Classification)
	      {
	        text.append(((ClassificationFeature) element).getName());
	        
	        text.append(" (" + ((ClassificationFeature) element).getChildrenCount() + ") ",
	              StyledString.COUNTER_STYLER);
	      } 
	      else if (((Feature) element).kind == FeatureKind.Class || ((Feature) element).kind == FeatureKind.RangeClass) 
	      {
	        text.append(((ClassFeature) element).getValue());
	      }
	      cell.setText(text.toString());
	      cell.setStyleRanges(text.getStyleRanges());
	      super.update(cell);
	}
	
	@Override
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.StyledCellLabelProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
}
