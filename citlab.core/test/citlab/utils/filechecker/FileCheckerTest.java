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
package citlab.utils.filechecker;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import citlab.utils.filechecker.FileChecker;


public class FileCheckerTest {

	@Test
	public void testEmpty() {
		List<int[]> testSuite = new ArrayList<int[]>();
		FileChecker.checkTestSuite(2, 3, 2, testSuite);
	}
	@Test
	public void testComplete1() {
		List<int[]> testSuite = new ArrayList<int[]>();
		testSuite.add(new int[]{0,0});
		testSuite.add(new int[]{0,1});
		testSuite.add(new int[]{1,0});
		testSuite.add(new int[]{1,1});
		FileChecker.checkTestSuite(2, 2, 2, testSuite);
	}

	@Test
	public void testComplete2() {
		List<int[]> testSuite = new ArrayList<int[]>();
		testSuite.add(new int[]{0,0,0});
		testSuite.add(new int[]{0,1,0});
		testSuite.add(new int[]{1,0,1});
		testSuite.add(new int[]{1,1,0});
		testSuite.add(new int[]{0,1,1});
		FileChecker.checkTestSuite(2, 3, 2, testSuite);
	}

	@Test
	public void testFile1() throws IOException {
		URL file = FileChecker.class.getResource("prova1.txt");
		assertEquals("file", file.getProtocol());
		FileChecker.main(new String[]{file.getFile().toString()});
	}

}
