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
package citlab.model.logic.cnf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.CNF;
import citlab.model.logic.cnf.CNFConverter;
import citlab.model.test.ModelsFromStringsTester;

public class CNFConverterTestNumbers {

	@Test
	public void testCNFConverter0() {			
		CNF res = testSimple("n>=3");
		assertEquals("[(n) >= (3)]", res.toString());
	}
	@Test
	public void testCNFConverter2() {			
		CNF res = testSimple("not(n>=3)");
		assertEquals("[(n) >= (3)]", res.toString());
	}

	
	CNF testSimple(String constraint){
		String s1="Parameters:	Range n [ 25 .. 30 ]; end \n";
		String s2="Constraints: # " + constraint + " # end";
		StringBuffer model= new StringBuffer("Model \n");
		model.append(s1);
		model.append(s2);
		CitModel m= ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull("null model",m);
		assertEquals(1, m.getConstraints().size());
		CNFConverter cnfConverter = new CNFConverter();
		Rule rule = m.getConstraints().get(0);
		assertNotNull(rule);
		return cnfConverter.convertToCNF((Expression) rule);
	}	
	
}
