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
package citlab.externaltool.mdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.citL.Range;
import citlab.model.citL.Rule;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.test.ModelsFromStringsTester;

public class ConvertExprAsIntegersTest {

	@Test
	public void testConvertSpinverifier() throws IOException {
		CitModel spin =  ModelsFromFilesUtils.getBenchmark("spin_verifier.citl",true);
		ConvertExprAsIntegers c = new ConvertExprAsIntegers(spin);
		for(Rule r:spin.getConstraints()){
			System.out.println(c.doSwitch(r));
		}		
	}
	@Test
	public void testExampleWith0() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:		Enumerative p1 { v1 v2 };\n"+
						"Enumerative p2 { v1 v2 }; \n end\n");
		model.append("Constraints: \n");
		model.append("# p1!=p1.v1 #\n");
		model.append("# p1==p1.v1 #\n");
		model.append("end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(2,m.getParameters().size());
		assertEquals(2,m.getConstraints().size());
		ConvertExprAsIntegers c = new ConvertExprAsIntegers(m);
		StringBuffer c1 = c.doSwitch(m.getConstraints().get(0));
		System.out.println(c1);
		assertEquals("0 -",c1.toString());
		StringBuffer c2 = c.doSwitch(m.getConstraints().get(1));
		System.out.println(c2);
		// only 0 (no + is needed)
		assertEquals("0",c2.toString());
	}	
}
