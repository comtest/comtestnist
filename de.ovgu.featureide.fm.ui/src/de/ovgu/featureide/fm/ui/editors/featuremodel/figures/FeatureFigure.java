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
package de.ovgu.featureide.fm.ui.editors.featuremodel.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.ZoomListener;

import de.ovgu.featureide.fm.core.ClassFeature;
import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.CompositionFeature;
import de.ovgu.featureide.fm.core.RangeClassFeature;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.FeatureStatus;
import de.ovgu.featureide.fm.core.Feature.FeatureKind;
import de.ovgu.featureide.fm.ui.editors.FeatureDiagramExtension;
import de.ovgu.featureide.fm.ui.editors.FeatureUIHelper;
import de.ovgu.featureide.fm.ui.editors.featuremodel.GUIDefaults;
import de.ovgu.featureide.fm.ui.editors.featuremodel.figures.anchors.SourceAnchor;
import de.ovgu.featureide.fm.ui.editors.featuremodel.figures.anchors.TargetAnchor;
import de.ovgu.featureide.fm.ui.properties.FMPropertyManager;

/**
 * A figure that represents a feature with its name.
 * 
 * @author Thomas Thuem
 */
public class FeatureFigure extends Figure implements GUIDefaults {
	
	private final Label label = new Label();
	
	private static final FreeformLayout layout = new FreeformLayout();

	private final ConnectionAnchor sourceAnchor;
	
	private final ConnectionAnchor targetAnchor;

	private Feature feature;

	private FeatureModel featureModel;
	
	private static GridLayout gl = new GridLayout();
	
	private static String CONCRETE = " Concrete";
	private static String ABSTRACT = " Abstract";
	private static String HIDDEN = " hidden";
	private static String DEAD = "is dead ";
	private static String FEATURE = " feature ";
	private static String FALSE_OPTIONAL = "is false optional ";
	private static String INDETERMINATE_HIDDEN = "is hidden and indeterminate";
	private static String VOID = " Feature Model is void ";
	private static String ROOT = " Root ";

	public FeatureFigure(Feature feature, FeatureModel featureModel) {
		super();
		this.feature = feature;
		this.featureModel = featureModel;
		
		//manual patching zoom issue see:https://github.com/tthuem/FeatureIDE/issues/138
		FeatureUIHelper.getZoomManager().addZoomListener(new ZoomListener(){
			@Override
			public void zoomChanged(double arg0) {
				enforceLabelSize();
			}
		});
		
		sourceAnchor = new SourceAnchor(this, feature);
		targetAnchor = new TargetAnchor(this, feature);
		
		setLayoutManager(layout);

		label.setForegroundColor(FMPropertyManager.getFeatureForgroundColor());
		label.setFont(DEFAULT_FONT);

		label.setLocation(new Point(FEATURE_INSETS.left, FEATURE_INSETS.top));
		
		//Abhi
		if(feature.kind == FeatureKind.Class)
		{
			setName(((ClassFeature) feature).getValue());
		}
		else if(feature.kind == FeatureKind.RangeClass)
		{
			setName(((RangeClassFeature) feature).getValue());
		}
		else
		{
			setName(feature.getName());
		}
		
		setProperties();
		
		
		//manual patching zoom issue see:https://github.com/tthuem/FeatureIDE/issues/138
		enforceLabelSize();
		FeatureUIHelper.setSize(feature,getSize());
		add(label, label.getBounds());
		setOpaque(true);

		if (FeatureUIHelper.getLocation(feature) != null)
			setLocation(FeatureUIHelper.getLocation(feature));
		
		if(isHidden(feature)){
			setSize(new Dimension(0,0));
		}
	}
	
	//manual patching zoom issue see:https://github.com/tthuem/FeatureIDE/issues/138
	protected void enforceLabelSize() {
		if(getChildren().isEmpty())
			return;
		setConstraint((IFigure) getChildren().get(0), label.getBounds().getExpanded(5,  0));
	}

	boolean isHidden(Feature feature){
		if(featureModel.getLayout().showHiddenFeatures()){
			return false;
		} else {
			if(feature.isHidden()){
				return true;
			}
			if(!feature.isRoot()){
				return isHidden(feature.getParent());
			} else {
				return feature.isHidden();
			}
		}

	}

