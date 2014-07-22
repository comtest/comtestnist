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
package citlab.ipogenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.util.ParameterSwitchToPairStrings;
import citlab.model.citL.Parameter;
import citlab.model.util.ParameterSize;
import citlab.model.util.Utils;
import citlab.model.util.Utils.Pair;

public class IPOgenerator extends ICitLabTestGenerator {

	public IPOgenerator(){
		super("IPO");
	}

	private static final boolean ORDER = true;

	
	// ---------------------------------------------------------------------------------------------
	// FUNZIONI
	// ---------------------------------------------------------------------------------------------

	private List<Map<Parameter, String>> testSuiteGenerator(
			List<List<Pair<Parameter, String>>> elemShuffle, int nWise) {

		// spezzo la lista di parametri in due liste
		List<List<Pair<Parameter, String>>> elemFirst = new ArrayList<List<Pair<Parameter, String>>>();
		List<List<Pair<Parameter, String>>> elemSecond = new ArrayList<List<Pair<Parameter, String>>>();
		Iterator<List<Pair<Parameter, String>>> ielemShuffle = elemShuffle
				.iterator();
		int k = 0;

		while (ielemShuffle.hasNext()) {
			List<Pair<Parameter, String>> list = ielemShuffle.next();

			if (k < nWise)
				elemFirst.add(list);
			else
				elemSecond.add(list);
			k++;
		}

		// genero le combinazioni delle prime n colonne
		List<Map<Parameter, String>> testSet = getCombination(elemFirst, nWise);
		Iterator<List<Pair<Parameter, String>>> ielemSecond = elemSecond
				.iterator();
		List<List<Pair<Parameter, String>>> elemTemp = new ArrayList<List<Pair<Parameter, String>>>();
		elemTemp.addAll(elemFirst);
		int verticale = 0;
		int ciclo = 0;

		// aggiungo colonna
		while (ielemSecond.hasNext()) {
			// parametro che aggiungo
			List<Pair<Parameter, String>> paramAttuale = ielemSecond.next();
			elemTemp.add(paramAttuale);

			ciclo++;
			System.out.println("ciclo colonna numero " + ciclo + " parametro "
					+ paramAttuale.get(0).getFirst().getName());
			// System.out.println("Parametro che aggiungo: "+
			// paramAttuale.get(0).getFirst().getName());

			// lista dei requisiti che devo coprire
			List<Map<Parameter, String>> piGreco = getCombination(elemTemp,
					nWise);

			// CRESCITA ORIZZONTALE
			Iterator<Map<Parameter, String>> itestSet = testSet.iterator();
			// ciclo le righe
			while (itestSet.hasNext()) {
				// la mappa contiene una riga
				Map<Parameter, String> map = itestSet.next();
				Pair<Parameter, String> pairMax = null;
				int coverMax = 0;

				// scorro i Valori del parametro per trovare quello che copre
				// pi� casi di test per aggiungerlo alla riga
				for (Pair<Parameter, String> pair : paramAttuale) {
					Map<Parameter, String> mapApp = new HashMap<Parameter, String>();
					mapApp.putAll(map);
					mapApp.put(pair.getFirst(), pair.getSecond());
					int coverCounter = 0;

					Iterator<Map<Parameter, String>> ireq = piGreco.iterator();
					while (ireq.hasNext()) {
						if (covers(mapApp, ireq.next())) {
							coverCounter++;
						}
					}

					if (coverCounter >= coverMax) {
						coverMax = coverCounter;
						pairMax = new Pair<Parameter, String>(pair.getFirst(),
								pair.getSecond());
					}

				}
				// aggiungo il valore migliore alla riga
				map.put(pairMax.getFirst(), pairMax.getSecond());
				// rimuovo i casi di test coperti
				remove(map, piGreco);

			}

			// CRESCITA VERTICALE

			Iterator<Map<Parameter, String>> i = piGreco.iterator();

			if (i.hasNext()) {
				verticale++;
				System.out.println("Ciclo verticale num " + verticale);
			}
			while (i.hasNext()) {
				Map<Parameter, String> req = i.next();
				Iterator<Map<Parameter, String>> itestSet2 = testSet.iterator();
				boolean remove = false;
				boolean trovato = false;
				while (itestSet2.hasNext()) {
					Map<Parameter, String> test = itestSet2.next();
					if (covers(test, req)) {
						i.remove();
						trovato = true;
						break;

					}
				}

				if (!trovato) {
					Iterator<Map<Parameter, String>> itestSet3 = testSet
							.iterator();
					while (itestSet3.hasNext()) {
						Map<Parameter, String> test = itestSet3.next();
						if (coversVertical(test, req)) {
							for (Parameter p : req.keySet()) {
								test.put(p, req.get(p));
							}
							remove = true;
							i.remove();
							break;
						}
					}

					if (!remove) {
						Map<Parameter, String> newTest = new HashMap<Parameter, String>();
						for (Parameter p : testSet.get(0).keySet()) {
							newTest.put(p, "*");
						}
						for (Parameter p : req.keySet()) {
							newTest.put(p, req.get(p));
						}
						testSet.add(ordina(newTest, elemTemp));
						i.remove();
					}
				}

			}
		}
		return testSet;
	}

