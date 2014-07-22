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
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;

import citlab.model.CitLStandaloneSetup;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Range;

import com.google.inject.Injector;

public class ModelsFromStringsTester {

	@Test
	public void test1() {
		CitModel m = loadModel("Model test");
		assertEquals("test", m.getName());
	}

	@Test(expected=Exception.class)
	public void testError1() {
		loadModel("Modellll test");
	}

	@Test
	public void testRange() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Range textLines [ 25 .. 30 ]; end");
		CitModel m = loadModel(model.toString());
		assertNotNull(m);
		assertEquals(1,m.getParameters().size());
		Range r = (Range) m.getParameters().get(0);
	//	assertEquals(25,r.getBegin());
	//	assertEquals(30,r.getEnd());
	}

	@Test
	public void testNumInEnum() {
		StringBuffer model = new StringBuffer("Model test\n");
		model.append("Parameters:	Enumerative display { ON OFF \"200\" }; end");
		CitModel m = loadModel(model.toString());
		assertNotNull(m);
		assertEquals(1,m.getParameters().size());
		Enumerative r = (Enumerative) m.getParameters().get(0);
		EList<Element> elements = ModelUtils.getEnumerativeType(r).getElements();
		assertEquals(3,elements.size());
		assertEquals("\"200\"", elements.get(2).getName());
	}

	
	
	
	// the string contains the model itself
	static public CitModel loadModel(String model) {
		Injector injector = new CitLStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.citl"));
		InputStream in = new ByteArrayInputStream(model.getBytes());
		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return (CitModel) resource.getContents().get(0);
	}	
	
}
