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
package citlab.externaltool.mdd;

import citlab.core.util.ConvertAtomicToSignedInt;
import citlab.core.util.SignedInteger;
import citlab.model.citL.AndExpression;
import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.CitModel;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.NotExpression;
import citlab.model.citL.Operators;
import citlab.model.citL.OrExpression;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.util.CitLSwitch;

/**
 * It converts an expression to a string containing a list of integers and
 * operators
 * 
 * a => 3 not a => 3 - a or b => 3 4 + a and ! b => 3 4 - *
 * 
 * @author garganti
 * 
 */
public class ConvertExprAsIntegers extends CitLSwitch<StringBuffer> {

	ConvertAtomicToSignedInt convToInt;

	public ConvertExprAsIntegers(CitModel citModel) {
		convToInt = new ConvertAtomicToSignedInt(citModel);

	}

	@Override
	public StringBuffer caseRule(Rule object) {
		return super.caseExpression((Expression) object);
	}

	@Override
	public StringBuffer caseEnumAssign(EnumAssign object) {
		return caseAssigns(object);
	}

	@Override
	public StringBuffer caseBoolAssign(BoolAssign object) {
		return caseAssigns(object);
	}

	@Override
	public StringBuffer caseRelationalExpression(RelationalExpression object) {
		return caseAssigns(object);
	}

	private StringBuffer caseAssigns(AtomicPredicate ap) {
		SignedInteger res = convToInt.doSwitch(ap);
		assert res != null;
		// if < 0 return res -
		if (res.isNegative())
			return new StringBuffer(res.getValue() + " -");
		else
			return new StringBuffer(Integer.toString(res.getValue()));
	}

	@Override
	public StringBuffer caseAndExpression(AndExpression ae) {
		return forBinaryExpression(doSwitch(ae.getLeft()),
				doSwitch(ae.getRight()), '*');
	}

	@Override
	public StringBuffer caseOrExpression(OrExpression ae) {
		return forBinaryExpression(doSwitch(ae.getLeft()),
				doSwitch(ae.getRight()), '+');
	}

	@Override
	public StringBuffer caseImpliesExpression(ImpliesExpression ie) {
		StringBuffer A = doSwitch(ie.getLeft());
		StringBuffer B = doSwitch(ie.getRight());
		// add A not
		StringBuffer nA = new StringBuffer(A).append(" -");
		// A => B
		// translated as !A or B			
		StringBuffer AimpliesB = forBinaryExpression(nA, B, '+');
		if (ie.getOp() == ImpliesOperator.IMPL) {
			return AimpliesB;
		} else {
			assert (ie.getOp() == ImpliesOperator.IFF);
			// A <=> B
			// translated as !A or B and 			
			// add A not
			StringBuffer nB = new StringBuffer(B).append(" -");
			// B => A
			// translated as !A or B			
			StringBuffer BimpliesA = forBinaryExpression(nB, A, '+');
			return forBinaryExpression(AimpliesB, BimpliesA, '*');
			
		}

	}

	@Override
	public StringBuffer caseNotExpression(NotExpression ne) {
		StringBuffer doSwitch = new StringBuffer();
		doSwitch.append(doSwitch(ne.getPredicate()));
		doSwitch.append(" -");
		return doSwitch;
	}

	private StringBuffer forBinaryExpression(StringBuffer o1, StringBuffer o2,
			char op) {
		StringBuffer result = new StringBuffer();
		result.append(o1);
		result.append(" ");
		result.append(o2);
		result.append(" ");
		result.append(op);
		return result;
	}

}
