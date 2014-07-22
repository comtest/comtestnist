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
package citlab.aetggenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.util.ASeedSwitchPair;
import citlab.core.util.ParameterSwitchToPairStrings;
import citlab.model.citL.Aseed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Seed;
import citlab.model.util.Utils;
import citlab.model.util.Utils.Pair;

public class AetgGenerator extends ICitLabTestGenerator {

	public AetgGenerator() {
		super("AETG");
	}

	// Tabella dei contatori
	List<Pair<Parameter, Map<String, Integer>>> mapCount = null;
	int M = 10;

	private Set<Map<Parameter, ?>> AddSeeds(final EList<Seed> seeds,
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
		return testSuite;
	}

	// FUNZIONI

	// scandisco la mappa del requisito per ogni sua chiave e cerco se nel test
	// generato per ogni chiave del requisito ho gli n valori uguali se si il
	// test copre il requisito
	private boolean covers(Map<Parameter, ?> test, Map<Parameter, ?> requirement) {
		int counter = 0;
		for (Parameter p : requirement.keySet()) {
			if (requirement.get(p).equals(test.get(p))) {
				counter++;
			}
		}
		return counter == requirement.size();
	}

	// scandisco la mappa del requisito per ogni sua chiave e cerco se nel test
	// generato per ogni chiave del requisito ho i P valori uguali se si il
	// test copre il requisito (P in questo caso corrisponde al numero di
	// parametri
	// presente nel test set)
	private boolean covers2(Map<Parameter, ?> test,
			Map<Parameter, ?> requirement, int nWise, int pIndex) {
		int counter = 0;
		int diff = nWise - pIndex;
		for (Parameter p : requirement.keySet()) {
			if (requirement.get(p).equals(test.get(p))) {
				counter++;
			}
		}
		if (diff < 0)
			diff = 0;
		return counter == (requirement.size() - diff);
	}

	// scorre le coppie dei requisti per il conteggio
	private void scorriParam(List<Map<Parameter, String>> MapReq) {

		Iterator<Map<Parameter, String>> imap = MapReq.iterator();
		while (imap.hasNext()) {
			Map<Parameter, String> m = imap.next();
			for (Parameter p : m.keySet()) {
				incrementa(p, m.get(p));
			}
		}
	}

	// incrementa i contatori relativi alle coppie dei requisiti
	private void incrementa(Parameter p, String s) {
		Iterator<Pair<Parameter, Map<String, Integer>>> imapCount = mapCount
				.iterator();
		while (imapCount.hasNext()) {
			Pair<Parameter, Map<String, Integer>> pair = imapCount.next();
			// controllo se il parametro � quello giusto
			if (pair.getFirst().getName().equals(p.getName())) {
				// incremento di 1 il contatore del valore "s"
				pair.getSecond().put(s, pair.getSecond().get(s) + 1);
				break;
			}
		}
	}

	// inizializza la mappa dei contatori
	private void inizializza(List<List<Pair<Parameter, String>>> elements) {
		mapCount = new ArrayList<Pair<Parameter, Map<String, Integer>>>();
		Iterator<List<Pair<Parameter, String>>> iElem = elements.iterator();
		while (iElem.hasNext()) {
			List<Pair<Parameter, String>> elem = iElem.next();
			Map<String, Integer> map = new HashMap<String, Integer>();
			Pair<Parameter, Map<String, Integer>> pair = new Pair<Parameter, Map<String, Integer>>(
					elem.get(0).getFirst(), map);
			// elem: lista di coppie
			for (Pair<Parameter, String> p : elem) {
				map.put(p.getSecond(), 0);
			}
			mapCount.add(pair);
		}
	}

	// restituisce la coppia parametro-valore piu ricorrente
	private Map<Parameter, String> parametroMax() {
		Iterator<Pair<Parameter, Map<String, Integer>>> imap = mapCount
				.iterator();
		List<Pair<Pair<Parameter, String>, Integer>> massimi = new ArrayList<Pair<Pair<Parameter, String>, Integer>>();

		while (imap.hasNext()) {
			int maxint = 0;
			String app = new String();
			Pair<Parameter, String> test = null;
			Pair<Parameter, Map<String, Integer>> pair = imap.next();
			for (String p : pair.getSecond().keySet()) {
				if (pair.getSecond().get(p).intValue() >= maxint) {
					app = p;
					maxint = pair.getSecond().get(p).intValue();
				}
			}
			test = new Pair<Parameter, String>(pair.getFirst(), app);
			Pair<Pair<Parameter, String>, Integer> massimo = new Pair<Pair<Parameter, String>, Integer>(
					test, maxint);
			massimi.add(massimo);
		}
		Map<Parameter, String> listMax = new HashMap<Parameter, String>();

		Iterator<Pair<Pair<Parameter, String>, Integer>> imassimi = massimi
				.iterator();
		Pair<Parameter, String> paramMax = null;
		int max = 0;
		while (imassimi.hasNext()) {
			Pair<Pair<Parameter, String>, Integer> m = imassimi.next();
			if (m.getSecond().intValue() >= max) {
				max = m.getSecond().intValue();
				paramMax = new Pair<Parameter, String>(m.getFirst().getFirst(),
						m.getFirst().getSecond());

			}
		}
		listMax.put(paramMax.getFirst(), paramMax.getSecond());

		return listMax;
	}

