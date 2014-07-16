/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2013  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.fm.core.citlabextension;

import java.text.Normalizer;

import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.impl.CitLPackageImpl;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;

/**
 * TODO description
 * 
 * @author Wayman Tan
 */
public class CitLabModelConverter {
	
	public CitModel importModel(FeatureModel fm) throws UnconvertibleModelException {
		// validate to ensure the model is ready for conversion
		validateModel(fm);
		
		CitLPackageImpl.init();
		CitModel result = CitLFactory.eINSTANCE.createCitModel();		
		Feature root = fm.getRoot();		
		result.setName(normalize(root.getName()));
		
		// add parameters 
		addParameterFor(fm, result);
		// add the constraints
		addConstraints(fm, result);
		
		return result;		
	}
	
	public void validateModel(FeatureModel featureModel) throws UnconvertibleModelException {
		
	}
	
	
	private String normalize(String x) {
		return Normalizer.normalize(x,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(",", "y");
	}

	private void addParameterFor(FeatureModel fm, CitModel result) {
		
	}
	
	private void addConstraints(FeatureModel fm, CitModel result) {
		// TODO by Douglas

	}
}
