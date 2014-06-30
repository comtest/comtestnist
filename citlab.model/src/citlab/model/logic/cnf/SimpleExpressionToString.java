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
package citlab.model.logic.cnf;

import org.eclipse.emf.ecore.EObject;

import citlab.model.citL.AndExpression;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.Boolean;
import citlab.model.citL.Constant;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.NotExpression;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalEx;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Range;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.util.CitLSwitch;

/**
 * convert an expression to string without using the serializer
 * 
 * @author garganti
 * 
 */
public class SimpleExpressionToString extends CitLSwitch<String> {

	public static SimpleExpressionToString eInstance = new SimpleExpressionToString();

	private SimpleExpressionToString() {
	}

	@Override
	public String caseAndExpression(AndExpression and) {
		return "(" + this.doSwitch(and.getLeft()) + ") and ("
				+ this.doSwitch(and.getRight()) + ")";
	}

	@Override
	public String caseOrExpression(OrExpression or) {
		Expression right = or.getRight();
		//assert right != null : or.getRight().getClass();
		String doSwitchRx = this.doSwitch(right);
		//assert doSwitchRx != null;
		Expression left = or.getLeft();
		//assert left != null;
		return "(" + this.doSwitch(left) + ") or (" + doSwitchRx + ")";
	}

	@Override
	public String caseImpliesExpression(ImpliesExpression imp) {
		return "(" + this.doSwitch(imp.getLeft()) + ") "
				+ imp.getOp().getLiteral() + " ("
				+ this.doSwitch(imp.getRight()) + ")";
	}

	@Override
	public String caseNotExpression(NotExpression not) {
		return "not " + this.doSwitch(not.getPredicate());
	}

	@Override
	public String caseRelationalExpression(RelationalExpression a) {
		Expression right = a.getRight();
		assert right != null : a.getRight().getClass();
		return "(" + this.doSwitch(a.getLeft()) + ") " + a.getOp().getLiteral()
				+ " (" + this.doSwitch(right) + ")";
	}

	@Override
	public String caseBoolAssign(BoolAssign object) {
		return this.doSwitch(object.getLeft()) + object.getOp().getLiteral()
				+ object.getRight();
	}

	@Override
	public String caseEnumAssign(EnumAssign object) {
		return this.doSwitch(object.getLeft()) + object.getOp().getLiteral()
				+ this.doSwitch(object.getRight());
	}

	@Override
	public String caseBoolean(Boolean object) {
		return object.getName();
	}

	@Override
	public String caseEnumerative(Enumerative object) {
		return object.getName();
	}

	@Override
	public String caseNumerical(Numerical object) {
		return object.getName();
	}

	@Override
	public String caseElement(Element object) {
		return object.getName();
	}

	@Override
	public String caseNumericalEx(NumericalEx object) {
		return object.getName();
	}

	@Override
	public String caseConstantNumber(ConstantNumber object) {
		return object.getName();
	}
	@Override
	public String caseNumberLiteral(NumberLiteral object) {
		if (object.getNumber() == null)
			return object.getNumerical().getName();
		else
			return object.getNumber().toString();
	}
	
}
