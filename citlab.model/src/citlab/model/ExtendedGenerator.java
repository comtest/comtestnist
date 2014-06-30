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
package citlab.model;

import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class ExtendedGenerator extends Generator {
	
	public ExtendedGenerator() {
		new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextRuntimeModule() {
					@Override
					public Class<? extends IXtext2EcorePostProcessor> bindIXtext2EcorePostProcessor() {
						return null; //CitLPostProcessor.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}

}
