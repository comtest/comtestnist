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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.validation.Check;

import citlab.model.citL.Aseed;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.CitLPackage;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.ModMultDiv;
import citlab.model.citL.ModMultDivOperators;
import citlab.model.citL.CitModel;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.citL.Numbers;


public class CitLJavaValidator extends AbstractCitLJavaValidator {

	/** The a evaluetor. */
	ArithmeticEvaluator aEvaluetor = new ArithmeticEvaluator(null);

	/**
	 * The Class CmbJavaValidator.
	 * 
	 * @param range
	 *            the range
	 */

	/**
	 * Check range is correct.
	 * 
	 * @param range
	 *            the range
	 */
	@Check
	public void checkRangeIsCorrect(Range range) {
		if (range.getBegin() > range.getEnd())
			error("The second term must be greater then the first one",
					CitLPackage.Literals.RANGE__END, CitLPackage.RANGE);
		if (range.getStep() != 0
				&& (((range.getEnd() - range.getBegin()) % range.getStep()) != 0))
			error("The step is not valid", CitLPackage.Literals.RANGE__STEP,
					CitLPackage.RANGE);
	}

	@Check
	public void checkNumberSize(Numbers numbers) {
		if (numbers.getValues().size() < 2)
			error("Numbers requires at least 2 values",
					CitLPackage.Literals.NUMBERS__VALUES, CitLPackage.NUMBERS);
	}

	/**
	 * Check numerical assign is correct.
	 * 
	 * @param numSeed
	 *            the num seed
	 */
	@Check
	public void checkNumericalAssignIsCorrect(NumericalSeed numSeed) {
		int right;
		if (numSeed.getRight().getConstant() != null)
			right = numSeed.getRight().getConstant().getValue();
		else
			right = numSeed.getRight().getNumber();
		if (numSeed.getLeft() instanceof Range) {
			Range range = (Range) numSeed.getLeft();
			if ((right > range.getEnd()) || (right < range.getBegin()))
				warning("Seed assignment out of range interval ",
						CitLPackage.Literals.NUMERICAL_SEED__RIGHT,
						CitLPackage.NUMERICAL_SEED);
			if (range.getStep() != 0
					&& (((right - range.getBegin()) % range.getStep()) != 0)) {
				warning("Range step does not allow this assignment ",
						CitLPackage.Literals.NUMERICAL_SEED__RIGHT,
						CitLPackage.NUMERICAL_SEED);
			}

		} else if (numSeed.getLeft() instanceof Numbers) {
			Numbers numbers = (Numbers) numSeed.getLeft();
			boolean error = false;
			for (int n :  numbers.getValues()) {
			//	System.out.println(n);
				if ((right != n)) {
					error = true;

				} else {
					error = false;
					break;
				}
			}
			if (error)
				error("Seed assignment is not correct, Numbers values are  constant ",
						CitLPackage.Literals.NUMERICAL_SEED__RIGHT,
						CitLPackage.NUMERICAL_SEED);
		}
	}

	/**
	 * Check zero division.
	 * 
	 * @param modMultDiv
	 *            the mod mult div
	 */
	@Check
	public void checkZeroDivision(ModMultDiv modMultDiv) {
		if (modMultDiv.getOp() == ModMultDivOperators.DIV
				&& aEvaluetor.evaluateArith(modMultDiv.getRight()).equals(0.0)) {

			error("Division by zero detected",
					CitLPackage.Literals.MOD_MULT_DIV__RIGHT);

		}

	}

	/**
	 * Check seed contains an (only one for each) assignment for each parameter
	 * of the model and evaluate each seed, if a seed contains an assignment
	 * that invalidates a logic rule it generates an error .
	 * 
	 * @param seed
	 *            the seed
	 */
	@Check
	public void checkSeedContainsAll(Seed seed) {
		// names in the seed
		List<String> namesInSeed = new ArrayList<String>();
		for (Aseed a : seed.getAssigmentSeedList()) {
			String name = null;
			if (a instanceof EnumSeed)
				name = ((EnumSeed) a).getLeft().getName();
			if (a instanceof NumericalSeed)
				name = ((NumericalSeed) a).getLeft().getName();
			if (a instanceof BoolAssignSeed)
				name = ((BoolAssignSeed) a).getLeft().getName();
			// check if already in the seed
			if (namesInSeed.contains(name)) {
				error("Parameter " + name + " is repeated in the seed",
						CitLPackage.Literals.SEED__ASSIGMENT_SEED_LIST,
						CitLPackage.SEED);
			}
			namesInSeed.add(name);
		}
		// remove all the parameters
		List<String> missingPramaters = new ArrayList<String>();
		CitModel my = (CitModel) seed.eContainer();
		for (Parameter p : my.getParameters()) {
			if (namesInSeed.contains(p.getName()))
				continue;
			// skip constants
			missingPramaters.add(p.getName());
		}
		if (!missingPramaters.isEmpty()) {
			error("It is necessary to give a value to each parameter. Missing parameters "
					+ missingPramaters.toString(),
					CitLPackage.Literals.SEED__ASSIGMENT_SEED_LIST,
					CitLPackage.SEED);
		}
		RuleEvaluator rl = new RuleEvaluator(seed);
		for (Rule lr : my.getConstraints()) {
			if (!rl.evaluateRule(lr))
				error("This seed does not satisfy the "
						+ (my.getConstraints().indexOf(lr) + 1)
						+ getOrdinalFor(my.getConstraints().indexOf(lr) + 1)
						+ " constraint", null,
						CitLPackage.SEED__ASSIGMENT_SEED_LIST);

		}
	}

	/**
	 * Check rule and seed and it generates a warning when a rule invalidates a
	 * seed.
	 * 
	 * @param rule
	 *            the rule
	 */
	@Check
	public void checkRuleAndSeed(Rule rule) {
		if (rule.eContainer() instanceof CitModel) {
			CitModel my = (CitModel) rule.eContainer();
			// if its ia test goal instead of a constraint
			if (!my.getConstraints().contains(rule))
				return;
			for (Seed seed : my.getSeeds()) {
				RuleEvaluator rl = new RuleEvaluator(seed);
				if (!rl.evaluateRule(rule))
					warning("This constraint invalidates the "
							+ (my.getSeeds().indexOf(seed) + 1)
							+ getOrdinalFor(my.getSeeds().indexOf(seed) + 1)
							+ " seed", null, CitLPackage.SEED);

			}
		}
	}

	public static String getOrdinalFor(int value) {
		int hundredRemainder = value % 100;
		int tenRemainder = value % 10;
		if (hundredRemainder - tenRemainder == 10) {
			return "th";
		}

		switch (tenRemainder) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}

}