	public void setProperties() {
	
		String toolTip = "";
		boolean modelIsValid = featureModel.getAnalyser().valid();
		
		label.setForegroundColor(FMPropertyManager.getFeatureForgroundColor());
		setBackgroundColor(FMPropertyManager.getConcreteFeatureBackgroundColor());
		
		//Abhi
		if(this.feature instanceof CompositionFeature)
			setBorder(FMPropertyManager.getCompositionFeatureBorder());
		
		//Abhi
		else if(this.feature instanceof ClassificationFeature)
			setBorder(FMPropertyManager.getClassificationFeatureBorder());
		
		//Abhi
		else if(this.feature instanceof ClassFeature)
			setBorder(FMPropertyManager.getClassFeatureBorder());
		
		//Abhi
		else
		{
			if(this.feature.kind == FeatureKind.Composition)
			{
				setBorder(FMPropertyManager.getCompositionFeatureBorder());
			}

			else if(this.feature.kind == FeatureKind.Classification)
			{
				setBorder(FMPropertyManager.getClassificationFeatureBorder());
			}
			
			else if(this.feature.kind == FeatureKind.Class)
			{
				setBorder(FMPropertyManager.getClassFeatureBorder());
			}	
			
			//sudhi
			else if(this.feature.kind == FeatureKind.Root)
			{
				setBorder(FMPropertyManager.getRootBorder());
			}

			else 
			{
				setBorder(FMPropertyManager.getFeatureBorder());
			}
			
		}
		//Abhi

		
		if (feature.isConcrete()) toolTip += CONCRETE;
		
		if (feature.isAbstract()){
			setBackgroundColor(FMPropertyManager.getAbstractFeatureBackgroundColor());
			if (feature.isRoot()){
				toolTip += ROOT;
			} else {
				toolTip += ABSTRACT;
				setBorder(FMPropertyManager.getFeatureBorder());
			}
		}
		
		if (feature.hasHiddenParent()){
			setBorder(FMPropertyManager.getHiddenFeatureBorder(feature.isConstraintSelected()));
			label.setForegroundColor(HIDDEN_FOREGROUND);
			if (feature.isHidden()) toolTip += HIDDEN;
		}
		
		//Abhi
		String kind = feature.kind == FeatureKind.RangeClass ? "Class" : feature.kind.toString();
		if (kind != null && !kind.equals(" ")) {
			toolTip += "\r\n" + "\r\n Node: " + kind;
		}
		
		//Abhi 
		if(feature instanceof ClassificationFeature)
		{
			String dataType = ((ClassificationFeature) feature).getDataType();
			if(dataType != null && !dataType.equals(" "))
			{
				toolTip += "\r\n" + "\r\n DataType: " + dataType;
			}
		
		}
		
		//if (!feature.isRoot()) toolTip += FEATURE; //Abhi
		
		if ((feature.getFeatureStatus() == FeatureStatus.DEAD) && modelIsValid){
			setBackgroundColor(FMPropertyManager.getDeadFeatureBackgroundColor());
			setBorder(FMPropertyManager.getDeadFeatureBorder(feature.isConstraintSelected()));
			toolTip += DEAD;			
		}
		
		if (feature.getFeatureStatus() == FeatureStatus.FALSE_OPTIONAL){
			setBackgroundColor(FMPropertyManager.getWarningColor());
			setBorder(FMPropertyManager.getConcreteFeatureBorder(feature.isConstraintSelected()));
			toolTip += FALSE_OPTIONAL;
		}
		
		if (feature.getFeatureStatus() == FeatureStatus.INDETERMINATE_HIDDEN){
			setBackgroundColor(FMPropertyManager.getWarningColor());
			setBorder(FMPropertyManager.getConcreteFeatureBorder(feature.isConstraintSelected()));
			toolTip += INDETERMINATE_HIDDEN;
		}
		
		if (feature.isRoot() && !modelIsValid){
			setBackgroundColor(FMPropertyManager.getDeadFeatureBackgroundColor());
			setBorder(FMPropertyManager.getDeadFeatureBorder(feature.isConstraintSelected()));
			toolTip = VOID;
		}
		
		String description = feature.getDescription();
		if (description != null && !description.equals(" ")) {
			toolTip += "\r\n\r\n" + "Description:\r\n" + description;
		}
		
		String contraints = feature.getRelevantConstraintsString();
		if (!contraints.isEmpty()) {
			toolTip += "\n\nConstraints:\n" + contraints;
		}
		Figure toolTipContent = new Figure();
		toolTipContent.setLayoutManager(gl);
		toolTipContent.setFont(DEFAULT_FONT);
		toolTipContent.add(new Label(toolTip));
		
		// call of the FeatureDiagramExtensions
		for (FeatureDiagramExtension extension : FeatureDiagramExtension.getExtensions()) {
			toolTipContent = extension.extendFeatureFigureToolTip(toolTipContent, this);
		}
		
		setToolTip(toolTipContent);
	}
	
	public ConnectionAnchor getSourceAnchor() {
		return sourceAnchor;
	}

	public ConnectionAnchor getTargetAnchor() {
		return targetAnchor;
	}

	public void setName(String newName) {
		label.setText(newName);
		Dimension labelSize = label.getPreferredSize();
		//manual patching zoom issue see:https://github.com/tthuem/FeatureIDE/issues/138
		this.minSize = labelSize;
		
		if (labelSize.equals(label.getSize()))
			return;
		label.setSize(labelSize);

		Rectangle bounds = getBounds();
		int w = FEATURE_INSETS.getWidth();
		int h = FEATURE_INSETS.getHeight();
		
		bounds.setSize(labelSize.expand(w, h));
			

		Dimension oldSize = getSize();
		if (!oldSize.equals(0, 0)) {
			int dx = (oldSize.width - bounds.width) / 2;
			bounds.x += dx;
		}

		setBounds(bounds);
	}

	public Rectangle getLabelBounds() {
		return label.getBounds();
	}
	
	/**
	 * @return The <code>Feature</code> represented by this <code>FeatureFigure</code>
	 */
	public Feature getFeature() {
		return feature;
	}
}
