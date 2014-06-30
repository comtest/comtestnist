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
package citlab.core.util;

import citlab.model.citL.Aseed;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Parameter;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.util.Utils.Pair;

/**
 * It converts a Seed in a list of Pairs<parameter,String>.
 * 
 * @author garganti
 * 
 */
public class ASeedSwitchPair extends CitLSwitch<Pair<Parameter, String>> {
	@Override
	public Pair<Parameter, String> caseAseed(Aseed aseed) {
		return this.doSwitch(aseed);
	}

	@Override
	public Pair<Parameter, String> caseBoolAssignSeed(BoolAssignSeed bool) {

		return new Pair<Parameter, String>(bool.getLeft(), bool.getRight()
				.getLiteral());
	}

	@Override
	public Pair<Parameter, String> caseEnumSeed(EnumSeed enumSeed) {

		return new Pair<Parameter, String>(enumSeed.getLeft(), enumSeed
				.getRight().getName());
	}

	@Override
	public Pair<Parameter, String> caseNumericalSeed(NumericalSeed numericalSeed) {
        if (numericalSeed.getRight().getConstant() != null)
		return new Pair<Parameter, String>(numericalSeed.getLeft(),

		Integer.toString(numericalSeed.getRight().getConstant().getValue()));
        else
        	return new Pair<Parameter, String>(numericalSeed.getLeft(),

        			Integer.toString(numericalSeed.getRight().getNumber()));
	}

}
