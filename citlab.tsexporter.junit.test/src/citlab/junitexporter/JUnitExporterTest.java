/**
 * 
 */
package citlab.junitexporter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	private String templateName;
	private String templateSuffix;
	private String testSuiteSuffix;
	
	@Before
	public void createTestData() {
		TestsuiteFactory tsFact = TestsuiteFactory.eINSTANCE;
		testSuite = tsFact.createTestSuite();
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
		templateName = "TestExporter";
		templateSuffix = ".java";
		testSuiteSuffix = ".csv";
	}

	/**
	 * Test method for {@link citlab.junitexporter.JUnitExporter#generateOutput(citlab.testsuite.TestSuite, java.lang.String)}.
	 * @throws IOException When temporary file can not be created
	 */
	@Test
	public void testGenerateOutput() throws IOException {
		JUnitExporter junitExporter = new JUnitExporter();
		String templatePrefix = tmpDir.newFolder("test").getPath()
				+ "/" + templateName;
		junitExporter.generateOutput(
				testSuite,
				templatePrefix + templateSuffix);
		assertTrue(Files.exists(Paths.get(templatePrefix + templateSuffix)));
		assertTrue(Files.exists(Paths.get(templatePrefix + testSuiteSuffix)));
	}

	@After
	public void cleanUp() {
		testSuite = null; //not necessary
	}
}
