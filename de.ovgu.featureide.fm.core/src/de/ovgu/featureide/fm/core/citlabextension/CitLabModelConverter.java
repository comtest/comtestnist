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
package de.ovgu.featureide.fm.core.citlabextension;

import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;

import citlab.model.citL.AnonymousType;
import citlab.model.citL.Boolean;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Numbers;
import citlab.model.citL.Numerical;
import citlab.model.citL.Range;
import citlab.model.citL.impl.CitLPackageImpl;
import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureConstants;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.RangeClassFeature;

/**
 * TODO description
 * 
 * @author Wayman Tan
 */
public class CitLabModelConverter {
	
	public CitModel convertModel(FeatureModel fm) throws UnconvertibleModelException {
		// validate to ensure the model is ready for conversion
		validateModel(fm);
		
		CitLPackageImpl.init();
		CitModel result = CitLFactory.eINSTANCE.createCitModel();		
		Feature root = fm.getRoot();	
		
		result.setName(normalize(root.getName()));
		
		// add parameters 
		addParameterFor(fm, result);
		// add the constraints
		addConstraints(fm, result);
		
		return result;		
	}
	
	public void validateModel(FeatureModel featureModel) throws UnconvertibleModelException {
		// TODO by Wayman
	}
	
	
	private String normalize(String x) {
		return Normalizer.normalize(x,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(",", "y");
	}

	private void addParameterFor(FeatureModel fm, CitModel result) {
		List<ClassificationFeature> classificationNodeList = fm.getClassificationNodeList();
		for(ClassificationFeature classificationNode : classificationNodeList) {
			if (classificationNode.isHidden()) 
				// ignore the hidden node
				continue;
			Feature parent = classificationNode.getParent();
			// ignore the classification nodes that are 
			// descendant from a class node. They will be handled
			// by processing other classification nodes.
			if (!(parent instanceof ClassFeature)) {
				if (classificationNode.getDataType().equals(FeatureConstants.TYPE_BOOLEAN)){
					Boolean bool = CitLFactory.eINSTANCE.createBoolean();
					bool.setName(normalize(classificationNode.getName()));
					result.getParameters().add(bool);
					
				} else if (classificationNode.getDataType().equals(FeatureConstants.TYPE_RANGE)) {
					Range range = CitLFactory.eINSTANCE.createRange();
					range.setName(normalize(classificationNode.getName()));
					// There should be only two range class node 
					// attached to a classification node in range type
					RangeClassFeature rangeClass1 = (RangeClassFeature) classificationNode.getChildren().getFirst();
					RangeClassFeature rangeClass2 = (RangeClassFeature) classificationNode.getChildren().getLast();
					if (rangeClass1.isMin()) {
						range.setBegin(Integer.parseInt(rangeClass1.getValue()));
						range.setEnd(Integer.parseInt(rangeClass2.getValue()));
					} else {
						range.setBegin(Integer.parseInt(rangeClass2.getValue()));
						range.setEnd(Integer.parseInt(rangeClass1.getValue()));			
					}
					result.getParameters().add(range);
				
				} else {
					List<String> values = getParameterValues(classificationNode);
					if (classificationNode.getDataType().equals(FeatureConstants.TYPE_ENUM)) {
						Enumerative enume = CitLFactory.eINSTANCE.createEnumerative();
						enume.setName(normalize(classificationNode.getName()));
						AnonymousType atype = CitLFactory.eINSTANCE.createAnonymousType();
						enume.setAtype(atype);
						enume.setNamedType(null);
						for (String value : values) {
							Element e = CitLFactory.eINSTANCE.createElement();
							e.setName(normalize(value));
							enume.getAtype().getElements().add(e);
						}
						result.getParameters().add(enume);
					} else if (classificationNode.getDataType().equals(FeatureConstants.TYPE_INTEGER)) {
						Numbers numbers = CitLFactory.eINSTANCE.createNumbers();
						numbers.setName(normalize(classificationNode.getName()));
						for (String value : values) {						
							numbers.getValues().add(Integer.parseInt(value));
						}
						result.getParameters().add(numbers);															
					}
				}
			}
		}		
	}
	
	/**
	 * @param classificationNode
	 * @return
	 */
	private List<String> getParameterValues(ClassificationFeature classificationNode) {
		List<String> values = new LinkedList<String>();
		LinkedList<Feature> children = classificationNode.getChildren();
		for(Feature child : children) {
			// ignore the hidden node
			if (child.isHidden())
				continue;
			LinkedList<Feature> grandChildren = child.getChildren();
			// get the value if there is no further child
			if (grandChildren.isEmpty()) {
				values.add(((ClassFeature)child).getValue());				
			} else {
				// there should be only one node attached 
				// to a class node
				Feature grandChild = grandChildren.getFirst();
				if (grandChild.isHidden()) {
					// if the node attached to the class node 
					// is hidden, add the value of the class node
					values.add(((ClassFeature)child).getValue());
				} else {
					List<String> subValues = getParameterValues((ClassificationFeature) grandChild);
					values.addAll(subValues);
				}
			}
				
		}
		return values;
	}

	private void addConstraints(FeatureModel fm, CitModel result) {
		// TODO by Douglas

	}
}
