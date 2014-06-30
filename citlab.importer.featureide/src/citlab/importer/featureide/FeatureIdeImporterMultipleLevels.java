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
package citlab.importer.featureide;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.EcoreUtil2;
import org.sat4j.specs.TimeoutException;

import citlab.core.ext.ICitLabImporter;
import citlab.core.ext.NotImportableException;
import citlab.model.citL.AnonymousType;
import citlab.model.citL.Operators;
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
import citlab.model.citL.OrExpression;
import citlab.model.citL.OrOperators;
import citlab.model.citL.Parameter;
import citlab.model.citL.impl.CitLPackageImpl;
import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.ConstraintAttribute;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.FeatureModelAnalyzer;
import de.ovgu.featureide.fm.core.io.AbstractFeatureModelReader;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

/**
 * general importer for Feature Models by using the code from featureide.
 * It uses the approach presented in IWCT13.
 * 
 * @author garganti
 * 
 */
public abstract class FeatureIdeImporterMultipleLevels extends ICitLabImporter {
	
	
	private static final Logger logger = Logger.getLogger(FeatureIdeImporterMultipleLevels.class);

	Map<Feature, Expression> choosenExpr = new HashMap<Feature, Expression>();
	// at every feature add a constraint that means that that feature is choosen
	Map<Feature, String> choosenString = new HashMap<Feature, String>();
	// all the constraints
	List<String> constraintStrings = new ArrayList<String>();

	public FeatureIdeImporterMultipleLevels() {
	}
	
	// subclasses can introduce their own reader for feature models (FeatureModel)
	abstract protected AbstractFeatureModelReader getFeatureModelReader(FeatureModel fm);

	
	@Override
	public CitModel importModel(String path) throws NotImportableException {
		FeatureModel fm = null;
		try {
			fm = readModel(path);
			FeatureModelAnalyzer featureModelAnalyzer = fm.getAnalyser();
			if (!featureModelAnalyzer.isValid())
				throw new NotImportableException(path+"\n NOT VALID MODEL");
			// analyze the model in order to find problems, useless features and
			// so on
			featureModelAnalyzer.analyzeFeatureModel(new NullProgressMonitor());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotImportableException(path+"\n FILE NOT FOUND");
		} catch (UnsupportedModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotImportableException(path+"\n UNSUPPORTED EXCEPTION");
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotImportableException(path+"\n TIMEOUT");
		}
		// transform to citlab
		CitModel transformed = transform(fm);
		return transformed;
	}

