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
/*
 * 
 */
package citlab.model.validation;

import citlab.model.citL.AndExpression;
import citlab.model.citL.Aseed;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.Element;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.Operators;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.NotExpression;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.citL.util.CitLSwitch;
 
/**
 * Evaluated if a rule makes a seed invalid, it generate a boolean output .
 * 
 * @author garganti vava
 */
public class RuleEvaluator extends CitLSwitch<Boolean> {
	
	/** The seed. */
	Seed seed;

	/**
	 * Sets the seed that requires to be validate.
	 * 
	 * @param s
	 *            the new seed
	 */	
	public RuleEvaluator(Seed s){
		this.seed = s;
	}


	/**
	 * If true the seed is valid, if false the seed is invalid an the validator
	 * generates an error runtime .
	 * 
	 * @param r
	 *            the r
	 * @return the boolean
	 */
	public Boolean evaluateRule(Rule r) {
		assert seed!= null;
		return this.doSwitch(r);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseNot(combinatorial.comb.comB
	 * .Not)
	 */
	@Override
	public Boolean caseNotExpression(NotExpression not) {
		if (not == null || not.getPredicate() == null)
			return null;
		Boolean predicate = this.doSwitch(not.getPredicate());
		return !predicate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecombinatorial.comb.comB.util.CmbSwitch#caseImpliesExpression(combinatorial.comb
	 * .comB. LogicalRule)
	 */
	@Override
	public Boolean caseImpliesExpression(ImpliesExpression ruleExpr) {
		if (ruleExpr == null || ruleExpr.getLeft() == null
				| ruleExpr.getRight() == null) {
			return null;
		}
		Boolean leftVal = this.doSwitch(ruleExpr.getLeft());
		// if leftval is false and implication
		if (!leftVal && ruleExpr.getOp() == ImpliesOperator.IMPL) return true;
		Boolean rightVal = this.doSwitch(ruleExpr.getRight());
		switch(ruleExpr.getOp()){
		case IMPL:
			return !leftVal || rightVal;
		case IFF:
			return(leftVal == rightVal);
			
		}
		throw new RuntimeException("Operator not found in seed");
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseOr(combinatorial.comb.comB.Or)
	 */
	@Override
	public Boolean caseOrExpression(OrExpression orExpr) {
		if (orExpr == null || orExpr.getLeft() == null
				|| orExpr.getRight() == null) {
			return null;
		}
		Boolean leftVal = this.doSwitch(orExpr.getLeft());
		// if the first one is true, exit
		if (leftVal ) return true;
		Boolean rightVal = this.doSwitch(orExpr.getRight());
		return rightVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseAnd(combinatorial.comb.comB
	 * .And)
	 */
	@Override
	public Boolean caseAndExpression(AndExpression andExpr) {
		if (andExpr == null || andExpr.getLeft() == null
				|| andExpr.getRight() == null) {
			return null;
		}
		Boolean leftVal = this.doSwitch(andExpr.getLeft());
		// simulate short circuit - first is false
		if (! leftVal ) return false;
		Boolean rightVal = this.doSwitch(andExpr.getRight());
		return rightVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseInequality(combinatorial.comb
	 * .comB.Inequality )
	 */
	@Override
	public Boolean caseRelationalExpression(RelationalExpression ineqExpr) {
		if (ineqExpr == null || ineqExpr.getLeft() == null
				|| ineqExpr.getRight() == null) {
			return null;
		}
		Numerical numerical = ineqExpr.getLeft();
		ArithmeticEvaluator aEvaluetor = new ArithmeticEvaluator(seed);
		Double value2 = aEvaluetor.evaluateArith(ineqExpr.getRight());
		Double value1 = getNumericalInSeed(numerical,this.seed);
		switch (ineqExpr.getOp()) {
		case EQ:
			return value1.equals(value2);
		case GE:
			return value1 >= value2;
		case GT:
			return value1 > value2;
		case LE:
			return value1 <= value2;
		case LT:
			return value1 < value2;
		case NE:
			return !(value1.equals(value2));
		}
		throw new RuntimeException("Operator not found in seed");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseAssign(combinatorial.comb.
	 * comB.Assign)
	 */
	@Override
	public Boolean caseEnumAssign(EnumAssign assgn) {
		Enumerative enume = assgn.getLeft();
		if (enume == null) {
			return null;
		}
		Element e1 = assgn.getRight();
		Element e2 = getEnuMvalueInSeed(enume);
		Operators op = assgn.getOp();
		if (op == Operators.EQ) {
			return e2 == e1;
		} else if (op == Operators.NE)
			return e2 != e1;
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseBoolAssign(combinatorial.comb
	 * .comB.BoolAssign )
	 */
	@Override
	public Boolean caseBoolAssign(BoolAssign Bassign) {
		citlab.model.citL.Boolean bs = Bassign.getLeft();
		if (bs == null) {
			return null;
		}
		BooleanConst e1 = Bassign.getRight();
		BooleanConst e2 = getBooleanInSeed(bs);
		if (Bassign.getOp() == citlab.model.citL.Operators.EQ)
		return e2 == e1;
		else 
			return e2 !=e1;

	}

	/**
	 * Gets the enumerative assignments in the seed.
	 * 
	 * @param enume
	 *            the enume
	 * @return the enu mvalue in seed
	 */
	private Element getEnuMvalueInSeed(Enumerative enume) {
		if (enume == null)
			return null;
		for (Aseed a : seed.getAssigmentSeedList()) {
			if (a instanceof EnumSeed) {
				if (((EnumSeed) a).getLeft() == enume) {
					return ((EnumSeed) a).getRight();
				}
			}
		}
		return null;
	}

	/**
	 * Gets the boolean assignment in the seed.
	 * 
	 * @param BSF
	 *            the bSF
	 * @return the boolean in seed
	 */
	private BooleanConst getBooleanInSeed(citlab.model.citL.Boolean BSF) {
		if (BSF == null)
			return null;
		for (Aseed a : seed.getAssigmentSeedList()) {
			if (a instanceof BoolAssignSeed) {
				if (((BoolAssignSeed) a).getLeft() == BSF) {
					return ((BoolAssignSeed) a).getRight();
				}
			}
		}
		// it reach this point only when i'm typing my seed, when it is
		// incomplete.
		return null;
	}

	/**
	 * Gets the numerical assignments in the seed.
	 * 
	 * @param numerical
	 *            the numerical
	 * @return the numerical in seed
	 */
	public static Double getNumericalInSeed(citlab.model.citL.Numerical numerical, Seed seed) {
		if (numerical == null)
			return null;
		for (Aseed a : seed.getAssigmentSeedList()) {
			if (a instanceof NumericalSeed) {
				if (((NumericalSeed) a).getLeft() == numerical) {
					if(((NumericalSeed) a).getRight().getConstant() !=null)
					return ((double) ((NumericalSeed) a).getRight().getConstant().getValue());
					else
						return ((double) ((NumericalSeed) a).getRight().getNumber());
				}
			}
		}
		return null;
	}
}
