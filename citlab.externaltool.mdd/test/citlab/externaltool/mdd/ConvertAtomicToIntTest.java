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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;

import citlab.core.util.ConvertAtomicToSignedInt;
import citlab.core.util.IndexOutOfBoundException;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.test.ModelsFromFilesUtils;

public class ConvertAtomicToIntTest {
	
	@Test
	public void testConvertEx1() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests/correct", "enum1.citl"); 
		assertNotNull(model);
		ConvertAtomicToSignedInt c = new ConvertAtomicToSignedInt(model);
		assertEquals("A,a1",toString(c.convertInt(0)));
		assertEquals("A,a2",toString(c.convertInt(1)));
		assertEquals("A,a3",toString(c.convertInt(2)));
		assertEquals("B,b1",toString(c.convertInt(3)));
		assertEquals("B,b2",toString(c.convertInt(4)));
		assertEquals("B,b3",toString(c.convertInt(5)));
		try{
			c.convertInt(6);
			fail();
		} catch(IndexOutOfBoundException e){
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testConvertEx2() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests/correct", "enumwt1.citl"); 
		assertNotNull(model);
		ConvertAtomicToSignedInt c = new ConvertAtomicToSignedInt(model);
		assertEquals("A,a1",toString(c.convertInt(0)));
		assertEquals("A,a2",toString(c.convertInt(1)));
		assertEquals("B,a1",toString(c.convertInt(2)));
		assertEquals("B,a2",toString(c.convertInt(3)));
		try{
			c.convertInt(4);
			fail();
		} catch(IndexOutOfBoundException e){
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testConvertSpinverifier() throws IOException {
		CitModel model = ModelsFromFilesUtils.getBenchmark("spin_verifier.citl",true);
		ConvertAtomicToSignedInt c = new ConvertAtomicToSignedInt(model);
		try{
			c.convertInt(135);
			fail();
		} catch(IndexOutOfBoundException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testConvertMx1() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests\\correct", "mix1.citl"); 
		assertNotNull(model);
		ConvertAtomicToSignedInt c = new ConvertAtomicToSignedInt(model);
		assertEquals("A,a1",toString(c.convertInt(0)));
		assertEquals("A,a2",toString(c.convertInt(1)));
		assertEquals("B,b1",toString(c.convertInt(2)));
		assertEquals("B,b2",toString(c.convertInt(3)));
		assertEquals("C,false",toString(c.convertInt(4)));
		assertEquals("C,true",toString(c.convertInt(5)));
		assertEquals("D,false",toString(c.convertInt(6)));
		assertEquals("D,true",toString(c.convertInt(7)));
		try{
			c.convertInt(8);
			fail();
		} catch(IndexOutOfBoundException e){
			System.out.println(e.getMessage());
		}
	}

	
	private String toString(Pair<Parameter, String> convertInt) {
		return convertInt.getKey().getName()+"," + convertInt.getValue().toString();
	}

}
