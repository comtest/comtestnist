/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.splotimporter;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.XMLFeatureModel;
import citlab.core.ext.ICitLabImporter;
import citlab.core.ext.NotImportableException;

import citlab.model.citL.BoolAssign;
import citlab.model.citL.Boolean;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.Operators;
import citlab.model.citL.OrExpression;
import citlab.model.citL.OrOperators;
import citlab.model.citL.Rule;

/**
 * imports a SPLOT feature model into CitLab it uses the SPAR parser, all
 * boolean variables, and for the constraints the constraints (due to the
 * translation and extra) as computed by SPLAR
 * */

public class SplotImporter extends ICitLabImporter {

	static final Logger logger = Logger.getLogger(SplotImporter.class);
	
	public SplotImporter() {
	}

	@Override
	public CitModel importModel(String path) throws NotImportableException {
		//
		CitModel result = CitLFactory.eINSTANCE.createCitModel();
		//
		Map<String, Boolean> parameters = new HashMap<>();
		// read the SPLOT model
		FeatureModel splotModel;
		try {
			splotModel = getSplotModel(path);
		} catch (FeatureModelException e) {
			System.err.println(e.getMessage());
			throw new NotImportableException(path+"\n THIS FEATURE MODEL IS NOT CORRECT");
		}
		// validate
		if (!isImportable(splotModel))
			throw new NotImportableException(path+"\n NOT IMPORTABLE BY CITLAB");
		// set the name
		// TODO why not
		//splotModel.getName()???
		String name = splotModel.getRoot().getName().replace(' ', '_');
		//
		logger.debug("reading model " + name);
		result.setName(name+"_Bool");
		// add the feature as Boolean parameters
		for (FeatureTreeNode node : splotModel.getNodes()) {
			if (!(node instanceof FeatureGroup)) {
				//System.out.println(node.getID());
				Boolean bool = CitLFactory.eINSTANCE.createBoolean();
				// TODO the name may contain "strange" chars to be converted in ascii
				bool.setName(node.getID());
				result.getParameters().add(bool);
				// add to the map
				parameters.put(node.getID(), bool);
			}
		}
		// add the constraints (due to the translation)
		CNFFormula formula = splotModel.FT2CNF();
		addConstraints(parameters, result.getConstraints(), formula);
		// add comment ???
		// extra constraints
		if (splotModel.countConstraints() > 0) {
			addConstraints(parameters, result.getConstraints(),
					splotModel.EC2CNF());
		}
		//
		return result;
	}

	protected splar.core.fm.FeatureModel getSplotModel(String featureModelPath)
			throws FeatureModelException {
		// Create feature model object from an XML file (SXFM format - see
		// www.splot-research.org for details)
		// If an identifier is not provided for a feature use the feature name
		// as id
		splar.core.fm.FeatureModel featureModel = new XMLFeatureModel(
				featureModelPath, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		// load feature model from
		featureModel.loadModel();
		// Now, let's print some statistics about the feature model
		FeatureModelStatistics stats = new FeatureModelStatistics(featureModel);
		stats.update();

		// stats.dump();
		return featureModel;
	}

	/**
	 * 
	 * @param parameters
	 * @param eList
	 *            constraints
	 * @param formula
	 */
	private void addConstraints(Map<String, Boolean> parameters,
			EList<Rule> eList, CNFFormula formula) {
		for (CNFClause clause : formula.getClauses()) {
			Expression cnfclause2citlab = null;
			//System.out.print("# ");
			boolean first = true;
			for (CNFLiteral lit : clause.getLiterals()) {
				BoolAssign assign = CitLFactory.eINSTANCE.createBoolAssign();
				BooleanVariableInterface var = lit.getVariable();
				// set the boolean parameter
				assign.setLeft(parameters.get(var.getID()));
				if (lit.isPositive()) {
					assign.setOp(Operators.EQ);
					//System.out.print(var.getID() + " == true, ");
					assign.setRight(BooleanConst.TRUE);
				} else {
					assign.setOp(Operators.EQ);
					//System.out.print(var.getID() + " == false, ");
					assign.setRight(BooleanConst.FALSE);
				}
				if (first) {
					first = false;
					cnfclause2citlab = assign;
				} else {
					// make the OR
					OrExpression temp = CitLFactory.eINSTANCE
							.createOrExpression();
					temp.setLeft(assign);
					temp.setOp(OrOperators.OR);
					temp.setRight(cnfclause2citlab);
					cnfclause2citlab = temp;
				}
				assert cnfclause2citlab != null;
				eList.add(cnfclause2citlab);
			}
			//System.out.println(" #");
		}
	}

	private boolean isImportable(FeatureModel featureModel2) {
		return true;
	}
}
