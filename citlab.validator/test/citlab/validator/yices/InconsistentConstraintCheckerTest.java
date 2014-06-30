package citlab.validator.yices;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;

import com.sun.jna.Pointer;

public class InconsistentConstraintCheckerTest {

	private static final String MODELSFORTESTS_VALIDATION = "modelsfortests/";
	YicesLibrary yices = YicesLibrary.INSTANCE;
	Pointer ctx = yices.yices_mk_context();	

	@Test
	public void testCheckConsistency() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(MODELSFORTESTS_VALIDATION, "validation/inconsistent1.citl" );
		assertNotNull(model);
		assertFalse(new ConstraintChecker().checkConsistency(model,true));
	}
	@Test
	public void testCheckConsistency2() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(MODELSFORTESTS_VALIDATION, "validation/inconsistent2.citl" );
		assertNotNull(model);
		assertFalse(new ConstraintChecker().checkConsistency(model,true));
	}
}

