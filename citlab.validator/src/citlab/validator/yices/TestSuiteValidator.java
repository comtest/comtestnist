package citlab.validator.yices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import citlab.core.util.ASeedSwitchPair;
import citlab.core.util.ParameterSwitchToPairStrings;
import citlab.model.citL.Aseed;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.Enumerative;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.citL.SeedNumberLiteral;
import citlab.model.citL.impl.CitLPackageImpl;
import citlab.model.util.Utils.Pair;
import citlab.model.validation.RuleEvaluator;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;

import com.sun.jna.Pointer;

public class TestSuiteValidator {

	private static final Logger logger = Logger
			.getLogger(TestSuiteValidator.class);

	private TestSuite testSuite;
	public void setTestsuite(TestSuite testSuite){
		this.testSuite=testSuite;
	}

	class Mycomp implements Comparator<Map<Parameter, ?>> {
        private List<Map<Parameter, String>> listMapReq;
        public void setReq(List<Map<Parameter, String>> listMapReq){
        	this.listMapReq= listMapReq;
        }
        public Mycomp(List<Map<Parameter, String>> listMapReq){
        	this.listMapReq= listMapReq;
        }
		@Override
		public int compare(Map<Parameter, ?> test1, Map<Parameter, ?> test2) {
		//	System.out.println(test1+" \n"+test2);
			Integer size1 = 0, size2 = 0;
			if (!listMapReq.isEmpty()) {
				Iterator<Map<Parameter, String>> iReq = listMapReq.iterator();
				while (iReq.hasNext()) {
					Map<Parameter, ?> actual = iReq.next();

					if (covers(test1, actual)) {
						size1++;
					}
					if (covers(test2, actual)) {
						size2++;
					}

				}

			}
			//System.out.println(size2);
			return size2.compareTo(size1);

		}
	}

	private boolean covers(Map<Parameter, ?> test, Map<Parameter, ?> requirement) {
		int counter = 0;
		for (Parameter p : requirement.keySet()) {
			if (requirement.get(p).equals(test.get(p)))
				counter++;
		}

		return counter == requirement.size();

	}

	public TestSuiteValidator(TestSuite testSuite) {
		this.testSuite = testSuite;
		// TODO Auto-generated constructor stub
	}

	public Boolean checkRuleAndSeed() {
		for (Rule rule : testSuite.getModel().getConstraints()) {
			if (rule.eContainer() instanceof CitModel) {
				for (Seed seed : createListOfSeeds()) {
					RuleEvaluator rl = new RuleEvaluator(seed);
					if (!rl.evaluateRule(rule))
						return false;

				}
			}
		}
		return true;
	}

	public Boolean completenessChecker() {
		YicesLibrary yices = YicesLibrary.INSTANCE;
		Pointer ctx = yices.yices_mk_context();
		Set<Map<Parameter, String>> testSuiteSet = getSeedsMap();
		List<Map<Parameter, String>> listMapReq = getRequirements();
		Iterator<Map<Parameter, String>> iSeed = testSuiteSet.iterator();

		while (iSeed.hasNext()) {
			Map<Parameter, ?> seed = iSeed.next();
			if (!listMapReq.isEmpty()) {
				Iterator<Map<Parameter, String>> iReq = listMapReq.iterator();
				while (iReq.hasNext()) {
					if (covers(seed, iReq.next()))
						iReq.remove();

				}
			}

		}
		Map<String, String> declaredElements = new HashMap<>();

		Map<Parameter, Pointer> variables = new HashMap<Parameter, Pointer>();
		ConstraintChecker.createCtxFromModel(testSuite.getModel(), testSuite
				.getModel().getConstraints(), yices, ctx, declaredElements,
				variables);
		yices.yices_check(ctx);
		yices.yices_display_model(yices.yices_get_model(ctx));

		// add the n-wise tuple to the context
		Iterator<Map<Parameter, String>> i = listMapReq.iterator();
		return checkRequirementsConsistency(yices, ctx, listMapReq,
				declaredElements, variables, i);
	}

