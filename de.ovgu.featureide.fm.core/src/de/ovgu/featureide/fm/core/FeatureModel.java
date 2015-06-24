/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2013  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.fm.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import org.eclipse.core.resources.IProject;
import org.prop4j.Node;

/**
 * The model representation of the feature tree that notifies listeners of
 * changes in the tree.
 * 
 * @author Thomas Thuem
 * @author Florian Proksch
 * @author Stefan Krueger
 * 
 */
public class FeatureModel extends DeprecatedFeatureModel implements PropertyConstants {
	
	private Feature rootFeature;
	
	/**
	 * a {@link Hashtable} containing all features
	 */
	private final Map<String, Feature> featureTable = new ConcurrentHashMap<String, Feature>();
	
	/**
	 * the classification feature list containing all 
	 * classification features. This is used for CitLab model conversion
	 * author: Wayman Tan
	 */
	private final List<ClassificationFeature> classificationNodeList = new LinkedList<ClassificationFeature>();
	
	/**
	 * this class feature list containing all class features 
	 * author: Abhishek Sharma
	 */
	private final List<ClassFeature> classNodeList = new LinkedList<ClassFeature>();
	
	
	protected final List<Constraint> constraints = new LinkedList<Constraint>();
	
	/**
	 * All comment lines from the model file without line number at which they
	 * occurxxxx
	 */
	private final List<String> comments = new LinkedList<String>();

	/**
	 * Saves the annotations from the model file as they were read,
	 * because they were not yet used.
	 */
	private final List<String> annotations = new LinkedList<String>();

	/**
	 * A list containing the feature names in their specified order will be
	 * initialized in XmlFeatureModelReader.
	 */
	private final List<String> featureOrderList = new LinkedList<String>();
	
	private boolean featureOrderUserDefined = false;
	
	private boolean featureOrderInXML = false;
	
	private Object undoContext;

	private final List<PropertyChangeListener> listenerList = new LinkedList<PropertyChangeListener>();
	
	private ColorschemeTable colorschemeTable = new ColorschemeTable(this);

	private FMComposerManager fmComposerManager;
	
	private final FeatureModelAnalyzer analyser = new FeatureModelAnalyzer(this);
	
	private final FeatureModelLayout layout = new FeatureModelLayout();
	
	private final RenamingsManager renamingsManager = new RenamingsManager(this);
	
	/**
	 * Returns the {@link FeatureModelAnalyzer} which should be used for all calculation 
	 * on the {@link FeatureModel}.
	 */
	@Override
    public FeatureModelAnalyzer getAnalyser() {
    	return analyser;
    }

	@Override
    public FeatureModelLayout getLayout() {
		return layout;
    }

	public ColorschemeTable getColorschemeTable() {
		return colorschemeTable;
	}
	
	@Override
	public FMComposerManager getFMComposerManager(final IProject project) {
		if (fmComposerManager == null) {
			fmComposerManager = new FMComposerManager(project);
		}
		return fmComposerManager;
	}

	public IFMComposerExtension initFMComposerExtension(final IProject project) {
		return getFMComposerManager(project);
	}

	public IFMComposerExtension getFMComposerExtension() {
		return getFMComposerManager(null).getFMComposerExtension();
	}
	
	@Override
	public RenamingsManager getRenamingsManager() {
		return renamingsManager;
	}
	
	public void reset() {
		if (rootFeature != null) {
			while (rootFeature.hasChildren()) {
				Feature child = rootFeature.getLastChild();
				deleteChildFeatures(child);
				rootFeature.removeChild(child);
				featureTable.remove(child.getName());
			}
			rootFeature = null;
		}
		featureTable.clear();
		// wayman
		classificationNodeList.clear();
		//abhi
		classNodeList.clear();
		renamingsManager.clear();
		constraints.clear();
		comments.clear();
		annotations.clear();
		featureOrderList.clear();
		colorschemeTable.reset();
	}
	
	private void deleteChildFeatures(Feature feature) {
		while (feature.hasChildren()) {
			Feature child = feature.getLastChild();
			deleteChildFeatures(child);
			feature.removeChild(child);
			featureTable.remove(child.getName());
		}
	}
	
