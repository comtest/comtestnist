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

import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Range;
import citlab.model.citL.util.CitLSwitch;

/**
 * Given a parameter returns the number of values it can take
 * 
 * @author garganti
 * 
 */
public class ParameterSize extends CitLSwitch<Integer> {

	public static final ParameterSize eInstance = new ParameterSize();

	private ParameterSize() {
	}

	@Override
	public Integer caseBoolean(citlab.model.citL.Boolean object) {
		return 2;
	}

	@Override
	public Integer caseEnumerative(Enumerative enume) {
		return ModelUtils.getEnumerativeType(enume).getElements().size();
	}

	@Override
	public Integer caseRange(Range r) {
		int delta = r.getEnd() - r.getBegin();
		if (r.getStep() != 0)
			return delta / r.getStep() + 1;
		else
			return delta + 1;
	}

	@Override
	public Integer caseNumbers(citlab.model.citL.Numbers numbers) {
		return numbers.getValues().size();
	}

}
