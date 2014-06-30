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
package citlab.model.simplifier;

import java.util.List;

import citlab.model.citL.EnumAssign;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Rule;

/** simplify the constraints 
 * 
 * @author garganti
 *
 */
public final class ConstraintSimplifier extends Simplifier {

	static ConstraintSimplifier eInstance = new ConstraintSimplifier();

	private ConstraintSimplifier() {
	}

	@Override
	void simplify(CitModel model) {
		List<Rule> cs = model.getConstraints();
		boolean constraintChanged = true;
		while (constraintChanged) {
			constraintChanged = false;
			for (int i = 0; i < cs.size(); i++) {
				// constraint to be simplified
				Rule constraint = cs.get(i);
				// constraint is an implication
				if (constraint instanceof ImpliesExpression) {
					ImpliesExpression impl = (ImpliesExpression) constraint;
					if (impl.getOp() == ImpliesOperator.IMPL) {
						// a -> b
						// take the first
						Expression a = impl.getLeft();
						Expression b = impl.getRight();
						if (searchConstraint(a, model)) {
							// if a is a constraint ?
							// substitute a->b => b
							cs.set(i, b);
							constraintChanged = true;
						}
						if (searchConstraint(b, model)) {
							// b is a constraint ?
							// substitute a->b => b
							cs.remove(i);
							constraintChanged = true;
						}

					} else if (impl.getOp() == ImpliesOperator.IFF) {
						// a <-> b
						// take the first (a)
						Expression a = impl.getLeft();
						Expression b = impl.getRight();
						// searching for a
						if (searchConstraint(a, model)) {
							// substitute a <->b => b
							cs.set(i, b);
							constraintChanged = true;
						}
						// searching for b
						if (searchConstraint(b, model)) {
							// substitute a <->b => a
							cs.set(i, a);
							constraintChanged = true;
						}

					}
				} else if (constraint instanceof OrExpression) {
					// TODO
				}
			}
		}
		return;
	}

	/**
	 * check if an expression rpresenting a constraints is present in a model
	 * 
	 * @param a
	 * @param model
	 * @return
	 */
	private boolean searchConstraint(Expression a, CitModel model) {
		for (Rule r : model.getConstraints()) {
			if (identical((Expression) r, a))
				return true;
			else {
				// System.out.println(a + "!=" + r);
			}
		}
		return false;
	}
	/** check if two expressions are identical. BoolAssign e EnumAssign
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean identical(Expression a, Expression b) {
		if (a instanceof BoolAssign && b instanceof BoolAssign) {
			BoolAssign a1 = (BoolAssign) a;
			BoolAssign b1 = (BoolAssign) b;
			return (a1.getLeft().equals(b1.getLeft())
					&& a1.getOp().equals(b1.getOp()) && a1.getRight().equals(
					b1.getRight()));
		} else if (a instanceof EnumAssign && b instanceof EnumAssign) {
			EnumAssign a1 = (EnumAssign) a;
			EnumAssign b1 = (EnumAssign) b;
			return (a1.getLeft().equals(b1.getLeft())
					&& a1.getOp().equals(b1.getOp()) && a1.getRight().equals(
					b1.getRight()));
		}
		return false;
	}

}