	/**
	 * Creates a default {@link FeatureModel} with a root feature named as the project and a
	 * child feature named base.
	 * @param projectName The name of the project
	 */
	public void createDefaultValues(String projectName) {
		String rootName = getValidJavaIdentifier(projectName);
		
		Feature root;
		if (!"".equals(rootName)) {
			root = getFeature(rootName);
		} else {
			root = getFeature("Root");
		}
		
		// wayman
//		root.setAbstract(true);
//		Feature feature = new Feature(this, "Base");
//		root.addChild(feature);
//		addFeature(feature);
	}
	
	/**
	 * Removes all invalid java identifiers form a given string.
	 */
	private String getValidJavaIdentifier(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		for (; i < s.length(); i++) {
			if (Character.isJavaIdentifierStart(s.charAt(i))) {
				stringBuilder.append(s.charAt(i));
				i++;
				break;
			}
		}
		for (; i < s.length(); i++) {
			if (Character.isJavaIdentifierPart(s.charAt(i))) {
				stringBuilder.append(s.charAt(i));
			}
		}
		return stringBuilder.toString();
	}

	/* *****************************************************************
	 * 
	 * Feature handling
	 * 
	 *******************************************************************/
	public void setRoot(Feature root) {
		this.rootFeature = root;
	}
	
	public Feature getRoot() {
		return rootFeature;
	}

	/**
	 * @param featureTable
	 *            the featureTable to set
	 */
	public void setFeatureTable(final Hashtable<String, Feature> featureTable) {
		this.featureTable.clear();
		this.featureTable.putAll(featureTable);
	}
	
	public boolean addFeature(Feature feature) {
		String name = feature.getName();
		if (featureTable.containsKey(name))
			return false;
		featureTable.put(name, feature);
		// wayman: add the classification node to the list
		if (feature instanceof ClassificationFeature) {
			classificationNodeList.add((ClassificationFeature)feature);
		}
		
		//Abhishek: add the class node to the list 
		if(feature instanceof ClassFeature){
			classNodeList.add((ClassFeature) feature);
		}
			
		return true;
	}
	
	public Collection<Feature> getFeatures() {
		return Collections.unmodifiableCollection(featureTable.values());
	}
	
	// TODO this seems to be a false implementation
	//    	returns root instead of null
	/**
	 * 
	 * @return The {@link Feature} with the given name or <code>null</code> there is no Feature with this name. 
	 */
	@CheckForNull
	public Feature getFeature(String name) {
		if (featureTable.isEmpty()) {
			// create the root feature (it is the only one without a reference)
			// wayman
//			rootFeature = new Feature(this, name);
			rootFeature = new RootFeature(this, name);
			addFeature(rootFeature);
			return rootFeature;
		}
		return featureTable.get(name);
	}

	/**
	 * 
	 * @return A list of all concrete features. This list is in preorder of the tree. 
	 */
	@Nonnull
	public Collection<Feature> getConcreteFeatures() {
		List<Feature> concreteFeatures = new LinkedList<Feature>();
		if (rootFeature != null) {
			getConcreteFeatures(rootFeature, concreteFeatures);
		}
		return Collections.unmodifiableCollection(concreteFeatures);
	}

	private void getConcreteFeatures(Feature feature, List<Feature> concreteFeatures) {
		if (feature.isConcrete()) {
			concreteFeatures.add(feature);
		}
		for (Feature child : feature.getChildren()) {
			getConcreteFeatures(child, concreteFeatures);
		}
	}
	
	/**
	 * 
	 * @return A list of all concrete feature names. This list is in preorder of the tree. 
	 */
	@Nonnull
	public List<String> getConcreteFeatureNames() {
		List<String> concreteFeatureNames = new LinkedList<String>();
		for (Feature f : getConcreteFeatures()) {
			concreteFeatureNames.add(f.getName());
		}
		return concreteFeatureNames;
	}
	
	/**
	 * @return <code>true</code> if a feature with the given name exists and is concrete.
	 */
	public boolean isConcrete(String featureName) {
		Feature feature = featureTable.get(featureName);
		return feature != null && feature.isConcrete();
	}
	
