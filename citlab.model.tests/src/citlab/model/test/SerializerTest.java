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

import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.junit.Test;

import com.google.inject.Injector;

import citlab.model.CitLInjectorProvider;
import citlab.model.citL.Boolean;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;

public class SerializerTest {

	@Test
	public void test() {
		CitModel model = CitLFactory.eINSTANCE.createCitModel();
		model.setName("prova");
		Boolean b1 = CitLFactory.eINSTANCE.createBoolean();
		b1.setName("b1");
		Boolean b2 = CitLFactory.eINSTANCE.createBoolean();
		b2.setName("b2");
		model.getParameters().add(b1);
		model.getParameters().add(b2);
		//
		Injector injector = new CitLInjectorProvider().getInjector();
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		System.out.println(SERIALIZER.serialize(model));
	}

}
