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
package citlab.importer.featureide;

import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;

import citlab.core.ext.NotImportableException;
import citlab.model.CitLStandaloneSetup;
import citlab.model.citL.CitModel;
import citlab.model.util.CombinationCounter;

import com.google.inject.Injector;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
/**
 * 
 * test of the importer from feature IDE (not simplifier) 
 *
 */
public class FeatureIdeModelImporterTest {

	public static final String FI_MODELS_DIR = "models/featureide/";

	@Test
	public void readCellPhone() throws FileNotFoundException,
			UnsupportedModelException {
		CitModel cellPhone = readModel(FI_MODELS_DIR +"cellphone_15.xml");
		int count = CombinationCounter.count(cellPhone);
		System.out.println(count);

	}

	@Test
	public void readConnector() throws FileNotFoundException,
			UnsupportedModelException {
		CitModel cellPhone = readModel(FI_MODELS_DIR +"connector_fm.xml");
		int count = CombinationCounter.count(cellPhone);
		System.out.println(count);
		System.out.println(modelToStringSerializer(cellPhone));
		Assert.assertEquals(18, count);

	}

	@Test
	public void readConnectorSimple() throws FileNotFoundException,
			UnsupportedModelException {
		CitModel connector = FeatureIdeModelImporterTest.readModel(FI_MODELS_DIR +"connector_fm_sim.xml");
		int count = CombinationCounter.count(connector);
		System.out.println(count);
		System.out.println(FeatureIdeModelImporterTest.modelToStringSerializer(connector));
		Assert.assertEquals(4, count);
	}

	@Test
	public void readModel_Alt_Alt() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, a1!= NONE =>model = a1]
		readModel(FI_MODELS_DIR +"model_Alt_Alt.xml");
	}

	@Test
	public void readModel_Alt_Or() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, model = a1 => OR a11 OR a12, a11 = true => model =
		// a1, a12 = true => model = a1]
		readModel(FI_MODELS_DIR +"model_Alt_Or.xml");
	}

	@Test
	public void readModel_Alt_Root() throws FileNotFoundException,
			UnsupportedModelException {
		// root is an alternative
		// [model != NONE]
		readModel(FI_MODELS_DIR +"model1.xml");
	}

	@Test
	public void readModel_Alt_SubRoot() throws FileNotFoundException,
			UnsupportedModelException {
		// [model = true, A != NONE IFF model = true, B != NONE IFF model =
		// true]
		readModel(FI_MODELS_DIR +"model2.xml");
	}

	@Test
	public void readModel_Alt_SubRoot2() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, B = true IFF model = a1, C = true => model = a2]
		readModel(FI_MODELS_DIR +"model_Alt_sub1.xml");
	}

	@Test
	public void readModel_Man2() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, model = a1 => OR a11 OR a12, a11 = true => model =
		// a1, a12 = true => model = a1]
		readModel(FI_MODELS_DIR +"model_Man_Man.xml");
	}
	@Test
	public void readModel_Or_Alt() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, model = a1 => OR a11 OR a12, a11 = true => model =
		// a1, a12 = true => model = a1]
		readModel(FI_MODELS_DIR +"model_Or_Alt.xml");
	}
	@Test
	public void readModel_Or_Or() throws FileNotFoundException,
			UnsupportedModelException {
		// [model != NONE, model = a1 => OR a11 OR a12, a11 = true => model =
		// a1, a12 = true => model = a1]
		readModel(FI_MODELS_DIR +"model_Or_Or.xml");
	}

	

	@Test
	public void readModel_OR_Root() throws FileNotFoundException,
			UnsupportedModelException {
		// [model = true, model = true => OR a1 OR a2 OR a3 OR a4,
		// a1 = true => model = true, a2 = true => model = true, a3 = true =>
		// model = true, a4 = true => model = true]
		readModel(FI_MODELS_DIR +"model3_OR.xml");
	}

	@Test
	public void readSmartHome() throws FileNotFoundException,
			UnsupportedModelException {
		CitModel cellPhone = readModel(FI_MODELS_DIR +"smart_phone.xml");
		// TOOMANY
		//int count = CombinationCounter.count(cellPhone);
		//System.out.println(count);

	}

	
	/** returns the citmodel as String
	 * 
	 * @param result
	 * @return
	 */
	public static String modelToStringSerializer(CitModel result) {
		CitLStandaloneSetup citLStandaloneSetup = new CitLStandaloneSetup();
		Injector injector = citLStandaloneSetup
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		// create temp resource
		Resource resource = resourceSet.createResource(URI.createFileURI("temp.citl"));
		resource.getContents().add(result);
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		IResourceValidator validator = injector
				.getInstance(IResourceValidator.class);
		List<Issue> list = validator.validate(resource, CheckMode.ALL,CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return new String("error");
		}else
		return SERIALIZER.serialize(result);
	}
	public static String modelToStringSerializer(CitModel result,String name) {
		CitLStandaloneSetup citLStandaloneSetup = new CitLStandaloneSetup();
		Injector injector = citLStandaloneSetup
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		// create temp resource
		Resource resource = resourceSet.createResource(URI.createFileURI("name.citl"));
		resource.getContents().add(result);
		Serializer SERIALIZER = injector.getInstance(Serializer.class);
		IResourceValidator validator = injector
				.getInstance(IResourceValidator.class);
		List<Issue> list = validator.validate(resource, CheckMode.ALL,CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return new String("error");
		}else
		return SERIALIZER.serialize(result);
	}   
	/**
	 * read the feature ide model
	 * 
	 * @param modelPath
	 *            path
	 * @return
	 * @throws FileNotFoundException
	 * @throws UnsupportedModelException
	 */
	static public CitModel readModel(String modelPath)
			throws FileNotFoundException, UnsupportedModelException {

		FeatureIdeImporterMultipleLevels importer = new XmlFeatureModelImporter();
		CitModel result;
		try {
			result = importer.importModel(modelPath);
			return result;
		} catch (NotImportableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
