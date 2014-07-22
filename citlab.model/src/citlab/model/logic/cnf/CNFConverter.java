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
package citlab.model.logic.cnf;

import static citlab.model.citL.CitLFactory.eINSTANCE;
import static citlab.model.logic.cnf.SimpleExpressionToString.eInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;

import citlab.model.citL.AndExpression;
import citlab.model.citL.AndOperators;
import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.NotExpression;
import citlab.model.citL.Operators;
import citlab.model.citL.OrExpression;
import citlab.model.citL.OrOperators;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.util.CitLSwitch;

/**
 * Adapted from :
 * 
 * Transformation rules extracted from AIMA book 346 and 347, which are
 * essentially the INSEADO method outlined in:
 * http://logic.stanford.edu/classes/cs157/2008/lectures/lecture09.pdf
 * 
 * @author Angelo gargantini
 * 
 */
public class CNFConverter {
	
	static private Logger logger = Logger.getLogger(CNFConverter.class); 
	
	private static final DistributeOrOverAnd DISTRIBUTE_OR_OVER_AND = new DistributeOrOverAnd();
	private static final NegationsIn NEGATIONS_IN = new NegationsIn();
	private static final ImplicationsOut IMPLICATIONS_OUT = new ImplicationsOut();

	public CNFConverter() {
	}

	public CNF convertToCNF(Expression aExpression) {
		// clone the expression that will be modified
		aExpression = EcoreUtil2.clone(aExpression);	
		// change the new expressions
		logger.debug("original =>" + eInstance.doSwitch(aExpression));
		// I)mplications Out:
		Expression implicationsOut = IMPLICATIONS_OUT.doSwitch(aExpression);
		assert implicationsOut != null;
		logger.debug("implication out =>" + eInstance.doSwitch(implicationsOut));
		// N)egations In:
		Expression negationsIn = NEGATIONS_IN.doSwitch(implicationsOut);
		assert negationsIn != null;
		logger.debug("negation in  =>" +eInstance.doSwitch(negationsIn));
		// D)istribution V over ^:
		Expression orDistributedOverAnd = DISTRIBUTE_OR_OVER_AND.doSwitch(negationsIn);
		assert orDistributedOverAnd != null;
		logger.debug("distributed or/and  =>" + eInstance.doSwitch(orDistributedOverAnd));
		// O)perators Out
		CNF fillWith = (new CNFFiller()).fillWith(orDistributedOverAnd);
		return fillWith;
	}
}
/** super class with standard behvaior
 *
 */
abstract class CitLSwitchRecursive extends CitLSwitch<Expression> {

	@Override
	public Expression caseNotExpression(NotExpression notExpression) {
		Expression negated = notExpression.getPredicate();
		assert negated != null;
		Expression doSwitch = this.doSwitch(negated);
		if (doSwitch == negated)
			return notExpression;
		else {
			NotExpression newNot = eINSTANCE.createNotExpression();
			newNot.setPredicate(doSwitch);
			return newNot;
		}
	}

	@Override
	public Expression caseAndExpression(AndExpression andExpression) {
		Expression left = andExpression.getLeft();
		Expression right = andExpression.getRight();
		Expression e1 = this.doSwitch(left);
		Expression e2 = this.doSwitch(right);
		if ((e1 == left) && (e2 == right))
			return andExpression;
		// something changed
		AndExpression newAnd = eINSTANCE.createAndExpression();
		newAnd.setLeft(e1);
		newAnd.setRight(e2);
		newAnd.setOp(AndOperators.AND);
		return newAnd;
	}

	@Override
	public Expression caseOrExpression(OrExpression prExpression) {
		Expression left = prExpression.getLeft();
		Expression right = prExpression.getRight();
		Expression e1 = this.doSwitch(left);
		Expression e2 = this.doSwitch(right);
		assert e1 != null && e2 != null;
		if ((e1 == left) && (e2 == right))
			return prExpression;
		// something changed
		OrExpression newAnd = eINSTANCE.createOrExpression();
		newAnd.setLeft(e1);
		newAnd.setRight(e2);
		newAnd.setOp(OrOperators.OR);
		return newAnd;
	}

	// BASE CASES x recursion
	@Override
	public Expression caseAtomicPredicate(AtomicPredicate object) {
		return object;
	}

	/*
	 * @Override public Expression caseBoolAssign(BoolAssign object) { return
	 * object; }
	 * 
	 * @Override public Expression caseAssign(EnumAssign object) { return object; }
	 * 
	 * @Override public Expression caseRelationalExpression(RelationalExpression
	 * object) { return object; }
	 */
}

// remove implication
// FIRST STEP

class ImplicationsOut extends CitLSwitchRecursive {

	public ImplicationsOut() {}

