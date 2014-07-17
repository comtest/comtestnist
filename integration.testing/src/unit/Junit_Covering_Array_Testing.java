package unit;

import static org.junit.Assert.*;

import org.junit.Test;

import citlab.core.ui.views.generator.TestSuiteView;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;

public class Junit_Covering_Array_Testing {

	@Test
	public void testAddExpectedValueColumn() {
		
		TestSuite mock_test_suite = TestsuiteFactory.eINSTANCE.createTestSuite();
		assertNotNull(mock_test_suite);
		
		
		Assignment assignment = TestsuiteFactory.eINSTANCE
				.createAssignment();
		assertNotNull(assignment);
		
		Parameter parameter = CitLFactory.eINSTANCE.createParameter();
		parameter.setName("Mock_testing");
		assertNotNull(parameter);
		
		assignment.setParameter(parameter);
		assignment.setValue("*");
		
		citlab.testsuite.Test mock_test = TestsuiteFactory.eINSTANCE.createTest();
		mock_test.getAssignments().add(assignment);
		mock_test_suite.getTests().add(mock_test);
		
		
		System.out.println(mock_test_suite.toString());
		
		TestSuiteView view  = new TestSuiteView();
		TestSuite after = view.add_in_expected_value_col(mock_test_suite);
		

		for(int i = 0; i < after.getTests().get(0).getAssignments().size(); i++){
			Assignment temp_assignemnt = after.getTests().get(0).getAssignments().get(i);
			System.out.println(temp_assignemnt.getParameter().getName());
		}
		citlab.testsuite.Test temp_test = after.getTests().get(0);
			
			
		assertEquals(2, temp_test.getAssignments().size());
		
		
		
	}
}
