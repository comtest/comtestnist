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
package citlab.model.simplifier;

import citlab.model.citL.BoolAssign;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalEx;
import citlab.model.citL.Parameter;

/** given a Parameter, return if the parameter is present in a rule
 * 
 * @author garganti
 *
 */
public class ParameterInRule extends InRule {
	
	private Parameter param;

	ParameterInRule(Parameter p){
		param = p;
	}
	
	@Override
	public Boolean caseBoolAssign(BoolAssign object) {
		return object.getLeft() == param;
	}
	
	@Override
	public Boolean caseEnumAssign(EnumAssign object) {
		return object.getLeft() == param;
	}
	@Override
	public Boolean caseNumberLiteral(NumberLiteral object) {
		return false;
	}
	
}
