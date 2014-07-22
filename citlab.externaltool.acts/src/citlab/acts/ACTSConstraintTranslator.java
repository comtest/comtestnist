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
package citlab.acts;

import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.AndExpression;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ModMultDiv;
import citlab.model.citL.NotExpression;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Operators;
import citlab.model.citL.OrExpression;
import citlab.model.citL.PlusMinus;
import citlab.model.citL.PlusMinusOperators;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.util.CitLSwitch;

/**
 * translates a constraints in the ACTS language
 * 
 * @author garganti
 * 
 */
public class ACTSConstraintTranslator extends CitLSwitch<String> {

	private static final String ACTS_OP_NEQ = "!=";
	private static final String ACTS_OP_AND = "&&";
	private static final String ACTS_OP_IMPLIES = "=>";
	@SuppressWarnings("unused")
	private static final String ACTS_OP_IFF = "=";
	private static final String ACTS_OP_EQ = "=";
	private static final boolean AVOID_BOOLASSIGN = true;

	// the constraint to be translated;
	Rule cons;

	ACTSConstraintTranslator(Rule c) {
		cons = c;
	}

	@Override
	public String caseNotExpression(NotExpression not) {
		String predicate = this.doSwitch(not.getPredicate());
		return "! (" + predicate + ")";
	}

	@Override
	public String caseImpliesExpression(ImpliesExpression ruleExpr){
		String leftVal = this.doSwitch(ruleExpr.getLeft());
		String rightVal = this.doSwitch(ruleExpr.getRight());
		switch (ruleExpr.getOp()) {
		case IMPL:
			return parathesis(leftVal, ACTS_OP_IMPLIES, rightVal);
		case IFF:
			return parathesis(parathesis(leftVal, ACTS_OP_IMPLIES, rightVal), ACTS_OP_AND,parathesis(rightVal, ACTS_OP_IMPLIES, leftVal) );
		}
		throw new RuntimeException("Operator not found in seed");

	}

	private String parathesis(String leftVal, String op, String rightVal){
		// choco does not accept nagtive integers
		if (rightVal.matches("-\\d+")) throw new RuntimeException(new NotConvertableModel("choco does not accept constraints witrh negative numbers"));
		return "(" + leftVal + ")" + op + "(" + rightVal + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseOr(combinatorial.comb.comB.Or)
	 */
	@Override
	public String caseOrExpression(OrExpression orExpr) {
		String leftVal = this.doSwitch(orExpr.getLeft());
		String rightVal = this.doSwitch(orExpr.getRight());
		return parathesis(leftVal, "||", rightVal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseAnd(combinatorial.comb.comB
	 * .And)
	 */
	@Override
	public String caseAndExpression(AndExpression andExpr) {
		String leftVal = this.doSwitch(andExpr.getLeft());
		String rightVal = this.doSwitch(andExpr.getRight());
		return parathesis(leftVal, ACTS_OP_AND, rightVal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseInequality(combinatorial.comb
	 * .comB.Inequality )
	 */
	@Override
	public String caseRelationalExpression(RelationalExpression ineqExpr) {
		String numerical = ineqExpr.getLeft().getName();
		String value2 = this.doSwitch(ineqExpr.getRight());
		switch (ineqExpr.getOp()) {
		case EQ:
			return parathesis(numerical, ACTS_OP_EQ, value2);
		case GE:
			return parathesis(numerical, ">=", value2);
		case GT:
			return parathesis(numerical, ">", value2);
		case LE:
			return parathesis(numerical, "<=", value2);
		case LT:
			return parathesis(numerical, "<", value2);
		case NE:
			return parathesis(numerical, ACTS_OP_NEQ, value2);
		}
		throw new RuntimeException("Operator not found in constraint");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseAssign(combinatorial.comb.
	 * comB.Assign)
	 */
	@Override
	public String caseEnumAssign(EnumAssign assgn) {
		String enume = assgn.getLeft().getName();
		String e1 = this.doSwitch(assgn.getRight());
		if (assgn.getOp() == Operators.EQ) {
			return parathesis(enume, ACTS_OP_EQ, e1);
		} else if (assgn.getOp() == Operators.NE)
			return parathesis(enume, ACTS_OP_NEQ, e1);
		throw new RuntimeException("operator enum assign???");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseBoolAssign(combinatorial.comb
	 * .comB.BoolAssign )
	 */
	@Override
	public String caseBoolAssign(BoolAssign Bassign) {
		String bs = Bassign.getLeft().getName();
		BooleanConst right = Bassign.getRight();
		if (Bassign.getOp() == Operators.EQ){
			if (AVOID_BOOLASSIGN){
				if (right == BooleanConst.TRUE) return bs;
				else return "! " + bs + "";
			} else{
				// traslate to = true or = false
				String e1 = right.getLiteral();// true or false
				return parathesis(bs, ACTS_OP_EQ, e1);
			}
		} else if (Bassign.getOp() == Operators.NE){
			if (AVOID_BOOLASSIGN){
				if (right == BooleanConst.TRUE) return  "! " + bs + "";
				else return bs;
			} else{
				// traslate to != true or != false
				String e1 = right.getLiteral();// true or false
				return parathesis(bs, ACTS_OP_NEQ, e1);
			}
		} 
		throw new RuntimeException("operator bool assign???");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#casePlusMinus(combinatorial.comb
	 * .comB.PlusMinus)
	 */
	@Override
	public String casePlusMinus(PlusMinus pm) {
		String leftVal = this.doSwitch(pm.getLeft());
		String rightVal = this.doSwitch(pm.getRight());
		if (pm.getOp() == PlusMinusOperators.MINUS)
			return parathesis(leftVal, "-", rightVal);
		else
			return parathesis(leftVal, "+", rightVal);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseModMultDiv(combinatorial.comb
	 * .comB.ModMultDiv)
	 */
	@Override
	public String caseModMultDiv(ModMultDiv md) {
		String leftVal = this.doSwitch(md.getLeft());
		String rightVal = this.doSwitch(md.getRight());
		switch (md.getOp()) {
		case DIV:
			return parathesis(leftVal, "/", rightVal);
		case MULT:
			return parathesis(leftVal, "*", rightVal);
		case MOD:
			return parathesis(leftVal, "%", rightVal);
		}
		throw new RuntimeException("Operator not found");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * combinatorial.comb.comB.util.CmbSwitch#caseNumberLiteral(combinatorial
	 * .comb.comB.NumberLiteral)
	 */
	@Override
	public String caseNumberLiteral(NumberLiteral nl) {
		// is a value literal 2
		if (nl.getNumerical() == null)
			return String.valueOf(nl.getNumber());
		// is a constant // range // value
		else
			if(nl.getNumerical() instanceof ConstantNumber)
			return String.valueOf(( (ConstantNumber)nl.getNumerical()).getValue());
			else return ((nl.getNumerical()).getName()) ;
	}

	@Override
	public String caseElement(Element e) {
		// in ACTS element must be quoted
		return "\"" + e.getName() + "\"";
	}

}
