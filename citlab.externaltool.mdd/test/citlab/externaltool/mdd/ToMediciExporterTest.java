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

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import com.google.common.io.Files;

import citlab.core.ext.CitLabException;
import citlab.core.ext.NotConvertableModel;
import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;

public class ToMediciExporterTest {

	@Test
	public void exportAllBenchmarks() throws IOException {

		Iterator<CitModel> models = ModelsFromFilesUtils.getBenchmarks(true);

		while (models.hasNext()) {
			CitModel citModel = (CitModel) models.next();
			//
			ToMediciExporter exp = new ToMediciExporter();
			try{ 
				StringBuffer result = exp.convertToStringBuffer(citModel, true, 2);
				writeToFile("examples/" + citModel.getName() + ".medici", result);
			}catch(Throwable t){
				System.err.println(citModel.getName() + " not translated because :");
				t.printStackTrace();
			}

		}

	}

	public static void writeToFile(String pFilename, StringBuffer pData)
			throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(pFilename));
		out.write(pData.toString());
		out.flush();
		out.close();
	}
	
	@Test
	public void exportStorage3() throws IOException, NotConvertableModel {
		CitModel model = ModelsFromFilesUtils.getBenchmark("Storage3.citl",true);
		ToMediciExporter exp = new ToMediciExporter();
		StringBuffer result = exp.convertToStringBuffer(model, true, 2);
	}
	
	@Test
	public void exportSmartHome() throws IOException, CitLabException {
		CitModel model = ModelsFromFilesUtils.getTestModel("examples/fromSPL","SmartHome.citl");
		ToMediciExporter exp = new ToMediciExporter();
		StringBuffer result = exp.convertToStringBuffer(model, true, 2);
		System.out.println(result);
	} 
	
	@Test
	public void testPhone() throws IOException{
		// get a model
		CitModel model = ModelsFromFilesUtils.getBenchmark("phone.citl", true);
		ToMediciExporter exp = new ToMediciExporter();
		try {
			exp.convertToStringBuffer(model, true, 2);
		} catch (NotConvertableModel ce) {
			// ok, phone is not convertable
			// check the constraints
			System.out.println("OK " + ce.getMessage());
			return;
		}
		fail();
	}

	@Test
	public void testBool1() throws IOException{
		// get a model
		CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests/correct", "bool1.citl");
		ToMediciExporter exp = new ToMediciExporter();
		StringBuffer sb = exp.convertToStringBuffer(model, true, 2);
		System.out.println(sb.toString());
	}

	
	@Test
	public void testBBS() throws IOException{
		// get a model
		CitModel model = ModelsFromFilesUtils.getTestModel("modelsfortests/correct","bbs.citl");
		ToMediciExporter exp = new ToMediciExporter();
		StringBuffer sb = exp.convertToStringBuffer(model, true, 2);
		System.out.println(sb.toString());
	}

	
	@Test
	public void testPhoneTofile() throws IOException{
		// get a model
		CitModel model = ModelsFromFilesUtils.getBenchmark("phone.citl", true);
		ToMediciExporter exp = new ToMediciExporter();
		try {
			//create a directory file
	    	File temp = Files.createTempDir();
	    	temp.deleteOnExit();
	    	assertTrue(temp.exists() && temp.isDirectory());
			exp.convertModel(model, true, 2,temp.getAbsolutePath());
		} catch (NotConvertableModel ce) {
			// ok, phone is not convertable
			// check the constraints
			System.out.println("OK " + ce.getMessage());
			return;
		}
		fail();
	}

	
}
