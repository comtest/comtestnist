package citlab.validator.yices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import citlab.core.util.ParameterElementsGetter;
import citlab.model.citL.CitModel;
import citlab.model.citL.Enumerative;
import citlab.model.citL.Numerical;
import citlab.model.citL.Parameter;
import citlab.model.util.Utils.Pair;

import com.sun.jna.Pointer;

/** check if all the parameters can take any value in their domain */
public class InfeasibleAssignmentfinder {

	static YicesLibrary yices = YicesLibrary.INSTANCE;

	public Pair<String, Integer> getInfeasibleAssignment(CitModel model) {
		Pointer ctx = yices.yices_mk_context();
		Map<String, String> declaredElements = new HashMap<>();

		Map<Parameter, Pointer> variables = new HashMap<Parameter, Pointer>();
		ConstraintChecker.createCtxFromModel(model, model.getConstraints(),
				yices, ctx, declaredElements, variables);
		yices.yices_check(ctx);
		int n=0;
		int bools=0;
		int numericals=0;
		int elements=0;
		int uselessParameter=0;
		for (Parameter p : model.getParameters()) {
			Pointer t = null;
			Pointer varPointer = variables.get(p);
			assert varPointer != null;
			List<String> listElements = ParameterElementsGetter.eInstance
					.doSwitch(p);
			if (p instanceof Enumerative) {
				int elementUselessOfP=0;
				for (String assignment : listElements) {
					String elementName = declaredElements.get(assignment
							.concat(p.getName()));
					assert elementName != null;
					Pointer a1 = yices.yices_parse_expression(ctx, elementName);
					t = yices.yices_mk_eq(ctx, varPointer, a1);
					if (checkUnfeasible(ctx, t, p, assignment)) {
						elements = elements + 1;
						n = n + 1;
						elementUselessOfP= elementUselessOfP+1;
						if(elementUselessOfP==listElements.size()-1)
							uselessParameter=uselessParameter+1;
					}
					
				}

			} else if (p instanceof Numerical) {
				int numbersUselessOfP=0;
				for (String assignment : listElements) {
					Pointer number = yices.yices_mk_num(ctx,
							Integer.valueOf(assignment));
					t = yices.yices_mk_eq(ctx, varPointer, number);
					if(checkUnfeasible(ctx, t, p, assignment)){
						numericals = numericals + 1;
						n = n + 1;
						numbersUselessOfP= numbersUselessOfP+1;
						if(numbersUselessOfP==listElements.size()-1)
							uselessParameter=uselessParameter+1;
					}
					
						
				}
			} else if (p instanceof citlab.model.citL.Boolean) {
				for (String assignment : listElements) {
					if (assignment.toLowerCase().equals("true"))
						t = varPointer;
					else
						t = yices.yices_mk_not(ctx, varPointer);
					if(checkUnfeasible(ctx, t, p, assignment)){
						bools = bools + 1;
						n = n + 1;
						uselessParameter=uselessParameter+1;
					} 
					
				}
			}

		}
		yices.yices_del_context(ctx);
		return new Pair<String, Integer>(", "+bools+", "+numericals+", "+elements+", "+uselessParameter, n);

	}

	/**
	 * 
	 * @param ctx
	 *            the current context
	 * @param expression
	 *            the expression to check
	 * @param p
	 * @param assignment
	 */
	private boolean checkUnfeasible(Pointer ctx, Pointer expression, Parameter p,
			String assignment) {
		yices.yices_push(ctx);
		yices.yices_assert(ctx, expression);
		if (yices.yices_check(ctx) == YicesLibrary.lbool.l_false){
			//System.out.println(p.getName() + " is never equals to "
				//	+ assignment);
		yices.yices_pop(ctx);
		return true;
		}
		yices.yices_pop(ctx);
		return false;
	}
}