	private Boolean checkRequirementsConsistency(YicesLibrary yices,
			Pointer ctx, List<Map<Parameter, String>> listMapReq,
			Map<String, String> declaredElements,
			Map<Parameter, Pointer> variables,
			Iterator<Map<Parameter, String>> i) {
		while (i.hasNext()) {
			Map<Parameter, String> requirement = i.next();
			logger.debug("checking requirment " + requirement);
			if (logger.isDebugEnabled())
				yices.yices_dump_context(ctx);

			yices.yices_push(ctx);
			for (Parameter p : requirement.keySet()) {

				Pointer t = null;
				Pointer varPointer = variables.get(p);
				assert varPointer != null;
				if (p instanceof Enumerative) {
					String elementName = declaredElements.get(requirement
							.get(p).concat(p.getName()));
					assert elementName != null;
					Pointer a1 = yices.yices_parse_expression(ctx, elementName);
					t = yices.yices_mk_eq(ctx, varPointer, a1);

				} else if (p instanceof Numerical) {
					Pointer number = yices.yices_mk_num(ctx,
							Integer.valueOf(requirement.get(p)));
					t = yices.yices_mk_eq(ctx, varPointer, number);

				} else if (p instanceof citlab.model.citL.Boolean) {
					if (requirement.get(p).toLowerCase().equals("true"))
						t = varPointer;
					else
						t = yices.yices_mk_not(ctx, varPointer);
				}
				yices.yices_assert(ctx, t);
				// the context is inconsistent the tuple is unfeasible
				// go to the next one
				if (yices.yices_inconsistent(ctx) != 0) {
					break;
				}

			}
			// if the tuple is feasible, it returns false since the test suite
			// is missing a requirement
			if (yices.yices_check(ctx) == YicesLibrary.lbool.l_true) {
				yices.yices_del_context(ctx);
				return false;
			}

			yices.yices_pop(ctx);
		}
		yices.yices_del_context(ctx);
		return true;
	}

	public List<Map<Parameter, String>> getRequirements() {
		CitModel model = testSuite.getModel();
		Iterator<List<Pair<Parameter, String>>> reqs = ParameterSwitchToPairStrings
				.getTuples(model, testSuite.getStrength());

		List<Map<Parameter, String>> ListMapReq = new ArrayList<Map<Parameter, String>>();
		// Trasformo la lista di liste in una map scindendo i pairelement in key
		// e value
		while (reqs.hasNext()) {
			List<Pair<Parameter, String>> req = reqs.next();
			Map<Parameter, String> map = new HashMap<Parameter, String>();
			for (Pair<Parameter, String> e : req) {
				map.put(e.getFirst(), e.getSecond());

			}
			ListMapReq.add(map);

		}

		return ListMapReq;
	}

	private Set<Map<Parameter, String>> getSeedsMap() {
		Set<Map<Parameter, String>> testSuiteSet = new HashSet<Map<Parameter, String>>();
		ASeedSwitchPair switchS = new ASeedSwitchPair();
		List<Seed> createListOfSeeds = createListOfSeeds();
		assert (createListOfSeeds != null);
		//System.out.println("testsuite size" + createListOfSeeds.size());
		for (Seed test : createListOfSeeds) {
			Map<Parameter, String> map = new HashMap<Parameter, String>();
			for (Aseed assignment : test.getAssigmentSeedList()) {
				Pair<Parameter, String> e = switchS.doSwitch(assignment);
				map.put(e.getFirst(), e.getSecond());
			}
			testSuiteSet.add(map);
		}
		return testSuiteSet;
	}

