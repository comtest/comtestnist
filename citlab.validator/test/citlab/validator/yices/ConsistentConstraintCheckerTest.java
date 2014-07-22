package citlab.validator.yices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;

import com.sun.jna.Pointer;

public class ConsistentConstraintCheckerTest {

	private static final String MODELSFORTESTS_VALIDATION = "modelsfortests/";
	private static   YicesLibrary yices = YicesLibrary.INSTANCE;
	private Pointer ctx = yices.yices_mk_context();

	@Test
	public void testBoolandEnum() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/mix1.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testDefaultModel() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/phone.citl");
		assertNotNull(model);
	  
		if(new ConstraintChecker().checkConsistency(model, true)); 
		System.out.println(new ConstraintChecker().findMaxConstraintsSet(model, true));
	}

	@Test
	public void testModelAddition() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/phone2.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testModelNumbers2() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/numbers2.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testModelNumbers() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/numbers.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testModelPhone3() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/phone3.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testModelRange() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/range.citl");
		assertNotNull(model);
		assertTrue(new ConstraintChecker().checkConsistency(model, true));
	}

	@Test
	public void testAllModels() throws IOException {
		Iterator<CitModel> models = ModelsFromFilesUtils.getBenchmarks(true);
		while (models.hasNext()) {
			CitModel cm = models.next();
			assertNotNull(cm);
			System.out.println(cm.getName());
			assertTrue(new ConstraintChecker().checkConsistency(cm, true));
			
			
		}
	}
	@Test
	public void testAllSPLModels() throws IOException {
		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks(false);
		while (models.hasNext()) {
			CitModel cm = models.next();
			assertNotNull(cm);
			System.out.println(cm.getName());
			assertTrue(new ConstraintChecker().checkConsistency(cm, true));
			
			
		}
	}

}
