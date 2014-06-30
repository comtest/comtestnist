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
package citlab.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import citlab.model.citL.Aseed;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.Element;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Numbers;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.Seed;
import citlab.model.citL.SeedNumberLiteral;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.services.CitLGrammarAccess.PossiblySignedNumberElements;
import citlab.model.services.CitLGrammarAccess.SeedNumberLiteralElements;
import citlab.model.util.Utils.Pair;

/**
 * It converts a list of Pairs<parameter,String> in to a seed
 * 
 * @author garganti
 * 
 */
public class ListPairsToSeed {

	public static Seed convertToSeed(List<Pair<Parameter, ?>> paramsValues) {
		Seed myseed = CitLFactory.eINSTANCE.createSeed();
		for (Pair<Parameter, ?> e : paramsValues) {
			Aseed assign = getAssignEObject(e.getFirst(), e.getSecond());
			myseed.getAssigmentSeedList().add(assign);
		}
		return myseed;
	}

	/**
	 * values as strings: to find the values, it needs a loop
	 * 
	 * @param paramsValues
	 * @return
	 */
	static Seed convertToSeedStrings(List<Pair<Parameter, String>> paramsValues) {
		Seed myseed = CitLFactory.eINSTANCE.createSeed();
		for (Pair<Parameter, String> e : paramsValues) {
			Aseed assign = getAssignString(e.getFirst(), e.getSecond());
			myseed.getAssigmentSeedList().add(assign);
		}
		return myseed;
	}

	private static Aseed getAssignString(Parameter param, String value) {

		if (param instanceof Enumerative) {
			Enumerative enume = (Enumerative) param;
			EnumSeed assign = CitLFactory.eINSTANCE.createEnumSeed();
			assign.setLeft(enume);
			assign.setOp("=");
			assign.setRight(ModelUtils.getEnumElement(enume, value));
			return assign;
		} else if (param instanceof Boolean) {
			Boolean b = (Boolean) param;
			BoolAssignSeed assign = CitLFactory.eINSTANCE
					.createBoolAssignSeed();
			assign.setLeft(b);
			assign.setOp("=");
			if (value.compareToIgnoreCase("true") == 0)
				assign.setRight(BooleanConst.TRUE);
			else if (value.compareToIgnoreCase("false") == 0)
				assign.setRight(BooleanConst.FALSE);
			else
				throw new RuntimeException();
			return assign;
		} else if (param instanceof Range) {
			Range range = (Range) param;
			NumericalSeed assign = CitLFactory.eINSTANCE.createNumericalSeed();
			assign.setLeft(range);
			assign.setOp("=");
			assign.setRight(ModelUtils.getRangeElement(range, value));
			return assign;

		} else if (param instanceof Numbers) {
			Numbers numbers = (Numbers) param;
			NumericalSeed assign = CitLFactory.eINSTANCE.createNumericalSeed();
			assign.setLeft(numbers);
			assign.setOp("=");
			assign.setRight(ModelUtils.getNumbersElement(numbers, value));
			return assign;

		}
		throw new RuntimeException();
	}

	private static Aseed getAssignEObject(Parameter param, Object value) {

		if (param instanceof Enumerative) {
			Enumerative enume = (Enumerative) param;
			EnumSeed assign = CitLFactory.eINSTANCE.createEnumSeed();
			assign.setLeft(enume);
			assign.setOp("=");
			assign.setRight((Element) value);
			return assign;
		} else if (param instanceof Boolean) {
			Boolean b = (Boolean) param;
			BoolAssignSeed assign = CitLFactory.eINSTANCE
					.createBoolAssignSeed();
			assign.setLeft(b);
			assign.setOp("=");
			assign.setRight((BooleanConst) value);
			return assign;
		} else if (param instanceof Range) {
			Range range = (Range) param;
			NumericalSeed assign = CitLFactory.eINSTANCE.createNumericalSeed();
			assign.setLeft(range);
			assign.setOp("=");
			SeedNumberLiteral v = CitLFactory.eINSTANCE
					.createSeedNumberLiteral();
			if (value instanceof ConstantNumber)
				v.setConstant(EcoreUtil2
						.cloneIfContained((ConstantNumber) value));
			else
			if (value instanceof Integer)
				v.setNumber((Integer) value);
			else throw new RuntimeException();
			assign.setRight(EcoreUtil2.cloneIfContained(v));
			return assign;
		} else if (param instanceof Numbers) {
			Numbers numbers = (Numbers) param;
			NumericalSeed assign = CitLFactory.eINSTANCE.createNumericalSeed();
			assign.setLeft(numbers);
			assign.setOp("=");
			SeedNumberLiteral v = CitLFactory.eINSTANCE
					.createSeedNumberLiteral();
			if (value instanceof ConstantNumber)
				v.setConstant(EcoreUtil2
						.cloneIfContained((ConstantNumber) value));
			else if (value instanceof Integer)

				v.setNumber((Integer) value);
			else
				throw new RuntimeException();
			assign.setRight(EcoreUtil2.cloneIfContained(v));
			return assign;

		}
		throw new RuntimeException();
	}

}
