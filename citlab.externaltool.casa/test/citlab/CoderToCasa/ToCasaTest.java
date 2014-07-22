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
package citlab.CoderToCasa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.CNF;
import citlab.model.logic.cnf.CNFConverter;
import citlab.model.logic.cnf.SimpleExpressionToString;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.test.ModelsFromStringsTester;

public class ToCasaTest {

	@Test
	public void testSpinSToCasa() throws IOException {
		// get a model
		CitModel spin = ModelsFromFilesUtils.getBenchmark(
				"spin_simulator.citl", true);
		ToCasaExporter tocasa = new ToCasaExporter();
		tocasa.init(spin);
		// translate to model
		// TODO
		// translate constraints
		System.out.println(tocasa.translateConstraints());
	}

	@Test
	public void testOfficialSpinVToCasa() throws IOException {
		// get a model
		CitModel spin = ModelsFromFilesUtils.getBenchmark("spin_verifier.citl",
				true);
		ToCasaExporter tocasa = new ToCasaExporter();
		tocasa.init(spin);
		// translate to model
		// TODO
		// translate constraints
		System.out.println(tocasa.translateConstraints());
	}

	// with something that cannot be traslated to casa (arithmetics)
	@Test
	public void testPhoneToCasa() throws IOException{
		// get a model
		CitModel model = ModelsFromFilesUtils.getBenchmark("phone.citl", true);
		ToCasaExporter tocasa = new ToCasaExporter();
		tocasa.init(model);
		System.out.println("PRIMA DELLA CONVERSIONE");
		for(Rule r: model.getConstraints()){
			System.out.println(SimpleExpressionToString.eInstance.doSwitch(r));
		}
		System.out.println("DOPO CONVERSIONE");
		// traduco in CNF . li cambia??
		for(Rule r: model.getConstraints()){
			CNFConverter cnfconv = new CNFConverter();
			CNF ss = cnfconv.convertToCNF((Expression) r);
			System.out.println(SimpleExpressionToString.eInstance.doSwitch(r));
		}
		
		// translate constraints
		try {
			System.out.println(tocasa.translateConstraints());
		} catch (NotConvertableModel ce) {
			// ok, phone is not convertable
			// check the constraints
			for(Rule r: model.getConstraints()){
				System.out.println(SimpleExpressionToString.eInstance.doSwitch(r));
			}
			return;
		}
		fail();
	}

	@Test
	public void testExampleWith0() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:		Enumerative p1 { v1 v2 };\n"
				+ "Enumerative p2 { v1 v2 }; \n end\n");
		model.append("Constraints: \n");
		model.append("# p1!=p1.v1 #\n");
		model.append("# p1==p1.v1 #\n");
		model.append("end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(2, m.getParameters().size());
		assertEquals(2, m.getConstraints().size());
		ToCasaExporter tocasa = new ToCasaExporter();
		tocasa.init(m);
		// translate constraints
		CharSequence translateConstraints = tocasa.translateConstraints();
		System.out.println(translateConstraints);
		// contains both +0 and -0
		assertTrue(translateConstraints.toString().contains("- 0"));
		assertTrue(translateConstraints.toString().contains("+ 0"));
	}

}
