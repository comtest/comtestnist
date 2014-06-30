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

/*******************************************************************************
 * Copyright (c) 2012 University of Bergamo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Paolo Vavassori - initial API and implementation
 *     Angelo Gargantini - utils and architecture
 ******************************************************************************/
import static citlab.model.test.ModelsFromFilesUtils.getTestModel;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import citlab.model.citL.CitModel;

public class WrongModelsFromFilesTester {

	@Test(expected=RuntimeException.class)
	public void testWrong1() throws IOException{
		CitModel citModel = getTestModel("modelsfortests/incorrect","duplicatedID.citl");
	}

	@Test(expected=RuntimeException.class)
	public void test1() throws IOException {
		CitModel citModel = getTestModel("modelsfortests/incorrect","model0.citl");
		assertEquals("zero", citModel.getName());
	}

	
	
}
