package citlab.validator.yices;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.simplifier.Simplificator;
import citlab.model.test.ModelsFromFilesUtils;

public class InfeasibleAssignmentfinderTest {

	private static final String MODELSFORTESTS_VALIDATION = "modelsfortests/";

	@BeforeClass
	public static void initLogger() {
		Logger.getLogger(ConstraintChecker.class).setLevel(Level.OFF);
	}

	@Test
	public void testTwoElementInfeasible() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "maximumset/two.citl");
		assertNotNull(model);

		InfeasibleAssignmentfinder inf = new InfeasibleAssignmentfinder();
		inf.getInfeasibleAssignment(model);
	}

	@Test
	public void testAllModels() throws IOException {
		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks(false);
		int n = 0;
		int counter = 0;
		while (models.hasNext()) {
			CitModel cm = models.next();
			//Simplificator simpl = new Simplificator(cm);
			//cm= simpl.getSimplifiedVersion();
			assertNotNull(cm);
			// System.out.println(cm.getName());
			InfeasibleAssignmentfinder inf = new InfeasibleAssignmentfinder();
			n = inf.getInfeasibleAssignment(cm).getSecond();
			if (n > 0) {
				counter = counter + 1;
				System.out.println(cm.getName() + "  "+inf.getInfeasibleAssignment(cm).getFirst()+" tot: " + n);
			}
			
		}
		 System.out.println("****************  "+ counter);
	}

//	@Test
//	public void testAllModelsWSimplifier() throws IOException {
//		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks();
//		while (models.hasNext()) {
//			CitModel cm = models.next();
//			assertNotNull(cm);
//			System.out.println(cm.getName());
//			Simplificator simpl = new Simplificator(cm);
//			CitModel cms = simpl.getSimplifiedVersion();
//			InfeasibleAssignmentfinder inf = new InfeasibleAssignmentfinder();
//			inf.getInfeasibleAssignment(cms);
//			System.out.println("****************");
//		}
//	}

}
