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
package citlab.core.util;

import java.util.ArrayList;
import java.util.List;

import citlab.model.citL.BoolAssign;
import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.util.Utils.Pair;

public class AlwaysTrueFilter {
	public List<List<Pair<Parameter, ?>>> RemoveImmutableAssignment(
			CitModel model, List<List<Pair<Parameter, ?>>> pairs) {
		List<List<Pair<Parameter, ?>>> partial = new ArrayList<>();
		partial = pairs;
		List<List<Pair<Parameter, ?>>> toRemove = new ArrayList<List<Pair<Parameter, ?>>>();
		for (Rule e : model.getConstraints()) {
			if (e instanceof BoolAssign) {

				for (List<Pair<Parameter, ?>> pair : pairs) {
					if (pair.get(0).getFirst().getName().equals( ((BoolAssign) e)
							.getLeft().getName())) {
						toRemove.add(pair);

					}

				}

			}
		}
		System.out.println("SIZE TO REMOVE " + toRemove.size());
		partial.removeAll(toRemove);
		System.out.println("ELEMENT SIZE " + partial.size());
		return partial;
	}

}
