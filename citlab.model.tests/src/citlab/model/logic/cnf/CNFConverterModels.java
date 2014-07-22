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

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Rule;
import citlab.model.test.ModelsFromFilesUtils;

public class CNFConverterModels {


	@Test
	public void testSpinSCNF() throws IOException {
		// get a model
		CitModel spin = ModelsFromFilesUtils.getBenchmark("spin_verifier.citl", true);
		CNFConverter converter = new CNFConverter();
		for(Rule r : spin.getConstraints()){
			CNF res = converter.convertToCNF((Expression) r);
			assertNotNull(res);
			System.out.println(res);
		}
	}

	@Test
	public void testBBSCNF() throws IOException {
		// get a model
		CitModel spin = ModelsFromFilesUtils.getBenchmark("bbs.citl", true);
		for(Rule r : spin.getConstraints()){
			CNFConverter converter = new CNFConverter();
			CNF res = converter.convertToCNF((Expression) r);
			assertNotNull(res);
			System.out.println(res);
		}
	}

	
	// with something that cannot be traslated to casa (arithmetics)
	@Test
	public void testPhoneToCNF() throws IOException {
		// get a model
		CitModel model = ModelsFromFilesUtils.getBenchmark("phone.citl", true);
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
	}
	
}
