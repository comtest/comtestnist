package citlab.testsuite.util;

import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;

// prints as string the test suite
public class TestSuiteWriter extends TestsuiteSwitch<StringBuffer> {

	@Override
	public StringBuffer caseTestSuite(TestSuite tests) {
		StringBuffer result = new StringBuffer();
		for (citlab.testsuite.Test t : tests.getTests()) {
			for (Assignment a : t.getAssignments()) {
				result.append(a.getValue()).append('\t');
			}
			result.append('\n');

		}
		return result;
	}

}
