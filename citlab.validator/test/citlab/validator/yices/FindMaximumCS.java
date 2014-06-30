package citlab.validator.yices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;

public class FindMaximumCS {

	private static final String MODELSFORTESTS_VALIDATION = "modelsfortests/";

	@BeforeClass
	public static void initLogger(){
		Logger.getLogger(ConstraintChecker.class).setLevel(Level.DEBUG);
	}
	
	
	// adding an infeasible constraint
	@Test
	public void testOne() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/one.citl");
		assertNotNull(model);

		assertTrue(new ConstraintChecker().findMaxConstraintsSet(model, true)
				.size() == 4);
	}

	// the model is feasible
	@Test
	public void testTwo() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/two.citl");
		assertNotNull(model);

		assertTrue(new ConstraintChecker().findMaxConstraintsSet(model, true)
				.size() == 4);
	}

	// the model is infeasible 3 constraints
	@Test
	public void testThree() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/three.citl");
		assertNotNull(model);

		int n = (new ConstraintChecker().findMaxConstraintsSet(model, true)
				.size());

		System.out.println(n);

		assertTrue(n == 3);
	}

	// the model is infeasible 4 constraints
	@Test
	public void testFour() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/four.citl");
		assertNotNull(model);

		int n = (new ConstraintChecker().findMaxConstraintsSet(model, true)
				.size());

		System.out.println(n);

		assertTrue(n == 4);
	}

	// the model is infeasible 4 constraints
	@Test
	public void testFive() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/five.citl");
		assertNotNull(model);

		int n = (new ConstraintChecker().findMaxConstraintsSet(model, true)
				.size());

		System.out.println(n);

		assertTrue(n == 4);
	}

	// the model is totally infeasible
	@Test
	public void testSix() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/six.citl");
		assertNotNull(model);

		assertNull(new ConstraintChecker().findMaxConstraintsSet(model, true));
	}

}
