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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Numbers;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.util.Utils.Pair;

/**
 * Given a parameter returns the list of pairs <paramter,value> with values as
 * Objects (there is no superclass)
 * 
 * @author garganti
 * 
 */
public class ParameterToPairElements extends
		CitLSwitch<List<Pair<Parameter, ?>>> {

	private static ParameterToPairElements eInstance = new ParameterToPairElements();

	private ParameterToPairElements() {

	}

	@Override
	public List<Pair<Parameter, ?>> caseParameter(Parameter parameter) {
		return buildList(parameter);
	}

	private List<Pair<Parameter, ?>> buildList(Parameter parameter) {
		List<Pair<Parameter, ?>> elements;
		elements = new ArrayList<Pair<Parameter, ?>>();
		List<?> values = ParameterElementsGetter.eInstance.doSwitch(parameter);
		for (Object v : values) {
			elements.add(new Pair<Parameter,Object>(parameter, v));
		}
		return elements;

	}

	/**
	 * return the list of the list of parameters and values (As strings). the
	 * order in which the parameters are taken is not set.
	 * 
	 * @param citModel
	 * @return
	 */
	static public List<List<Pair<Parameter, ?>>> getListPairsParameterValues(
			CitModel citModel) {
		List<List<Pair<Parameter, ?>>> elements = new ArrayList<List<Pair<Parameter, ?>>>();
		EList<Parameter> vars = citModel.getParameters();
		ParameterToPairElements switchP = ParameterToPairElements.eInstance;
		for (Parameter p : vars) {
			elements.add(switchP.doSwitch(p));
		}
		return elements;
	}
	
	static class ParameterElementsGetter extends CitLSwitch<List<?>> {

		public static ParameterElementsGetter eInstance = new ParameterElementsGetter();

		private ParameterElementsGetter() {
		}

		@Override
		public List<?> caseParameter(Parameter parameter) {
			return this.doSwitch(parameter);
		}

		@Override
		public List<Element> caseEnumerative(Enumerative enumerative) {
			return ModelUtils.getEnumerativeType(enumerative).getElements();
		}

		@Override
		public List<BooleanConst> caseBoolean(Boolean bool) {
			return Arrays.asList(BooleanConst.values());
		}

		@Override
		public ArrayList<Integer> caseRange(Range range) {
			ArrayList<Integer> rangeValues = new ArrayList<Integer>();
			if(range.getStep()!=0)
			for (int i = range.getBegin(); i <= range.getEnd(); i=range.getStep()+i) {
				rangeValues.add(i);
			}else for (int i = range.getBegin(); i <= range.getEnd(); i++) {
				rangeValues.add(i);
			}
			return rangeValues;

		}

		@Override
		public List<Integer> caseNumbers(Numbers numbers) {
			ArrayList<Integer> numberValues = new ArrayList<Integer>();
			for (int n : numbers.getValues())
				numberValues.add(n);
			return numberValues;
		}

	}
}


