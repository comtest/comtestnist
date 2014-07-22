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
package citlab.acts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import org.junit.Test;
  
import citlab.core.ext.NotConvertableModel;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import edu.uta.cse.fireeye.common.SUT;


/** test the traslator from citlab to ACTS */

public class ToACTSTester {	
	
	@Test
	public void translateSpin_simulator() throws  NotConvertableModel, IOException {
		ACTSExporter trans = new ACTSExporter();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("spin_simulator.citl",true);
		SUT sut = trans.buildSUT(bbs, false, 2);
		assertNotNull(sut);
		// the same number of parameters
		assertEquals(toNames(bbs.getParameters()) + "->" + sut.getParameters(), bbs.getParameters().size(), sut.getParameters().size());
		//
		System.out.println(sut.toString());
	}

	
	@Test
	public void translateProcessorComm2() throws  NotConvertableModel, IOException {
		ACTSExporter trans = new ACTSExporter();
		CitModel bbs = ModelsFromFilesUtils.getBenchmark("ProcessorComm2.citl",true);
		SUT sut = trans.buildSUT(bbs, false, 2);
		assertNotNull(sut);
		//
		System.out.println(sut.toString());
	}
	
	
	@Test
	public void translateBenchmarksConstraintsPairwise() throws NotConvertableModel, IOException {
		ACTSExporter trans = new ACTSExporter();
		Iterator<CitModel> l = ModelsFromFilesUtils.getBenchmarks(true);
		while(l.hasNext()){
			CitModel m = l.next();
			System.out.println("translating " + m.getName());
			SUT sut = trans.buildSUT(m, false,2);
			assertNotNull(sut);
			// the same number of parameters
			assertEquals(toNames(m.getParameters()) + "->" + sut.getParameters(), m.getParameters().size(), sut.getParameters().size());
			// TODO add check constraints 			
		}
	}

	private String toNames(EList<Parameter> parameters) {
		String result = "";
		for(Parameter p:parameters){
			result += "," + p.getName();
		}
		return result;
	}
	
}
