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

import citlab.model.citL.BoolAssign;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numbers;

/** search an element (of an enumerative type) in a constraint
 *
 */
public class ElementInRule extends InRule {
	
	private Element element;

	ElementInRule(Element p){
		assert p != null;
		element = p;
	}
	
	@Override
	public Boolean caseEnumAssign(EnumAssign object) {
		return object.getRight() == element;
	}

	@Override
	public Boolean caseBoolAssign(BoolAssign object) {
		// an element is never in a BoolAssign
		return false;
	}
	
	@Override
	public Boolean caseNumberLiteral(NumberLiteral object) {
		return false;
	}

	@Override
	public Boolean caseNumbers(Numbers object) {
		// an element will never be an element
		return false;
	}
	
}
