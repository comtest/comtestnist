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

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import citlab.testsuite.TestSuite;
import citlab.core.ext.CitLabException;
import citlab.model.citL.CitModel;

import citlab.model.test.ModelsFromFilesUtils;


public class ComparisonACTSTester {

	
	
	@BeforeClass
	public static void makeSerializer() {
		//ModelsFromFilesTester.makeSerializer();
		Logger.getLogger(TSGeneratorByACTS.class).setLevel(Level.INFO);
	}

	@Test
	public void comparefromSPL() throws IOException, CitLabException {
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel bbs = ModelsFromFilesUtils.getTestModel("examples/fromSPL","ModelAgenFI.citl");
		TestSuite ts = trans.generateTestsAndInfo(bbs, false, true, true, 2);
		System.out.println("time " + ts.getGeneratorTime() + " size " + ts.getTests().size());		
		bbs = ModelsFromFilesUtils.getTestModel("examples/fromSPL","ModelAgenGuidsl.citl");
		ts = trans.generateTestsAndInfo(bbs, false, true, true, 2);
		System.out.println("time " + ts.getGeneratorTime() + " size " + ts.getTests().size());		
	}
}