	@Override
	public Expression caseImpliesExpression(ImpliesExpression imp) {
		Expression alpha = this.doSwitch(imp.getLeft());
		Expression beta = this.doSwitch(imp.getRight());
		// this is needed in any case
		NotExpression notAlpha = eINSTANCE.createNotExpression();
		notAlpha.setPredicate(EcoreUtil2.cloneIfContained(alpha));
		// Eliminate <=>, bi-conditional elimination,
		// replace (alpha <=> beta) with (~alpha V beta) ^ (alpha V ~beta).
		if (imp.getOp() == ImpliesOperator.IFF) {
			// (~alpha V beta)
			OrExpression first = eINSTANCE.createOrExpression();
			first.setLeft(notAlpha);
			first.setRight(beta);
			// (alpha V ~beta)
			OrExpression second = eINSTANCE.createOrExpression();
			NotExpression notBeta = eINSTANCE.createNotExpression();
			notBeta.setPredicate(EcoreUtil2.cloneIfContained(beta));
			second.setLeft(alpha);
			second.setRight(notBeta);
			//
			AndExpression result = eINSTANCE.createAndExpression();
			result.setLeft(first);
			result.setRight(second);
			return result;
		} else {
			assert imp.getOp() == ImpliesOperator.IMPL;
			// Eliminate =>, implication elimination,
			// replacing (alpha => beta) with (~alpha V beta)
			OrExpression first = eINSTANCE.createOrExpression();
			first.setLeft(notAlpha);
			first.setRight(EcoreUtil2.cloneIfContained(beta));
			return first;
		}
	}
}
// push the negation inside 
class NegationsIn extends CitLSwitchRecursive {
	public NegationsIn() {

	}

	@Override
	public Expression caseImpliesExpression(ImpliesExpression object) {
		throw new RuntimeException("impication not possible");
	}

	@Override
	public Expression caseNotExpression(NotExpression notExpression) {
		// CNF requires NOT (~) to appear only in literals, so we 'move ~
		// inwards' by repeated application of the following equivalences:
		Expression operand = notExpression.getPredicate();

		// ~(~alpha) equivalent to alpha (double negation elimination)
		if (operand instanceof NotExpression) {
			return this.doSwitch(((NotExpression) operand).getPredicate());
		} else if (operand instanceof AndExpression) {
			AndExpression negatedAnd = (AndExpression) operand;
			Expression alpha = negatedAnd.getLeft();
			Expression beta = negatedAnd.getRight();
			// I need to ensure the ~s are moved in deeper
			NotExpression notAlpha = eINSTANCE.createNotExpression();
			notAlpha.setPredicate(EcoreUtil2.cloneIfContained(alpha));
			Expression notAlphaP = this.doSwitch(notAlpha);
			NotExpression notBeta = eINSTANCE.createNotExpression();
			notBeta.setPredicate(EcoreUtil2.cloneIfContained(beta));
			Expression notBetaP = this.doSwitch(notBeta);
			// ~(alpha ^ beta) equivalent to (~alpha V ~beta) (De Morgan)
			OrExpression result = eINSTANCE.createOrExpression();
			result.setLeft(notAlphaP);
			result.setRight(notBetaP);
			return result;
		} else if (operand instanceof OrExpression) {
			OrExpression negatedAnd = (OrExpression) operand;
			Expression alpha = negatedAnd.getLeft();
			Expression beta = negatedAnd.getRight();
			// I need to ensure the ~s are moved in deeper
			NotExpression notAlpha = eINSTANCE.createNotExpression();
			notAlpha.setPredicate(EcoreUtil2.cloneIfContained(alpha));
			Expression notAlphaP = this.doSwitch(notAlpha);
			NotExpression notBeta = eINSTANCE.createNotExpression();
			notBeta.setPredicate(EcoreUtil2.cloneIfContained(beta));
			Expression notBetaP = this.doSwitch(notBeta);
			// ~(alpha V beta) equivalent to (~alpha ^ ~beta) (De Morgan)
			AndExpression result = eINSTANCE.createAndExpression();
			result.setLeft(notAlphaP);
			result.setRight(notBetaP);
			return result;
		} else if (operand instanceof AtomicPredicate) {
			// change the atomic predicate
			Expression newOperand = EcoreUtil2.cloneIfContained(operand);
			if (operand instanceof EnumAssign){ 
				// also in case of assign, change the operator
				Operators op = ((EnumAssign) operand).getOp();
				assert ((EnumAssign) operand).getLeft()!= null;
				assert ModelUtils.getEnumerativeType(((EnumAssign) operand).getLeft())!= null : "no type for " + ((EnumAssign) operand).getLeft().getName();
				// simply change the operator
				if (op == Operators.EQ) {
					((EnumAssign) newOperand).setOp(Operators.NE);
				} else {
					assert (op == Operators.NE);
					((EnumAssign) newOperand).setOp(Operators.EQ);
				}
				return newOperand;
			} if (operand instanceof BoolAssign){
				assert ((BoolAssign) operand).getLeft()!= null;
				// also in case of assign, change the operator
				Operators op = ((BoolAssign) operand).getOp();
				// simply change the operator
				if (op == Operators.EQ) {
					((BoolAssign) newOperand).setOp(Operators.NE);
				} else {
					assert (op == Operators.NE);
					((BoolAssign) newOperand).setOp(Operators.EQ);
				}
				return newOperand;
			} else if (operand instanceof RelationalExpression){
				// TODO
				throw new RuntimeException("class" + operand.getClass());
				
			} else{
				throw new RuntimeException("class" + operand.getClass());
			}
		} else {
			return super.caseNotExpression(notExpression);
		}
	}
}

