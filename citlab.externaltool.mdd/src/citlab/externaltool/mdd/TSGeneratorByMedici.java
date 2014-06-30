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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Pair;

import citlab.core.ext.ICitLabTestGenerator;
import citlab.core.genprefs.CitlabIntPreference;
import citlab.core.genprefs.CitlabPreferncesSet;
import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuiteFactory;

/**
 * 
 *
 */
public class TSGeneratorByMedici extends ICitLabTestGenerator {

	private static final String MEDICI_NODE_ID = "medici";

	private static final String EXEC_NAME_WIN = "medici.exe";

	private static final String EXEC_NAME_LINUX = "medici";

	private static final boolean READ_STD_OUT = true;

	private static final String MIN_TRIES = "MIN_TRIES";

	private static final String TRIES = "TRIES";

	private static final String BETTER_TRIES = "BETTER_TRIES";

	private static final String THRESHOLD = "THRESHOLD";

	private static Logger logger = Logger.getLogger(TSGeneratorByMedici.class);

	// options :
	// if < 0 do not use them
	// --mintries [default 1]
	private int mintries;
	// --tries [default 1]
	private int tries;
	// --bettertries
	private int bettertries;
	// --threshold
	private int threshold;
	// --queuecheck
	private boolean queuecheck;
	// if < 0 do not use them
	// --wexp arg set weight exponent over threshold [1]
	private float wexp;
	// --wexp2 arg set weight exponent under threshold [1.5]
	private float wexp2;
	//--nit1 arg            set iterations over threshold [1]
	private int nit1;
	private boolean isUsedStandalone;


	/** default constructor */
	public TSGeneratorByMedici() {
		// init with the default prferences
		super("MEDICI");
		setPreferences();
		isUsedStandalone = false;
	}

	/**
	 * 
	 * @param mintries
	 * @param tries
	 * @param bettertries
	 * @param queuecheck
	 *            - default true, check the queue for early termination
	 * @param wexp
	 *            TODO
	 * @param wexp2
	 *            TODO
	 * @param nit1 TODO
	 */
	public TSGeneratorByMedici(int mintries, int tries, int bettertries,
			boolean queuecheck, int threshold, float wexp, float wexp2, int nit1) {
		super("MEDICI");
		this.mintries = mintries;
		this.tries = tries;
		this.bettertries = bettertries;
		this.threshold = threshold;
		this.wexp = wexp;
		this.wexp2 = wexp2;
		this.nit1 = nit1;
		this.queuecheck = queuecheck;
		isUsedStandalone = true;
	}

