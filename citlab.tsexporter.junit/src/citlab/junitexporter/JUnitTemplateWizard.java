/**
 * 
 */
package citlab.junitexporter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.internal.junit.wizards.NewTestCaseCreationWizard;
import org.eclipse.jdt.junit.wizards.NewTestCaseWizardPageOne;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;

/**
 * @author sudhi
 *
 */
@SuppressWarnings("restriction")
public class JUnitTemplateWizard extends NewTestCaseCreationWizard {

	private TestSuite testSuite;
	private String osSafeCsvFilePath;
	private Pattern importPattern = Pattern.compile("^import.*");
	private Pattern classPattern = Pattern.compile("^public (static )?class.*");
	private Pattern methodPattern = Pattern.compile("^(\\s*).+ (test\\w*)\\(\\) \\{$");
	private String newLine = System.getProperty("line.separator");

	public JUnitTemplateWizard(IWorkbench workbench,
			TestSuite testSuite, String osSafeCsvFilePath) {
		super();
		if(this.getSelection() == null) {
			this.init(workbench, StructuredSelection.EMPTY);
		} else {
			this.init(workbench, this.getSelection());
		}

		this.testSuite = testSuite;
		this.osSafeCsvFilePath = osSafeCsvFilePath;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		Field pageField = null;
		Object pageValue = null;
		NewTestCaseWizardPageOne page = null;
		try {
			pageField = NewTestCaseCreationWizard.class.getDeclaredField("fPage1");
			pageField.setAccessible(true);
			pageValue = pageField.get(this);
			pageField.setAccessible(false);
			if (pageValue == null) {
				throw new RuntimeException("can not set junit4");
			} else {
				page = (NewTestCaseWizardPageOne) pageValue;
			}
			page.setJUnit4(true, false);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			System.out.println("check field name of super class");
			e1.printStackTrace();
		}
	}

	@Override
	protected void openResource(final IResource resource) {
		//original code
		if (resource.getType() == IResource.FILE) {
			final IWorkbenchPage activePage = JUnitPlugin.getActivePage();
			if (activePage != null) {
				final Display display = Display.getDefault();
				if (display != null) {
					display.asyncExec(new Runnable() {
						public void run() {
							try {

								//just before opening the IFile
								//read it line by line, and do some regex magic
								//to insert 'import junitparams.*; and other stuff'
								insertJunitParamsAnnotation((IFile) resource);

								IDE.openEditor(activePage, (IFile)resource, true);
							} catch (PartInitException e) {
								JUnitPlugin.log(e);
							}
						}
					});
				}
			}
		}
	}