	private FeatureModel readModel(String path) throws FileNotFoundException,
			UnsupportedModelException {
		FeatureModel fm = new FeatureModel();
		AbstractFeatureModelReader reader = getFeatureModelReader(fm);
		reader.readFromFile(new File(path));
		return fm;
	}
    private String normalize(String x){
    	return Normalizer.normalize(x,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(",", "y");
    }
	/**
	 * 
	 * @param fm
	 * @return an equivalent CitModel
	 */
	private CitModel transform(FeatureModel fm) {
		CitLPackageImpl.init();
		CitModel result = CitLFactory.eINSTANCE.createCitModel();
		Feature root = fm.getRoot();
		result.setName(normalize(normalize(root.getName())));
		// add parameters and set choose
		addParameterFor(root, result);
		// add the constraints (due to the translation)
		addConstraints(root, result);
		// add the extra constraints contained in the original model
		ConstraintConverter converter = new ConstraintConverter(choosenExpr);
		for (Constraint c : fm.getConstraints()) {
			// if the constraint is useless, skip it
			ConstraintAttribute attribute = c.getConstraintAttribute();
			if ((attribute == ConstraintAttribute.REDUNDANT)
					|| (attribute == ConstraintAttribute.DEAD)
					|| (attribute == ConstraintAttribute.TAUTOLOGY))
				continue;
			Expression expr = converter.visit(c.getNode());
			result.getConstraints().add(expr);
		}
		// System.out.println(constraints);
		return result;
	}


	
	/** add the constraints due to the translation
	 * 
	 * @param currentNode
	 * @param result
	 */
	private void addConstraints(Feature currentNode, CitModel result) {
		// aggiungo i constraints
		Feature parent = currentNode.getParent();
		String currentNodeChoose = choosenString.get(currentNode);
		Expression chooseCurrent = choosenExpr.get(currentNode);
		if (parent == null) {
			// assume that parent is the root
			result.getConstraints().add(chooseCurrent);
			constraintStrings.add(currentNodeChoose);
		} else {
			if (parent.isAlternative()) {
				if (currentNode.isAlternative()) {
					// parent alternative and current alternative
					EnumAssign enumAssign = CitLFactory.eINSTANCE.createEnumAssign();
					Parameter pNode = getEnumerativeByName(result,normalize(currentNode.getName()));
					enumAssign.setLeft((Enumerative) pNode);
					enumAssign.setOp(Operators.NE);
					enumAssign.setRight(ModelUtils.getEnumElement(
									(Enumerative) pNode, "NONE"));
					//
					String currentNodeIsTaken = currentNode + "!= NONE";
					// currentNode != NONE <=> choose(currentNode)
					addImpliesConstraint(
							EcoreUtil2.cloneIfContained(enumAssign),
							ImpliesOperator.IFF, EcoreUtil2.cloneIfContained(chooseCurrent),
							result);
					addImpliesConstraint(currentNodeIsTaken, currentNodeChoose,
							ImpliesOperator.IFF);

				} else {
					// the constraints are guranteed by the enumerative
					logger.debug("skipping constraint for "	+ normalize(currentNode.getName()));
				}
			} else if (currentNode.isMandatory() && !parent.isOr()) {
				// mandatory (but leaf in not OR)
				// choose current IFF choose parent 
				addImpliesConstraint(EcoreUtil2.cloneIfContained(chooseCurrent),
						ImpliesOperator.IFF,
						EcoreUtil2.cloneIfContained(choosenExpr.get(parent)), result);
				addImpliesConstraint(currentNodeChoose,
						choosenString.get(parent), ImpliesOperator.IFF);
			} else {
				// not mandatory of not in or  => OPTIONAL 
				// son => parent
				addImpliesConstraint(EcoreUtil2.cloneIfContained(chooseCurrent),
						ImpliesOperator.IMPL,
						EcoreUtil2.cloneIfContained(choosenExpr.get(parent)), result);
				addImpliesConstraint(currentNodeChoose,
						choosenString.get(parent), ImpliesOperator.IMPL);

				// NOT POSSIBLE OPTIMIZATION; se currentNodeChoose � gi� nei
				// constraints posso otttimizzare.
				// if constraints.contains(currentNodeChoose) add only
				// choosen.get(parent)
			}
		}
		// if current Node is an OrNode even if it is root
		if (currentNode.isOr()) {
			// add constraints
			// parent => or dei figli
			addImpliesConstraint(EcoreUtil2.cloneIfContained(chooseCurrent),
					ImpliesOperator.IMPL, EcoreUtil2.cloneIfContained(getOrExp(currentNode
									.getChildren())), result);
			addImpliesConstraint(currentNodeChoose,
					getOr(currentNode.getChildren()), ImpliesOperator.IMPL);
			// it will added that son => parent for every son
		}
		// recurse down the children
		addConstraints(currentNode.getChildren(), result);
	}

	private void addConstraints(LinkedList<Feature> children, CitModel result) {
		for (Feature f : children)
			addConstraints(f, result);
	}

	private void addImpliesConstraint(Expression left, ImpliesOperator impl,
			Expression right, CitModel result) {
		if(impl== ImpliesOperator.IMPL){
			ImpliesExpression implies = CitLFactory.eINSTANCE
					.createImpliesExpression();
			implies.setRight(right);
			implies.setLeft(left);
			implies.setOp(ImpliesOperator.IMPL);
			result.getConstraints().add(implies);
		} else{
			assert (impl == ImpliesOperator.IFF);
			ImpliesExpression iffs = CitLFactory.eINSTANCE.createImpliesExpression();
			iffs.setRight(right);
			iffs.setLeft(left);
			iffs.setOp(ImpliesOperator.IFF);
			result.getConstraints().add(iffs);
		}
	}

	// add the constraint ifPart op thenPart, where op is => or IFF
	private void addImpliesConstraint(String ifPart, String thenPart,
			ImpliesOperator impl) {
		if(impl== ImpliesOperator.IMPL){
			constraintStrings.add(ifPart + " => " + thenPart);
		} else{
			assert (impl == ImpliesOperator.IFF);
			constraintStrings.add(ifPart + " IFF " + thenPart);
		}
	}
	/**
	 * FASE 1: per ogni nodo aggiungi un termine grammatica citlab 
	 * @param currentNode
	 * @param result
	 */
	private void addParameterFor(Feature currentNode, CitModel result) {
		// compute the type for father
		//System.out.println("adding parameter for " + currentNode);
		if (currentNode.isAlternative()) {
			// aggiungi come enumerativo
			Enumerative en = getEnumerative(currentNode);
			result.getParameters().add(en);
			// update chosen unless is an alternative and already set
			if (currentNode.getParent() != null
					&& currentNode.getParent().isAlternative()) {
				logger.debug("skipping choose for " + currentNode.getName());
			} else {
				// set chosen for the currentNode 
				EnumAssign enumAssign = CitLFactory.eINSTANCE .createEnumAssign();
				enumAssign.setLeft(en);
				enumAssign.setOp(Operators.NE);
				enumAssign.setRight(ModelUtils.getEnumElement(en, "NONE"));
				setChosen(currentNode, enumAssign);
				setChosen(currentNode, normalize(currentNode.getName()) + " != NONE");

			}
			// get newphews
			for (Feature son : currentNode.getChildren()) {
				// update choosen for son ???
				EnumAssign enumAssign = CitLFactory.eINSTANCE.createEnumAssign();
				enumAssign.setLeft(en);
				enumAssign.setOp(Operators.EQ);
				enumAssign.setRight(ModelUtils.getEnumElement(en,normalize( son.getName())));
				setChosen(son, enumAssign);
				setChosen(son, normalize(currentNode.getName()) + " = " + normalize(son.getName()));
				// if son is an alternative, add paramters for it
				if (son.isAlternative())
					addParameterFor(son, result);
				else {
					// if son is not an alternative, skip it (traslated already as element)
					for (Feature nephew : son.getChildren()) {
						addParameterFor(nephew, result);
					}
				}
			}
		} else {
			// current node is not an alternative
			Boolean bool = CitLFactory.eINSTANCE.createBoolean();
			bool.setName(normalize(currentNode.getName()));
			result.getParameters().add(bool);
			BoolAssign boolassign = CitLFactory.eINSTANCE.createBoolAssign();
			boolassign.setOp(Operators.EQ);
			boolassign.setLeft(bool);
			boolassign.setRight(BooleanConst.TRUE);

			setChosen(currentNode, boolassign);
			setChosen(currentNode, normalize(currentNode.getName()) + " = true");

			logger.debug("boolean " + currentNode);
			for (Feature son : currentNode.getChildren()) {
				addParameterFor(son, result);
			}
		}
	}

	private Expression createOrExpression(ArrayList<Expression> bList) {
		assert bList.size() >= 1;
		Expression result = null;
		for (Expression boola : bList) {
			// the first one
			if (result == null) {
				result = boola;
			} else {
				// the seond and so on
				OrExpression resultP = CitLFactory.eINSTANCE
						.createOrExpression();
				resultP.setLeft(result);
				resultP.setOp(OrOperators.OR);
				resultP.setRight(boola);
				result = resultP;
			}
		}

		return result;
	}

	Enumerative getEnumerative(Feature root) {
		Enumerative enume = CitLFactory.eINSTANCE.createEnumerative();
		enume.setName(normalize(root.getName()));
		AnonymousType atype = CitLFactory.eINSTANCE.createAnonymousType();
		enume.setAtype(atype);
		enume.setNamedType(null);
		for (Feature nephew : root.getChildren()) {
			Element e = CitLFactory.eINSTANCE.createElement();
			e.setName(normalize(nephew.getName()));
			enume.getAtype().getElements().add(e);
		}
		Element e = CitLFactory.eINSTANCE.createElement();
		e.setName("NONE");
		enume.getAtype().getElements().add(e);
		return enume;
	}

	private Parameter getEnumerativeByName(CitModel result, String name) {
		for (Parameter parameter : result.getParameters()) {
			if (normalize(parameter.getName()).equals(normalize(name))
					&& (parameter instanceof Enumerative)) {
				return parameter;
			}
		}
		throw new RuntimeException(name + " not found");
	}

	private String getOr(LinkedList<Feature> children) {
		String result = "";
		for (Feature f : children) {
			result += " OR " + choosenString.get(f);
		}
		return result;
	}

	private Expression getOrExp(LinkedList<Feature> children) {
		ArrayList<Expression> bList = new ArrayList<Expression>();
		for (Feature f : children) {
			bList.add(EcoreUtil2.cloneIfContained(choosenExpr.get(f)));
		}
		return createOrExpression(bList);
	}


	private void setChosen(Feature currentNode, Expression expr) {
		assert choosenString.get(currentNode) == null : "current value "
				+ choosenString.get(currentNode) + "->" + expr.toString();
		choosenExpr.put(currentNode, expr);
	};

	private void setChosen(Feature currentNode, String string) {
		assert choosenString.get(currentNode) == null : "current value "
				+ choosenString.get(currentNode) + "->" + string;
		choosenString.put(currentNode, string);
	}
}
