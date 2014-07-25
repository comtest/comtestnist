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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.EcoreUtil2;

import citlab.model.citL.AnonymousType;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numbers;
import citlab.model.citL.Operators;
import citlab.model.citL.Range;
import citlab.model.citL.Rule;
import citlab.model.citL.impl.CitLPackageImpl;
import citlab.model.logic.cnf.SimpleExpressionToString;
import citlab.model.simplifier.ConstraintSimplifier;
import citlab.model.simplifier.ParameterSimplifier;
import citlab.model.simplifier.Simplificator;
import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.ConstraintAttribute;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureConstants;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.RangeClassFeature;

/**
 * TODO description
 * 
 * @author Wayman Tan, dkrew
 */
public class CitLabModelConverter {
	
	Map<Feature, Expression> choosenExpr = new HashMap<Feature, Expression>();
	
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
		addConstraintsMine(fm, result);   
		
		return result;		
	}
	
	public void validateModel(FeatureModel featureModel) throws UnconvertibleModelException {		
		Map<String, Feature> featureTable = featureModel.getFeatureTable();
		for(Feature node: featureTable.values()) {
			LinkedList<Feature> children = node.getChildren();
			// ensure all the leaf nodes are Class nodes
			if (children.isEmpty()) {
				// return false if the leaf node is not a ClassNode
				if (!(node instanceof ClassFeature)) {
					throw new UnconvertibleModelException(node.getName() + 
							" cannot be a leaf node because it is not a Class node.");				
				}
			}
			
			// ensure all Class nodes contain values
			if (node instanceof ClassFeature) {
				String value = ((ClassFeature)node).getValue();
				if (value == null||"".equals(value)) {
					throw new UnconvertibleModelException(node.getName() +
															" under " + node.getParent().getName() +
															" does not have a value.");					
				}
				
				if (node.isAbstract()) {
					String concreteValue = ((ClassFeature)node).getConcreteValue();
					if (concreteValue == null||"".equals(concreteValue)) {
						throw new UnconvertibleModelException("Abstract Class node " + node.getName() + 
															" under " + node.getParent().getName() +
															" does not have a concrete value.");					
					}
				}
			}
			
			if (node instanceof ClassificationFeature) {
				// ensure all Classification nodes should at least have two children
				if (children.size() < 2) {
					throw new UnconvertibleModelException(node.getName() + 
							" should have at least 2 children.");
				}
				
				// ensure all Classification nodes are in same type with their parent Classification node
				Feature parent = node.getParent();
				if (parent instanceof ClassFeature) {
					// Currently only allow a Classification node added to a class node
					Feature grandParent = parent.getParent();
					String dataType = ((ClassificationFeature)node).getDataType();
					String grandParentDataType = ((ClassificationFeature)grandParent).getDataType();
					if(!(dataType.equals(grandParentDataType))) {
						throw new UnconvertibleModelException(node.getName() + 
								" does not have the same type with its parents.");
					}
				}				
			}
		}		
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
					
					ClassFeature cf1 = (ClassFeature) classificationNode.getChildren().getFirst();
					ClassFeature cf2 = (ClassFeature) classificationNode.getChildren().getLast();
					
					BoolAssign boolassign_True = CitLFactory.eINSTANCE.createBoolAssign();
					boolassign_True.setOp(Operators.EQ);
					boolassign_True.setLeft(bool);
					boolassign_True.setRight(BooleanConst.TRUE);
					setChosen((Feature)cf1, boolassign_True);
					
					BoolAssign boolassign_False = CitLFactory.eINSTANCE.createBoolAssign();
					boolassign_False.setOp(Operators.EQ);
					boolassign_False.setLeft(bool);
					boolassign_False.setRight(BooleanConst.FALSE);
					setChosen((Feature)cf2, boolassign_False);
					
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
						System.out.println("From type Range");
						
						setChosen(rangeClass1, 	
								getEnumAssignWithOneValue((Feature)rangeClass1, rangeClass1.toString()));
						
					} else {
						range.setBegin(Integer.parseInt(rangeClass2.getValue()));
						range.setEnd(Integer.parseInt(rangeClass1.getValue()));			
						
						System.out.println("From type Range");

						setChosen((Feature)rangeClass2, 	
								getEnumAssignWithOneValue(rangeClass2, rangeClass2.toString()));
					}
					result.getParameters().add(range);
					
				
					
					
				
				} else {
					List<String> values = getParameterValues(classificationNode);
					List<Feature> featureList = getParameterFeature(classificationNode);
					if (classificationNode.getDataType().equals(FeatureConstants.TYPE_ENUM)) {
						Enumerative enume = CitLFactory.eINSTANCE.createEnumerative();
						enume.setName(normalize(classificationNode.getName()));
						AnonymousType atype = CitLFactory.eINSTANCE.createAnonymousType();
						enume.setAtype(atype);
						enume.setNamedType(null);
						
						
						int counter_for_feature_List = 0;
						for (String value : values) {
							Element e = CitLFactory.eINSTANCE.createElement();
							e.setName(normalize(value));
							enume.getAtype().getElements().add(e);
							
							
							
							setChosen((Feature)featureList.get(counter_for_feature_List), 
									getEnumAssignWithOneValue(featureList.get(counter_for_feature_List), value));
							counter_for_feature_List++;
						}
		

						// For Constraints/////////////////////////////////////////
//						Element e = CitLFactory.eINSTANCE.createElement();
//						System.out.println("adding ina NONE");
//						e.setName("NONE");
//						enume.getAtype().getElements().add(e);
//						
//						// I believe this will hava all the ranges...
//						System.out.println("From type ENUM");
//						EnumAssign enumAssign = CitLFactory.eINSTANCE .createEnumAssign();
//						enumAssign.setLeft(enume);
//						enumAssign.setOp(Operators.NE);
//						enumAssign.setRight(ModelUtils.getEnumElement(enume, "NONE"));
//						setChosen(classificationNode, enumAssign);
						/////////////////////////////////////////////////////////////////////
						result.getParameters().add(enume);
					
					} else if (classificationNode.getDataType().equals(FeatureConstants.TYPE_INTEGER)) {
						Numbers numbers = CitLFactory.eINSTANCE.createNumbers();
						numbers.setName(normalize(classificationNode.getName()));
						int counter_for_feature_List = 0;
						for (String value : values) {						
							numbers.getValues().add(Integer.parseInt(value));
							//setChosen(classificationNode, normalize(numbers.toString()));
							
							setChosen((Feature)featureList.get(counter_for_feature_List), 
									getEnumAssignWithOneValue(featureList.get(counter_for_feature_List), value));
							counter_for_feature_List++;
						}
						result.getParameters().add(numbers);			
			
						
//						System.out.println("From type INTEGER");
//						Enumerative en = getEnumerative(classificationNode);
//						EnumAssign enumAssign = CitLFactory.eINSTANCE .createEnumAssign();
//						enumAssign.setLeft(en);
//						enumAssign.setOp(Operators.NE);
//						enumAssign.setRight(ModelUtils.getEnumElement(en, "NONE"));
//						setChosen(classificationNode, enumAssign);
						
						
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

	
	private List<Feature> getParameterFeature(ClassificationFeature classificationNode) {
		List<Feature> values = new LinkedList<Feature>();
		LinkedList<Feature> children = classificationNode.getChildren();
		for(Feature child : children) {
			// ignore the hidden node
			if (child.isHidden())
				continue;
			LinkedList<Feature> grandChildren = child.getChildren();
			// get the value if there is no further child
			if (grandChildren.isEmpty()) {
				values.add(((ClassFeature)child));				
			} else {
				// there should be only one node attached 
				// to a class node
				Feature grandChild = grandChildren.getFirst();
				if (grandChild.isHidden()) {
					// if the node attached to the class node 
					// is hidden, add the value of the class node
					values.add(((ClassFeature)child));
				} else {
					List<Feature> subValues = getParameterFeature((ClassificationFeature) grandChild);
					values.addAll(subValues);
				}
			}
				
		}
		return values;
	}
	private void addConstraintsMine(FeatureModel fm, CitModel result) {
		System.out.println("addCscscsconstraintsaddConstraints");   
		    
//			for(Entry<Feature,Expression> entry : choosenExpr.entrySet()){
//				System.out.println(entry.getKey().toString());
//				System.out.println(SimpleExpressionToString.eInstance.doSwitch(entry.getValue()));
//				
//			}
//		
		
	//	System.out.println(result.getConstraints().get(0).toString());
		/*ConstraintConverter converter = new ConstraintConverter(choosenExpr);
		for (Constraint c : fm.getConstraints()) {
			// if the constraint is useless, skip it
			ConstraintAttribute attribute = c.getConstraintAttribute();
			if ((attribute == ConstraintAttribute.REDUNDANT)
					|| (attribute == ConstraintAttribute.DEAD)
					|| (attribute == ConstraintAttribute.TAUTOLOGY))
				continue;
			
			
			System.out.println(c.toString());
			System.out.println(c.getNode().toString());
			System.out.println(c.getContainedFeatures());
			Expression expr = converter.visit(c.getNode());
			result.getConstraints().add(expr);
			System.out.println(expr.toString());
		}
		
		for(Rule r : result.getConstraints()){
			System.out.println(SimpleExpressionToString.eInstance.doSwitch(r));
			
		}
		
//		(display==BW) => (rearCamera==NOC)
//				(display==BW) => (rearCamera==1MP)
//				(emailViewer==true) or (((frontCamera!=NOC) => (display!=BW)) and ((textLines) >= (threshold)))
		}*/
		// TODO by Douglas

   
		
		
		
	}
	
	private void setChosen(Feature currentNode, Expression expr) {
		choosenExpr.put(currentNode, expr);
	};
	
	// This will generate an enumerative for all type except boolean
	Enumerative getEnumerative(Feature root) {
		Enumerative enume = CitLFactory.eINSTANCE.createEnumerative();
		System.out.println("Setting name    " + root.getName());
		enume.setName(normalize(root.getName()));
		AnonymousType atype = CitLFactory.eINSTANCE.createAnonymousType();
		enume.setAtype(atype);
		enume.setNamedType(null);
		for (Feature nephew : root.getChildren()) {
			Element e = CitLFactory.eINSTANCE.createElement();
			e.setName(normalize(nephew.getName()));
			System.out.println("Setting child  " + nephew.getName());
			enume.getAtype().getElements().add(e);
		}
		Element e = CitLFactory.eINSTANCE.createElement();
		
		System.out.println("adding ina NONE");
		e.setName("NONE");
		enume.getAtype().getElements().add(e);
		return enume;
	}
	
	
	private EnumAssign getEnumAssignWithOneValue(Feature root, String nodeName){
		
		Enumerative enume = CitLFactory.eINSTANCE.createEnumerative();
		enume.setName(normalize(root.getName()));
		AnonymousType atype = CitLFactory.eINSTANCE.createAnonymousType();
		enume.setAtype(atype);
		enume.setNamedType(null);

		Element e = CitLFactory.eINSTANCE.createElement();
		e.setName(nodeName);
		enume.getAtype().getElements().add(e);
		
		
	
		EnumAssign enumAssign = CitLFactory.eINSTANCE .createEnumAssign();
		enumAssign.setLeft(enume);
		enumAssign.setOp(Operators.EQ);
		enumAssign.setRight(ModelUtils.getEnumElement(enume, nodeName));
		
		return enumAssign;
	}
	
	
	

}
