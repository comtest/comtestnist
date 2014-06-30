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

import java.util.ArrayList;
import java.util.List;

import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.Boolean;
import citlab.model.citL.Numbers;
import citlab.model.citL.util.CitLSwitch;

/**
 * given a parameter returns the list of elements as strings
 * 
 * @author garganti
 * 
 */
public class ParameterElementsGetter extends CitLSwitch<List<String>> {

	public static ParameterElementsGetter eInstance = new ParameterElementsGetter();

	private ParameterElementsGetter() {
	}

	@Override
	public List<String> caseParameter(Parameter parameter) {
		return this.doSwitch(parameter);
	}

	@Override
	public List<String> caseEnumerative(Enumerative enumerative) {
		ArrayList<String> elements = new ArrayList<String>();
		for (Element e : ModelUtils.getEnumerativeType(enumerative)
				.getElements()) {
			elements.add(e.getName());
		}
		return elements;

	}

	@Override
	public List<String> caseBoolean(Boolean bool) {
		ArrayList<String> boolValues = new ArrayList<String>();
		// use false , true (as declared in the grammar)
		// useful when using Casa Like translation (true = 0, false = 1)
		boolValues.add("true");
		boolValues.add("false");
		return boolValues;
	}

	@Override
	public List<String> caseRange(Range range) {
		ArrayList<String> rangeValues = new ArrayList<String>();
		int step;
		if (range.getStep() == 0)
			step = 1;
		else
			step = range.getStep();
		for (int i = range.getBegin(); i <= range.getEnd(); i += step) {
				rangeValues.add(Integer.toString(i));
		} 
		return rangeValues;

	}

	@Override
	public List<String> caseNumbers(Numbers numbers) {
		ArrayList<String> numberValue = new ArrayList<String>();
		for (int n : numbers.getValues()) {
			numberValue.add(Integer.toString(n));
		}
		return numberValue;
	}

}
