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
package citlab.acts;

import java.util.ArrayList;
import citlab.model.citL.Rule;
import citlab.model.citL.util.CitLSwitch;
import edu.uta.cse.fireeye.common.Parameter;

/** returns the list of Parameters in a constraint
 * TODO to implemenst - now returns the null
 * @author garganti
 *
 */ 
public class ACTSParamsInConstraintFinder extends CitLSwitch<ArrayList<Parameter>>{
	
	// Constraint to be abalyzed
	Rule constr;
	
	ACTSParamsInConstraintFinder(Rule c){
		constr = c;
	}
	
}
