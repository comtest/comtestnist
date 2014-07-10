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
package citlab.core.ext;

/** an alternative editor in the CitLab platform 
 * Author: Wayman Tan
 */

public abstract class ICitLabAlternativeEditor {
	/** Create a new file and open the 
	 *  default editor for that file
	 * 
	 * @param newFileName
	 * @return
	 */
	public abstract void openEditor (String newFileName);

	
}
