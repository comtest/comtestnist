/**
 * 
 */
package integration.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;

/**
 * @author Douglas Rew
 *
 */
public class Junit_Happy_Path {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Happy_Path() {
		
		System.out.println("Integration Test : test_Happy Path");
		
		FeatureModel featureModel = new FeatureModel();
		assertNull(featureModel.getRoot());
		featureModel.createDefaultValues("Testing");
		
		Feature root = featureModel.getRoot();
		assertNotNull(root);
		assertEquals("Testing",root.getName());	 
		assertEquals(1, featureModel.getFeatureTable().size());
		
		// converting to classification to CITLAB should be here.
		
		// Starting from the citlab
		
		
		

	}

}
