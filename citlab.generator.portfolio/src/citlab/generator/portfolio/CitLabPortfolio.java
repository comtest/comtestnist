package citlab.generator.portfolio;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import citlab.core.ext.ICitLabTestGenerator;
import citlab.model.citL.CitModel;
import citlab.model.util.Utils.Pair;
import citlab.testsuite.TestSuite;

/**
 * compare the generation and produces a file for wiki google
 * 
 * @author Paolo Vavassori
 * 
 */
public class CitLabPortfolio {

	private static final int NRuns = 5;

	//

	public void run(List<Pair<ICitLabTestGenerator, CitModel>> generators) {

		// do not validate the models
		// ModelsFromFilesUtils.VALIDATE = false;
		// init the file where to save
		PrintStream fileStdOutput = null;
		try {
			fileStdOutput = new PrintStream(new BufferedOutputStream(
					new FileOutputStream("results.txt")));
			printInfo(fileStdOutput);
			// print header of table
			fileStdOutput.print("|| *model* \t");
			fileStdOutput.print("|| *generator* \t");
			fileStdOutput.print("|| *time avg.*\t");
			fileStdOutput.print("|| *time stddev.*\t");
			fileStdOutput.print("|| *size avg.*\t");
			fileStdOutput.print("|| *size stddev.*\t");
			fileStdOutput.println("||");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Map<String, Pair<Double, Double>> dataSizeTime = new HashMap<>();
		for (Pair<ICitLabTestGenerator, CitModel> generator : generators) {
			String name = generator.getSecond().getName();
			dataSizeTime.put(name, new Pair<Double, Double>(0.0, 0.0));
		}


		
		try {
			generate(generators, NRuns, fileStdOutput, dataSizeTime);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// print results
		fileStdOutput
				.print("\nsummary over the specs correclty solved by all the generators\n");
		fileStdOutput
				.print("||generator || sum mean of size || sum mean of time ||\n");
		for (Iterator<Entry<String, Pair<Double, Double>>> iterator = dataSizeTime
				.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, Pair<Double, Double>> e = iterator.next();
			fileStdOutput.print("|| " + e.getKey() + " || "
					+ e.getValue().getFirst() + " || "
					+ e.getValue().getSecond() + " ||\n");
		}
		//
		fileStdOutput.close();
	}

	private static void printInfo(PrintStream fileStdOutput) {
		// header
		fileStdOutput.println("=== benchmarking with constraints===\n");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		fileStdOutput.println("`date of execution: " + dateFormat.format(date)
				+ "`\n");
		fileStdOutput.println("`number of runs: " + NRuns + "`\n");
		//
		fileStdOutput
				.println("`CASA: Covering Arrays by Simulated Annealing (CASA) 1.1`\n");
		fileStdOutput.println("`ACTS: acts_cmd_beta_v2_r2.8.jar`\n");
		fileStdOutput
				.println("`medici: v1: (20, 25, 5, 200) - v2: (30, 50, 10, 500)`\n");
	}

	static final String URL = "||[http://code.google.com/a/eclipselabs.org/p/citlab/source/browse/trunk/citlab.benchmarks/constrained/%s.citl %s]";
	static final String data = "\t||%g||%g\t";

	// generate

	private void generate(
			List<Pair<ICitLabTestGenerator, CitModel>> generators, int nt,
			PrintStream output, Map<String, Pair<Double, Double>> dataSizeTime)
			throws InterruptedException {
		// write model name
		output.print(String.format(URL,
				generators.get(0).getSecond().getName(), generators.get(0)
						.getSecond().getName()));
		double[] sizes = new double[nt];
		double[] times = new double[nt];
		boolean first = true;
		//
		Map<String, Pair<Double, Double>> dataRun = new HashMap<>();
		// generate
		for (Pair<ICitLabTestGenerator, CitModel> generator : generators) {
			boolean error = false;
			if (first)
				first = false;
			else
				// skip first column
				output.print("||\t");
			output.print("|| " + generator.getSecond());
			for (int i = 0; i < nt; i++) {
				System.out.println("**** model "
						+ generator.getSecond().getName() + " run: " + i
						+ " generator: " + generator.getSecond());
				try {
					ICitLabTestGenerator gen = generator.getFirst();
					assert gen != null;
					TestSuite test = gen.generateTestsAndInfo(
							generator.getSecond(), false, true, true, 2);
					sizes[i] = test.getTests().size();
					times[i] = test.getGeneratorTime();
				} catch (Throwable e) {
					output.print("\t|| ERROR " + e.getClass() + "||");
					error = true;
					e.printStackTrace();
					break;
				}
			}
			if (!error) {
				// time
				Statistics timesS = new Statistics(times);
				double meanTime = timesS.getMean();
				output.print(String.format(data, meanTime, timesS.getStdDev()));
				// size
				Statistics sizesS = new Statistics(sizes);
				double meanSize = sizesS.getMean();
				output.print(String.format(data, meanSize, sizesS.getStdDev()));
				dataRun.put(generator.getSecond().getName(), new Pair<Double, Double>(
						meanSize, meanTime));

			}
			output.println("||");
			output.flush();
			Thread.sleep(1000);
		}
		// add this data if alla completed
		if (dataRun.entrySet().size() == generators.size()) {
			for (Pair<ICitLabTestGenerator, CitModel> generator : generators) {
				String name = generator.getSecond().getName();
				Pair<Double, Double> tillNow = dataSizeTime.get(name);
				Pair<Double, Double> pair = dataRun.get(name);
				dataSizeTime.put(
						name,
						new Pair<Double, Double>(tillNow.getFirst()
								+ pair.getFirst(), tillNow.getSecond()
								+ pair.getSecond()));
			}
		}
		return;
	}
}
