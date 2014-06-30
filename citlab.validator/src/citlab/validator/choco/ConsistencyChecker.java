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
package citlab.validator.choco;

import choco.cp.model.CPModel;
import citlab.model.citL.CitModel;

/**
 * In logic, a consistent theory is one that does not contain a
 * contradiction.[1] The lack of contradiction can be defined in either semantic
 * or syntactic terms. The semantic definition states that a theory is
 * consistent if and only if it has a model, i.e. there exists an interpretation
 * under which all formulas in the theory are true.
 * 
 * @author garganti
 * 
 */
public class ConsistencyChecker {

	
	public void checkConsistecy(CitModel modelToCheck){
		
	}
	
	// build the CPModel without the constraints (only the variables and types
	private CPModel translateSignature(CitModel model){
		CPModel cpmodel = new CPModel();
		// add variables
		
		//
		return cpmodel;
		
	}
	
}