	/**
	 * @return the featureTable
	 */
	public Map<String, Feature> getFeatureTable() {
		return featureTable;
	}
	
	/**
	 * @return the classification node list
	 */
	public List<ClassificationFeature> getClassificationNodeList() {
		return classificationNodeList;
	}
	
	
	public Set<String> getFeatureNames() {
		return Collections.unmodifiableSet(featureTable.keySet());
	}
	
	public int getNumberOfFeatures() {
		return featureTable.size();
	}

	public void deleteFeatureFromTable(Feature feature) {
		featureTable.remove(feature.getName());
	}

	public boolean deleteFeature(Feature feature) {
		// the root can not be deleted
		if (feature == rootFeature) {
			return false;
		}

		// check if it exists
		String name = feature.getName();
		if (!featureTable.containsKey(name)) {
			return false;
		}

		// use the group type of the feature to delete
		Feature parent = feature.getParent();

		if (parent.getChildrenCount() == 1) {
			if (feature.isAnd()) {
				parent.setAnd();
			} else if (feature.isAlternative()) {
				parent.setAlternative();
			} else {
				parent.setOr();
			}
		}

		// add children to parent
		int index = parent.getChildIndex(feature);
		while (feature.hasChildren()) {
			parent.addChildAtPosition(index, feature.removeLastChild());
		}

		// delete feature
		parent.removeChild(feature);
		featureTable.remove(name);
		featureOrderList.remove(name);
		
		// wayman
		if (feature instanceof ClassificationFeature){
			classificationNodeList.remove((ClassificationFeature)feature);
		}
		
		// Abhi
		if (feature instanceof ClassFeature){
			classNodeList.remove((ClassFeature)feature);
		}
		
		return true;
	}
	
	public void replaceRoot(Feature feature) {
		featureTable.remove(rootFeature.getName());
		rootFeature = feature;
	}

	/* *****************************************************************
	 * 
	 * Constraint handling
	 * 
	 *#*****************************************************************/
	public void setConstraints(final LinkedList<Constraint> constraints) {
		this.constraints.clear();
		this.constraints.addAll(constraints);
	}
	
