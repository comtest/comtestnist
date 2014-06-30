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
package citlab.model.simplifier;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.junit.Test;

import citlab.model.CitLInjectorProvider;
import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromStringsTester;

import com.google.inject.Injector;

public class ConstraintSimplifierTest {

	@Test
	public void testSimplify() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean a; Boolean b; end\n");
		model.append("Constraints:	# a == true# # a == true => b == true # end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(2,m.getParameters().size());
		assertEquals(2,m.getConstraints().size());
		Injector injector = new CitLInjectorProvider().getInjector();
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		System.out.println(SERIALIZER.serialize(m));
		ConstraintSimplifier.eInstance.simplify(m);
		System.out.println(SERIALIZER.serialize(m));
	}

	@Test
	public void testSimplify2() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean a; Boolean b; end\n");
		model.append("Constraints:	# b == true# # a == true => b == true # end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(2,m.getParameters().size());
		assertEquals(2,m.getConstraints().size());
		Injector injector = new CitLInjectorProvider().getInjector();
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		System.out.println(SERIALIZER.serialize(m));
		ConstraintSimplifier.eInstance.simplify(m);
		System.out.println(SERIALIZER.serialize(m));
		assertEquals(1,m.getConstraints().size());
	}

}
