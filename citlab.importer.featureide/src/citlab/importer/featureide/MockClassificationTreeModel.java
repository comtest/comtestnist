package citlab.importer.featureide;

import java.util.Hashtable;

import de.ovgu.featureide.fm.core.Feature;

public class MockClassificationTreeModel {
	private Feature root;
	private Hashtable<String, Feature> nodeTable = new Hashtable<String, Feature>(); 
	
	public Hashtable<String, Feature> getNodeTable() {
		return nodeTable;
	}

}
