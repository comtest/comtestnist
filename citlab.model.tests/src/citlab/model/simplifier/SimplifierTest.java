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


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.junit.Test;

import com.google.inject.Injector;

import citlab.model.CitLInjectorProvider;
import citlab.model.citL.CitModel;



import citlab.model.test.ModelsFromFilesUtils;
import citlab.model.test.ModelsFromStringsTester;

public class SimplifierTest {

	@Test
	public void testSimplify() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Boolean a; Boolean b; Boolean c; Boolean d; end\n");
		model.append("Constraints:	# a == true# # a == true => b == true # end");
		CitModel m = ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull(m);
		assertEquals(4,m.getParameters().size());
		assertEquals(2,m.getConstraints().size());
		Injector injector = new CitLInjectorProvider().getInjector();
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		System.out.println(SERIALIZER.serialize(m));
		CitModel m2 = new Simplificator(m).getSimplifiedVersion();
		System.out.println(SERIALIZER.serialize(m2));
		assertEquals(2,m2.getParameters().size());
	}

	@Test
	public void testSimplifyProcessorComm2() throws IOException {
		Logger.getLogger(ParameterSimplifier.class).setLevel(Level.DEBUG);
		CitModel model = ModelsFromFilesUtils.getBenchmark("ProcessorComm2.citl",true);
		CitModel m2 = new Simplificator(model).getSimplifiedVersion();			
	}

	
	@Test
	public void testSimplifyBenchmarks() throws IOException {
		Iterator<CitModel> models = ModelsFromFilesUtils.getBenchmarks(true);
		while(models.hasNext()){
			CitModel m = models.next();
			try{
				CitModel m2 = new Simplificator(m).getSimplifiedVersion();			
				if (m.getParameters().size() > m2.getParameters().size())
					System.out.println("model parameters " + m.getName());
				if (m.getConstraints().size() > m2.getConstraints().size())
					System.out.println("model constraints " + m.getName());
			}catch(Exception e){
				System.out.println(e.getMessage() + " in "+ m.getName());
			}
		}
	}
}
