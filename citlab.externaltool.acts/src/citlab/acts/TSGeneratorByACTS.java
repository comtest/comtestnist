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

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.ext.NotConvertableModel;
import citlab.core.genprefs.CitlabPreference;
import citlab.model.citL.CitModel;
import edu.uta.cse.fireeye.common.Parameter;
import edu.uta.cse.fireeye.common.SUT;
import edu.uta.cse.fireeye.common.TestGenProfile;
import edu.uta.cse.fireeye.common.TestGenProfile.Algorithm;
import edu.uta.cse.fireeye.common.TestSet;
import edu.uta.cse.fireeye.service.engine.IpoEngine;

/**
 * Generator using any of the ACTS algorithms.
 * 
 */
public abstract class TSGeneratorByACTS extends ICitLabTestGenerator {

	// private static Logger logger = Logger.getLogger(TSGeneratorByACTS.class);

	protected TSGeneratorByACTS(String n) {
		super(n);
	}

	/**
	 * translate the test suite from ACTS to citlab
	 * 
	 * @param ts
	 * @return
	 */
	TestSuite translateTest(TestSet ts, SUT sut, CitModel citModel) {
		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(citModel);
		// for each test in the acts test suite, create a citlab test
		for (int i = 0; i < ts.getNumOfTests(); i++) {
			Test testCitlab = TestsuiteFactory.eINSTANCE.createTest();
			// for each parameter index of acts test suite get its name
			for (int j = 0; j < ts.getNumOfParams(); j++) {
				Parameter param = sut.getParam(j);
				int col = ts.getColumnID(param.getID());
				int value = ts.getValue(i, col);
				// create the assigment for citlab test suite
				Assignment assignment = TestsuiteFactory.eINSTANCE
						.createAssignment();
				// get a citlab.model.citL.Parameter instance from acts
				// parameter name
				for (citlab.model.citL.Parameter citlabparam : citModel
						.getParameters()) {
					if (citlabparam.getName().equals(param.getName()))
						assignment.setParameter(citlabparam);
				}
				if (value != -1) {
					String valueTobeShown = param.getValue(value);
					if (valueTobeShown == null)
						assignment.setValue("*");
					else
						assignment.setValue(valueTobeShown);
				}
				testCitlab.getAssignments().add(assignment);
			}
			result.getTests().add(testCitlab);
		}
		return result;
	}

	@Override
	public TestSuite call() throws Exception {
		// ACTS SUPPORTS CONSTRAINTS
		if (!ignoreSeeds && !citModel.getSeeds().isEmpty())
			throw new RuntimeException("ACTS does not work with seeds");
		if (!ignoreTestGoals && !citModel.getTestGoals().isEmpty())
			throw new RuntimeException("ACTS does not work with test goals");
		// build the SUT
		ACTSExporter exporter = new ACTSExporter();
		SUT sut = exporter.buildSUT(citModel, ignoreConstraints, nWise);

		// print out the sut
		// if (logger.isDebugEnabled()) Log.debug(sut.toString());

		// set the test generation profile
		// randomize don't care values
		TestGenProfile.instance().setRandstar(TestGenProfile.ON);

		try {
			// set the options
			// load preferences
			if (this.genProperties != null) {
				this.genProperties.loadPrefs();
				// set the test generation profile
				// randomize don't care values
				for (CitlabPreference<?> p : this.genProperties){
				if (p.getName().equals("RANDOMIZE_VALUE") && p.getIsEnabled()== 
						true) if (p.getMyValue().equals(true)) {
					TestGenProfile.instance().setRandstar(TestGenProfile.ON);
				} else
					TestGenProfile.instance().setRandstar(TestGenProfile.OFF);
				// constraint handler?
				if (p.getName().equals("CONSTRAINT_HANDLER") && p.getIsEnabled()== 
						true) if (p.getMyValue().equals("CSP"))
					TestGenProfile.instance().setConstraintMode(
							TestGenProfile.ConstraintMode.solver);
				else
					TestGenProfile.instance().setConstraintMode(
							TestGenProfile.ConstraintMode.tuples);}
			}
			// Create an IPO engine object
			IpoEngine engine = new IpoEngine(sut);
			// build a test set
			engine.build(getAlgorithm());
			// get the resulting test set
			TestSet ts = engine.getTestSet();
			assert ts != null;
			return translateTest(ts, sut, citModel);
		} catch (Throwable t) {
			System.err.println("*****" + t.toString());
			System.err.println("***" + t.getCause());
			throw new NotConvertableModel(citModel.getName());
		}

	}

	abstract protected Algorithm getAlgorithm();
}
