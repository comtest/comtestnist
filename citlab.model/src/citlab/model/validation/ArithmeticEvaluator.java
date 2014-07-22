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
package citlab.model.validation;

import citlab.model.citL.ConstantNumber;
import citlab.model.citL.Expression;
import citlab.model.citL.ModMultDiv;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numerical;
import citlab.model.citL.PlusMinus;
import citlab.model.citL.PlusMinusOperators;
import citlab.model.citL.Seed;
import citlab.model.citL.util.CitLSwitch;



// TODO: Auto-generated Javadoc
/**
 * The Class ArithmeticEvaluator.
 */
public class ArithmeticEvaluator extends CitLSwitch<Double> {


	private Seed seed;
	
	/**
	 * Instantiates a new arithmetic evaluator.
	 */
	ArithmeticEvaluator(Seed seed){
		this.seed = seed;
	}

	/**
	 * Evaluates arithmetic rules giving each arithmetic rule a double output.
	 *
	 * @param r the r
	 * @return the double
	 */
	public Double evaluateArith(Expression r) {
		return this.doSwitch(r);
	}

	/* (non-Javadoc)
	 * @see combinatorial.comb.comB.util.CmbSwitch#casePlusMinus(combinatorial.comb.comB.PlusMinus)
	 */
	@Override
	public Double casePlusMinus(PlusMinus pm) {
		Double leftVal = this.doSwitch(pm.getLeft());
		Double rightVal = this.doSwitch(pm.getRight());
		if (pm.getOp() == PlusMinusOperators.MINUS)
			return (leftVal - rightVal);
		else
			return (leftVal + rightVal);

	}

	/* (non-Javadoc)
	 * @see combinatorial.comb.comB.util.CmbSwitch#caseModMultDiv(combinatorial.comb.comB.ModMultDiv)
	 */
	@Override
	public Double caseModMultDiv(ModMultDiv md) {
		Double leftVal = this.doSwitch(md.getLeft());
		Double rightVal = this.doSwitch(md.getRight());
		switch (md.getOp()) {
		case DIV:
			return (leftVal / rightVal);
		case MULT:
			return (leftVal * rightVal);
		case MOD:
			return (leftVal % rightVal);
		}
		throw new RuntimeException("Operator not found");
	}

	/* (non-Javadoc)
	 * @see combinatorial.comb.comB.util.CmbSwitch#caseNumberLiteral(combinatorial.comb.comB.NumberLiteral)
	 */
	@Override
	public Double caseNumberLiteral(NumberLiteral nl) {
		if (nl== null) return null;
		// is a value literal 2
		if (nl.getNumerical() == null )
			return (double) nl.getNumber();
		// is a constant
		else if (nl.getNumerical() instanceof ConstantNumber){
			return (double)((ConstantNumber) nl.getNumerical()).getValue();
		}
		else if ((nl.getNumerical()instanceof Numerical)){
			// get teh value from the seed
			return RuleEvaluator.getNumericalInSeed( (citlab.model.citL.Numerical)nl.getNumerical(), this.seed);
		}
		return null;
	}
}
