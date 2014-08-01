/**
 * 
 */
package citlab.junitexporter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import citlab.model.citL.CitLFactory;
import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;

/**
 * @author sudhi
 *
 */
public class JUnitExporterTest {

	@Rule
	public TemporaryFolder tmpDir = new TemporaryFolder();

	private TestSuite testSuite;
	private String testSuiteName;
	
	@Before
	public void createTestData() {
		testSuite = createTestSuite();
		testSuiteName = "param42.csv";
	}

	private TestSuite createTestSuite() {
		TestsuiteFactory tsFact = TestsuiteFactory.eINSTANCE;
		TestSuite testSuite = tsFact.createTestSuite();
		assertNotNull(testSuite);

		citlab.testsuite.Test testCase = tsFact.createTest();
		//create 7 assignements each with 4 params
		for(int i = 0; i < 7; i++) {
			
			Assignment assignment = tsFact.createAssignment();
			assertNotNull(assignment);

			for(int j = 0; j < 4; j++) {
				
				Parameter parameter = CitLFactory.eINSTANCE.createParameter();
				parameter.setName("param" + j);
				assertNotNull(parameter);

				assignment.setParameter(parameter);
				assignment.setValue("val" + j);
			}
			testCase.getAssignments().add(assignment);
		}
		testSuite.getTests().add(testCase);
		return testSuite;
	}

	/**
	 * Test method for {@link citlab.junitexporter.JUnitExporter#generateOutput(citlab.testsuite.TestSuite, java.lang.String)}.
	 * This method tests if a new csv file is created when one does not exists.
	 * @throws IOException When temporary file can not be created
	 */
	@Test
	public void testGenerateOutput() throws IOException {
		JUnitExporter junitExporter = new JUnitExporter();
		String testSuiteFileName = tmpDir.newFolder("test").getPath() + "/" + testSuiteName;
		//assert that file does not exists before
		assertTrue(! Files.exists(Paths.get(testSuiteFileName)));
		//then call the generateOutput method
		junitExporter.generateOutput(testSuite, testSuiteFileName);
		//and assert that the testSuite is exported
		assertTrue(Files.exists(Paths.get(testSuiteFileName)));
	}

	@After
	public void cleanUp() {
		testSuite = null; //not necessary
	}
}
