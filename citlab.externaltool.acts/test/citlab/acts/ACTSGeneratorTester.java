/*******************************************************************************
 * Copyright (c) 2013 Vava.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import citlab.core.ext.CitLabException;
import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.CitModel;
import citlab.model.simplifier.Simplificator;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.test.ModelsFromStringsTester;
import citlab.testsuite.TestSuite;
import citlab.testsuite.util.TestSuiteWriter;

/** test the generation by ACTS */

public class ACTSGeneratorTester {
	
	
	@Test
	public void generateSpin_simulator() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("spin_simulator.citl",true);
		@SuppressWarnings("unused")
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true, 2);
	}

	@Test
	public void generateMobilePhone() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true,2);
		assertTrue(ts.getTests().size() > 0);
	}

	@Test
	public void generatePhone() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("phone.citl",true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true,2);
		assertTrue(ts.getTests().size() > 0);
	}

	@Test
	public void translateAndGenerateSmarthome() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel sh = ModelsFromFilesUtils.getBenchmark("SmartHome.citl",true);
		CitModel shs = new Simplificator(sh).getSimplifiedVersion();
		TestSuite ts = trans.generateTestsAndInfo(shs, false, true, true, shs.getParameters().size());
		System.out.println(ts.getTests().size());
	}

	@Test
	public void generateDellNotebook() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel sh = ModelsFromFilesUtils.getTestModel("examples/fromSPL","DellLaptops_Notebooks.citl");
		//CitModel shs = Simplifier.getSimplifiedVersion(sh);
		TestSuite ts = trans.generateTestsAndInfo(sh, false, true, true, sh.getParameters().size());
		System.out.println(ts.getTests().size());
	}
	
	@Test(expected=NotConvertableModel.class)
	public void generateWNegNumbers() throws IOException, CitLabException {
		Logger.getLogger(ACTSConstraintTranslator.class).setLevel(Level.ALL);
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("ProcessorComm2.citl", true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, false, true, true, 2);
		System.out.println(ts.getTests().size());		
	}

	
	
	@Test
	public void generateFromIncorrect1() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getTestModel("modelsfortests/incorrect","inconsistent1.citl");
		TestSuite ts = trans.generateTestsAndInfo(bbs, false, true, true, 2);
		System.out.println(ts.getTests().size());		
	}

	
	@Test
	public void generateBenchmarksPairwise() throws IOException, CitLabException {
		TSGeneratorByACTS trans;// = new IpoGGenerator();
		trans = new IpoGDGenerator();
		
		Iterator<CitModel> l = ModelsFromFilesUtils.getBenchmarks(true);
		while(l.hasNext()){
			CitModel m = l.next();
			System.out.println("generating for " + m.getName());
			TestSuite ts = trans.generateTestsAndInfo(m, false , true, true, 2);
			assertNotNull(ts);
			// chekc some data
		}
	}

	// genero per benchmark 19 che aveve problemi con versione 2.7
	@Test
	public void generateBenchmark19() throws IOException, CitLabException {
		TSGeneratorByACTS[] trans ={new IpoGGenerator(), new IpoFGenerator(), new  IpoGDGenerator()};
		CitModel model = ModelsFromFilesUtils.getBenchmark("benchmark_19_2way.citl", true);
		assertNotNull(model);
		for(TSGeneratorByACTS t: trans){
			System.out.println("generating for " + model.getName() + "with" + t.toString());
			TestSuite ts = t.generateTestsAndInfo(model, false , true, true, 2);
			assertNotNull(ts);			
		}		
	}

	
	@Test
	public void testPhoneASE() throws IOException, CitLabException {
		TSGeneratorByACTS gen = new IpoGGenerator();
		CitModel model = ModelsFromFilesUtils.getTestModel("examples","phone_small_ase.citl");
		// without constraints
		TestSuite ts = gen.generateTestsAndInfo(model,true, true, true, 2);
		TestSuiteWriter writer = new TestSuiteWriter();				
		System.out.println(writer.doSwitch(ts));
		ts = gen.generateTestsAndInfo(model,false, true, true, 2);
		System.out.println(writer.doSwitch(ts));
	}


	
	@Test
	public void generateModelWithIff() throws CitLabException {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean x; Boolean y; end \n");
		// aggiungi constraint
		model.append("Constraints: # " + "(x == true) <=> (y == true)" + " # end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(1, m.getConstraints().size());
		System.out.println( m.getConstraints().get(0).toString());
		TSGeneratorByACTS trans = new IpoGGenerator();
		TestSuite ts = trans.generateTestsAndInfo(m, false, true, true, 2);
		//System.out.println(ts.getTests().size());		
		assertEquals(2, ts.getTests().size());
		System.out.println(ts.getTests().get(0).getAssignments());
		System.out.println(ts.getTests().get(1).getAssignments());
	}
		
	
	
}
