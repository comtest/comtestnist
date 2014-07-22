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
package citlab.model.simplifier;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;


import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.Boolean;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.Expression;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Operators;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.SimpleExpressionToString;
/** 
 * 
 * semplifica i parmetri rimuovendoli se possibile
 * 
 *
 */
public final class ParameterSimplifier extends Simplifier {
	
	static private final Logger logger = Logger.getLogger(ParameterSimplifier.class);
	
	Set<AtomicPredicate> removed = new HashSet<AtomicPredicate>();

	/** builds a new parameter simplificer
	 * (constructur nededd since every model has different parameters removed)
	 */
	ParameterSimplifier() {}

	@Override
	void simplify(CitModel model) {
		Iterator<Parameter> params = model.getParameters().iterator();
		while (params.hasNext()) {
			Parameter p = params.next();
			logger.debug("looking for "+ p.getName() + " =/!= X");
			// search for a constraint p = x
			Iterator<Rule> constraintsIterator = model.getConstraints().iterator();
			while (constraintsIterator.hasNext()) {
				// check if constraint p = x
				Expression constraint = (Expression) constraintsIterator.next();
				if ((p instanceof Boolean) && (constraint instanceof BoolAssign)) {
					BoolAssign boolAssign = (BoolAssign) constraint;
					if (boolAssign.getLeft() == p){
						// p is boolean and constraint is a BoolAssign about p kind of p = true or p = false
						if (!inConstraints(model.getConstraints(), p, constraint)) {
							// delete p and delete constraints
							logger.debug("removing "+ p.getName());
							addRemovedAssignment((BoolAssign)constraint);
							constraintsIterator.remove();
							params.remove();
							
						} else{
							logger.debug(p.getName() +" cannot be removed since it compares in a constraint" );							
						}
					}
				}
				if ((p instanceof Enumerative) && (constraint instanceof EnumAssign) && 
						(((EnumAssign) constraint).getLeft() == p)) {
					// p is an enumerative and constraint is about p 
					Element element = ((EnumAssign) constraint).getRight();
					if (((EnumAssign) constraint).getOp() == Operators.NE) {
						// constraint p != element
						if (!inConstraints(model.getConstraints(), element, constraint)) {
							//System.out.println("***  removing " + element.getName() + " from " + p .getName());
							//System.out.println("***  removing " + constraint);
							constraintsIterator.remove();
							EnumerativeType enumerativeType = ModelUtils.getEnumerativeType(((Enumerative) p));
							enumerativeType.getElements().remove(element);
						}
					}
					if (((EnumAssign) constraint).getOp() == Operators.EQ) {
						if (!inConstraints(model.getConstraints(), p, constraint)) {
							addRemovedAssignment((EnumAssign)constraint);
							constraintsIterator.remove();
							params.remove();
							
						}
						// remove the other constraints
						// for (final Element oneLeft :
						// ModelUtils.getEnumerativeType(((Enumerative)p)).getElements())
						// {
						// if(oneLeft!= element){
						// ModelUtils.getEnumerativeType(((Enumerative)p)).getElements().remove(oneLeft);
						// }
						// }
					}

				}
			}

		}
	}

	private void addRemovedAssignment(AtomicPredicate constraint) {
		removed.add(constraint);		
	}	

	private boolean inConstraints(EList<Rule> constraints, Element element, Expression except) {
		logger.debug("checking element " + element.getName());
		ElementInRule pramRule =  new ElementInRule(element);
		assert pramRule != null;
		for(Rule r: constraints){
			if (r == except) continue;
			logger.debug("in constraint " + SimpleExpressionToString.eInstance.doSwitch(r));			
			if (pramRule.doSwitch(r)) return true;
		}
		return false;
	}

	/**
	 * 
	 * @param constraints
	 * @param p
	 * @param except: constraint to skip
	 * @return
	 */
	private boolean inConstraints(EList<Rule> constraints, Parameter p, Expression except) {
		logger.debug("checking parameter " + p.getName() + " in constraints");
		ParameterInRule pramRule =  new ParameterInRule(p);
		for(Rule r: constraints){
			if (r == except) continue;
			logger.debug("in constraint " + SimpleExpressionToString.eInstance.doSwitch(r));			
			if (pramRule.doSwitch(r)) return true;
		}
		return false;
	}
}
