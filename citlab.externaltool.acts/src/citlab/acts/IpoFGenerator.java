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
package citlab.acts;

import edu.uta.cse.fireeye.common.TestGenProfile.Algorithm;

public class IpoFGenerator extends TSGeneratorByACTS {

	public IpoFGenerator(){
		super("IpoF");
		ACTSCommonPreferencesSetter.set(this, "CITLAB.ACTS.IPOF");
	}

	@Override
	protected Algorithm getAlgorithm() {
		
		return Algorithm.ipof;
		
	}

}
