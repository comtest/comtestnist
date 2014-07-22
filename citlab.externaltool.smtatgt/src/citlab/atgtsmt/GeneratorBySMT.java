/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.atgtsmt;

/*******************************************************************************
 * Copyright (c) 2012 University of Bergamo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 ******************************************************************************/

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tgtlib.definitions.TestSequenceState;
import tgtlib.definitions.expression.Expression;
import tgtlib.definitions.expression.type.BoolType;
import tgtlib.definitions.expression.type.EnumConst;
import tgtlib.definitions.expression.type.EnumConstCreator;
import tgtlib.definitions.expression.type.EnumType;
import tgtlib.reduction.TestSuiteRed;
import tgtlib.specification.Axiom;
import atgt.combinatorial.NWiseCoverage;
import atgt.combinatorial.TPNWiseCompatibleCollector;
import atgt.combinatorial.Util.TestGenMethod;
import atgt.combinatorial.yices.YicesTSuiteGenCollect;
import atgt.coverage.AsmTestSequence;
import atgt.coverage.AsmTestSuite;
import atgt.generator.collection.TPCompatibleCollector;
import atgt.generator.testsuite.TestGeneratorCollectTP;
import atgt.preferences.ATGToolPreferences;
import atgt.preferences.ATGToolPreferences.OrderKind;
import atgt.project.AsmProject;
import atgt.specification.ASMSpecification;
import atgt.specification.location.Variable;
import atgt.yices.generator.YicesModelGenJNA;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;
import citlab.core.ext.ICitLabTestGenerator;
import citlab.model.citL.AnonymousType;
import citlab.model.citL.Boolean;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.NamedType;
import citlab.model.citL.Numbers;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import citlab.model.citL.Rule;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.logic.cnf.SimpleExpressionToString;

/**
 * Generator using any of the ACTS algorithms.
 * 
 */
public class GeneratorBySMT extends ICitLabTestGenerator {

	static final private Logger logger = Logger.getLogger(GeneratorBySMT.class);

	private static final boolean collect = true;
	private static final boolean reduce = true;
	private int twise = 2;

	private TestGenMethod TGM;

	public GeneratorBySMT() {
		super("ATGT_SMT");
		// set the right options
		ATGToolPreferences.CollectTPS.setChecked(collect);
		TGM = new atgt.combinatorial.Util.TestGenMethod() {
			@Override
			public TestGeneratorCollectTP getTGM(AsmProject pro) {
				YicesModelGenJNA generator = new YicesModelGenJNA(
						pro.specification.getVariables(),
						pro.specification.getAxiom(), AsmTestSequence.factory);
				return new TestGeneratorCollectTP(pro, generator,
						AsmTestSuite.getAsmTestSuiteFactory());
			}
		};
		// set the collector
		if (collect)
			TPCompatibleCollector.collectorRegistrator.register(
					NWiseCoverage.class,
					TPNWiseCompatibleCollector.getFactory(), true);
		// set the order
		// useless?
		// NWiseTcComparatorFactory.setComparator(new TOUCHComparator());
		ATGToolPreferences.TP_ORDERING.setValue(OrderKind.NOVELTY);
		/*
		 * break; case AS_GENERATED:
		 * TP_ORDERING.setValue(OrderKind.AS_GENERATED); break; case RANDOM:
		 * TP_ORDERING.setValue(OrderKind.RANDOM); break; }
		 */
	}

	@Override
	public TestSuite call() throws Exception {
		// translate from CitLab to ASMSpecification
		ASMSpecification spec = convertToAsmSpec();
		// generate
		AsmProject result = atgt.combinatorial.Util.generateNwiseTestSuite(
				spec, "", true, TGM, twise);
		AsmTestSuite ts = result.getAsmTestSuite();
		// infeasible tests predicates
		if (reduce) {
			boolean reducedTs = TestSuiteRed.reduce(ts);
			if (reducedTs) {
				// logger.info("test suite has been reduced");
			} else {
				// logger.info("test suite has not been reduced");
			}
			// printTestSuite(ts, true, out);
		} else {
			// logger.info("no reduction applied - completed test suite");
			// printTestSuite(ts, false, out);
		}
		return convertTestSuite(ts);
	}

	// the spec to be built
	private ASMSpecification spec;
	private EnumConstCreator icc;

	private ASMSpecification convertToAsmSpec() {
		spec = new ASMSpecification();
		icc = new EnumConstCreator();
		Map<Parameter, Variable> vars = new HashMap<Parameter, Variable>();
		// set the name
		spec.name = citModel.getName();
		// add enum types defined by name
		for (NamedType nt : citModel.getTypes()) {
			logger.debug("adding type " + nt.getName());
			spec.addType(convertEnumType(nt, nt.getName()));
		}
		// add variables
		ConvertVariable cv = new ConvertVariable();
		for (Parameter p : citModel.getParameters()) {
			Variable v = cv.doSwitch(p);
			logger.debug("adding variable " + v + " for parameter " + p);
			spec.addVariable(v);
			vars.put(p, v);
		}
		// add constraints
		if (!ignoreConstraints) {
			ExpressionConverter econv = new ExpressionConverter(vars);
			int i = 1;
			for (Rule r : citModel.getConstraints()) {
				citlab.model.citL.Expression s = (citlab.model.citL.Expression) r;
				Expression expression = econv.doSwitch(s);
				logger.debug(SimpleExpressionToString.eInstance.doSwitch(r));
				assert expression != null : SimpleExpressionToString.eInstance
						.doSwitch(r);
				spec.addAxiom(new Axiom("constraint_" + i++, expression));
			}
		}
		return spec;
	}

	private EnumType convertEnumType(EnumerativeType nt, String name) {
		// build e new type
		EnumType et = new EnumType(name);
		for (Element e : nt.getElements()) {
			EnumConst ec = icc.createEnumConst(e.getName());
			et.addElement(ec);
		}
		return et;
	}

	private TestSuite convertTestSuite(AsmTestSuite ts) {
		TestSuite result = TestsuiteFactory.eINSTANCE.createTestSuite();
		result.setModel(citModel);
		for (AsmTestSequence t : ts.getTests()) {
			if (t.getState() == TestSequenceState.TEST_DISCARDED)
				continue;
			Test tt = TestsuiteFactory.eINSTANCE.createTest();
			result.getTests().add(tt);
		}
		return result;
	}

	class ConvertVariable extends CitLSwitch<Variable> {

		@Override
		public Variable caseBoolean(Boolean b) {
			return new Variable(icc.createIdExpression(b.getName()),
					BoolType.BOOLTYPE, null);
		}

		@Override
		public Variable caseEnumerative(Enumerative e) {
			EnumType eType;
			// if already defined
			if (e.getNamedType() != null) {
				eType = (EnumType) spec.getTypeFor(e.getNamedType().getName());
			} else {
				// create the type
				AnonymousType atype = e.getAtype();
				eType = convertEnumType(atype, e.getName() + "Type");
			}
			return new Variable(icc.createIdExpression(e.getName()), eType,
					null);
		}

		@Override
		public Variable caseRange(Range object) {
			throw new IllegalArgumentException("range not supported");
		}

		@Override
		public Variable caseNumbers(Numbers object) {
			throw new IllegalArgumentException("constants not supported yet");
		}
	}
}
