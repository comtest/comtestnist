package citlab.validator.vacuity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.SimpleExpressionToString;
import citlab.model.util.Utils.Pair;
import citlab.validator.yices.ConstraintChecker;
import citlab.validator.yices.YicesConstraintTranslator;
import citlab.validator.yices.YicesLibrary;

import com.sun.jna.Pointer;

/**  */
public class VacuousRuleFinder {

	private static final Logger logger = Logger
			.getLogger(VacuousRuleFinder.class);
	
	static YicesLibrary yices = YicesLibrary.INSTANCE;

	public Pair<Collection<Rule>,Collection<Rule>> getVacuousRules(CitModel model) {
		Collection<Rule> partiallyVacuous= new ArrayList<>();
		Collection<Rule> totallyVacuous= new ArrayList<>();	
		//
		Collection<Rule> constraints = model.getConstraints();
		for(Rule constraintToCheck : constraints){	
			logger.debug("Checking constraint " + SimpleExpressionToString.eInstance.doSwitch(constraintToCheck));
			// get the other rules
			List<Rule> otherRules = new ArrayList<>(constraints);
			otherRules.remove(constraintToCheck);
			// create context 
			// 
			Pointer ctx = yices.yices_mk_context();
			Map<String, String> declaredElements = new HashMap<>();

			Map<Parameter, Pointer> variables = new HashMap<Parameter, Pointer>();
			// crea context e riempie mappe
			// senza constraints
			ConstraintChecker.createCtxFromModel(model, otherRules, yices, ctx, declaredElements, variables);
			yices.yices_check(ctx);
			// traslate the current constraint
			YicesConstraintTranslator translator = new YicesConstraintTranslator(ctx, variables, declaredElements);
			Pointer constraint = translator.doSwitch(constraintToCheck);
			// get the variations of the current constraint
			VacuousPropBuilder vcp = new VacuousPropBuilder(ctx,translator);
			Collection<Pair<Pointer,Rule>> vacousVariations = vcp.getVacuousProp(constraintToCheck);
			// add the not eq 
			
			for(Pair<Pointer,Rule> vc : vacousVariations){
				// save current context
				yices.yices_push(ctx);
				// assert disequals
				Pointer diseq = yices.yices_mk_diseq(ctx, constraint, vc.getFirst());
				yices.yices_assert(ctx, diseq);
				// check 
				int res = yices.yices_check(ctx);
				// if unsat, is vacous
				if (res == YicesLibrary.lbool.l_false){
					//yices.yices_dump_context(ctx);
					
					if (logger.isDebugEnabled()){
						yices.yices_pp_expr(vc.getFirst());
						System.out.println();
						System.out.println("VACUO DETECTED "+SimpleExpressionToString.eInstance.doSwitch(constraintToCheck)+"in "+SimpleExpressionToString.eInstance.doSwitch(vc.getSecond()));
						yices.yices_pp_expr(vc.getFirst());
					}
					//vacuousRules.add(vc.getSecond());
					if(vc.getSecond().equals(constraintToCheck)){
						totallyVacuous.add(constraintToCheck);
						//a seconda della definizione di partially
						break;
					}
					else{
						partiallyVacuous.add(vc.getSecond());
						break;
					}
				}
				yices.yices_pop(ctx);
			}						
			yices.yices_del_context(ctx);
		}
		// 
		return new Pair<Collection<Rule>, Collection<Rule>>(partiallyVacuous, totallyVacuous);
	}
}
