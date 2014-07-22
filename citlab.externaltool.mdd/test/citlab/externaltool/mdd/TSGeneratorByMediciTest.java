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

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;
import citlab.core.ext.CitLabException;
import citlab.model.citL.CitModel;


import citlab.model.test.ModelsFromFilesUtils;

public class TSGeneratorByMediciTest {

	@BeforeClass
	public static void setUpLogger(){
		Logger.getLogger(TSGeneratorByMedici.class).setLevel(Level.ALL);
		
	}
	
	@Test
	public void testCall() throws IOException, CitLabException {
		TSGeneratorByMedici gen = new TSGeneratorByMedici();
		CitModel model = ModelsFromFilesUtils.getBenchmark("spin_simulator.citl",true);
//		CitModel model = ModelsFromFilesTester.getBenchmark("fromSPL/Aircraft.citl");
//		CitModel model = ModelsFromFilesTester.getBenchmark("SmartHome.citl");
		//CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests/correct","numbers.citl");
		TestSuite ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		System.out.println(ts.getTests().toString());
	} 

	@Test
	public void testMobilePhone() throws IOException, CitLabException {
		TSGeneratorByMedici gen = new TSGeneratorByMedici();
		CitModel model = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",true);
		TestSuite ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		System.out.println(ts.getTests().toString());
	} 

	@Test
	public void testSmartHome() throws IOException, CitLabException {
		TSGeneratorByMedici gen = new TSGeneratorByMedici();
		CitModel model = ModelsFromFilesUtils.getTestModel("examples/fromSPL","SmartHome.citl");
		TestSuite ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		System.out.println(ts.getTests().toString());
	} 
	@Test
	public void testSmartHomeBenchmark() throws IOException, CitLabException {
		TSGeneratorByMedici gen = new TSGeneratorByMedici();
		CitModel model = ModelsFromFilesUtils.getBenchmark("SmartHome.citl", true);
		TestSuite ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		System.out.println(ts.getTests().toString());
	} 

	@Test
	public void testPhoneASE() throws IOException, CitLabException {
		TSGeneratorByMedici gen = new TSGeneratorByMedici();
		CitModel model = ModelsFromFilesUtils.getTestModel("examples","phone_small_ase.citl");
		// without constraints
		TestSuite ts = gen.generateTestsAndInfo(model,true, true, true, 2);
		print(ts.getTests());
		ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		print(ts.getTests());
	}

	private void print(EList<citlab.testsuite.Test> tests) {
		for (citlab.testsuite.Test t: tests){
			for( Assignment a: t.getAssignments()){
				System.out.print(a.getValue());
			}
			System.out.println();
		}
	} 

	
}
