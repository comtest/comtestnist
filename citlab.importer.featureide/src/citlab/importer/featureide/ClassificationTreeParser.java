package citlab.importer.featureide;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import de.ovgu.featureide.fm.core.Feature;

public class ClassificationTreeParser {
	public boolean parse(MockClassificationTreeModel ctm) {
	
		Hashtable<String, Feature> nodeTable = ctm.getNodeTable();
		
		Set<String> keys = nodeTable.keySet();
		for (String key: keys) {
			Feature node = nodeTable.get(key);
			LinkedList<Feature> children = node.getChildren();
			// check if it is a leaf node
			if (children.isEmpty()) {
				// return false if the leaf node is not a ClassNode
				if (!(node instanceof MockClassNode)) {
					return false;					
				}
			}
			
			// check if there is any mandatory property missing.
			// to do. 
		}
		
		return true;
	}

}
