package citlab.validator.vacuity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;

import citlab.model.citL.AndExpression;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.NotExpression;
import citlab.model.citL.OrExpression;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.util.CitLSwitch;
import citlab.model.logic.cnf.SimpleExpressionToString;
import citlab.model.util.Utils.Pair;
import citlab.validator.yices.YicesConstraintTranslator;
import citlab.validator.yices.YicesLibrary;

import com.sun.jna.Pointer;

/**
 * data una rule restitisce tutte le variazioni della rule, gi� trodotte in
 * yices, in cui le sottoformule sono sostituite con tru e false
 * 
 * @author garganti
 * 
 */
public class VacuousPropBuilder {

	private static final Logger logger = Logger
			.getLogger(VacuousPropBuilder.class);

	static YicesLibrary yices = YicesLibrary.INSTANCE;

	Pointer ctx;
	YicesConstraintTranslator translator;

	private Pointer truevalue;

	VacuousPropBuilder(Pointer ctx, YicesConstraintTranslator translator) {
		this.ctx = ctx;
		this.translator = translator;
		truevalue = yices.yices_mk_true(ctx);
	}

	public Collection<Pair<Pointer,Rule>> getVacuousProp(Rule constraintToCheck) {
		Collection<Pair<Pointer, Rule>> res = new ArrayList<>();
		logger.debug("visiting top level "
				+ SimpleExpressionToString.eInstance.doSwitch(constraintToCheck));
		// first case rule is equivalent to true
		res.add(new Pair<>(truevalue,constraintToCheck));
		// call the variations
		res.addAll(new VacuousPropBuilderHelper().doSwitch(constraintToCheck));
		return res;
	}

	// returns the collection of variations
	// caseExpression(e) mi restitusice tutte le espressioni in cui ho tolto una sottoespressione di e 
	// a and b => a, b
	// a and (b or c) => a, b or c, a and b, a and c	
	class VacuousPropBuilderHelper extends CitLSwitch<Collection<Pair<Pointer,Rule>>> {

		@Override
		public Collection<Pair<Pointer,Rule>> caseNotExpression(NotExpression not) {
			logger.debug("visiting not expression "
					+ SimpleExpressionToString.eInstance.doSwitch(not));
			Collection<Pair<Pointer,Rule>> res = new ArrayList<>();
			for (Pair<Pointer, Rule> p : doSwitch(not.getPredicate())) {
				Pointer lp= yices.yices_mk_not(ctx, p.getFirst());
				res.add(new Pair<>(lp,p.getSecond()));
			}
			return res;
		}

		/*
		 * 
		 * /* (non-Javadoc)
		 * 
		 * @see
		 * combinatorial.comb.comB.util.CmbSwitch#caseOr(combinatorial.comb.
		 * comB.Or)
		 */
		@Override
		public Collection<Pair<Pointer,Rule>> caseOrExpression(OrExpression e) {
			Collection<Pair<Pointer,Rule>> res = new ArrayList<>();
			Collection<Pair<Pointer,Rule>> resRight = new ArrayList<>();
			Collection<Pair<Pointer,Rule>> resLeft = new ArrayList<>();
			Pointer lp = translator.doSwitch(e.getLeft());
			Pointer rp = translator.doSwitch(e.getRight());
			// adding the left and the right
			res.add(new Pair<Pointer, Rule>(lp, e.getRight()));
			res.add(new Pair<Pointer, Rule>(rp, e.getLeft()));
			resRight.addAll(doSwitch(e.getLeft()));
			resLeft.addAll(doSwitch(e.getRight()));
			for (Pair<Pointer,Rule> p : resRight) {
				if (p.getFirst() != rp) {
					res.add(new Pair<Pointer, Rule>(yices.yices_mk_or(ctx, new Pointer[] { lp, p.getFirst() }, 2),p.getSecond()));
				}
			}
			for (Pair<Pointer,Rule> p : resLeft) {
				if (p.getFirst() != lp) {
					res.add(new Pair<Pointer, Rule>(yices.yices_mk_or(ctx, new Pointer[] { p.getFirst(), rp }, 2), p.getSecond()));
				}
			}
			return res;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * combinatorial.comb.comB.util.CmbSwitch#caseInequality(combinatorial
		 * .comb .comB.Inequality )
		 */
		@Override
		public Collection<Pair<Pointer,Rule>> caseRelationalExpression(
				RelationalExpression ineqExpr) {
			return Collections.EMPTY_LIST;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * combinatorial.comb.comB.util.CmbSwitch#caseAssign(combinatorial.comb.
		 * comB.Assign)
		 */
		@Override
		public Collection<Pair<Pointer,Rule>> caseEnumAssign(EnumAssign assgn) {
			return Collections.EMPTY_LIST;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * combinatorial.comb.comB.util.CmbSwitch#caseBoolAssign(combinatorial
		 * .comb .comB.BoolAssign )
		 */
		@Override
		public Collection<Pair<Pointer,Rule>> caseBoolAssign(BoolAssign Bassign) {
			logger.debug("visiting boolean assign  "
					+ SimpleExpressionToString.eInstance.doSwitch(Bassign));
			return Collections.EMPTY_LIST;
		}

