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
package citlab.model.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

import citlab.model.util.TupleIterator;

public class TupleIteratorTest {

	@Test
	public void testHasNext() {
		/**
		 * Test program. The program takes any number of command line arguments,
		 * each of which represents a collection. A collection is represented as
		 * a whitespace-separated list of elements (so it must be put in quotes,
		 * or else it will be broken into separate command line arguments by the
		 * shell). The program should print out all the tuples that can be
		 * formed from these collections. For example: <blockquote> <code>
		 * &gt; java -cp . common.TupleIterator "a b" "c d"   <br>
		 * [a, c]      <br>
		 * [a, d]      <br>
		 * [b, c]      <br>
		 * [b, d]
		 * </code> </blockquote>
		 */
		String[] args = { "a b c", "d e f" };
		List collections = new ArrayList();
		for (int i = 0; i < args.length; ++i) {
			List curColl = new ArrayList();
			for (StringTokenizer tok = new StringTokenizer(args[i]); tok
					.hasMoreTokens();) {
				curColl.add(tok.nextToken());
			}
			collections.add(curColl);
		}

		for (Iterator iter = new TupleIterator(collections); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}

}