	/**
	 * This method essentially parses the generated JUnit Test Case template
	 * and inserts annotations and statements for junitparams.
	 * It also modifies any test methods with FileParameters annotation and adds
	 * parameter names (with type String) to the method declaration.
	 * @param resource the generated java template file from super JUnitWizard
	 * @return
	 */
	protected void insertJunitParamsAnnotation(IFile resource) {
		
		//declare variables
		String line = null;
		File tmpFile = null;
		Charset cs = null;
		Scanner in = null;
		BufferedWriter out = null;
		boolean importStatementsAdded = false;
		boolean runWithAdded = false;
		boolean fileParametersAdded = false;
		//initialize them
		try {
			cs = Charset.forName(resource.getCharset());
			in = new Scanner(
					new BufferedReader(
							new InputStreamReader(resource.getContents(), cs)
							)
					);
			
			tmpFile = File.createTempFile("tmpJunitTemplate", ".tmp");
			out = new BufferedWriter(new FileWriter(tmpFile));

			//read line by line
			while (in.hasNextLine()) {
				line = in.nextLine();

				//insert junitparams import statements before the first import
				if(importPattern.matcher(line).matches() && (! importStatementsAdded)) {
					insertImportStatements(out, line);
					importStatementsAdded = true;
					
				//insert the @RunWith annotation before class declaration
				} else if(classPattern.matcher(line).matches() && (! runWithAdded)) {
					insertRunWithAnnotation(out, line);
					runWithAdded = true;

				//for any @Test annotated method replace with our template
				} else if(methodPattern.matcher(line).matches()) {
					insertFileParameters(out, line);
					fileParametersAdded = true;
					while(! in.nextLine().matches("^\\s*\\}$")) {
						//do nothing and skip the method declaration
					}

				//in case we didn't find any methods, append a sample test method
				} else if((! in.hasNextLine()) && (! fileParametersAdded)) {
					appendSampleTestMethod(out, line);

				//write out normal lines as it is
				} else {
					out.write(line);
					out.newLine();
				}

			}

			//done inserting the annotations, now close the output writer
			out.close();
			//now simply move the tmp file to the original file path
			if(resource.getLocation() != null) {
				tmpFile.renameTo(resource.getLocation().toFile());
			};

		} catch (Exception e) {
			JUnitPlugin.log(e);
		} finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// ignore
					JUnitPlugin.log(e);
				}
			}
		}
	}

	/**
	 * Writes a sample test method with FileParameters annotation and with test method
	 * declaration to include parameter names (type String) from the TestSuite.
	 * @param out
	 * @param lastLine
	 * @throws IOException
	 */
	private void appendSampleTestMethod(BufferedWriter out, String lastLine)
			throws IOException {

		StringBuffer sb = new StringBuffer();
		sb.append("\t// Sample test method that uses the parameters:").append(newLine)
		  .append("\t@Test").append(newLine)
		  .append("\t@FileParameters(").append(newLine)
		  .append("\t\t\t\tvalue = \"")
		  .append(osSafeCsvFilePath).append("\", ").append(newLine)
		  .append("\t\t\t\tmapper = CsvWithHeaderMapper.class)").append(newLine)
		  .append("\tpublic void testSampleMethod(").append(newLine);

		//set suffix to empty before the loop, then set it inside
		//this avoids the extra dangling suffix after iteration is done
		String suffix = "";
		String commaNewLine = "," + newLine;

		//use a string builder to iterate over the parameter names
		for(Assignment as : testSuite.getTests().get(0).getAssignments()) {
			sb.append(suffix);
			suffix = commaNewLine;
			sb.append("\t\t\t\t").append("String ");
			sb.append(as.getParameter().getName().replaceAll("\\W", ""));
		}

		sb.append(newLine).append("\t) {").append(newLine);
		sb.append("\t\tfail(\"Not yet implemented\");").append(newLine);
		sb.append("\t}").append(newLine);

		//append the sample template
		out.write(sb.toString());
		out.newLine();
		out.write(lastLine);
	}

	private void insertFileParameters(BufferedWriter out, String capturedLine)
			throws IOException {

		//next get the indent level, triple it as prefix for writing parameters
		Matcher m = methodPattern.matcher(capturedLine);
		m.matches();
		String indent = m.group(1);
		String methodName = m.group(2);
		String prefix = indent + indent + indent;

		//next use a string builder to create the annotation
		StringBuilder sbParams = new StringBuilder();
		sbParams.append(indent).append("@FileParameters(").append(newLine);
		sbParams.append(prefix).append("value = \"");
		sbParams.append(osSafeCsvFilePath).append("\",").append(newLine);
		sbParams.append(prefix).append("mapper = ");
		sbParams.append("CsvWithHeaderMapper.class").append(")").append(newLine);

		//First write down the method declaration as it is except the closing parenthesis
		//e.g. "public final void testFooBar() {" gets written as
		//     "public final void testFooBar("
		String methodDeclaration = capturedLine.substring(0, capturedLine.length() - 4);
		sbParams.append(methodDeclaration).append("(").append(newLine);

		//create a separate string builder to write the result exporter
		String resultExporterName = "sb"
							       + Character.toUpperCase(methodName.charAt(0))
							       + methodName.substring(1)
							       + "Results";
		StringBuilder sbExport = new StringBuilder();
		sbExport.append(indent).append(indent).append(resultExporterName).append(newLine);

		//the suffix for params is ",\n" i.e. comma and then next parameter on next line
		//e.g. "public final void testFooBar(
		//                   String foo,
		//                   String bar,
		//                   String baz
		//             ) {"
		String commaNewLine = "," + newLine;
		//the suffix for export is '.append(", ")' i.e. append and then next parameter on next line
		//e.g. "sbTestResults
		//			.append(foo).append(", ")
		//			.append(bar).append(", ")
		//			.append(baz).append(", ")
		//          ;
		String dotAppendCommaNewLine = ".append(\", \")" + newLine;

		//set suffix to empty before the loop, then set it inside
		//this avoids the extra dangling suffix after iteration is done
		String exportSuffix = "";
		String paramSuffix = "";

		//use a string builder to iterate over the parameter names
		//and build the params list as well as result export list
		String paramName = "";
		for(Assignment as : testSuite.getTests().get(0).getAssignments()) {
			sbParams.append(paramSuffix);
			sbExport.append(exportSuffix);
			paramSuffix = commaNewLine;
			exportSuffix = dotAppendCommaNewLine;
			paramName = as.getParameter().getName().replaceAll("\\W", "");
			sbParams.append(prefix).append("String ");
			sbParams.append(paramName);
			sbExport.append(prefix).append(".append(");
			sbExport.append(paramName).append(")");
		}

		//after parameter names, close the parenthesis on next line at double indent
		sbParams.append(newLine).append(indent).append(indent).append(") {").append(newLine);
		//then write out the export buffer append statements
		sbParams.append(sbExport.toString()).append(";").append(newLine);
		sbParams.append(indent).append(indent).append("//test your class here").append(newLine);
		sbParams.append(indent).append(indent).append("assertTrue(true);").append(newLine);
		//then close the method declaration
		sbParams.append(indent).append("}").append(newLine).append(newLine);
		//and declare the private static buffer to hold the results
		sbParams.append(indent).append("private static StringBuffer ").append(resultExporterName);
		sbParams.append(" = new StringBuffer();").append(newLine).append(newLine);
		//append the after class annotation
		sbParams.append(indent).append("@AfterClass").append(newLine);
		sbParams.append(indent).append("public static void exportCsvResult() throws IOException {").append(newLine);
		sbParams.append(indent).append(indent).append("BufferedWriter resultWriter = Files.newBufferedWriter(").append(newLine);
		sbParams.append(indent).append(indent).append(indent);
		sbParams.append("Paths.get(\"").append(osSafeCsvFilePath.substring(0, osSafeCsvFilePath.length() - 4));
		sbParams.append("_Results.csv\"),").append(newLine);
		sbParams.append(indent).append(indent).append(indent);
		sbParams.append("Charset.defaultCharset());").append(newLine);
		sbParams.append(indent).append(indent).append("resultWriter.write(\"");
		paramName = "";
		paramSuffix = "";
		for(Assignment as : testSuite.getTests().get(0).getAssignments()) {
			sbParams.append(paramSuffix);
			paramSuffix = ", ";
			paramName = as.getParameter().getName();
			sbParams.append(paramName);
		}
		//add the result column
		sbParams.append(", TestResult\");").append(newLine);
		sbParams.append(indent).append(indent).append("resultWriter.newLine();").append(newLine);
		sbParams.append(indent).append(indent).append("resultWriter.write(");
		sbParams.append(resultExporterName).append(".toString());").append(newLine);
		sbParams.append(indent).append(indent).append("resultWriter.close();").append(newLine);
		sbParams.append(indent).append("}").append(newLine).append(newLine);

		sbParams.append(indent).append("@Rule").append(newLine);
		sbParams.append(indent).append("public static TestWatcher addCsvResult = new TestWatcher() {").append(newLine);
		sbParams.append(indent).append(indent).append("@Override").append(newLine);
		sbParams.append(indent).append(indent).append("protected void succeeded(Description description) {").append(newLine);
		sbParams.append(indent).append(indent).append(indent).append(resultExporterName).append(".append(\", Passed\")").append(newLine);
		sbParams.append(indent).append(indent).append(indent).append(indent).append(".append(System.getProperty(\"line.separator\"));").append(newLine);
		sbParams.append(indent).append(indent).append("}").append(newLine);

		sbParams.append(indent).append(indent).append("@Override").append(newLine);
		sbParams.append(indent).append(indent).append("protected void failed(Throwable e, Description description) {").append(newLine);
		sbParams.append(indent).append(indent).append(indent).append(resultExporterName).append(".append(\", Failed\")").append(newLine);
		sbParams.append(indent).append(indent).append(indent).append(indent).append(".append(System.getProperty(\"line.separator\"));").append(newLine);
		sbParams.append(indent).append(indent).append("}").append(newLine);
		sbParams.append(indent).append("};").append(newLine).append(newLine);

		//done building parameter names, now write it out to the file
		out.write(sbParams.toString());
	}

	private void insertRunWithAnnotation(BufferedWriter out, String capturedLine)
			throws IOException {

		//we write the "@RunWith" annotation before the class declaration
		out.write("@RunWith(JUnitParamsRunner.class)");
		out.newLine();

		//then write out the capturedLine containing class declaration
		out.write(capturedLine);
		out.newLine();
	}

	private void insertImportStatements(BufferedWriter out, String capturedLine)
			throws IOException {
		out.newLine();
		out.write("//Add citlab.tsexporter.junit to required bundles "
				+ "by selecting fix project setup");
		out.write("//Or add JUnitParams-1.0.2.jar to your build path");
		out.write("//You can download it from: https://code.google.com/p/junitparams/");
		out.newLine();
		out.write("import junitparams.JUnitParamsRunner;");
		out.newLine();
		out.write("import junitparams.FileParameters;");
		out.newLine();
		out.write("import junitparams.mappers.CsvWithHeaderMapper;");
		out.newLine();
		out.write("import java.nio.file.Paths;");
		out.newLine();
		out.write("import java.nio.file.Files;");
		out.newLine();
		out.write("import java.nio.charset.Charset;");
		out.newLine();
		out.write("import java.io.BufferedWriter;");
		out.newLine();
		out.write("import java.io.IOException;");
		out.newLine();
		out.newLine();
		out.write("import org.junit.runner.RunWith;");
		out.newLine();
		out.write("import org.junit.runner.Description;");
		out.newLine();
		out.write("import org.junit.rules.TestWatcher;");
		out.newLine();
		out.write("import org.junit.AfterClass;");
		out.newLine();
		out.write("import org.junit.Rule;");
		out.newLine();
		out.write(capturedLine);
		out.newLine();
	}
}