	private List<Seed> createListOfSeeds() {
		CitLPackageImpl.init();

		List<Seed> seeds = new ArrayList<>();
		for (Test test : testSuite.getTests()) {
			Seed seed = CitLFactory.eINSTANCE.createSeed();
			for (Assignment assignment : test.getAssignments()) {
				if (assignment.getParameter() instanceof Numerical) {
					NumericalSeed numSeed = CitLFactory.eINSTANCE
							.createNumericalSeed();
					numSeed.setLeft((Numerical) assignment.getParameter());
					SeedNumberLiteral literal = CitLFactory.eINSTANCE
							.createSeedNumberLiteral();
					literal.setNumber(Integer.parseInt(assignment.getValue()));
					numSeed.setRight(literal);
					numSeed.setOp("=");
					seed.getAssigmentSeedList().add(numSeed);
				} else if (assignment.getParameter() instanceof citlab.model.citL.Boolean) {
					BoolAssignSeed boolSeed = CitLFactory.eINSTANCE
							.createBoolAssignSeed();
					boolSeed.setLeft((citlab.model.citL.Boolean) assignment
							.getParameter());
					if (assignment.getValue().toLowerCase().equals("true"))
						boolSeed.setRight(BooleanConst.TRUE);
					else
						boolSeed.setRight(BooleanConst.FALSE);
					boolSeed.setOp("=");
					seed.getAssigmentSeedList().add(boolSeed);
				} else if (assignment.getParameter() instanceof citlab.model.citL.Enumerative) {
					EnumSeed enumSeed = CitLFactory.eINSTANCE.createEnumSeed();
					Enumerative parameter = (Enumerative) assignment
							.getParameter();
					enumSeed.setLeft(parameter);
					enumSeed.setOp("=");
					enumSeed.setRight(ModelUtils.getEnumElement(parameter,
							assignment.getValue()));
					seed.getAssigmentSeedList().add(enumSeed);
				}

			}
			seeds.add(seed);
		}

		return seeds;

	}
//It returns a reduced test suite that can be minimal
	public TestSuite reduceSize() {
		ArrayList<Map<Parameter, ?>> testSuiteSet = new ArrayList<Map<Parameter, ?>>();
		testSuiteSet.addAll(getSeedsMap());
		List<Map<Parameter, String>> listMapReq = getRequirements();
		Iterator<Map<Parameter, ?>> iTest = testSuiteSet.iterator();
		Mycomp m = new Mycomp(listMapReq);
		Collections.sort(testSuiteSet, m);
		while (iTest.hasNext()) {
			Map<Parameter, ?> seed = iTest.next();
			int coveredTuples = 0;
			if (!listMapReq.isEmpty()) {
				Iterator<Map<Parameter, String>> iReq = listMapReq.iterator();
				while (iReq.hasNext()) {
					if (covers(seed, iReq.next())) {
						iReq.remove();
						coveredTuples++;
					}

				}
			}
			if (coveredTuples != 0) {
				iTest.remove();
				m.setReq(listMapReq);
				Collections.sort(testSuiteSet, m);
			}
			if (listMapReq.size() <= 0)
				break;
		}
		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(testSuite.getModel());
		result.setGeneratorName(testSuite.getGeneratorName());
		result.setStrength(testSuite.getStrength());
		Set<Map<Parameter, String>> newTestSuite = getSeedsMap();
		newTestSuite.removeAll(testSuiteSet);
		for (Map<Parameter, ?> map : newTestSuite ) {
			Test test = TestsuiteFactory.eINSTANCE.createTest();
			for (Parameter p : map.keySet()) {
				Assignment assignment = TestsuiteFactory.eINSTANCE
						.createAssignment();
				assignment.setParameter(p);
				assignment.setValue((String) map.get(p));
				test.getAssignments().add(assignment);
			}
			result.getTests().add(test);
			}
		return result;
	}

	
	public boolean isMinimal() {

		Set<Map<Parameter, String>> testsSet = getSeedsMap();
		List<Map<Parameter, String>> listMapReq = getRequirements();
		// set of tests that cover at least one tp uniqueley 
		Set<Map<Parameter, ?>> necessaryTests = new HashSet<>();
		// take one tuple at the time
		for(Map<Parameter, String> currentTuple : listMapReq) {
			// find the set of tests covering currentReq
			Set<Map<Parameter, String>> testsCoveringTp = new HashSet<>();
			for(Map<Parameter, String> test : testsSet) {
				if (covers(test, currentTuple)) {
					testsCoveringTp.add(test);
				}
			}
			// if currentReq is uniquely covered by one test in covTp
			if (testsCoveringTp.size() == 1)
					necessaryTests.addAll(testsCoveringTp);
		}
		return necessaryTests.size() == testsSet.size();
	}
}
