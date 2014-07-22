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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import citlab.model.util.CombinationGeneratorList;

/**
 * some utilities
 * 
 */
public class Utils {

	// ------------------
	// Compute factorial
	// ------------------

	/**
	 * Method getFactorial.
	 * 
	 * @param n
	 *            int
	 * @return BigInteger
	 */
	public static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	/**
	 * given a list of list of n elements, returns an iterator over all the n-wise combinations of the elements
	 * to be used with pairs if one wants to keep track of variables.
	 *
	 * @param <T> the generic type
	 * @param elements the elements
	 * @return iterator of all the combinations
	 */
	static public <T> Iterator<List<T>> getAllCombinations(List<List<T>> elements) {
		return getAllKWiseCombination(elements, elements.size());
	}

	
	/**
	 * given a list of list of elements, and a k-wise it returns the k-wise combinations of the elements
	 * to be used with pairs if one wants to keep track of variables.
	 *
	 * @param <T> the generic type
	 * @param elements the elements
	 * @param k the k
	 * @return the all k wise combination
	 */
	static public <T> Iterator<List<T>> getAllKWiseCombination(List<List<T>> elements, int k) {
		// build the combinator for the variables
		final CombinationGeneratorList<List<T>> gen = new CombinationGeneratorList<List<T>>(elements, k);

		return new Iterator<List<T>>() {
			// current combination which is iterated
			private Iterator<List<T>> currentCombinationIterator;

			@Override
			public boolean hasNext() {
				return gen.hasNext() || currentCombinationIterator.hasNext();
			}

			@Override
			public List<T> next() {
				if (currentCombinationIterator == null || !currentCombinationIterator.hasNext()) {
					// get the next combination
					List<List<T>> vs = gen.next();
					TupleIterator<T> lE = new TupleIterator<T>(vs);
					currentCombinationIterator = lE;
				}
				return currentCombinationIterator.next();
			}

			@Override
			public void remove() {
				throw new RuntimeException("remove not supported");

			}
		};
	}
	
	/**
	 * given a list of list of variables and their elements, and a k-wise it returns the k-wise combinations of the elements
	 * da covertire la mappa in lista di coppie??? TODO AG
	 * T potrebbero essere anche non omogenei cosa succede??? 
	 * 
	 * @return
	 */
	static public <S,T> Iterator<List<Pair<S,T>>> getAllKWiseCombination(final Map<S,List<T>> varElements, int k) {
		// get the list of variables
		List<S> vars = new ArrayList<S>(varElements.keySet());
		// build all the pairs
		List<List<Pair<S, T>>> problem = new ArrayList<List<Pair<S, T>>>();
		// for var
		for (S var: vars) {
			List<Pair<S, T>> vi = new ArrayList<Pair<S, T>>();
			for (T ele: varElements.get(var)) {
				vi.add(new Pair<S, T>(var, ele));
			}
			problem.add(vi);
		}
		return getAllKWiseCombination(problem, k);
	}

	static public class Pair<S,T>{
		
		private S first;
		private T second;
		
		public Pair(S s, T a) {
			first = s; second = a;
		}
		
		@Override
		public String toString() {
			return "[" + first.toString()+ ", "+ second.toString() + "]";
		}

		public S getFirst() {
			return first;
		}

		public T getSecond() {
			return second;
		}
		
	}
}
