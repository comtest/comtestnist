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

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import citlab.core.ext.CitLabException;
import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;

public class TSGeneratorByCasaTest {

	@Test
	public void testCall() throws IOException, CitLabException {
		TSGeneratorByCasa gen = new TSGeneratorByCasa();
		// CitModel spin =
		// ModelsFromFilesTester.getBenchmark("spin_simulator.citl");
		// CitModel model =
		// ModelsFromFilesTester.getBenchmark("fromSPL/Aircraft.citl");
		// CitModel model =
		// ModelsFromFilesTester.getBenchmark("SmartHome.citl");
		CitModel model = ModelsFromFilesUtils.getTestModel(
				"modelsfortests/correct", "numbers.citl");
		TestSuite ts = gen.generateTestsAndInfo(model, false, true, true, 2);
		System.out.println(ts.getTests().toString());
	}

	@Test
	public void testMobilePhone() throws IOException, CitLabException {
		TSGeneratorByCasa gen = new TSGeneratorByCasa();
		CitModel model = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",
				true);
		TestSuite ts = gen.generateTestsAndInfo(model, false, true, true, 2);
		System.out.println(ts.getTests().toString());
	}

	@Test
	public void testSmartHome() throws IOException, CitLabException {
		TSGeneratorByCasa gen = new TSGeneratorByCasa();
		CitModel model = ModelsFromFilesUtils.getTestModel("examples/fromSPL",
				"SmartHome.citl");
		TestSuite ts = gen.generateTestsAndInfo(model, false, true, true, 2);
		System.out.println(ts.getTests().toString());
	}

	@Test
	public void testPhoneASE() throws IOException, CitLabException {
		TSGeneratorByCasa gen = new TSGeneratorByCasa();
		CitModel model = ModelsFromFilesUtils.getTestModel("examples",
				"phone_small_ase.citl");
		// without constraints
		TestSuite ts = gen.generateTestsAndInfo(model, true, true, true, 2);
		print(ts.getTests());
	}
	@Test
	public void testProcessCom2() throws IOException, CitLabException {
		TSGeneratorByCasa gen = new TSGeneratorByCasa();
		CitModel model = ModelsFromFilesUtils.getBenchmark("ProcessorComm2.citl",true);
		TestSuite ts = gen.generateTestsAndInfo(model, false, true, true, 2);
		print(ts.getTests());
	}

	private void print(EList<citlab.testsuite.Test> tests) {
		for (citlab.testsuite.Test t : tests) {
			for (Assignment a : t.getAssignments()) {
				System.out.print(a.getValue());
			}
			System.out.println();
		}
	}

}
