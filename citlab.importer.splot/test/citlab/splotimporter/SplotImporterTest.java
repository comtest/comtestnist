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
package citlab.splotimporter;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

import com.google.inject.Injector;

import splar.core.fm.FeatureModelException;
import citlab.core.ext.NotImportableException;
import citlab.model.CitLStandaloneSetup;
import citlab.model.citL.CitModel;

public class SplotImporterTest {

	@Test
	public void testImportModel() throws NotImportableException, FeatureModelException {
		SplotImporter splotimport = new SplotImporter();
		CitModel m = splotimport.importModel("models/model.xml");
		System.out.println(modelToStringSerializer(m));
	}

	@Test
	public void testImportModel1() throws NotImportableException, FeatureModelException {
		SplotImporter splotimport = new SplotImporter();
		CitModel m = splotimport.importModel("models/model1.xml");
		System.out.println(modelToStringSerializer(m));
	}

	@Test
	public void testImportModelAIR() throws NotImportableException, FeatureModelException {
		SplotImporter splotimport = new SplotImporter();
		CitModel m = splotimport.importModel("models/aircraft_fm.xml");
		System.out.println(modelToStringSerializer(m));
	}

	
	
	/** returns the citmodel as String
	 * 
	 * @param result
	 * @return
	 */
	public static String modelToStringSerializer(CitModel result) {
		CitLStandaloneSetup citLStandaloneSetup = new CitLStandaloneSetup();
		Injector injector = citLStandaloneSetup.createInjectorAndDoEMFRegistration();
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
			return null;
		}
		return SERIALIZER.serialize(result);
	}

}