	private Map<Parameter, String> ordina(Map<Parameter, String> newTest,
			List<List<Pair<Parameter, String>>> elemTemp) {
		Map<Parameter, String> testOrdinato = new HashMap<Parameter, String>();
		Iterator<List<Pair<Parameter, String>>> ielem = elemTemp.iterator();
		while (ielem.hasNext()) {
			List<Pair<Parameter, String>> list = ielem.next();
			testOrdinato.put(list.get(0).getFirst(),
					newTest.get(list.get(0).getFirst()));
		}
		return testOrdinato;
	}

	private boolean remove(Map<Parameter, String> map,
			List<Map<Parameter, String>> req) {
		Iterator<Map<Parameter, String>> i = req.iterator();
		boolean remove = false;
		while (i.hasNext()) {
			if (covers(map, i.next())) {
				i.remove();
				remove = true;
			}
		}
		return remove;
	}

	private List<Map<Parameter, String>> getCombination(
			List<List<Pair<Parameter, String>>> elem, int nWise) {

		List<Map<Parameter, String>> testSet = new ArrayList<Map<Parameter, String>>();
		Iterator<List<Pair<Parameter, String>>> reqs = Utils
				.getAllKWiseCombination(elem, nWise);

		while (reqs.hasNext()) {
			List<Pair<Parameter, String>> list = reqs.next();
			Map<Parameter, String> map = new HashMap<Parameter, String>();
			for (Pair<Parameter, String> e : list) {
				map.put(e.getFirst(), e.getSecond());
			}
			testSet.add(map);
		}
		return testSet;
	}

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

	// variante covers per crescita verticale
	private boolean coversVertical(Map<Parameter, ?> test,
			Map<Parameter, ?> requirement) {
		int counter = 0;
		for (Parameter p : requirement.keySet()) {
			if (requirement.get(p).equals(test.get(p))
					|| test.get(p).equals("*")) {
				counter++;
			}
		}
		return counter == requirement.size();
	}

	@Override
	public TestSuite call() throws Exception {
		System.out.println("IPO" + nWise + ignoreConstraints); // $codepro.audit.disable accidentalConcatenation

		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(citModel);

		if (!ignoreConstraints && !citModel.getConstraints().isEmpty())
			throw new RuntimeException("IPO does not work with constraints");

		List<Parameter> vars = new ArrayList<Parameter>(citModel.getParameters());
		if (ORDER)
			// redoer the paramters in terms of their size
			Collections.sort(vars, new Comparator<Parameter>() {

				ParameterSize ps = ParameterSize.eInstance;

				@Override
				public int compare(Parameter arg0, Parameter arg1) {
					// prendo la size
					int deltaSize = ps.doSwitch(arg1) - ps.doSwitch(arg0);
					if (deltaSize == 0) return arg0.getName().compareTo(arg1.getName());
					return deltaSize;
				}
			});
		System.out.println("variables " + vars);
		List<List<Pair<Parameter, String>>> elements = ParameterSwitchToPairStrings.getListPairsParameterValues(citModel);

		// List<List<Pair<Parameter, String>>> elemShuffle =
		// elementsShuffle(nWise, elements);
		List<Map<Parameter, String>> bestTestSuite = new ArrayList<Map<Parameter, String>>();
		List<Map<Parameter, String>> testsuite = testSuiteGenerator(elements,
				this.nWise);
		bestTestSuite.addAll(testsuite);
		for (Map<Parameter, ?> map : bestTestSuite) {
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
