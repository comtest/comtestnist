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
package citlab.atgtsmt;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import tgtlib.definitions.expression.BinaryExpression;
import tgtlib.definitions.expression.Expression;
import tgtlib.definitions.expression.Operator;
import tgtlib.definitions.expression.UnaryExpression;
import tgtlib.definitions.expression.type.EnumConst;
import tgtlib.definitions.expression.type.EnumType;
import atgt.specification.location.Variable;
import citlab.model.citL.AndExpression;
import citlab.model.citL.Operators;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.NotExpression;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Parameter;
import citlab.model.citL.util.CitLSwitch;

/** convert an expression from Citlab to AsmExpression
 * 
 */
public class ExpressionConverter extends CitLSwitch<Expression>{
	
	Map<Parameter, Variable> vars;
	
	ExpressionConverter(Map<Parameter, Variable> vars){
		this.vars = vars;
	}
	
	@Override
	public Expression doSwitch(EObject eObject) {
		// TODO da eliminare 
		//System.out.println("****" + eObject.getClass());
		return super.doSwitch(eObject);
	}
	
	
	@Override
	public Expression caseAndExpression(AndExpression a) {
		return BinaryExpression.mkBinExpr(doSwitch(a.getLeft()), Operator.AND,doSwitch(a.getRight()));
	}

	@Override
	public Expression caseOrExpression(OrExpression a) {
		return BinaryExpression.mkBinExpr(doSwitch(a.getLeft()), Operator.OR,doSwitch(a.getRight()));
	}
	
	@Override
	public Expression caseImpliesExpression(ImpliesExpression a) {
		if(a.getOp()==ImpliesOperator.IFF){
			return BinaryExpression.mkBinExpr(doSwitch(a.getLeft()), Operator.EQ,doSwitch(a.getRight()));			
		} else{
			assert (a.getOp()==ImpliesOperator.IMPL);
			return BinaryExpression.mkBinExpr(doSwitch(a.getLeft()), Operator.IMPLIES,doSwitch(a.getRight()));			
		}
	}
	@Override
	public Expression caseNotExpression(NotExpression not) {
		return UnaryExpression.mkUnExpr(Operator.NOT, doSwitch(not.getPredicate()));
	}
	
	@Override
	public Expression caseEnumAssign(EnumAssign e) {
		Enumerative enumerative = e.getLeft();
		Variable varEnum = vars.get(enumerative);
		EnumType type = (EnumType) varEnum.getType();
		EnumConst ec = type.getEnumConst(e.getRight().getName());
		if (e.getOp() == Operators.EQ){
			return BinaryExpression.mkBinExpr(varEnum.getIdExpression(), Operator.EQ,ec);			
		} else{			
			assert (e.getOp() == Operators.NE);
			return BinaryExpression.mkBinExpr(varEnum.getIdExpression(), Operator.NEQ,ec);
		}
	}	
	
	@Override
	public Expression caseBoolAssign(BoolAssign e) {
		Boolean boolVar = e.getLeft();
		Variable varEnum = vars.get(boolVar);
		// A == TRUE
		if (e.getOp() == Operators.EQ && e.getRight() == BooleanConst.TRUE){
			return varEnum.getIdExpression();			
		} 
		// A != FALSE
		if (e.getOp() == Operators.NE && e.getRight() == BooleanConst.FALSE){
			return varEnum.getIdExpression();			
		} 
		return UnaryExpression.mkUnExpr(Operator.NOT,varEnum.getIdExpression());
	}
	
}
