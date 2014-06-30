package citlab.validator.vacuity;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import citlab.model.citL.CitModel;
import citlab.model.test.ModelsFromFilesUtils;

public class VacuousRuleFinderTest {

	private static final String MODELSFORTESTS_VALIDATION = "modelsfortests/";

	@BeforeClass
	public static void initLogger() {
		// Logger.getLogger("citlab.validator").setLevel(Level.DEBUG);
		Logger.getLogger(VacuousRuleFinder.class).setLevel(Level.OFF);
	}

	@Test
	public void testPhone() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "correct/phone.citl");
		assertNotNull(model);

		VacuousRuleFinder vc = new VacuousRuleFinder();
		vc.getVacuousRules(model);
	}

	@Test
	public void testVacuous1() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "validation/vacuous1.citl");
		assertNotNull(model);
		VacuousRuleFinder vc = new VacuousRuleFinder();
		vc.getVacuousRules(model);
	}

	@Test
	public void testVacuous2() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "validation/vacuous2.citl");
		assertNotNull(model);
		VacuousRuleFinder vc = new VacuousRuleFinder();
		vc.getVacuousRules(model);
	}

	@Test
	public void testVacuous3() throws IOException {
		CitModel model = ModelsFromFilesUtils.getTestModel(
				MODELSFORTESTS_VALIDATION, "validation/vacuous3.citl");
		assertNotNull(model);
		VacuousRuleFinder vc = new VacuousRuleFinder();
		vc.getVacuousRules(model);
	}

	@Test
	public void testAllModels() throws IOException {
		Iterator<CitModel> models = ModelsFromFilesUtils.getSPLBenchmarks(false);
		int modelsWithVC = 0;
		int totalVCs = 0;
		int partiallyVcs=0;
		while (models.hasNext()) {
			CitModel cm = models.next();
			assertNotNull(cm);
			// System.out.println(cm.getName());
			VacuousRuleFinder vc = new VacuousRuleFinder();
			int partiallyvacuous = vc.getVacuousRules(cm).getFirst().size();
			int totallyvacous= vc.getVacuousRules(cm).getSecond().size();
			if (partiallyvacuous > 0 || (partiallyvacuous ==0 && totallyvacous!=0)) {
				modelsWithVC++;
				totalVCs += totallyvacous;
				partiallyVcs +=partiallyvacuous;
				System.out.println(cm.getName() + ", " + partiallyvacuous + ", " + totallyvacous+", "+cm.getConstraints().size());
			}

		}
		System.out.println("Models with vacuous constraints: " + modelsWithVC);
		System.out.println("Totally vacuous constraints: " + totalVCs);
		System.out.println("Partially vacuous constraints: " + partiallyVcs);

	}

}
