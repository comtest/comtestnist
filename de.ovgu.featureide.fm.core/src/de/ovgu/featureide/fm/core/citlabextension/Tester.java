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

import java.io.File;
import java.io.FileNotFoundException;

import citlab.model.citL.CitModel;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelReader;

/**
 * TODO description
 * 
 * @author waymantan
 */
public class Tester {
	public static void main(String[] args) throws UnconvertibleModelException {
		System.out.println("testing");
		FeatureModel featureModel = new FeatureModel();
		File file = new File("/Users/waymantan/Desktop/testtree.xml");
		XmlClassificationTreeModelReader reader = new XmlClassificationTreeModelReader(featureModel);
		try {
			reader.readFromFile(file);
			System.out.println("Model read!");
			CitLabModelConverter citLabConverter = new CitLabModelConverter();	
			CitModel citModel = citLabConverter.convertModel(featureModel);
			System.out.println("Model converted!");		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
