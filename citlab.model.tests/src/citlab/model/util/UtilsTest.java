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
package citlab.model.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import citlab.model.util.Utils;
import citlab.model.util.Utils.Pair;


public class UtilsTest {

	@Test
	public void testGetAllKWiseCombination() {
		// crea la lista di liste
		List<List<Integer>> problema = new ArrayList<List<Integer>>();
		problema.add(Arrays.asList(1, 2));
		problema.add(Arrays.asList(3, 4));
		problema.add(Arrays.asList(5, 6));
		Iterator<List<Integer>> comb = Utils.getAllKWiseCombination(problema, 2);
		assertEquals("[1, 3]", comb.next().toString());
		assertEquals("[1, 4]", comb.next().toString());
		assertEquals("[2, 3]", comb.next().toString());
		assertEquals("[2, 4]", comb.next().toString());
		assertEquals("[1, 5]", comb.next().toString());
		assertEquals("[1, 6]", comb.next().toString());
		assertEquals("[2, 5]", comb.next().toString());
		assertEquals("[2, 6]", comb.next().toString());
		assertEquals("[3, 5]", comb.next().toString());
		assertEquals("[3, 6]", comb.next().toString());
		assertEquals("[4, 5]", comb.next().toString());
		assertEquals("[4, 6]", comb.next().toString());
		assertFalse(comb.hasNext());

	}

	@Test
	public void printGetAllKWiseCombination() {
		// crea la lista di liste
		List<List<Integer>> problema = new ArrayList<List<Integer>>();
		problema.add(Arrays.asList(1, 2, 3));
		problema.add(Arrays.asList(4, 5));
		problema.add(Arrays.asList(6, 7));
		problema.add(Arrays.asList(8, 9, 10));
		Iterator<List<Integer>> comb = Utils
				.getAllKWiseCombination(problema, 3);
		while (comb.hasNext()) {
			System.out.println(comb.next());
		}
	}

	@Test
	public void allKWiseCombinationDuplicatedList() {
		String a = "A";
		String b = "B";
		List<List<String>> problema = new ArrayList<List<String>>();
		problema.add(Arrays.asList(a, b));
		problema.add(Arrays.asList(a, b));
		problema.add(Arrays.asList(a, b));
		Iterator<List<String>> comb = Utils.getAllKWiseCombination(problema, 2);
		// many duplicates: not clear which refers to what !!!
		assertEquals("[A, A]", comb.next().toString());
		assertEquals("[A, B]", comb.next().toString());
		assertEquals("[B, A]", comb.next().toString());
		assertEquals("[B, B]", comb.next().toString());
		assertEquals("[A, A]", comb.next().toString());
		assertEquals("[A, B]", comb.next().toString());
		assertEquals("[B, A]", comb.next().toString());
		// and so on
		// attenzione che gli elementi sono ripetuti perch� riferita a parametri diversi
	}
	@Test
	public void allKWiseCombinationDuplicatedPairs() {
		// a method to solve the problem 
		String a = "A";
		String b = "B";
		List<Pair<String,String>> v1 = new ArrayList<Pair<String, String>>();
		v1.add(new Pair<String, String>("v1",a));
		v1.add(new Pair<String, String>("v1",b));
		List<Pair<String,String>> v2 = new ArrayList<Pair<String, String>>();
		v2.add(new Pair<String, String>("v2",a));
		v2.add(new Pair<String, String>("v2",b));
		List<Pair<String,String>> v3 = new ArrayList<Pair<String, String>>();
		v3.add(new Pair<String, String>("v2",a));
		v3.add(new Pair<String, String>("v2",b));
		List<List<Pair<String,String>>> problema = new ArrayList<List<Pair<String, String>>>();
		problema.add(v1);
		problema.add(v2);
		problema.add(v3);
		Iterator<List<Pair<String, String>>> comb = Utils.getAllKWiseCombination(problema, 2);
		while (comb.hasNext()) {
			System.out.println(comb.next());
		}
	}

	@Test
	public void allKWiseCombinationDuplicatedMap() {
		String a = "A";
		String b = "B";
		Map<String,List<String>> problema = new HashMap<String, List<String>>();
		problema.put("v1",Arrays.asList(a, b));
		problema.put("v2",Arrays.asList(a, b));
		problema.put("v3",Arrays.asList(a, b));
		Iterator<List<Pair<String, String>>> comb = Utils.getAllKWiseCombination(problema, 2);
		while (comb.hasNext()) {
			System.out.println(comb.next());
		}
	}

	
	@Test
	public void testGetAllCombinationSmall(){
		List<List<String>> problema = new ArrayList<List<String>>();
		problema.add(Arrays.asList("a", "b"));
		problema.add(Arrays.asList("c", "d"));
		Iterator<List<String>> i = Utils.getAllCombinations(problema);
		assertEquals("[a, c]", i.next().toString());
		assertEquals("[a, d]", i.next().toString());
		assertEquals("[b, c]", i.next().toString());
		assertEquals("[b, d]", i.next().toString());
		assertFalse(i.hasNext());
		
	}

	@Test
	public void testGetAllCombination10power5(){
		testgetAllCombinations10powern(5);
	}

	@Test
	public void testGetAllCombination10power6(){
		testgetAllCombinations10powern(6);
	}

	@Test
	public void testGetAllCombination10power8(){
		testgetAllCombinations10powern(8);
	}

	private void testgetAllCombinations10powern(int n) {
		List<List<Integer>> problema = new ArrayList<List<Integer>>();
		List<Integer> asList10 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		for(int i = 0; i < n; i++){
			problema.add(asList10);
		}
		long start = System.currentTimeMillis();
		Iterator<List<Integer>> i = Utils.getAllCombinations(problema);
		long count = 0;
		while(i.hasNext()){
			i.next();
			count ++;
		}		
		// 
		assertEquals(Math.round(Math.pow(10, n)), count);
		// Get elapsed time in milliseconds
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println(elapsedTimeMillis);
	}
}
