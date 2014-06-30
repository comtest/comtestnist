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
package citlab.CoderToCasa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osgi.framework.Bundle;

import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.genprefs.CitlabDoublePreference;
import citlab.core.genprefs.CitlabIntPreference;
import citlab.core.genprefs.CitlabPreference;
import citlab.core.genprefs.CitlabPreferncesSet;
import citlab.externaltool.casa.ToCasaParametersExporter;
import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;

/**
 * Generator the C.A.S.A. algorithms.
 * 
 */
public class TSGeneratorByCasa extends ICitLabTestGenerator {

	private static final String P_PARTITION = "-p (partition)";

	private static final String R_RETRIES = "-r (retries)";

	private static final String I_ITERATIONS = "-i (iterations)";

	private static final boolean READ_STD_OUT = true;

	private static Logger logger = Logger.getLogger(TSGeneratorByCasa.class);

	public TSGeneratorByCasa() {
		super("CASA");
		setPreferences();
	}

	private void setPreferences() {
		genProperties = new CitlabPreferncesSet("casa");
		// `-i, --iterations'
		// When one-sided narrowing is enabled (see BUILDING, above) CASA can
		// adjust the iteration limit automatically at run-time. Therefore,
		// unless you pass a very small value for the problem CASA will usually
		// grow the iteration limit to match the problem, mostly independent of
		// this parameter. However CASA will never decrease the limit, so an
		// especially large value will make CASA spend more effort early on in
		// the search.

		CitlabIntPreference iterations = new CitlabIntPreference(
				I_ITERATIONS);
		// default value is 256 see Usage.C
		iterations.setMyValue(256);
		genProperties.add(iterations);
		/*
		 * -r, --retries' As described in the paper this option controls how
		 * persistently CASA repeats binary searches when one-sided narrowing is
		 * enabled. Consequently, it can have a significant impact on run-time,
		 * though the benefits for the final array size seem to drop off after
		 * two retries.
		 */
		CitlabIntPreference retries = new CitlabIntPreference(R_RETRIES);
		// default value is 256 see Usage.C
		retries.setMyValue(2);
		genProperties.add(retries);
		/*
		 * `-p, --partition' The partition controls how cautiously CASA tries to
		 * reach its guess at the minimum array size; the less this value the
		 * more aggressive CASA is. In general the partition ratio should be
		 * larger when you suspect that the lower bound is more conservative.
		 */
		CitlabDoublePreference partition = new CitlabDoublePreference(
				P_PARTITION);
		// default value is 2/3
		partition.setMyValue(2.0 / 3.0);
		genProperties.add(partition);

		// load - if no prop is stored, take the default value
		genProperties.loadPrefs();
		// store the prferences
		genProperties.storePrefs();
	}

	@Override
	public TestSuite call() throws Exception {
		// 1. MODEL
		// convert to temporary file
		File tempModel = File.createTempFile(
				"casamodel_" + this.citModel.getName(), ".citmodel");
		logger.debug("writing the model to " + tempModel.getAbsolutePath());
		// Delete temp file when program exits.
		// tempModel.deleteOnExit();
		ToCasaExporter exporter = new ToCasaExporter();
		exporter.init(citModel);
		ToCasaParametersExporter mygen = new ToCasaParametersExporter();
		BufferedWriter out = new BufferedWriter(new FileWriter(tempModel));
		// get the model in casa
		CharSequence modelS = mygen.toCasaCode(citModel, nWise);
		out.append(modelS);
		out.close();
		//
		// 2. the constraints
		File output;
		// write the constraints
		if (!ignoreConstraints && !citModel.getConstraints().isEmpty()) {
			File tempConstr = File.createTempFile(
					"casamodel" + this.citModel.getName(), ".constraints");
			logger.debug("writing the constraints to "
					+ tempConstr.getAbsolutePath());
			// Write to temp file
			out = new BufferedWriter(new FileWriter(tempConstr));
			CharSequence constraints = exporter.translateConstraints();
			assert constraints != null;
			out.append(constraints);
			out.close();
			//
			output = runTool(tempModel, tempConstr);
		} else {
			output = runTool(tempModel, null);
		}
		// parse the results
		TestSuite ts = parseResults(output, exporter);
		// set the model
		ts.setModel(citModel);
		return ts;
	}

