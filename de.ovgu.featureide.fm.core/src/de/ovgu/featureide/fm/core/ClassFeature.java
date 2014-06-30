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
package de.ovgu.featureide.fm.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.CheckForNull;

import org.prop4j.NodeWriter;

/**
 * TODO description
 * 
 * @author abhisheksharma
 */

//Just a wrapper around feature
public class ClassFeature extends Feature {

	private String value;
	
	public ClassFeature(FeatureModel featureModel, String name) {
		super(featureModel, name);
		this.kind = FeatureKind.Class;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String v) {
		value = v;
		fireValueChanged(); //Abhi
	}
	
	//Abhi
	private void fireValueChanged() {
		PropertyChangeEvent event = new PropertyChangeEvent(this, VALUE_CHANGED,
				Boolean.FALSE, Boolean.TRUE);
		for (PropertyChangeListener listener : listenerList)
			listener.propertyChange(event);
	}
}
