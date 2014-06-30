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
package citlab.acts;

import java.util.ArrayList;

import citlab.core.util.ParameterElementsGetter;
import citlab.model.citL.Boolean;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Range;
import citlab.model.citL.util.CitLSwitch;

import edu.uta.cse.fireeye.common.Parameter;
import edu.uta.cse.fireeye.common.SUT;

/** add a parameter (and return the parameter added) with the right type 
 * 
 * @author garganti
 *
 */
public class ACTSParameterAdder extends CitLSwitch<Parameter>{
	
	// add parameters to this citModel;
	SUT sut;
		
	ACTSParameterAdder(SUT s){
		sut = s;
	} 
	
	
	
	@Override
	public Parameter caseEnumerative(Enumerative enumerative) {
		Parameter p = sut.addParam(enumerative.getName());
		p.setType(Parameter.PARAM_TYPE_ENUM);
		p.setValues(new ArrayList<String>(ParameterElementsGetter.eInstance.caseEnumerative(enumerative)));
		return p;
	}

	@Override
	public Parameter caseBoolean(Boolean boolParam) {
		Parameter p = sut.addParam(boolParam.getName());
		p.setType(Parameter.PARAM_TYPE_BOOL);
		p.addValue("true");
		p.addValue("false");
		return p;
	}

	@Override
	public Parameter caseRange(Range range) {
		Parameter p = sut.addParam(range.getName());
		p.setType(Parameter.PARAM_TYPE_INT);
		p.setValues(new ArrayList<String>(ParameterElementsGetter.eInstance.caseRange(range)));
		return p;
	}

	@Override
	public Parameter caseNumbers(citlab.model.citL.Numbers n) {
		Parameter p = sut.addParam(n.getName());
		p.setType(Parameter.PARAM_TYPE_INT);
		//p.addValue(String.valueOf(n.getValue()));
		p.setValues(new ArrayList<String>(ParameterElementsGetter.eInstance.caseNumbers(n)));
		
	/*	p.addValue(String.valueOf(n.getValue()+1));
		ArrayList<Parameter> pInC = new ArrayList<Parameter>();
		pInC.add(p);
		String casString = (p.getName()+"!="+String.valueOf(n.getValue()+1));
		Constraint constraint = new Constraint(casString , pInC);
		sut.addConstraint(constraint); */
		return p;
	}
}
