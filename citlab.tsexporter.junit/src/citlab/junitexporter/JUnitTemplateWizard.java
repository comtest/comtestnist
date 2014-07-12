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
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.internal.junit.wizards.NewTestCaseCreationWizard;
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
	private Pattern methodPattern = Pattern.compile("^(\\s*).+ test\\w*\\(\\) \\{$");
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

				//for any @Test annotation
				} else if(methodPattern.matcher(line).matches()) {
					insertFileParameters(out, line);
					fileParametersAdded = true;

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
		String prefix = indent + indent + indent;

		//next use a string builder to create the annotation
		StringBuilder sb = new StringBuilder();
		sb.append(indent).append("@FileParameters(").append(newLine);
		sb.append(prefix).append("value = \"");
		sb.append(osSafeCsvFilePath).append("\",").append(newLine);
		sb.append(prefix).append("mapper = ");
		sb.append("CsvWithHeaderMapper.class").append(")").append(newLine);

		//First write down the method declaration as it is except the closing parenthesis
		//e.g. "public final void testFooBar() {" gets written as
		//     "public final void testFooBar("
		String methodNameWithOpenParen = capturedLine.substring(0, capturedLine.length() - 3);
		sb.append(methodNameWithOpenParen).append(newLine);

		//the suffix is ",\n" i.e. comma and then next parameter on next line
		//e.g. "public final void testFooBar(
		//                   String foo,
		//                   String bar,
		//                   String baz
		//             ) {"
		String commaNewLine = "," + newLine;

		//set suffix to empty before the loop, then set it inside
		//this avoids the extra dangling suffix after iteration is done
		String suffix = "";

		//use a string builder to iterate over the parameter names
		for(Assignment as : testSuite.getTests().get(0).getAssignments()) {
			sb.append(suffix);
			suffix = commaNewLine;
			sb.append(prefix).append("String ");
			sb.append(as.getParameter().getName().replaceAll("\\W", ""));
		}

		//after parameter names, close the parenthesis on next line at double indent
		sb.append(newLine).append(indent).append(indent).append(") {").append(newLine);

		//done writing parameter names, now write it out
		out.write(sb.toString());
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
		out.write("//Please make sure you have the junitparams in the build path");
		out.newLine();
		out.write("//You can download it from: https://code.google.com/p/junitparams/");
		out.newLine();
		out.write("import junitparams.*;");
		out.newLine();
		out.write("import junitparams.mappers.*;");
		out.newLine();
		out.write("import org.junit.runner.RunWith;");
		out.newLine();
		out.newLine();
		out.write(capturedLine);
		out.newLine();
	}
}