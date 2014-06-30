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
package citlab.CoderToCasa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import citlab.core.ext.ICitLabExporter;
import citlab.core.ext.NotConvertableModel;
import citlab.core.util.ConvertAtomicToSignedInt;

import citlab.externaltool.casa.ToCasaParametersExporter;
import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.CNF;
import citlab.model.logic.cnf.CNFConverter;

/**
 * 
 * Convert to CASA as two files (one with model the other with constraints)
 * 
 */
public class ToCasaExporter extends ICitLabExporter {

	ConvertAtomicToSignedInt convInt;
	CitModel citModel;

	public ToCasaExporter() {

	}
	// convert to a new model
	@Override
	public void convertModel(CitModel citModel, Boolean constraintUse, int nWise,String path) throws NotConvertableModel {
		init(citModel);
		saveModel(citModel, nWise, constraintUse, path);

	}
	// to be called at the beginning
	void init(CitModel citModel) {
		// init the model
		this.citModel = citModel;
		// the converter from atomic expression to int
		convInt = new ConvertAtomicToSignedInt(citModel);
	}
	/** save the model 
	 * @param result
	 * @param nWise
	 * @param constraintUse
	 * @param path
	 * 
	 * @throws NotConvertableModel
	 */
	public void saveModel(CitModel result, int nWise, boolean constraintUse,
			String path) throws NotConvertableModel {
		File file = new File(path + File.separator + result.getName() + ".citmodel");
		File fileconstr = new File(path + File.separator + result.getName() + ".constraints");
		
		ToCasaParametersExporter exporter = new ToCasaParametersExporter();
		CharSequence source = exporter.toCasaCode(result, nWise);
		try {
			/*if (!file.exists()) {*/
				// write 
				FileWriter fw = new FileWriter(file);
				fw.append(source);
				fw.close();				
				// constraints
				if (constraintUse && !result.getConstraints().isEmpty()) {
					CharSequence constraints = this.translateConstraints();
					//InputStream sourceC = new ByteArrayInputStream(constraints.toString().getBytes());
					fw = new FileWriter(fileconstr);
					fw.append(constraints);
					fw.close();
					//fileconstr.create(sourceC, IResource.FORCE, null);
				}
				//file.create(source, IResource.NONE, null);
/*			} else {
				fileconstr.delete(true, null);
				file.delete(true, null);
				if (constraintUse && !result.getConstraints().isEmpty()) {
					CharSequence constraints = this.translateConstraints();
					InputStream sourceC = new ByteArrayInputStream(constraints
							.toString().getBytes());

					fileconstr.create(sourceC, IResource.FORCE, null);
				}

				file.create(source, IResource.FORCE, null);
			}*/

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//[number of disjunctive clauses] \n
	//[number of terms in this disjunctive clause] \n
	//[+ for plain, - for negated] [variable] [more plain or negated variables...] \n
	//[more disjunctive clauses...] \n
	CharSequence translateConstraints() throws NotConvertableModel {
		//
		StringBuffer clauses = new StringBuffer();
		EList<Rule> constraints = citModel.getConstraints();
		// [number of disjunctive clauses] \n
		int numberofClauses = 0;
		// TODO: fix it is the sum
		CNFConverter cnfConverter = new CNFConverter();
		for (Rule r : constraints) {
			CNF cnfc = cnfConverter.convertToCNF((Expression) r);
			for (CNF.Clause c : cnfc.getClauses()) {
				numberofClauses++;
				List<Expression> literals = c.getLiterals();
				// [number of terms in this disjunctive clause] \n
				clauses.append(literals.size()).append('\n');
				for (Expression e : literals) {
					// [+ for plain, - for negated] [variable] [more plain or
					// negated variables...] \n
					try{
						citlab.core.util.SignedInteger value = convInt.doSwitch(e);
						assert value != null;
						if (value.isNegative()) {
							clauses.append("- ").append(value.getValue());
						} else {
							clauses.append("+ ").append(value.getValue());
						}
						}catch(Exception re){
							throw new NotConvertableModel(re.getMessage());
						}
					clauses.append(' ');
				}
				clauses.append('\n');
			}
			// [more disjunctive clauses...] \n
		}
		StringBuffer result = new StringBuffer();
		// [number of disjunctive clauses] \n
		result.append(numberofClauses).append('\n');
		// clauses
		result.append(clauses);
		assert result != null;
		return result;
	}
}


