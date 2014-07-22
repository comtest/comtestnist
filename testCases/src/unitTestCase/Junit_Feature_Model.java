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
package unitTestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;

/**
 * TODO description
 * 
 * @author Douglas Rew
 */
public class Junit_Feature_Model {

	@Test
	public void test_Feature_Model_Root_Creation() {
	
		System.out.println("Unit Test : test_Feature_Model_Root_Creation");
		
		FeatureModel featureModel = new FeatureModel();
		assertNull(featureModel.getRoot());
		featureModel.createDefaultValues("Testing");
		
		Feature root = featureModel.getRoot();
		assertNotNull(root);
		assertEquals("Testing",root.getName());	 
		assertEquals(1, featureModel.getFeatureTable().size());

	}
	

}
