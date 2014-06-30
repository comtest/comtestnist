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

import java.util.Map;

import citlab.model.citL.Parameter;

public class IndexOutOfBoundException extends RuntimeException {

	public IndexOutOfBoundException(int n, Map<Parameter, Integer> offsets) {
		super("index " + n + " not found - current indexes " + offsets);
	}
}
