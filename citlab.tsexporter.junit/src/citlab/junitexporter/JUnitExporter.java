package citlab.junitexporter;

import citlab.core.ext.ICitLabTestSuiteExporter;
import citlab.cvsexporter.CVSExporter;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JUnitExporter extends ICitLabTestSuiteExporter {

	@Override
	public void generateOutput(TestSuite input, String fileName) {
		Path javaFilePath = FileSystems.getDefault().getPath(fileName);
		String csvFileName = fileName.substring(0, fileName.length() - 4) + "csv";
		CVSExporter cvsExporter = new CVSExporter();
		cvsExporter.generateOutput(input, csvFileName);
		String header = getJUnitParamsHeader(input, fileName);
		String annotation = getJunitAnnotation(input, csvFileName);
		try {
			BufferedWriter fileWriter = Files.newBufferedWriter(javaFilePath, StandardCharsets.UTF_8);
			fileWriter.write(header);
			fileWriter.write(annotation);
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Path jsonFilePath = FileSystems.getDefault().getPath(fileName);
//		String fileNameWithoutExtension = fileName.substring(0, fileName.length() - 4);
//		JSONArray ts = createJSONedTestCases(input);
//		JSONObject jsonTestSuite = new JSONObject();
//		jsonTestSuite.put("model", input.getModel().getName());
//		jsonTestSuite.put("strength", input.getStrength());
//		jsonTestSuite.put("algorithm", input.getGeneratorName());
//		jsonTestSuite.put("testCases", ts);
//		Test firstTest = input.getTests().get(0);
//		int numParams = firstTest.getAssignments().size();
//		jsonTestSuite.put("numParams", numParams);
//		for(int i = 0 ; i < numParams; i++) {
//			jsonTestSuite.put("paramName" + i, firstTest.getAssignments().get(i).getParameter().getName());
//		}
//		try {
//			BufferedWriter fileWriter = Files.newBufferedWriter(jsonFilePath, StandardCharsets.UTF_8);
//			fileWriter.write(jsonTestSuite.toJSONString());
//			fileWriter.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	private String getJunitAnnotation(TestSuite input, String csvFileName) {
		StringBuilder pBuilder = new StringBuilder();
		String suffix = "";
		for(Assignment as : input.getTests().get(0).getAssignments()) {
			pBuilder.append(suffix);
			suffix = ",\n";
			pBuilder.append("\t\t\t String ");
			pBuilder.append(as.getParameter().getName().replaceAll("\\W", ""));
		}
		//remove last comma and new line character
		String annotation = "@RunWith(JUnitParamsRunner.class)\n"
				+ "public class SampleClassTest {\n"
				+ "\n"
				+ "\t@Test\n"
				+ "\t@FileParameters(\n"
				+ "value = \"" + csvFileName + "\",\n"
				+ "mapper = CsvWithHeaderMapper.class)\n"
				+ "\tpublic void SampleMethodTest(\n" + pBuilder.toString() + "\n\t\t) {\n\n"
				+ "\t\t//manage SUT setup here\n"
				+ "\t\tassertEquals(true, true);\n"
				+ "\t}\n"
				+ "\n"
				+ "}";
		return annotation;
	}

	private String getJUnitParamsHeader(TestSuite input, String javaFilePath) {
		String header = "package sut;\n\n" 
				+ "import static org.junit.Assert.*;\n"
				+ "import org.junit.Test;\n"
				+ "import org.junit.runner.RunWith;\n"
				+ "import junitparams.*;\n"
				+ "import junitparams.mappers.*;\n"
				+ "\n//This is a sample template\n";
		return header;
	}

	/*
	private JSONArray createJSONedTestCases(TestSuite input) {
		JSONArray ts = new JSONArray();
		JSONArray t;
		for (Test test : input.getTests()) {
			t = new JSONArray();
			for(Assignment ass : test.getAssignments()) {
				t.add(ass.getValue());
			}
			ts.add(t);
		}

		return ts;
	}*/

}
