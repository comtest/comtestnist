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
package citlab.model.ui.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution.DefaultComparator;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

import citlab.model.citL.CitLPackage;


public class CitLOutlineNodeComparator extends DefaultComparator {
    @Override
    public int getCategory(IOutlineNode node) {
        if (node instanceof EObjectNode) 
            switch(((EObjectNode) node).getEClass().getClassifierID()) { 
            case CitLPackage.CONSTANT:
            	return 1;
            case CitLPackage.ENUMERATIVE_TYPE:   
                return 10;
            case CitLPackage.BOOLEAN:    
                return 20;
            case CitLPackage.NUMBERS:    
                return 30;
            case CitLPackage.RANGE:    
                return 40;
            case CitLPackage.ENUMERATIVE:    
                return 50;
            case CitLPackage.SEED:    
                return 60;
            }
        return 90;
    }
}
