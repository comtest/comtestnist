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
package citlab.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.xbase.lib.Pair;

import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.CitModel;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Expression;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numerical;
import citlab.model.citL.Operators;
import citlab.model.citL.Parameter;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.util.ParameterSize;

/**
 * It converts a atomic expression (Assign or Relational) to an unique integer
 * (with sign) (using SignedInteger because it needs a sign in case of not and
 * 0, to distinguish 0 from -0
 * It converts also the other way around: given an integer, returns the pair param and value
 * 
 * @author garganti
 * 
 */
public class ConvertAtomicToSignedInt extends CitLSwitch<SignedInteger> {

	Map<Parameter, Integer> offsets = new HashMap<Parameter, Integer>();

	public ConvertAtomicToSignedInt(CitModel citModel) {
		// init offsets
		int offset = 0;
		for (Parameter p : citModel.getParameters()) {
			offsets.put(p, offset);
			int size = ParameterSize.eInstance.doSwitch(p);
			offset += size;
		}
	}

	// convert an integer to a couple parameter + its value
	// example offsets 0,10,12
	// 1 -> first offset 0
	public Pair<Parameter, String> convertInt(int n) {
		// get the first offset that is suitable
		// the greatest offset between the minors or equals to n
		// init to the first one
		Parameter selectedPara = null;
		Integer selectedOffset = -1;
		// search among all
		for (Entry<Parameter, Integer> po : offsets.entrySet()) {
			// if this one is best, take this
			Integer currentOffset = po.getValue();
			// currentOffset must minor or equals n
			if (currentOffset <= n && currentOffset > selectedOffset) {
				// po is a good candidate and it is better than the current one
				selectedPara = po.getKey();
				selectedOffset = currentOffset;
			}
		}
		assert selectedPara != null;
		int singleOffset = n - selectedOffset;//
		assert singleOffset >= 0;
		List<String> doSwitch = ParameterElementsGetter.eInstance
				.doSwitch(selectedPara);
		if (singleOffset >= doSwitch.size()) {
			throw new IndexOutOfBoundException(n, offsets);
		}
		String string = doSwitch.get(singleOffset);
		return Pair.of(selectedPara, string);
	}

	@Override
	public SignedInteger caseEnumAssign(EnumAssign e) {
		// get the offset of enumerative of e
		Enumerative left = e.getLeft();
		int base = offsets.get(left);
		int value = base
				+ ParameterElementsGetter.eInstance.doSwitch(left).indexOf(
						e.getRight().getName());
		if (e.getOp() == Operators.EQ)
			return SignedInteger.mkPos(value);
		else
			// NEQ
			return SignedInteger.mkNeg(value);
	}

	@Override
	public SignedInteger caseBoolAssign(BoolAssign e) {
		citlab.model.citL.Boolean left = e.getLeft();
		int base = offsets.get(left);
		String rightName = e.getRight().getName(); // true or false
		List<String> elementsInType = ParameterElementsGetter.eInstance.doSwitch(left);
		int indexOf = elementsInType.indexOf(rightName);
		assert indexOf >= 0;
		int value = base + indexOf;		
		if (e.getOp() == Operators.EQ){
			// case base == true or case == false 
			return SignedInteger.mkPos(value);
		} else {
			// operator != 
			return SignedInteger.mkNeg(value);
		}

	}

	@Override
	public SignedInteger caseRelationalExpression(RelationalExpression re) {
		// it can convert only EQ or NEQ
		if (re.getOp() != Operators.EQ && re.getOp() != Operators.NE) {
			throw new NotConvertableModel(
					"Relational operators are not supported when traslating to integers");
		}
		//
		Numerical num = re.getLeft();
		Expression right = re.getRight();
		if (!(right instanceof NumberLiteral)) {
			// it is not a number nor a constant
			// like an expression term with plus minus ...
			throw new NotConvertableModel(
					"Arithmetic expression are not compatible with this generator ");
		}
		NumberLiteral rightNl = (NumberLiteral) right;
		int leftVal;
		if (rightNl.getNumerical() == null) {
			// it is initilized to a number
			leftVal = rightNl.getNumber();
		} else {
			// it is initilized to a number literal
			if (rightNl.getNumerical() instanceof Numerical) {
				// it is a range or a numbers
				throw new NotConvertableModel(
						"Range and Numbers are not compatible with this generator");
			}
			leftVal = ((ConstantNumber) rightNl.getNumerical()).getValue();
		}
		int base = offsets.get(num);
		//
		int indexOfNum = ParameterElementsGetter.eInstance.doSwitch(num)
				.indexOf(Integer.toString(leftVal));
		if (indexOfNum == -1) {
			// num not found (e.g. x == 3 and 3 is not in the domain of x)
			throw new NotConvertableModel(
					"Number not found (e.g. x == 3 and 3 is not in the domain of x)");
		}
		int value = base + indexOfNum;
		if (re.getOp() == Operators.EQ) {
			return SignedInteger.mkPos(value);
		} else {
			assert (re.getOp() == Operators.NE);
			return SignedInteger.mkNeg(value);
		}
	}

	// to be used in case of 0

}
