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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;

import citlab.model.citL.util.CitLSwitch;
import citlab.model.util.Utils;
import citlab.model.util.Utils.Pair;

/**
 * Given a parameter returns the list of pairs <paramter,value> with values as
 * strings
 * 
 * @author garganti
 * 
 */
public class ParameterSwitchToPairStrings extends
		CitLSwitch<List<Pair<Parameter, String>>> {

	private static ParameterSwitchToPairStrings eInstance = new ParameterSwitchToPairStrings();

	private ParameterSwitchToPairStrings() {

	}

	@Override
	public List<Pair<Parameter, String>> caseParameter(Parameter parameter) {
		return buildList(parameter);
	}

	private List<Pair<Parameter, String>> buildList(Parameter parameter) {
		List<Pair<Parameter, String>> elements = new ArrayList<Pair<Parameter, String>>();
		List<String> values = ParameterElementsGetter.eInstance
				.doSwitch(parameter);
		for (String v : values) {
			elements.add(new Pair<Parameter, String>(parameter, v));
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
	static public List<List<Pair<Parameter, String>>> getListPairsParameterValues(
			CitModel citModel) {
		List<List<Pair<Parameter, String>>> elements = new ArrayList<List<Pair<Parameter, String>>>();
		EList<Parameter> vars = citModel.getParameters();
		ParameterSwitchToPairStrings switchP = ParameterSwitchToPairStrings.eInstance;
		for (Parameter p : vars) {
			elements.add(switchP.doSwitch(p));
		}
		return elements;
	}

	/**
	 * 
	 * @param citModel
	 * @param nWise
	 * @return
	 */
	static public Iterator<List<Pair<Parameter, String>>> getTuples(CitModel citModel, int nWise) {
		List<List<Pair<Parameter, String>>> elements = getListPairsParameterValues(citModel);
		return Utils.getAllKWiseCombination(elements, nWise);
	}
}
