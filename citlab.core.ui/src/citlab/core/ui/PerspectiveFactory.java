package citlab.core.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
			  layout.addView("org.eclipse.jdt.ui.PackageExplorer", IPageLayout.LEFT, 0.34f, IPageLayout.ID_EDITOR_AREA);
			  layout.setEditorAreaVisible(true);
		        layout.setFixed(true);
		        IFolderLayout folder1 = layout.createFolder("folder1", 
		        	    IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_EDITOR_AREA);
		        folder1.addView("citlab.core.ui.views.CitLabView");
		        			  folder1.addPlaceholder("citlab.core.ui.output:citlab.core.ui.outputSecondaryID*");
		        layout.addStandaloneView("Myed", false, IPageLayout.LEFT, 1.0f,"citlab.model.CitL");

	}

}
