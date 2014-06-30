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
package citlab.atgtsmt;
/*******************************************************************************
 * Copyright (c) 2012 gargantini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     gargantini - initial API and implementation
 ******************************************************************************/


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import atgt.combinatorial.TPNWiseCompatibleCollector;
import atgt.coverage.TestCondition;
import atgt.generator.collection.TPCompatibleCollector;
  
import citlab.testsuite.TestSuite;
import citlab.atgtsmt.GeneratorBySMT;
import citlab.model.test.ModelsFromFilesTester;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.test.ModelsFromStringsTester;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.simplifier.Simplificator;
import citlab.model.simplifier.Simplifier;


public class GeneratorBySMTTester {

	
/*	
	@BeforeClass
	public static void makeSerializer() {
		Logger.getLogger(TPCompatibleCollector.class).setLevel(Level.OFF);
		Logger.getLogger(TestCondition.class).setLevel(Level.OFF);
		Logger.getLogger(TPNWiseCompatibleCollector.class).setLevel(Level.OFF); 
		Logger.getLogger(GeneratorBySMT.class).setLevel(Level.DEBUG);
	}
	
	@Test
	public void generateSpin_simulator() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("spin_simulator.citl",true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true, 2);
	}

	@Test
	public void generateMobilePhone() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true,2);
		assertTrue(ts.getTests().size() > 0);
	}

	@Test
	public void generatePhone() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("phone.citl",true);
		TestSuite ts = trans.generateTestsAndInfo(bbs, true, true, true,2);
		assertTrue(ts.getTests().size() > 0);
	}

	@Test
	public void translateAndGenerateSmarthome() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel sh = ModelsFromFilesUtils.getBenchmark("SmartHome.citl",true);
		CitModel shs = new Simplificator(sh).getSimplifiedVersion();
		TestSuite ts = trans.generateTestsAndInfo(shs, false, true, true, shs.getParameters().size());
		System.out.println(ts.getTests().size());
	}

	@Test
	public void translateAndGeneratBBS() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel sh = ModelsFromFilesUtils.getBenchmark("bbs.citl",true);
		CitModel shs = new Simplificator(sh).getSimplifiedVersion();
		TestSuite ts = trans.generateTestsAndInfo(shs, false, true, true, shs.getParameters().size());
		System.out.println(ts.getTests().size());
	}
	
	
	@Test
	public void generateFromIncorrect1() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		CitModel bbs = ModelsFromFilesUtils.getTestModel("modelsfortests/incorrect","inconsistent1.citl");
		TestSuite ts = trans.generateTestsAndInfo(bbs, false, true, true, 2);
		System.out.println(ts.getTests().size());		
	}

	
	@Test
	public void generateBenchmarksPairwise() throws IOException {
		GeneratorBySMT trans = new GeneratorBySMT();
		Iterator<CitModel> l = ModelsFromFilesUtils.getExamples();
		while(l.hasNext()){
			CitModel m = l.next();
			System.out.println("generating for " + m.getName());
			TestSuite ts = trans.generateTestsAndInfo(m, true, true, true, 2);
			assertNotNull(ts);
			// chekc some data
		}
	}

	
	
	@Test
	public void generateModelWithIff() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean x; Boolean y; end \n");
		// aggiungi constraint
		model.append("Constraints: # " + "(x == true) <=> (y == true)" + " # end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(1, m.getConstraints().size());
		System.out.println( m.getConstraints().get(0).toString());
		GeneratorBySMT trans = new GeneratorBySMT();
		TestSuite ts = trans.generateTestsAndInfo(m, false, true, true, 2);
		//System.out.println(ts.getTests().size());		
		assertEquals(2, ts.getTests().size());
		System.out.println(ts.getTests().get(0).getAssignments());
		System.out.println(ts.getTests().get(1).getAssignments());
	}
		
	@Test
	public void generateBoolModel() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean x; Boolean y; end \n");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(0, m.getConstraints().size());
		GeneratorBySMT trans = new GeneratorBySMT();
		TestSuite ts = trans.generateTestsAndInfo(m, false, true, true, 2);
		//System.out.println(ts.getTests().size());		
		assertEquals(2, ts.getTests().size());
		System.out.println(ts.getTests().get(0).getAssignments());
		System.out.println(ts.getTests().get(1).getAssignments());
	}
*/		
}