	// ordina la lista come � ordinato vars
	private Map<Parameter, String> ordina(EList<Parameter> vars,
			Map<Parameter, String> test) {
		Map<Parameter, String> map = new HashMap<Parameter, String>();
		for (Parameter p : vars) {
			map.put(p, test.get(p));
		}
		return map;
	}

	// ordina la lista in maniera casuale
	private List<List<Pair<Parameter, String>>> shuffle(
			List<List<Pair<Parameter, String>>> elements) {
		List<List<Pair<Parameter, String>>> elemShuffle = new ArrayList<List<Pair<Parameter, String>>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < elements.size(); i++) {
			array.add(i);
		}
		Collections.shuffle(array);

		for (int i = 0; i < elements.size(); i++) {
			elemShuffle.add(elements.get(array.get(i)));
		}
		return elemShuffle;
	}

	// genera un caso di test
	private Map<Parameter, String> testGenerator(
			List<List<Pair<Parameter, String>>> elem,
			List<Map<Parameter, String>> listMapReq,
			Map<Parameter, String> testMAX, int nWise)

	{
		Iterator<List<Pair<Parameter, String>>> ielem = elem.iterator();
		Map<Parameter, String> test = new HashMap<Parameter, String>();
		test.putAll(testMAX);

		int p = 1;
		while (ielem.hasNext()) {
			p++;
			List<Pair<Parameter, String>> list = ielem.next();

			if (testMAX.get(list.get(0).getFirst()) != null)
				if (ielem.hasNext())
					list = ielem.next();
				else
					break;

			int coverMax = 0;
			Pair<Parameter, String> pairMax = null;
			for (Pair<Parameter, String> pair : list) {
				Map<Parameter, String> mapApp = new HashMap<Parameter, String>();
				mapApp.putAll(test);
				mapApp.put(pair.getFirst(), pair.getSecond());
				int coverCounter = 0;

				Iterator<Map<Parameter, String>> i = listMapReq.iterator();
				while (i.hasNext()) {
					if (covers2(mapApp, i.next(), nWise, p)) {
						coverCounter++;
					}
				}
				if (coverCounter >= coverMax) {
					coverMax = coverCounter;
					pairMax = new Pair<Parameter, String>(pair.getFirst(),
							pair.getSecond());
				}
			}
			test.put(pairMax.getFirst(), pairMax.getSecond());
		}
		return test;
	}

	// genera m casi di test candidati e restituisce il migliore
	private Map<Parameter, String> mGenerator(
			List<List<Pair<Parameter, String>>> elements,
			List<Map<Parameter, String>> listMapReq,
			Map<Parameter, String> testMAX, int m, int nWise) {

		Set<Map<Parameter, String>> testSuite = new HashSet<Map<Parameter, String>>();
		Map<Parameter, String> testMigliore = null;

		for (int i = 0; i < m; i++) {
			List<List<Pair<Parameter, String>>> elemShuffle = shuffle(elements);
			Map<Parameter, String> mTest = testGenerator(elemShuffle,
					listMapReq, testMAX, nWise);
			testSuite.add(mTest);
		}
		System.out.println("Test suite size " + testSuite.size());
		Iterator<Map<Parameter, String>> itestSuite = testSuite.iterator();

		int coverMax = 0;
		while (itestSuite.hasNext()) {
			int coverCount = 0;
			Map<Parameter, String> testCandidato = itestSuite.next();

			Iterator<Map<Parameter, String>> ilistMapReq = listMapReq
					.iterator();
			while (ilistMapReq.hasNext()) {
				if (covers(testCandidato, ilistMapReq.next())) {
					coverCount++;
				}
			}

			if (coverCount >= coverMax) {
				coverMax = coverCount;
				testMigliore = new HashMap<Parameter, String>();
				testMigliore.putAll(testCandidato);
			}
		}
		System.out.println("cover MAX " + coverMax);
		return testMigliore;
	}

	@Override
	public TestSuite call() throws Exception {
		// AETG supports seeds
		if (!ignoreConstraints && !citModel.getConstraints().isEmpty())
			throw new RuntimeException("AETG does not work with constraints");
		if (!ignoreTestGoals && !citModel.getTestGoals().isEmpty())
			throw new RuntimeException("AETG does not work with test goals");
		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(citModel);
		EList<Parameter> vars = citModel.getParameters();
		EList<Seed> seeds = citModel.getSeeds();
		List<List<Pair<Parameter, String>>> elements = ParameterSwitchToPairStrings
				.getListPairsParameterValues(citModel);
		// genero i requisiti sotto forma di Lista di lista di
		// pairelement
		Iterator<List<Pair<Parameter, String>>> reqs = Utils
				.getAllKWiseCombination(elements, nWise);

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
			testSuite = AddSeeds(seeds, testSuite);
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
		System.out.println("AAAAAA" + testSuite.size());

		int c = 0;
		while (!ListMapReq.isEmpty()) {
			int r = 0;
			c++;
			System.out.println();
			System.out.println("ciclo numero " + c);
			inizializza(elements);
			scorriParam(ListMapReq);
			Map<Parameter, String> testMigliore = mGenerator(elements,
					ListMapReq, parametroMax(), M, nWise);
			Map<Parameter, String> test = ordina(vars, testMigliore);

			Iterator<Map<Parameter, String>> i = ListMapReq.iterator();
			while (i.hasNext()) {
				if (covers(test, i.next())) {
					i.remove();
					r++;
				}
			}
			if (r != 0) {
				System.out.println("remove n " + r);
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
