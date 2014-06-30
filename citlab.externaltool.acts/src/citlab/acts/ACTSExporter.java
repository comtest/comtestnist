/*******************************************************************************
 * Copyright (c) 2013 Universit� di Bergamo
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/

package citlab.acts;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import citlab.core.ext.ICitLabExporter;
import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.CitModel;
import citlab.model.citL.Rule;
import edu.uta.cse.fireeye.common.Constraint;
import edu.uta.cse.fireeye.common.Parameter;
import edu.uta.cse.fireeye.common.Relation;
import edu.uta.cse.fireeye.common.SUT;

/** exports to ACTS a citlab model **/
public class ACTSExporter extends ICitLabExporter {

	private static Logger logger = Logger.getLogger(ACTSExporter.class);

	@Override
	public void convertModel(CitModel citModel, Boolean constraintUse,
			int nWise, String path) throws NotConvertableModel{

		SUT sut;
		sut = buildSUT(citModel, !constraintUse, nWise);
		logger.debug(sut.toString());
		// TODO
		// usare codice di Dario oppure trovare metodo adatto in libreria
		// per salvare la SUT in XML valido

	}

	// accept only paramters with ascii names
	static CharsetEncoder asciiEncoder = Charset.forName("US-ASCII")
			.newEncoder(); // or "ISO-8859-1" for ISO Latin 1

	public static boolean isPureAscii(String v) {
		return asciiEncoder.canEncode(v);
	}

	/**
	 * translate a citModel from citlab to ACTS SUT
	 * 
	 * @param ignoreConstraints
	 * @throws NotConvertableModel
	 * 
	 */
	SUT buildSUT(CitModel citModel, boolean ignoreConstraints, int nWise) throws NotConvertableModel {
		// build a system configuration
		SUT sut = new SUT(citModel.getName());
		// it is recommended to create a new parameter from the SUT object
		// doing so will assign the parameter with an ID automatically
		ACTSParameterAdder paramBuilder = new ACTSParameterAdder(sut);
		for (citlab.model.citL.Parameter p : citModel.getParameters()) {
			String name = p.getName();
			//
			if (!isPureAscii(name)){
				logger.debug("parameter " + name + " is not US-ASCII . choco has problems");				
				throw new NotConvertableModel("parameter " + name + " is not US-ASCII . choco has problems");
			}
			logger.debug("adding parameter " + name);
			paramBuilder.doSwitch(p);
		}
		//
		// create relation
		Relation r = new Relation(nWise);
		for (Parameter p : sut.getParameters()) {
			r.addParam(p);
		}
		// add this relation into the sut
		sut.addRelation(r);

		// add the default relation
		// sut.addDefaultRelation(nWise);

		// create constraints
		if (!ignoreConstraints) {
			for (Rule c : citModel.getConstraints()) {
				// to String
				ACTSConstraintTranslator trans = new ACTSConstraintTranslator(c);
				String casString = trans.doSwitch(c);
				// it may throw an exepction
				logger.debug("adding constraint " + casString);
				assert casString != null;
				// to list of parameters
				ACTSParamsInConstraintFinder finder = new ACTSParamsInConstraintFinder(c);
				ArrayList<Parameter> pInC = finder.doSwitch(c);
				// TODO for now, it is null and it works the same
				Constraint constraint = new Constraint(casString, pInC);
				sut.addConstraint(constraint);				
			}
		} else {
			logger.debug("ignoring costraints");
		}
		return sut;
	}

}
