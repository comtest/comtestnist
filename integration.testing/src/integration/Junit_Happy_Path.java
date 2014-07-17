/**
 * 
 */
package integration;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import citlab.acts.IpoGGenerator;
import citlab.acts.TSGeneratorByACTS;
import citlab.core.ui.views.generator.TestSuiteView;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.test.ModelsFromFilesUtils;
import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
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
	public void test_Happy_Path() throws IOException {
		
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
		
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel mobile_phone = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",true);
		@SuppressWarnings("unused")
		TestSuite ts = trans.generateTestsAndInfo(mobile_phone, true, true, true, 2);
		
		TestSuiteView view  = new TestSuiteView();
		TestSuite after = view.add_in_expected_value_col(ts);
		

		for(int i = 0; i < after.getTests().get(0).getAssignments().size(); i++){
			Assignment temp_assignemnt = after.getTests().get(0).getAssignments().get(i);
			System.out.println(temp_assignemnt.getParameter().getName());
		}
		citlab.testsuite.Test temp_test = after.getTests().get(0);
			
			
		assertEquals(2, temp_test.getAssignments().size());

		
		
		

	}

	
	@Test
	public void test() throws IOException{
		
		TSGeneratorByACTS trans = new IpoGGenerator();
		CitModel mobile_phone = ModelsFromFilesUtils.getBenchmark("mobile_phone.citl",true);
		@SuppressWarnings("unused")
		TestSuite ts = trans.generateTestsAndInfo(mobile_phone, true, true, true, 2);
		
	}
}