class DistributeOrOverAnd extends CitLSwitchRecursive {

	public DistributeOrOverAnd() {

	}

	@Override
	public Expression caseImpliesExpression(ImpliesExpression object) {
		throw new RuntimeException("impication not possible");
	}

	@Override
	public Expression caseOrExpression(OrExpression orExpression) {

		// Distribute V over ^:

		// This will cause flattening out of nested ^s and Vs
		Expression left = orExpression.getLeft();
		Expression right = orExpression.getRight();
		Expression alpha = doSwitch(left);
		Expression beta = doSwitch(right);

		// (alpha V (beta ^ gamma)) equivalent to
		// ((alpha V beta) ^ (alpha V gamma))
		if (beta instanceof AndExpression) {
			AndExpression betaAndGamma = (AndExpression) beta;
			beta = betaAndGamma.getLeft();
			Expression gamma = betaAndGamma.getRight();
			OrExpression alphaBeta = eINSTANCE.createOrExpression();
			alphaBeta.setLeft(EcoreUtil2.cloneIfContained(alpha));
			alphaBeta.setRight(beta);
			OrExpression alphaGamma = eINSTANCE
					.createOrExpression();
			alphaGamma.setLeft(EcoreUtil2.cloneIfContained(alpha));
			alphaGamma.setRight(gamma);
			AndExpression dirstirbuted = eINSTANCE
					.createAndExpression();
			dirstirbuted.setLeft(alphaBeta);
			dirstirbuted.setRight(alphaGamma);
			// recursive
			// TODO .check is really necessary???
			Expression result = doSwitch(dirstirbuted);
			assert result == dirstirbuted;
			return result;
		}
		// ((alpha ^ gamma) V beta) equivalent to
		// ((alpha V beta) ^ (gamma V beta))
		if (alpha instanceof AndExpression) {
			AndExpression alphaAndGamma = (AndExpression) alpha;
			alpha = alphaAndGamma.getLeft();
			Expression gamma = alphaAndGamma.getRight();
			OrExpression alphaBeta = eINSTANCE.createOrExpression();
			alphaBeta.setLeft(alpha);
			alphaBeta.setRight(EcoreUtil2.cloneIfContained(beta));
			OrExpression gammaBeta = eINSTANCE.createOrExpression();
			gammaBeta.setLeft(gamma);
			gammaBeta.setRight(EcoreUtil2.cloneIfContained(beta));
			AndExpression dirstirbuted = eINSTANCE
					.createAndExpression();
			dirstirbuted.setLeft(alphaBeta);
			dirstirbuted.setRight(gammaBeta);
			// recursive
			// TODO .check is really necessary???
			Expression result = doSwitch(dirstirbuted);
			assert result == dirstirbuted;
			return result;
		}
		return super.caseOrExpression(orExpression);
	}

}

// assuming sentence is already in CNF
class CNFFiller extends CitLSwitch<CNF> {

	CNF tobeFilled;

	public CNFFiller() {

	}

	public CNF fillWith(Expression e) {
		tobeFilled = new CNF();
		doSwitch(e);
		return tobeFilled;
	}

	@Override
	public CNF caseOrExpression(OrExpression object) {
		List<Expression> clause = new ArrayList<Expression>();
		collectClause(object, clause);
		tobeFilled.add(clause);
		return tobeFilled;
	}

	@Override
	public CNF caseAndExpression(AndExpression object) {
		this.doSwitch(object.getLeft());
		this.doSwitch(object.getRight());
		return tobeFilled;
	}

	@Override
	public CNF caseNotExpression(NotExpression object) {
		tobeFilled.add(Collections.singletonList(object));
		return tobeFilled;
	}

	@Override
	public CNF caseAtomicPredicate(AtomicPredicate object) {
		assert object != null;
		tobeFilled.add(Collections.singletonList(object));
		return tobeFilled;
	}

	// given a or b or c return a,b,c
	private static void collectClause(OrExpression bin, List<Expression> clause) {
		collect(clause, bin.getLeft());
		collect(clause, bin.getRight());
	}

	/** collect e expression in clause
	 * e can be a literal or an OR expression
	 * **/
	private static void collect(List<Expression> clause, Expression e) {
		assert e != null;
		if (e instanceof OrExpression) {
			collectClause((OrExpression) e, clause);
		} else {
			assert CNF.isLiteral(e) : "left is " + e.getClass();
			clause.add(e);
		}
	}
}
