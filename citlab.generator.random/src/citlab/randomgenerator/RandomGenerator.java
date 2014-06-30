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
package citlab.randomgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.util.ASeedSwitchPair;
import citlab.core.util.ParameterElementsGetter;
import citlab.core.util.ParameterSwitchToPairStrings;
import citlab.model.citL.Aseed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Seed;
import citlab.model.util.Utils.Pair;



/**
 * Random generation
 */
public class RandomGenerator extends ICitLabTestGenerator {

	Random rnd = new Random();

	public RandomGenerator() {
		super("Random");
	}

	// scandisco la mappa del requisito per ogni sua chiave e cerco se nel test
	// generato
	// per ogni chiave del requisito ho gli n valori uguali se si il test copre
	// il requisito
	private boolean covers(Map<Parameter, ?> test, Map<Parameter, ?> requirement) {
		int counter = 0;
		for (Parameter p : requirement.keySet()) {
			if (requirement.get(p).equals(test.get(p)))
				counter++;
		}

		return counter == requirement.size();

	}

	private String getRandomValue(Parameter p) {
		List<String> listElements = ParameterElementsGetter.eInstance
				.doSwitch(p);
		return listElements.get(rnd.nextInt(listElements.size()));

	}

	// Add the tests for the seeds
	private void addSeeds(final EList<Seed> seeds,
			final Set<Map<Parameter, ?>> testSuite) {
		ASeedSwitchPair switchS = new ASeedSwitchPair();
		assert (seeds != null);
		for (Seed seed : seeds) {
			Map<Parameter, String> map = new HashMap<Parameter, String>();
			for (Aseed aseed : seed.getAssigmentSeedList()) {
				Pair<Parameter, String> e = switchS.doSwitch(aseed);
				map.put(e.getFirst(), e.getSecond());
			}
			testSuite.add(map);
		}
		return;
	}

	@Override
	public TestSuite call() throws Exception {
		// RANDOM SUPPORTS SEEDS
		if (!ignoreConstraints && !citModel.getConstraints().isEmpty())
			throw new RuntimeException("random does not work with constraints");
		if (!ignoreTestGoals && !citModel.getTestGoals().isEmpty())
			throw new RuntimeException("AETG does not work with test goals");
		// final result containing all the tests
		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(citModel);
		EList<Parameter> vars = citModel.getParameters();
		EList<Seed> seeds = citModel.getSeeds();
		System.out.println("SSSize" + seeds.size());
	///	System.out.println("numero di combinazioni"
	///			+ CombinationCounter.count(citModel));
		// genero i requisiti sotto forma di Lista di lista di
		// pairelement
		Iterator<List<Pair<Parameter, String>>> reqs = ParameterSwitchToPairStrings.getTuples(citModel, nWise);

		List<Map<Parameter, String>> ListMapReq = new ArrayList<Map<Parameter, String>>();
		// Trasformo la lista di liste in una map scindendo i pairelement in key
		// e value
		while (reqs.hasNext()) {
			List<Pair<Parameter, String>> req = reqs.next();
			Map<Parameter, String> map = new HashMap<Parameter, String>();
			for (Pair<Parameter, String> e : req) {
				map.put(e.getFirst(), e.getSecond());

			}
			ListMapReq.add(map);

		}

		Set<Map<Parameter, ?>> testSuite = new HashSet<Map<Parameter, ?>>();
		// Se ho i seed li carico nella test suite e controllo subito se
		// qualcuno di questi soddisfa qualche requisito
		// Se sì, vado a depennarli dalla lista dei requisiti
		if (!ignoreSeeds && seeds.size() != 0) {
			System.out.println("adding seeds");
			addSeeds(seeds, testSuite);
			Iterator<Map<Parameter, ?>> iSeed = testSuite.iterator();

			while (iSeed.hasNext()) {
				Map<Parameter, ?> seed = iSeed.next();
				if (!ListMapReq.isEmpty()) {
					Iterator<Map<Parameter, String>> iReq = ListMapReq
							.iterator();
					while (iReq.hasNext()) {
						if (covers(seed, iReq.next()))
							iReq.remove();

					}
				}

			}
		}
		while (!ListMapReq.isEmpty()) {

			Map<Parameter, String> test = new HashMap<Parameter, String>();
			for (Parameter p : vars) {
				test.put(p, getRandomValue(p));
			}

			Iterator<Map<Parameter, String>> i = ListMapReq.iterator();
			int r = 0;
			while (i.hasNext()) {
				if (covers(test, i.next())) {
					i.remove();
					r++;
				}
			}
			if (r != 0) {
				testSuite.add(test);
			}

		}
		for (Map<Parameter, ?> map : testSuite) {
			Test test = TestsuiteFactory.eINSTANCE.createTest();
			for (Parameter p : map.keySet()) {
				Assignment assignment = TestsuiteFactory.eINSTANCE
						.createAssignment();
				assignment.setParameter(p);
				assignment.setValue((String) map.get(p));
				test.getAssignments().add(assignment);
			}
			result.getTests().add(test);

		}
		return result;
	}

}
