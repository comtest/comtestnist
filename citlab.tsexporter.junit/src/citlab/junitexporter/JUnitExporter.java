package citlab.junitexporter;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import citlab.core.ext.ICitLabTestSuiteExporter;
import citlab.cvsexporter.CVSExporter;
import citlab.testsuite.TestSuite;


public class JUnitExporter extends ICitLabTestSuiteExporter {

	@Override
	public void generateOutput(TestSuite input, String fileName) {
		new CVSExporter().generateOutput(input, fileName);
		try {
		JUnitTemplateWizard junitWizard = new JUnitTemplateWizard(
				PlatformUI.getWorkbench(),
				input,
				fileName);
		WizardDialog wd = new WizardDialog(
				Display.getDefault().getActiveShell(),
				junitWizard
			);
		wd.open();
		} catch (Exception e) {
			//e.printStackTrace();
			//ignore as we are running without a UI for the testing
		}
	}
}
