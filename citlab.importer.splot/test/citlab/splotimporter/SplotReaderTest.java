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
package citlab.splotimporter;

import org.junit.Test;

import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.RootNode;
import splar.core.fm.SolitaireFeature;
import citlab.core.ext.NotImportableException;

public class SplotReaderTest {

	@Test
	public void testImportModel() throws NotImportableException, FeatureModelException {
		SplotImporter splotimport = new SplotImporter();
		splar.core.fm.FeatureModel m = splotimport.getSplotModel("models/example1FeatureIde.xml");
		traverseDFS(m.getRoot(), 0);
	}
	
	void traverseDFS(FeatureTreeNode node, int tab) {
		for( int j = 0 ; j < tab ; j++ ) {
			System.out.print('\t');
		}
		// Root Feature
		if ( node instanceof RootNode ) {
			System.out.print("Root");
		}
		// Solitaire Feature
		else if ( node instanceof SolitaireFeature ) {
			// Optional Feature
			if ( ((SolitaireFeature)node).isOptional())
				System.out.print("Optional");
			// Mandatory Feature
			else
				System.out.print("Mandatory");
		}
		// Feature Group
		else if ( node instanceof FeatureGroup ) {
			int minCardinality = ((FeatureGroup)node).getMin();
			int maxCardinality = ((FeatureGroup)node).getMax();
			System.out.print("Feature Group[" + minCardinality + "," + maxCardinality + "]"); 
		}
		// Grouped feature
		else {
			System.out.print("Grouped");
		}
		System.out.print( "(ID=" + node.getID() + ", NAME=" + node.getName() + ")\r\n");
		for( int i = 0 ; i < node.getChildCount() ; i++ ) {
			traverseDFS((FeatureTreeNode )node.getChildAt(i), tab+1);
		}
	}
	
	void traverseConstraints(FeatureModel featureModel) {
		for( PropositionalFormula formula : featureModel.getConstraints() ) {
			System.out.println(formula);			
		}
	}
}
