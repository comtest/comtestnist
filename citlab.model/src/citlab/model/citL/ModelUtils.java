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
package citlab.model.citL;

import citlab.model.citL.Aseed;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.Element;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.SeedNumberLiteral;
import citlab.model.util.Utils.Pair;

/**
 * some utils methods. query of the models. Some should be moved in appropriate
 * classes
 * 
 * @author garganti
 * 
 */
public class ModelUtils {

	// only static methods
	private ModelUtils() {
	}

	/**
	 * given an enumerative, return the type
	 * 
	 * @return the right type (anonymous or named)
	 */
	static public EnumerativeType getEnumerativeType(
			final Enumerative enumerative) {
		if (enumerative.getNamedType() == null) {
			return enumerative.getAtype();
		} else {
			return enumerative.getNamedType();
		}
	}

	/**
	 * return the element of a enumerative with given string. raises an
	 * exception if not found
	 * 
	 * @param enumerative
	 * @param element
	 * @return
	 */
	static public Element getEnumElement(Enumerative enumerative, String element) {
		EnumerativeType enumType = getEnumerativeType(enumerative);
		for (Element e : enumType.getElements()) {
			if (e.getName().equals(element))
				return e;
		}
		throw new RuntimeException("element " + element + " not found in type + " + enumType + " with elements " + enumType.getElements());
	}

	static public SeedNumberLiteral getRangeElement(Range range, String element) {
		SeedNumberLiteral v = CitLFactory.eINSTANCE.createSeedNumberLiteral();
		if (Integer.valueOf(element) < range.getEnd()
				&& Integer.valueOf(element) > range.getBegin()) {
			v.setNumber(Integer.valueOf(element));
			if (range.getStep() == 0) {
				
				return v;
			}else if (Integer.valueOf(element)- range.getBegin() % range.getStep()== 0){
				return v;
			}
		} 
			throw new RuntimeException("element " + element + " not found in "
					+ range.getName());
		
	}
	static public SeedNumberLiteral getNumbersElement(Numbers numbers, String element) {
		
		for (Integer v: numbers.getValues()){
			if (Integer.valueOf(element) == v);
			SeedNumberLiteral output = CitLFactory.eINSTANCE.createSeedNumberLiteral();
			output.setNumber(v);
		}
			throw new RuntimeException("element " + element + " not found in "
					+ numbers.getName());
		
	}

}
