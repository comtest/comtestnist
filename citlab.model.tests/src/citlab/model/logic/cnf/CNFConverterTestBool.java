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

import static org.junit.Assert.*;

import org.eclipse.xtext.EcoreUtil2;
import org.junit.Test;

import citlab.model.citL.AndExpression;
import citlab.model.citL.CitLFactory;
import citlab.model.citL.CitModel;
import citlab.model.citL.Expression;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Rule;
import citlab.model.logic.cnf.CNF;
import citlab.model.logic.cnf.CNFConverter;
import citlab.model.test.ModelsFromStringsTester;

public class CNFConverterTestBool {

	@Test
	public void testCNFConverter0() {			
		CNF res = testSimple("x==true");
		assertEquals("[x]", res.toString());
	}

	
	@Test
	public void testCNFConverter1() {			
		CNF res = testSimple("x==true and y == true");
		assertEquals("[x, y]", res.toString());
	}
	@Test
	public void testCNFConverter2() {	
		CNF res = testSimple("x==false and y == true");
		assertEquals("[!x, y]", res.toString());
	}

	@Test
	public void testCNFConverter3() {	
		CNF res = testSimple("x==false or y == true");
		assertEquals("[!x+y]", res.toString());
	}

	@Test
	public void testCNFConverter4() {	
		CNF res = testSimple("(x==false) or (y == true and z == false)");
		assertEquals("[!x+y, !x+!z]", res.toString());
	}

	@Test
	public void testCNFConverter5() {	
		CNF res = testSimple("(x==false and y == true) or z == false");
		assertEquals("[!x+!z, y+!z]", res.toString());
	}

	// some nots
	@Test
	public void testCNFConverter6() {	
		CNF res = testSimple("not (x==false)");
		assertEquals("[x]", res.toString());
	}

	@Test
	public void testCNFConverter7() {	
		CNF res = testSimple("not (x==false and y == true) ");
		assertEquals("[x+!y]", res.toString());
	}

	@Test
	public void testCNFConverter8() {	
		CNF res = testSimple("not (x==false or y == true) ");
		assertEquals("[x, !y]", res.toString());
	}

	@Test
	public void testCNFConverter9() {	
		CNF res = testSimple("not (x==false or not (z == false or y == true)) ");
		assertEquals("[x, !z+y]", res.toString());
	}
	
	
	CNF testSimple(String constraint){
		String s1="Parameters: Boolean x;  Boolean y;  Boolean z; end \n";
		String s2="Constraints: # " + constraint + " # end";
		StringBuffer model= new StringBuffer("Model \n");
		model.append(s1);
		model.append(s2);
		CitModel m= ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull("null model",m);
		assertEquals(1, m.getConstraints().size());
		CNFConverter cnfConverter = new CNFConverter();
		Rule rule = m.getConstraints().get(0);
		assertNotNull(rule);
		return cnfConverter.convertToCNF((Expression) rule);
	}
	
	@Test
	public void testRecomposeFormula(){
		String s1="Parameters: Boolean x;  Boolean y;  Boolean z; end \n";
		String constraint = "(x==false) or (y == true and z == false)";
		String s2="Constraints: # " + constraint  + " # end";
		StringBuffer model= new StringBuffer("Model \n");
		model.append(s1);
		model.append(s2);
		CitModel m= ModelsFromStringsTester.loadModel(model.toString());
		assertNotNull("null model",m);
		assertEquals(1, m.getConstraints().size());
		OrExpression expr = (OrExpression) m.getConstraints().get(0);
		Expression e1 = expr.getLeft();
		Expression e2 = expr.getRight();
		AndExpression andEx = CitLFactory.eINSTANCE.createAndExpression();
		andEx.setLeft(EcoreUtil2.cloneIfContained(e1));
		andEx.setRight(e2);
		AndExpression andExSup = CitLFactory.eINSTANCE.createAndExpression();
		andExSup.setLeft(e1);
		andExSup.setRight(andEx);
		assertNotNull(andEx.getLeft());
		assertNotNull(andEx.getRight());
		assertNotNull(andExSup.getLeft());
		assertNotNull(andExSup.getRight());		
		
	}
	
	
}
