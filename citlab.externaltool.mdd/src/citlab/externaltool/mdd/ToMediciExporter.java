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
package citlab.externaltool.mdd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import citlab.core.ext.ICitLabExporter;
import citlab.core.ext.NotConvertableModel;
import citlab.core.util.ConvertAtomicToSignedInt;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.util.ParameterSize;

/**
 * 
 * Convert to medici in the following format: 
 * w: wise interaction 
 * n: number of parameters 
 * s1,s2, ...sn : size of parameters 
 * nc: number of constraints (in and among them) 
 * c1: first constraint in the required format c2
 */
public class ToMediciExporter extends ICitLabExporter {

	ConvertAtomicToSignedInt convInt;
	CitModel citModel;

	public static String newline = System.getProperty("line.separator");

	public ToMediciExporter() {

	}

	// convert to a new model
	@Override
	public void convertModel(CitModel citModel, Boolean constraintUse, int nWise, String path) throws NotConvertableModel{
		// path should exists and be a directroy
		assert (new File(path).exists() && new File(path).isDirectory());
		// get the new file in path
		File file = new File(path + File.separator + citModel.getName()+ ".medici");
		// write the  data about parameters
		try {
			FileWriter fw = new FileWriter(file);
			fw.append(convertToStringBuffer(citModel,constraintUse,nWise));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public StringBuffer convertToStringBuffer(CitModel citModel,
			Boolean constraintUse, int nWise) throws NotConvertableModel {
		// init the model
		init(citModel);
		StringBuffer result = new StringBuffer();
		// n-wise interaction
		result.append(nWise).append(newline);
		// n: number of parameters
		result.append(citModel.getParameters().size()).append(newline);
		// s1,s2, ...sn : size of parameters
		for (Parameter p : citModel.getParameters()) {
			int s = ParameterSize.eInstance.doSwitch(p);
			result.append(s).append(' ');
		}
		result.append(newline);
		// nc: number of constraints (in and among them)
		if (!constraintUse){
			result.append("0").append(newline);			
		} else{
			// using constraints
			result.append(citModel.getConstraints().size()).append(newline);
		//	c1: first constraint in the required format
			for (Rule r : citModel.getConstraints()) {
				
					ConvertExprAsIntegers converter = new ConvertExprAsIntegers(citModel);
					StringBuffer doSwitch = converter.doSwitch(r);
					assert doSwitch != null;
					assert doSwitch.indexOf("null") == -1 : "null in " + doSwitch ;
					result.append(doSwitch).append(newline);			
				
			}
		}
		return result;
	}

	private void init(CitModel citModel) {
		// init the model
		this.citModel = citModel;
		// the converter from atomic expression to int
		convInt = new ConvertAtomicToSignedInt(citModel);
	}

}
