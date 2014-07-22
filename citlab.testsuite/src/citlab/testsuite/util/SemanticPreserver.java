/*******************************************************************************
 * Copyright (c) 2013 Vava.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.testsuite.util;

import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.EnumAssign;
import citlab.model.simplifier.Simplificator;
import static citlab.testsuite.TestsuiteFactory.*;

/**
 * reinsert in the test suite paramters which have been simplified
 * 
 * @author garganti
 * 
 */
public class SemanticPreserver {
	TestSuite testsuite;
	Simplificator simp;

	public SemanticPreserver(TestSuite testsuite, Simplificator simp) {
		this.testsuite = testsuite;
		this.simp = simp;
	}

	public TestSuite preserve() {
		for (Test t : testsuite.getTests()) {
			for (AtomicPredicate a : simp.getRemovedPA()) {
				// reinsert the Atomic Predicate 
				Assignment assignment = eINSTANCE.createAssignment();
				if (a instanceof BoolAssign) {
					assignment.setParameter(((BoolAssign) a).getLeft());
					assignment.setValue(((BoolAssign) a).getRight().getName());
				} else if (a instanceof EnumAssign) {
					assignment.setParameter(((EnumAssign) a).getLeft());
					assignment.setValue(((EnumAssign) a).getRight().getName());
				}
				t.getAssignments().add(assignment);
			}
		}
		return testsuite;
	}

}
