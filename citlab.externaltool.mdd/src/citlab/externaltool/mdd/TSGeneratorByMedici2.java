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
package citlab.externaltool.mdd;


/**
 * executes medi2 instead of medici
 *
 */
public class TSGeneratorByMedici2 extends TSGeneratorByMedici {
	
	public TSGeneratorByMedici2(){
		super(-1,-1,-1,true,-1,-1,-1, 200);
	}
	
	protected String searchMddExecutable() {
		return "medici2.exe";
	}
}