	public void addPropositionalNode(Node node) {
		addConstraint(new Constraint(this, node));
	}
	
	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);
	}

	public void addPropositionalNode(Node node, int index) {
		addConstraint(new Constraint(this, node), index);
	}
	
	public void addConstraint(Constraint constraint, int index) {
		constraints.add(index, constraint);
	}
	
	public List<Node> getPropositionalNodes() {
		LinkedList<Node> nodes = new LinkedList<Node>();
		for (Constraint c : constraints) {
			nodes.add(c.getNode());
		}
		return Collections.unmodifiableList(nodes);
	}
	
	//Abhi: To get the constriant Text
	public String getConstraintText(int index)
	{
		return constraints.get(index).getConstraintText();
	}
	
	
	public Node getConstraint(int index) {
		return constraints.get(index).getNode();
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public List<Constraint> getConstraints() {
		return Collections.unmodifiableList(constraints);
	}

	/**
	 * 
	 * @param constraint
	 * @return The position of the given {@link Constraint} or 
	 * 			-1 if it does not exist.
	 */
	public int getConstraintIndex(Constraint constraint) {
		int j = 0;
		for (Constraint c : constraints) {
			if (constraint == c) {
				return j;
			}
			j++;
		}
		return -1;
	}

	public void removePropositionalNode(Node node) {
		for (Constraint c : constraints) {
			if (c.getNode().equals(node)) {
				removeConstraint(c);
				break;
			}
		}
	}

	public void removeConstraint(Constraint constraint) {
		/*
		 * Zach
		 * Fixed the issue where the wrong constraint was sometimes deleted. 
		 */
		for(int i = 0; i < constraints.size(); i++){
			if(constraint.getConstraintText() == constraints.get(i).getConstraintText()){
				constraints.remove(i);
				break;
			}
		}
	}

	public void removeConstraint(int index) {
		constraints.remove(index);
	}
	
	public void replacePropNode(int index, Node node) {
		assert (index < constraints.size());
		constraints.set(index, new Constraint(this, node));
	}
	
	
	//Abhi 
	public void replaceConstraintText(int index, String text, Node node)
	{
		assert (index < constraints.size());
		constraints.set(index, new Constraint(this, text, node));		
	}
	
	public int getConstraintCount() {
		return constraints.size();
	}
	
	public List<String> getAnnotations() {
		return Collections.unmodifiableList(annotations);
	}

	public void addAnnotation(String annotation) {
		annotations.add(annotation);
	}

	public List<String> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public void addComment(String comment) {
		comments.add(comment);
	}
	
	public void addListener(PropertyChangeListener listener) {
		if (!listenerList.contains(listener)) {
			listenerList.add(listener);
		}
	}

	public void removeListener(PropertyChangeListener listener) {
		listenerList.remove(listener);
	}
	
	public void handleModelDataLoaded() {
		fireEvent(MODEL_DATA_LOADED);
	}

	public void handleModelDataChanged() {
		fireEvent(MODEL_DATA_CHANGED);
	}
	
	public void handleModelLayoutChanged() {
		fireEvent(MODEL_LAYOUT_CHANGED);
	}
	
	public void refreshContextMenu() {
		fireEvent(REFRESH_ACTIONS);
	}
	/**
	 * Refreshes the diagram colors.
	 */
	public void redrawDiagram() {
		fireEvent(REDRAW_DIAGRAM);
	}
	
	private final void fireEvent(final String action) {
		final PropertyChangeEvent event = new PropertyChangeEvent(this,
				action, Boolean.FALSE, Boolean.TRUE);
		for (PropertyChangeListener listener : listenerList) {
			listener.propertyChange(event);
		}
	}
	@Override
	public FeatureModel clone() {
		final FeatureModel clone = new FeatureModel();
		clone.featureTable.putAll(featureTable);
		if (rootFeature == null) {
			clone.rootFeature = new Feature(clone, "Root");
			clone.featureTable.put("root", clone.rootFeature);
		} else {
			// TODO this should never happen
			clone.rootFeature = clone.getFeature(rootFeature.getName());
		}
		clone.constraints.addAll(constraints);
		clone.annotations.addAll(annotations);
		clone.comments.addAll(comments);
		clone.colorschemeTable = colorschemeTable.clone(clone);
		return clone;
	}

	/**
	 * @return true if feature model contains mandatory features otherwise false
	 */
	public boolean hasMandatoryFeatures() {
		for (Feature f : featureTable.values()) {
			Feature parent = f.getParent();
			if (parent != null && parent.isAnd() && f.isMandatory())
				return true;
		}
		return false;
	}

	/**
	 * @return <code>true</code> if feature model contains optional features otherwise false
	 */
	public boolean hasOptionalFeatures() {
		for (Feature f : featureTable.values()) {
			if (!f.equals(rootFeature) && f.getParent().isAnd()
					&& !f.isMandatory())
				return true;
		}
		return false;
	}

	/**
	 * @return true if feature model contains and group otherwise false
	 */
	public boolean hasAndGroup() {
		for (Feature f : featureTable.values()) {
			if (f.getChildrenCount() > 1 && f.isAnd())
				return true;
		}
		return false;
	}

	/**
	 * @return true if feature model contains alternative group otherwise false
	 */
	public boolean hasAlternativeGroup() {
		for (Feature f : featureTable.values()) {
			if (f.getChildrenCount() > 1 && f.isAlternative())
				return true;
		}
		return false;
	}
	
	/**
	 * @return true if feature model contains or group otherwise false
	 */
	public boolean hasOrGroup() {
		for (Feature f : featureTable.values()) {
			if (f.getChildrenCount() > 1 && f.isOr())
				return true;
		}
		return false;
	}

	public boolean hasAbstract() {
		for (Feature f : featureTable.values()) {
			if (f.isAbstract())
				return true;
		}
		return false;
	}

	public boolean hasConcrete() {
		for (Feature f : featureTable.values()) {
			if (f.isConcrete())
				return true;
		}
		return false;
	}
	
	/**
	 * @return number of or groups contained in the feature model
	 */
	public int numOrGroup() {
		int count = 0;
		for (Feature f : featureTable.values()) {
			if (f.getChildrenCount() > 1 && f.isOr()) {
				count++;
			}
		}
		return count;
	}
	
	public int numAlternativeGroup() {
		int count = 0;
		for (Feature f : featureTable.values()) {
			if (f.getChildrenCount() > 1 && f.isAlternative()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @return <code>true</code> if the feature model contains a hidden feature
	 */
	public boolean hasHidden() {
		for (Feature f : featureTable.values()) {
			if (f.isHidden()) {
				return true;
			}
		}
		return false;
	}

	public boolean hasIndetHidden() {
		for (Feature f : featureTable.values()) {
			if (f.getFeatureStatus() == FeatureStatus.INDETERMINATE_HIDDEN) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasUnsatisfiableConst() {
		for (Constraint c : constraints) {
			if (c.getConstraintAttribute() == ConstraintAttribute.UNSATISFIABLE) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasTautologyConst() {
		for (Constraint c : constraints) {
			if (c.getConstraintAttribute() == ConstraintAttribute.TAUTOLOGY) {
				return true;
			}
		}
		return false;
	}
	public boolean hasDeadConst() {
		for (Constraint c : constraints) {
			if (c.getConstraintAttribute() == ConstraintAttribute.DEAD || !c.getDeadFeatures().isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasVoidModelConst() {
		for (Constraint c : constraints) {
			if (c.getConstraintAttribute() == ConstraintAttribute.VOID_MODEL)
				return true;
		}
		return false;
	}
	
	public boolean hasRedundantConst() {
		for (Constraint c : constraints) {
			if (c.getConstraintAttribute() == ConstraintAttribute.REDUNDANT) {
				return true;
			}
		}
		return false;
	}


	public boolean hasFalseOptionalFeatures() {
		for (Feature f : featureTable.values()) {
			if (f.getFeatureStatus() == FeatureStatus.FALSE_OPTIONAL) {
				return true;
			}
		}
		return false;
	}

	public void setUndoContext(Object undoContext) {
		this.undoContext = undoContext;
	}

	public Object getUndoContext() {
		return undoContext;
	}

	public List<String> getFeatureOrderList() {
		if (featureOrderList.isEmpty()) {
			return getConcreteFeatureNames();
		}
		return featureOrderList;
	}

	public void setFeatureOrderList(final List<String> featureOrderList) {
		this.featureOrderList.clear();
		this.featureOrderList.addAll(featureOrderList);
	}

	public boolean isFeatureOrderUserDefined() {
		return featureOrderUserDefined;
	}

	public void setFeatureOrderUserDefined(boolean featureOrderUserDefined) {
		this.featureOrderUserDefined = featureOrderUserDefined;
	}

	public boolean isFeatureOrderInXML() {
		return featureOrderInXML;
	}

	public void setFeatureOrderInXML(boolean featureOrderInXML) {
		this.featureOrderInXML = featureOrderInXML;
	}
	
	@Override
	public String toString() {
		String x = toString(getRoot());
		for (Constraint c : getConstraints()) {
			x +=c.toString() + " ";
		}
		return x;
	}
	
	private String toString(Feature feature) {
		String x = feature.getName();
		if (!feature.hasChildren()) {
			return x;
		}
		if (feature.isOr()) {
			x += " or [";
		} else if (feature.isAlternative()) {
			x += " alt [";
		} else {
			x += " and [";
		}
		
		for (Feature child : feature.getChildren()) {
			x += " ";
			if (feature.isAnd()) {
				if (child.isMandatory()) {
					x += "M ";
				} else {
					x += "O ";
				}
			}
			
			if (child.hasChildren()) {
				x += toString(child);
			} else {
				x += child.getName();
			}
		}
		return x + " ] ";
	}

	/**
	 * @return the classNodeList
	 */
	public List<ClassFeature> getClassNodeList() {
		return classNodeList;
	}

}