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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;


import citlab.model.util.ListPairsToSeed;
import citlab.model.util.ParameterToPairElements;
import citlab.model.util.Utils.Pair;
import citlab.model.citL.Boolean;
import citlab.model.citL.CitModel;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.validation.RuleEvaluator;
/**
 * It counts the combinations in a model // *
 * 
 */
public class CombinationCounter {

	public static CombinationCounter eInstance = new CombinationCounter();

	private CombinationCounter() {

	}
	/** return valid combinations */
	public static int count(CitModel citModel) {
		List<List<Pair<Parameter, ?>>> elements = ParameterToPairElements.getListPairsParameterValues(citModel);
		// AlwaysTrueFilter filter = new AlwaysTrueFilter();
		// List<List<Pair<Parameter, ?>>> paramsCleaned =
		// filter.RemoveImmutableAssignment(citModel, elements);
		// System.out.println("cleaned " + paramsCleaned);
		Iterator<List<Pair<Parameter, ?>>> tuples = new TupleIterator<Pair<Parameter, ?>>(elements);
		int count = 0;
		while (tuples.hasNext()) {
			List<Pair<Parameter, ?>> req = tuples.next();
			Seed myseed = ListPairsToSeed.convertToSeed(req);
			boolean check = true;

			for (Rule rule : citModel.getConstraints()) {
				check = checkRuleAndSeed(rule, myseed);
				if (!check)
					break;
			}
			if (check) {
				count++;
				// System.out.println(req);
			}
			
		}
		return count;
	}

	public static java.lang.Boolean checkRuleAndSeed(Rule rule, Seed seed) {
		return (new RuleEvaluator(seed).evaluateRule(rule));
	}

	// as BigInteger, can be very high
	// the cardinality of the parameters
	public static BigInteger countCartesianProduct(CitModel citModel) {
		BigInteger result = BigInteger.valueOf(1);
		for (Parameter p : citModel.getParameters()) {
			int factor = ParameterSize.eInstance.doSwitch(p);
			result = result.multiply(BigInteger.valueOf(factor));
		}
		assert result.signum() == 1 ;
		return result;
	}
	// print as 2^3 ...
	public static void printSize(CitModel m){
		List<Parameter> params = m.getParameters();
		int nPar = params.size();
		int currSize = 0;
		while(nPar > 0){
			int currSizeNP = 0;
			for(Parameter p: params){
				int factor = ParameterSize.eInstance.doSwitch(p);
				if (factor == currSize){
					currSizeNP++;
				}
			}
			if (currSizeNP>0) System.out.print(currSize+ "^{" + currSizeNP+"}");
			currSize++;
			nPar -= currSizeNP;
		}
	}
	
}
