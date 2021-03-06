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
package citlab.importer.featureide;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.EcoreUtil2;
import org.prop4j.And;
import org.prop4j.AtLeast;
import org.prop4j.AtMost;
import org.prop4j.Choose;
import org.prop4j.Equals;
import org.prop4j.Implies;
import org.prop4j.Literal;
import org.prop4j.Not;
import org.prop4j.Or;

import citlab.model.citL.AndExpression;
import citlab.model.citL.AndOperators;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.NotExpression;
import citlab.model.citL.OrExpression;
import citlab.model.citL.OrOperators;
import de.ovgu.featureide.fm.core.Feature;

/**
 * converts the constraints from FeatureIde (prop4j) to Citlab
 * 
 * @author garganti
 * 
 */
public class ConstraintConverter extends SwitchNode<Expression> {

	Map<String, Expression> litParams;
	 private String normalize(String x){
	    	return Normalizer.normalize(x,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(",", "y");
	    }

	ConstraintConverter(Map<Feature, Expression> choosenExpr) {
		litParams = new HashMap<String, Expression>();
		for (Entry<Feature, Expression> c : choosenExpr.entrySet()) {
			String name = normalize(c.getKey().getName());
			assert litParams.get(name) == null;
			litParams.put(name, c.getValue());
		}
	}

	@Override
	protected Expression visit(And n) {
		assert n.getChildren().length == 2;
		Expression n1 = visit(n.getChildren()[0]);
		Expression n2 = visit(n.getChildren()[1]);
		AndExpression and = CitLFactory.eINSTANCE.createAndExpression();
		and.setLeft(n1);
		and.setRight(n2);
		and.setOp(AndOperators.AND);
		return and;
	}

	@Override
	protected Expression visit(AtLeast n) {
		throw new ConstraintNotSupportedException();
	}

	@Override
	protected Expression visit(AtMost n) {
		throw new ConstraintNotSupportedException();
	}

	@Override
	protected Expression visit(Choose n) {
		throw new ConstraintNotSupportedException();
	}

	@Override
	protected Expression visit(Equals n) {
		assert n.getChildren().length == 2;
		Expression n1 = visit(n.getChildren()[0]);
		Expression n2 = visit(n.getChildren()[1]);
		ImpliesExpression and = CitLFactory.eINSTANCE.createImpliesExpression();
		and.setLeft(n1);
		and.setRight(n2);
		and.setOp(ImpliesOperator.IFF);
		return and;
	}

	@Override
	protected Expression visit(Implies n) {
		assert n.getChildren().length == 2;
		Expression n1 = visit(n.getChildren()[0]);
		Expression n2 = visit(n.getChildren()[1]);
		ImpliesExpression and = CitLFactory.eINSTANCE.createImpliesExpression();
		and.setLeft(n1);
		and.setRight(n2);
		and.setOp(ImpliesOperator.IMPL);
		return and;
	}
	
	@Override
	protected Expression visit(Literal n) {
		// if n is translated as boolean return n = true
		// if its root is an enumerative, and n is an element of the root return
		// root = n
		Expression eObject = litParams.get(n.var);
		assert eObject != null;
		Expression p = EcoreUtil2.cloneIfContained(eObject);
		return p;
	}

	@Override
	protected Expression visit(Not n) {
		assert n.getChildren().length == 1;
		Expression n1 = visit(n.getChildren()[0]);
		NotExpression not = CitLFactory.eINSTANCE.createNotExpression();
		not.setPredicate(n1);
		return not;
	}

	@Override
	protected Expression visit(Or or) {
		assert or.getChildren().length == 2;
		Expression n1 = visit(or.getChildren()[0]);
		Expression n2 = visit(or.getChildren()[1]);
		OrExpression and = CitLFactory.eINSTANCE.createOrExpression();
		and.setLeft(n1);
		and.setRight(n2);
		and.setOp(OrOperators.OR);
		return and;
	}

}
