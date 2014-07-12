package citlab.junitexporter;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import citlab.core.ext.ICitLabTestSuiteExporter;
import citlab.cvsexporter.CVSExporter;
import citlab.testsuite.Assignment;
import citlab.testsuite.TestSuite;


public class JUnitExporter extends ICitLabTestSuiteExporter {

	@Override
	public void generateOutput(TestSuite input, String fileName) {
		Path filePath = FileSystems.getDefault().getPath(fileName);
		if(! Files.exists(filePath)) {
			new CVSExporter().generateOutput(input, fileName);
		}
		JUnitTemplateWizard junitWizard = new JUnitTemplateWizard(
				PlatformUI.getWorkbench(),
				input,
				fileName);
		WizardDialog wd = new WizardDialog(
				Display.getDefault().getActiveShell(),
				junitWizard
			);
		wd.open();
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

}