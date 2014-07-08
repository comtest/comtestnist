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
package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelReader;
import de.ovgu.featureide.fm.core.io.xml.XmlClassificationTreeModelWriter;

/**
 * TODO description
 * 
 * @author Douglas Rew
 */
public class Junit_Feature_Model_IO {

	// TODO : dkrew : need to work on this
	@Test
	public void test_Feature_Model_Root_IO() throws FileNotFoundException, UnsupportedModelException {
	
		System.out.println("Unit Test : test_Feature_Model_Root_IO");
		
		FeatureModel featureModel = new FeatureModel();
		assertNull(featureModel.getRoot());
		featureModel.createDefaultValues("Testing_For_IO");
		
		Feature root = featureModel.getRoot();
		assertNotNull(root);
		assertEquals("Testing_For_IO",root.getName());	 
		assertEquals(1, featureModel.getFeatureTable().size());
		

		
		// Following the REDO logic from the operator
		Feature newFeature = new ClassificationFeature(featureModel, "Testing_Classification_Node");
		featureModel.addFeature(newFeature);
		Feature feature = featureModel.getFeature(root.getName());
		feature.addChild(newFeature);
		
		XmlClassificationTreeModelWriter writer = new XmlClassificationTreeModelWriter(featureModel);
		
		// Creating file for testing
		File file = new File("testing.file");
		writer.writeToFile(file);


		// Using a new feature model
		FeatureModel featureModel_Read = new FeatureModel();
		XmlClassificationTreeModelReader reader = new XmlClassificationTreeModelReader(featureModel_Read);
		reader.readFromFile(file);
		
		//System.out.println(featureModel_Read.toString());
//		System.out.println(featureModel_Read.getFeatureNames());
	
		Feature root_from_read = featureModel_Read.getFeature("Testing_For_IO");
		assertNotNull(root_from_read);
		
		Feature classification_node_from_read = featureModel_Read.getFeature("Testing_Classification_Node");
		assertNotNull(classification_node_from_read);
		
		
		
		
		// Cleaning up the file for testing
		file.delete();
		
		
		

	}

}
