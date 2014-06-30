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

public class ConverterTestEnumsNamedTypes {

	@Test
	public void testCNFConverter0() {			
		CNF res = testSimple("b==A.a1");
		assertEquals("[b=a1]", res.toString());
	}

	@Test
	public void testCNFConverter9() {	
		CNF res = testSimple("not ( ( b==A.a1) and ( c==A.a2))");
		assertEquals("[b!=a1+c!=a2]", res.toString());
	}

	@Test
	public void testCNFConverterDouble() {	
		CNF res = testSimple("( b==A.a1 => (c != A.a2 and c != A.a3))");
		assertEquals("[b!=a1+c!=a2, b!=a1+c!=a3]", res.toString());
		System.out.println(res);
	}

	
	CNF testSimple(String constraint){
		String types = "Types: 	EnumerativeType A { a1 a2 a3 }; end \n";
		String s1="Parameters:	Enumerative b : A; Enumerative c : A; end \n";
		String s2="Constraints: # " + constraint + " # end";
		StringBuffer model= new StringBuffer("Model \n");
		model.append(types);
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
