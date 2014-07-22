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
package de.ovgu.featureide.fm.ui.views.outline;

import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.prop4j.NodeWriter;

import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.ui.editors.featuremodel.GUIDefaults;

/**
 * This class is part of the outline. It maps the items provided by the
 * ContentProvider to visible items that can be displayed inside a TreeView.
 * 
 * @author Jan Wedding
 * @author Melanie Pflaume
 */
public class FmLabelProvider implements ILabelProvider,IFontProvider, GUIDefaults {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 * jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
	 * .Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
	 * .jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof Feature) {
			if ((((Feature) element).isRoot()))
				return null;
			if (((Feature) element).getParent().isAlternative() ||((Feature) element).getParent().isOr())
				return null;
			if (((Feature) element).isMandatory()) {
				
				Image image = IMG_MANDATORY;
				Image reDraw = new Image(image.getDevice(), image.getImageData().width, image.getImageData().height);
				GC gc = new GC(reDraw);
				gc.drawImage(image, 0, 0, image.getImageData().width, image.getImageData().height, 3, 3, image.getImageData().width, image.getImageData().height);
				gc.dispose();
				
				return reDraw;
			} else {
				Image image = IMG_OPTIONAL;
				Image reDraw = new Image(image.getDevice(), image.getImageData().width, image.getImageData().height);
				GC gc = new GC(reDraw);
				gc.drawImage(image, 0, 0, image.getImageData().width, image.getImageData().height, 3, 3, image.getImageData().width, image.getImageData().height);
				gc.dispose();
				
				return reDraw;
			}
		} else if (element instanceof FmOutlineGroupStateStorage) {
			if (((FmOutlineGroupStateStorage)element).isOrGroup()) {
				return IMG_OR;
			} else {
				return IMG_XOR;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Feature)
			return ((Feature) element).getName();
		else if (element instanceof Constraint)
			return ((Constraint) element).getNode().toString(NodeWriter.logicalSymbols);
		else if (element instanceof FmOutlineGroupStateStorage)
			return "";
	
		return element.toString();
	}



	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 */
	@Override
	public Font getFont(Object element) {
		return DEFAULT_FONT;
	}
}