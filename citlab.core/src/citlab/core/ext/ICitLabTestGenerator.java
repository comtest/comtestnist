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
package citlab.core.ext;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import citlab.core.genprefs.CitlabPreferncesSet;
import citlab.model.citL.CitModel;
import citlab.testsuite.TestSuite;

/**
 * The Class ICitLabTestGenerator: abstract class for test generators.
 */
public abstract class ICitLabTestGenerator extends ICitLabModelProcessor
		implements Callable<TestSuite> {

	protected boolean ignoreConstraints;
	protected boolean ignoreSeeds;
	protected boolean ignoreTestGoals;
	protected int nWise;
	protected String generatorName;
	/**
	 * @return the generatorName
	 */
	public String getGeneratorName() {
		return generatorName;
	}

	protected CitlabPreferncesSet  genProperties;
	
	private Future<TestSuite> futureTS;

	private ExecutorService es;

	protected ICitLabTestGenerator(String generator) {
		this.generatorName = generator;
	}
	/**
	 * generates the citModel and save some meta info in the test suite.
	 * 
	 * @param citModel
	 *            the cit model
	 * @param ignoreConstraints
	 *            the ignore constraints
	 * @param ignoreSeeds
	 *            the ignore seeds
	 * @param ignoreTestGoals
	 *            the ignore test goals
	 * @param nWise
	 *            the n wise
	 * @param generatorName
	 *            the generator name
	 * @return the test suite
	 */
	final public TestSuite generateTestsAndInfo(CitModel model,
			boolean ignoreConstraints, boolean ignoreSeeds,
			boolean ignoreTestGoals, int nWise) throws CitLabException {
		this.ICitLabTestGeneratorSetter(model, ignoreConstraints, ignoreSeeds,
				ignoreTestGoals, nWise);
		// save the time
		long time = System.currentTimeMillis();
		//es = Executors.newFixedThreadPool(4);
		//es = Executors.newCachedThreadPool();
		es = Executors.newSingleThreadScheduledExecutor();
		futureTS=es.submit(this);
		TestSuite ts = null;
		try {
			// take the test suite generate by the generator
			ts = futureTS.get();// 10,TimeUnit.SECONDS);
			// register 
			long delta = System.currentTimeMillis() - time;
			// System.out.println(String.valueOf(delta));
			// convert from missecs to secs
			ts.setGeneratorTime((float) (delta / 1000.0));
			// set the name
			ts.setGeneratorName(generatorName);
			ts.setStrength(nWise);
		} catch (ExecutionException | InterruptedException e) {
			if (e.getCause() instanceof NotConvertableModel )
			    throw (NotConvertableModel) e.getCause();
			if (e.getCause() instanceof java.lang.OutOfMemoryError)
				throw (java.lang.OutOfMemoryError) e.getCause();							
		} finally {
			es.shutdown();
		}
		return ts;
	}

	public CitlabPreferncesSet getGenProperties() {
		return genProperties;
	}

	/**
	 * Icitab test generator setter.
	 * 
	 * @param model
	 *            the model
	 * @param ignoreConstraints
	 *            the ignore constraints
	 * @param ignoreSeeds
	 *            the ignore seeds
	 * @param ignoreTestGoals
	 *            the ignore test goals
	 * @param nWise
	 *            the n wise
	 */
	private void ICitLabTestGeneratorSetter(CitModel model,
			boolean ignoreConstraints, boolean ignoreSeeds,
			boolean ignoreTestGoals, int nWise) {
		this.citModel = model;
		this.ignoreConstraints = ignoreConstraints;
		this.ignoreSeeds = ignoreSeeds;
		this.ignoreTestGoals = ignoreTestGoals;
		this.nWise = nWise;
	}

	public void setGenProperties(CitlabPreferncesSet genProperties) {
		this.genProperties = genProperties;
	}

	public final void stopGeneration() {
		assert (futureTS != null && es != null);
		if (!futureTS.isDone()) {
			futureTS.cancel(true);
			es.shutdown();
			//System.out.println("shutting down");
			//es.shutdownNow();			
			//System.out.println("es.isShutdown()" +es.isShutdown());
			//while(!es.isTerminated()) System.out.print('.');
			//System.out.println(futureTS.isCancelled() + " " + futureTS.isDone());
		}
	}

	
}