	/**
	 * run CASA as external tool
	 * 
	 * @param model
	 *            file for the model
	 * @param constraints
	 *            file containing the constraints (null if none)
	 * @return the file containing the test suite
	 * @throws IOException
	 */
	private File runTool(File model, File constraints) throws IOException {
		//
		List<String> command = new ArrayList<String>();
		String casaExecutable = getCasaExecutable();
		command.add(casaExecutable);
		// output}
		File tempoutput = File.createTempFile(
				"casaoutput" + this.citModel.getName(), ".txt");
		command.add("--output");
		command.add(tempoutput.getAbsolutePath());
		// constraints
		if (constraints != null) {
			command.add("--constrain");
			command.add(constraints.getAbsolutePath());
		}
		// add all the prewference
		if (this.genProperties != null) {
			this.genProperties.loadPrefs();
			// set the test generation profile
			// randomize don't care values
			for (CitlabPreference<?> p : this.genProperties) {
				if (p.getName().equals(I_ITERATIONS) && p.getIsEnabled()) {
					command.add("-i");
					command.add(p.getMyValue().toString());
				}
				if (p.getName().equals(R_RETRIES) && p.getIsEnabled()) {
					command.add("-r");
					command.add(p.getMyValue().toString());
				}
				if (p.getName().equals(P_PARTITION) && p.getIsEnabled()) {
					command.add("-p");
					command.add(p.getMyValue().toString());
				}
			}
		}

		// model
		command.add(model.getAbsolutePath());
		// run
		ProcessBuilder pc = new ProcessBuilder(command);
		pc.command(command);
		logger.debug("running " + command);
		Process p = pc.start();
		// wait it finishes
		try {
			if (READ_STD_OUT) {
				// redirect stderr to stout
				pc.redirectErrorStream();
				BufferedReader bri = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				String line;
				while ((line = bri.readLine()) != null) {
					System.out.println(line);
				}
				bri.close();
			}
			p.waitFor();
			logger.debug("command finished ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempoutput;
	}

	// try to get the executable name
	private String getCasaExecutable() {
		String execName;
		if (System.getProperty("os.name").startsWith("Windows")) {
			execName = "cover.exe";
		} else {
			execName = "cover";
		}
		try {
			Bundle bundle = Platform.getBundle("citlab.externaltool.casa");
			URL url = FileLocator.resolve(FileLocator.find(bundle, new Path(
					execName), Collections.EMPTY_MAP));
			logger.debug("cover found in bundle as " + url.getPath());
			System.out.println(url.getPath());
			 Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
		        //add owners permission
		        perms.add(PosixFilePermission.OWNER_READ);
		        perms.add(PosixFilePermission.OWNER_WRITE);
		        perms.add(PosixFilePermission.OWNER_EXECUTE);
		        //add group permissions
		        perms.add(PosixFilePermission.GROUP_READ);
		        perms.add(PosixFilePermission.GROUP_WRITE);
		        perms.add(PosixFilePermission.GROUP_EXECUTE);
		        //add others permissions
		        perms.add(PosixFilePermission.OTHERS_READ);
		        perms.add(PosixFilePermission.OTHERS_WRITE);
		        perms.add(PosixFilePermission.OTHERS_EXECUTE);
		        
		        Files.setPosixFilePermissions(Paths.get(url.getPath()), perms);
			return url.getPath();
		} catch (Throwable e) {
			logger.debug("cover not found in bundle, taking the simple executing cover with simple name");
			return execName;
		}
	}

	private TestSuite parseResults(File output, ToCasaExporter exporter)
			throws FileNotFoundException {
		TestSuite ts = TestsuiteFactory.eINSTANCE.createTestSuite();
		Scanner sc = new Scanner(output);
		assert output != null;
		assert output.canRead();
		int numberOfTests = sc.nextInt();
		sc.nextLine(); // skip line this very line
		logger.debug("reading " + numberOfTests + " tests from "
				+ output.getAbsolutePath());
		for (int i = 0; i < numberOfTests; i++) {
			String testS = sc.nextLine().trim();
			logger.debug("reading line " + i + " " + testS);
			// convert test to a single test
			Test test = TestsuiteFactory.eINSTANCE.createTest();
			String[] assignements = testS.split(" ");
			for (String s : assignements) {
				assert s.length() > 0 : "line " + testS;
				// covert s to int
				int aNum = Integer.parseInt(s);
				// convert from int to paramter and value
				Pair<Parameter, String> singleA = exporter.convInt
						.convertInt(aNum);
				Assignment assi = TestsuiteFactory.eINSTANCE.createAssignment();
				assi.setParameter(singleA.getKey());
				assi.setValue(singleA.getValue());
				test.getAssignments().add(assi);
			}
			ts.getTests().add(test);
		}
		sc.close();
		return ts;
	}

}
