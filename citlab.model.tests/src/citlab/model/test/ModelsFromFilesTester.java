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
package citlab.model.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.CitModel;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.SimpleExpressionToString;
import citlab.model.rnd.RndModelGeneratorTest;
import static citlab.model.test.ModelsFromFilesUtils.*;

public class ModelsFromFilesTester {
	
	@Test
	public void testPhone1() throws IOException {
		CitModel citModel = getTestModel("modelsfortests/correct","phone.citl");
		assertEquals("phone", citModel.getName());
		assertEquals(3, citModel.getConstraints().size());
		assertEquals("# display==display.BW => rearCamera==cameraType.NOC #",
				 ModelsFromFilesUtils.serialize(citModel.getConstraints().get(0)));
		assertEquals("# display==display.BW => rearCamera==cameraType.1MP #",
				ModelsFromFilesUtils.serialize(citModel.getConstraints().get(1)));
		assertEquals("# emailViewer==true or frontCamera!=cameraType.NOC => display!=display.BW and	textLines>=threshold #",
				ModelsFromFilesUtils.serialize(citModel.getConstraints().get(2)));
	}

	@Test
	public void testBBS() throws IOException {
		CitModel citModel = getTestModel("examples","bbs.citl");
		assertEquals("bbs", citModel.getName());
		assertEquals(1, citModel.getConstraints().size());
		assertEquals("# calltype==CallType.INTERNATIONAL => ( billing != Billing.COLLECT and billing != Billing.EIGHT_HUNDRED) #",
				ModelsFromFilesUtils.serialize(citModel.getConstraints().get(0)));
	}

	@Test
	public void testEnum() throws IOException {
		CitModel citModel = getTestModel("modelsfortests/correct","enum0.citl");
		assertEquals("enumerative", citModel.getName());
		// the first one is an anonymous type
		Enumerative var1 = (Enumerative) citModel.getParameters().get(0);
		assertNotNull(var1.getAtype());
		assertNull(var1.getNamedType());
		assertEquals("Windows", var1.getAtype().getElements().get(0).getName());
		// and so on
		// the second one is a named type
		Enumerative var2 = (Enumerative) citModel.getParameters().get(1);
		assertNull(var2.getAtype());
		assertNotNull(var2.getNamedType());
		assertTrue(var2.getNamedType() instanceof EnumerativeType);
		assertEquals("MacOS", ((EnumerativeType) var2.getNamedType())
				.getElements().get(0).getName());
		// and so on
	}

	@Test
	public void testListExamples() throws IOException {
		Iterator<CitModel> l = ModelsFromFilesUtils.getExamples();
		assertNotNull(l);
		while (l.hasNext()) {
			CitModel citModel = l.next();
			System.out.println(" reading model " + citModel.getName());
			assertNotNull(citModel);
		}
	}

	@Test
	public void testListUnConstrinedBenchmarks() throws IOException {
		Iterator<CitModel> l = ModelsFromFilesUtils.getBenchmarks(false);
		assertNotNull(l);
		while (l.hasNext()) {
			CitModel citModel = l.next();
			System.out.println(" reading model " + citModel.getName());
			assertNotNull(citModel);
		}
	}

	@Test
	public void testListConstrainedBenchmarks() throws IOException {
		Iterator<CitModel> l = ModelsFromFilesUtils.getBenchmarks(true);
		assertNotNull(l);
		while (l.hasNext()) {
			CitModel citModel = l.next();
			System.out.println(" reading model " + citModel.getName());
			assertNotNull(citModel);
		}
	}

	@Test
	public void testPhoneBenchmark() throws IOException {
		CitModel l = ModelsFromFilesUtils.getBenchmark("phone.citl",true);
		assertNotNull(l);
		for(Rule r: l.getConstraints()){
			System.out.println(SimpleExpressionToString.eInstance.doSwitch(r));
			
		}
	}

	
	@Test
	public void testRandomModels() throws IOException {
		File randomModels = new File(RndModelGeneratorTest.CITLAB_BENCHMARKS_RANDOM5);
		assertTrue(randomModels.exists());
		ModelsFromFilesUtils.VALIDATE = true;
		for(String f: randomModels.list()){
			System.out.println(" reading model " +f);
			CitModel l = ModelsFromFilesUtils.getTestModel(RndModelGeneratorTest.CITLAB_BENCHMARKS_RANDOM5, f);
			assertNotNull(l);
		}
	}

	
}