	@Override
	public TestSuite call() throws Exception {
		// 1. MODEL
		// convert to temporary file
		File tempModel = File.createTempFile(
				"tmpmodel_" + this.citModel.getName(), ".medici");
		logger.debug("writing the model to " + tempModel.getAbsolutePath());
		// Delete temp file when program exits.
		// tempModel.deleteOnExit();
		ToMediciExporter exporter = new ToMediciExporter();
		BufferedWriter out = new BufferedWriter(new FileWriter(tempModel));
		// get the model in casa
		CharSequence modelS = exporter.convertToStringBuffer(citModel,
				!ignoreConstraints, nWise);
		out.append(modelS);
		out.close();
		//
		File output = runTool(tempModel);
		assert output.exists() : "file " + output.getAbsolutePath()
				+ " not found";
		TestSuite ts = parseResults(output, exporter);

		return ts;
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	private File runTool(File model) throws IOException {
		if (!isUsedStandalone) {
			logger.debug("reading preferences");
			this.genProperties.loadPrefs();
			CitlabIntPreference minTriesPref = (CitlabIntPreference) genProperties
					.getPreferenceByName(MIN_TRIES);
			if (minTriesPref.getIsEnabled()) {
				this.mintries = minTriesPref.getMyValue();
			}
			CitlabIntPreference triesPref = (CitlabIntPreference) genProperties
					.getPreferenceByName(TRIES);
			if (triesPref.getIsEnabled()) {
				this.tries = triesPref.getMyValue();
			}
			CitlabIntPreference betterTriesPref = (CitlabIntPreference) genProperties
					.getPreferenceByName(BETTER_TRIES);
			if (betterTriesPref.getIsEnabled()) {
				this.bettertries = betterTriesPref.getMyValue();
			}
			CitlabIntPreference thresholdPref = (CitlabIntPreference) genProperties
					.getPreferenceByName(THRESHOLD);
			if (thresholdPref.getIsEnabled()) {
				this.threshold = thresholdPref.getMyValue();
			}
			queuecheck = true;
		}
		List<String> command = new ArrayList<String>();
		String mediciExecutable = getMddExecutable();
		assert mediciExecutable != null;
		command.add(mediciExecutable);
		//
		File tempoutput = new File(model.getAbsolutePath() + ".out");
		command.add("--o");
		command.add(tempoutput.getAbsolutePath());
		// model
		command.add("--m");
		command.add(model.getAbsolutePath());
		// add options
		// tries
		if (mintries >= 0)
			command.addAll(Arrays.asList("--mintries",
					Integer.toString(mintries)));
		if (bettertries >= 0)
			command.addAll(Arrays.asList("--bettertries",
					Integer.toString(bettertries)));
		if (tries >= 0)
			command.addAll(Arrays.asList("--tries", Integer.toString(tries)));
		//
		if (!queuecheck)
			command.add("--noqueuecheck");
		// threshold
		if (threshold >= 0)
			command.addAll(Arrays.asList("--threshold",
					Integer.toString(threshold)));
		// exponents for weights
		if (wexp >= 0)
			command.addAll(Arrays.asList("--wexp", Float.toString(wexp)));
		if (wexp2 >= 0)
			command.addAll(Arrays.asList("--wexp2", Float.toString(wexp2)));
		if (nit1 >= 0)
			command.addAll(Arrays.asList("--nit1", Integer.toString(nit1)));
		// run
		ProcessBuilder pc = new ProcessBuilder(command);
		pc.command(command);
		logger.debug("running " + command);
		Process p = pc.start();
		// wait it finishes
		try {
			if (READ_STD_OUT) {
				// redicrect stderr to stout
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

	// executable name
	static String mediciExecName = null;

	// try to get the executable name
	String getMddExecutable() {
		if (mediciExecName == null) {
			mediciExecName = searchMddExecutable();
		}
		assert mediciExecName!= null;
		// assuming that MEDICI IS already set 
		return mediciExecName;
	}
	// try to get the executable name
	// return the name (possibily with path) of medici executable
	protected String searchMddExecutable() {
		// FIRST enstabish the expected name 
		String mediciExec;
		if (System.getProperty("os.name").startsWith("Windows")) {
			mediciExec = EXEC_NAME_WIN;
		} else {
			mediciExec = EXEC_NAME_LINUX;
		}
		try {
			// run as it is in PATH
			String inPath = runMediciHelp(mediciExec);				
			if (inPath != null) return inPath;
			// 
			// search in current Dir
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			logger.debug("searching in current relative path : " + s);
			mediciExec = s + File.separator + mediciExec;
			String withPath = runMediciHelp(mediciExec);
			if (withPath == null) throw new RuntimeException("medici not found");
			return withPath;
		} catch (IOException e) {
			throw new RuntimeException("error when searching medici:" + e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// still assuming that medici is in the path
			return mediciExec;
		}
	}


	private String runMediciHelp(String mediciExec) throws IOException,
			InterruptedException {
		// check if it is in the path
		Process proc = Runtime.getRuntime()
				.exec(mediciExec + " --help");
		int exitVal = proc.waitFor();
		// // 0 mean normal termination
		if (exitVal == 0) {
			logger.debug("found program :" + mediciExec);
			return mediciExec;
		} else {					
			logger.debug("not found program :" + mediciExec);
			return null;
		}
	}

	/**
	 * String execName;
	 * 
	 * if (System.getProperty("os.name").startsWith("Windows")) { execName =
	 * EXEC_NAME_WIN; } else { execName = EXEC_NAME_LINUX; } try { Bundle bundle
	 * = Platform.getBundle("citlab.externaltool.mdd"); URL url =
	 * FileLocator.resolve(FileLocator.find(bundle, new Path( execName),
	 * Collections.EMPTY_MAP)); logger.debug(execName + " found in bundle as " +
	 * url.getPath());
	 * 
	 * //using PosixFilePermission to set file permissions 777
	 * Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
	 * //add owners permission perms.add(PosixFilePermission.OWNER_READ);
	 * perms.add(PosixFilePermission.OWNER_WRITE);
	 * perms.add(PosixFilePermission.OWNER_EXECUTE); //add group permissions
	 * perms.add(PosixFilePermission.GROUP_READ);
	 * perms.add(PosixFilePermission.GROUP_WRITE);
	 * perms.add(PosixFilePermission.GROUP_EXECUTE); //add others permissions
	 * perms.add(PosixFilePermission.OTHERS_READ);
	 * perms.add(PosixFilePermission.OTHERS_WRITE);
	 * perms.add(PosixFilePermission.OTHERS_EXECUTE);
	 * Files.setPosixFilePermissions(Paths.get(url.getPath()), perms);
	 * 
	 * return url.getPath(); } catch (Throwable e) { logger.debug(execName +
	 * " not found in bundle, taking the simple executing medici with simple name"
	 * ); return execName; }
	 */

	private TestSuite parseResults(File output, ToMediciExporter exporter)
			throws FileNotFoundException {
		assert exporter != null;
		assert exporter.convInt != null;
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
				// convert from int to parameter and value
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
		ts.setModel(citModel);
		return ts;
	}

	private void setPreferences() {
		genProperties = new CitlabPreferncesSet(MEDICI_NODE_ID);
		// --mintries arg set mintries [1]
		// --tries arg set max tries [1]
		// --bettertries arg set number of better tries [1]
		// --threshold arg set threshold [2000]

		CitlabIntPreference mintries = new CitlabIntPreference(MIN_TRIES);
		mintries.setMyValue(1);
		genProperties.add(mintries);
		CitlabIntPreference retries = new CitlabIntPreference(TRIES);
		retries.setMyValue(1);
		genProperties.add(retries);
		CitlabIntPreference betterTries = new CitlabIntPreference(BETTER_TRIES);
		betterTries.setMyValue(1);
		genProperties.add(betterTries);
		CitlabIntPreference threshold = new CitlabIntPreference(THRESHOLD);
		threshold.setMyValue(2000);
		genProperties.add(threshold);

		// load - if no prop is stored, take the default value
		genProperties.loadPrefs();
		// store the prferences
		genProperties.storePrefs();
	}

}
