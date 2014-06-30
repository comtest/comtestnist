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
package citlab.model.test;

import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.CNF;
import citlab.model.logic.cnf.CNF.Clause;
import citlab.model.logic.cnf.CNFConverter;
import citlab.model.util.CombinationCounter;

/**
 * check the product number in citlab and in splot should be the same
 * 
 * @author garganti
 * 
 */
public class BenchmarkData {

	static DecimalFormat formatter = new DecimalFormat("0000.##E0");

	@Test
	public void printDataModels() throws Exception {
		MathContext mc = new MathContext(3);
		Iterator<CitModel> models = ModelsFromFilesUtils.getBenchmarks(true);
		while (models.hasNext()) {
			CitModel m = models.next();
			System.out.print(m.getName() + "\t");
			// System.out.print(CombinationCounter.count(m)+ "\t");
			// System.out.print(new
			// BigDecimal(CombinationCounter.countCartesianProduct(m),mc).toEngineeringString());
			// number of variables
			System.out.print(m.getParameters().size());
			//
			CNFSize cnfsize = new CNFSize();
			for (Rule r : m.getConstraints()) {
				CNFConverter conv = new CNFConverter();
				CNF cnf = conv.convertToCNF((Expression) r);
				cnfsize.add(cnf);
			}
			System.out.print("\t" + cnfsize.nLiterals());
			System.out.print("\t" + formatter.format(cnfsize.product()));
			System.out.println();
		}
	}

	@Test
	public void printDataModelsSPL() throws Exception {
		MathContext mc = new MathContext(3);
		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks(false);
		while (models.hasNext()) {
			CitModel m = models.next();
			System.out.print(m.getName() + "\t");
			// System.out.print(CombinationCounter.count(m)+ "\t");
			// System.out.print(new
			// BigDecimal(CombinationCounter.countCartesianProduct(m),mc).toEngineeringString());
			// number of variables
			System.out.print(m.getParameters().size());
			//
			CNFSize cnfsize = new CNFSize();
			for (Rule r : m.getConstraints()) {
				CNFConverter conv = new CNFConverter();
				CNF cnf = conv.convertToCNF((Expression) r);
				cnfsize.add(cnf);
			}
			System.out.print("\t" + cnfsize.nLiterals());
			System.out.print("\t" + formatter.format(cnfsize.product()));
			System.out.println();
		}
	}

	@Test
	public void printDataModelsExpNotation() throws Exception {
		MathContext mc = new MathContext(3);
		Iterator<CitModel> models = ModelsFromFilesUtils.getBenchmarks(true);
		while (models.hasNext()) {
			CitModel m = models.next();
			System.out.print(m.getName() + "\t&\t");
			// System.out.print(CombinationCounter.count(m)+ "\t");
			// System.out.print(new
			// BigDecimal(CombinationCounter.countCartesianProduct(m),mc).toEngineeringString());
			System.out.print("$");
			CombinationCounter.printSize(m);
			System.out.print("$");
			//
			CNFSize cnfsize = new CNFSize();
			for (Rule r : m.getConstraints()) {
				CNFConverter conv = new CNFConverter();
				CNF cnf = conv.convertToCNF((Expression) r);
				cnfsize.add(cnf);
			}
			System.out.print("\t&\t$" + cnfsize);
			System.out.println("$\\\\");
		}
	}
	@Test
	public void printDataModelsSPLExpNotation() throws Exception {
		MathContext mc = new MathContext(3);
		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks(false);
		while (models.hasNext()) {
			CitModel m = models.next();
			System.out.print(m.getName() + "\t&\t");
			// System.out.print(CombinationCounter.count(m)+ "\t");
			// System.out.print(new
			// BigDecimal(CombinationCounter.countCartesianProduct(m),mc).toEngineeringString());
			System.out.print("$");
			CombinationCounter.printSize(m);
			System.out.print("$");
			//
			CNFSize cnfsize = new CNFSize();
			for (Rule r : m.getConstraints()) {
				CNFConverter conv = new CNFConverter();
				CNF cnf = conv.convertToCNF((Expression) r);
				cnfsize.add(cnf);
			}
			System.out.print("\t&\t$" + cnfsize);
			System.out.println("$\\\\");
		}
	}
	
}


class CNFSize {

	// size -> number of that size
	Map<Integer, Integer> sizes = new HashMap<>();

	public void add(CNF cnf) {
		for (Clause c : cnf.getClauses()) {
			addNewClause(c.getLiterals().size());
		}
	}

	public double product() {
		double res = 1;
		for (Entry<Integer, Integer> f : sizes.entrySet()) {
			res *= Math.pow(f.getKey(), f.getValue());
		}
		return res;
	}

	public int nLiterals() {
		int res = 0;
		for (Entry<Integer, Integer> f : sizes.entrySet()) {
			res += f.getKey() * f.getValue();
		}
		return res;
	}

	// add this new clause with size (number of literals)
	private void addNewClause(int size) {
		Integer sM = sizes.get(size);
		if (sM == null)
			sM = 0;
		sM++;
		sizes.put(size, sM);
	}

	@Override
	public String toString() {
		String res = "";
		for (Entry<Integer, Integer> f : sizes.entrySet()) {
			res += f.getKey() + "^{" + f.getValue() + "}";
		}
		return res;
	}

}