		@Override
		public Collection<Pair<Pointer,Rule>> caseAndExpression(AndExpression e) {
			Collection<Pair<Pointer,Rule>> res = new ArrayList<>();
			Collection<Pair<Pointer,Rule>> resRight = new ArrayList<>();
			Collection<Pair<Pointer,Rule>> resLeft = new ArrayList<>();
			Pointer lp = translator.doSwitch(e.getLeft());
			Pointer rp = translator.doSwitch(e.getRight());
			// adding the left and the right
			res.add(new Pair<Pointer, Rule>(lp, e.getRight()));
			res.add(new Pair<Pointer, Rule>(rp, e.getLeft()));
			resRight.addAll(doSwitch(e.getLeft()));
			resLeft.addAll(doSwitch(e.getRight()));
			for (Pair<Pointer,Rule> p : resRight) {
				if (p.getFirst() != rp) {
					res.add(new Pair<Pointer, Rule>(yices.yices_mk_and(ctx, new Pointer[] { lp, p.getFirst() }, 2),p.getSecond()));
				}
			}
			for (Pair<Pointer,Rule> p : resLeft) {
				if (p.getFirst() != rp) {
					res.add(new Pair<Pointer, Rule>(yices.yices_mk_and(ctx, new Pointer[] { p.getFirst(), rp }, 2), p.getSecond()));
				}
			}
			return res;
		}

		@Override
		public Collection<Pair<Pointer,Rule>> caseImpliesExpression(ImpliesExpression e) {
			Collection<Pair<Pointer,Rule>> res = new ArrayList<>();
			Pointer lp = translator.doSwitch(e.getLeft());
			Pointer rp = translator.doSwitch(e.getRight());
			// adding the left (remove right) and the right (remove left)
			res.add(new Pair<Pointer, Rule>(lp, e.getRight()));
			res.add(new Pair<Pointer, Rule>(rp, e.getLeft()));
			// recurse down
			Collection<Pair<Pointer,Rule>> resRight;
			Collection<Pair<Pointer,Rule>> resLeft;
			resRight = doSwitch(e.getLeft());
			resLeft = doSwitch(e.getRight());
			for (Pair<Pointer,Rule> p : resRight) {
				if (p.getFirst() != rp) {
					logger.debug("adding left implies sub right ");
					Pointer nl = yices.yices_mk_not(ctx, lp);
					// add left -> a right subformula
					res.add(new Pair<Pointer, Rule>((yices.yices_mk_or(ctx, new Pointer[] { nl, p.getFirst() }, 2)),p.getSecond()));
				}
			}
			for (Pair<Pointer,Rule> p: resLeft) {
				if (p.getFirst() != lp) {
					logger.debug("adding sub left implies right ");
					Pointer nl = yices.yices_mk_not(ctx, p.getFirst());
					res.add(new Pair<Pointer, Rule>((yices.yices_mk_or(ctx, new Pointer[] { nl, rp }, 2)), p.getSecond()));
				}
			}
			return res;
		}
	}
}
