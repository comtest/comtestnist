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
package de.ovgu.featureide.core.mpl.signature.abstr;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import de.ovgu.featureide.core.mpl.signature.ViewTag;

/** 
 * Abstract signature for a class member.
 * 
 * @author Sebastian Krieter
 */
public abstract class AbstractSignature {
	
	public static final class FeatureData {
		private final int id, lineNumber;
		private String comment;
		
		public FeatureData(int id, int lineNumber, String comment) {
			this.id = id;
			this.lineNumber = lineNumber;
			this.comment = comment;
		}
		
		public FeatureData(int id, int lineNumber) {
			this(id, lineNumber, null);
		}
		
		public int getId() {
			return id;
		}
		
		public int getLineNumber() {
			return lineNumber;
		}
		
		public String getComment() {
			return comment;
		}
		
		public void setComment(String comment) {
			this.comment = comment;
		}
	}
	
	protected static final String LINE_SEPARATOR = System.getProperty("line.separator");
	protected static final int hashCodePrime = 31;
	public static final byte 
		VISIBILITY_DEFAULT = 0,
		VISIBILITY_PRIVATE = 1,
		VISIBILITY_PROTECTED = 2,
		VISIBILITY_PUBLIC = 3;
	
	protected boolean hasHashCode = false;
	protected int hashCode = 0;
	
	protected final AbstractClassSignature parent;
	
	protected final String name;
	protected final String[] modifiers;
	protected final String type;
	
	protected final boolean finalSignature;
	protected final byte visibility;
	
	protected String fullName;
	
	protected LinkedList<ViewTag> viewTags;
	
	protected FeatureData[] featureData = null;
	protected String mergedjavaDocComment = null;
	
	protected AbstractSignature(AbstractClassSignature parent, String name, String modifierString, String type) {
		this.parent = parent;
		this.name = name;
		if (parent != null) {
			this.fullName = parent.fullName + '.' + name;
		} else {
			this.fullName = '.' + name;
		}
		
		this.viewTags = null;
		
		if (modifierString == null) {
			this.modifiers = new String[0];
		} else {
			this.modifiers = modifierString.trim().split("\\s+");
		}
		Arrays.sort(this.modifiers);
		if (Arrays.binarySearch(this.modifiers, "private") >= 0) {
			this.visibility = VISIBILITY_PRIVATE;
		} else if (Arrays.binarySearch(this.modifiers, "protected") >= 0) {
			this.visibility = VISIBILITY_PROTECTED;
		} else if (Arrays.binarySearch(this.modifiers, "public") >= 0) {
			this.visibility = VISIBILITY_PUBLIC;
		} else {
			this.visibility = VISIBILITY_DEFAULT;
		}
		
		this.finalSignature = Arrays.binarySearch(this.modifiers, "final") >= 0;
		if (type == null) {
			this.type = "void";
		} else {
			this.type = type;
		}
	}
	
	protected void setFullName(String perfixName) {
		this.fullName = perfixName + '.' + name;
	}

	public AbstractClassSignature getParent() {
		return parent;
	}

	public boolean hasViewTags() {
		return viewTags != null;
	}
	
	public boolean hasViewTag(ViewTag viewTag) {
		if (viewTag == null) {
			return true;
		}
		if (viewTags != null) {
			for (ViewTag vt : viewTags) {
				if (vt.matches(viewTag)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void addViewTag(ViewTag viewTag) {
		if (viewTags == null) {
			viewTags = new LinkedList<ViewTag>();
		}
		viewTags.add(viewTag);
	}
	
	public void clearViewTags() {
		viewTags = null;
	}
	
	public void deleteViewTag(String name) {
		if (viewTags != null) {
			Iterator<ViewTag> it = viewTags.iterator();
			while (it.hasNext()) {
				if (it.next().getName().equals(name)) {
					it.remove();
				}
			}
			if (viewTags.isEmpty()) {
				viewTags = null;
			}
		}
	}

	public LinkedList<ViewTag> getViewTags() {
		return viewTags;
	}

	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String[] getModifiers() {
		return modifiers;
	}
	
	public String getType() {
		return type;
	}
	
	public byte getVisibilty() {
		return visibility;
	}
	
	public String getMergedjavaDocComment() {
		return mergedjavaDocComment;
	}
	
	public FeatureData[] getFeatureData() {
		return featureData;
	}
	
	public boolean isPrivate() {
		return visibility == VISIBILITY_PRIVATE;
	}
	
	public boolean isProtected() {
		return visibility == VISIBILITY_PROTECTED;
	}
	
	public boolean isPublic() {
		return visibility == VISIBILITY_PUBLIC;
	}
	
	public boolean isDefault() {
		return visibility == VISIBILITY_DEFAULT;
	}
	
	public boolean isFinal() {
		return finalSignature;
	}

	public void setMergedjavaDocComment(String mergedjavaDocComment) {
		this.mergedjavaDocComment = mergedjavaDocComment;
	}
	
	public void setFeatureData(FeatureData[] featureData) {
		if (this.featureData == null) {
			this.featureData = featureData;
		}
	}

	public int hasFeature(int id) {
		for (int j = 0; j < featureData.length; j++) {
			if (id == featureData[j].id) {
				return j;
			}
		}
		return -1;
	}
	
	public boolean hasFeature(int[] idArray) {
		if (idArray == null) {
			return true;
		}
		for (int i = 0; i < idArray.length; i++) {
			int curId = idArray[i];
			for (int j = 0; j < featureData.length; j++) {
				if (curId == featureData[j].id) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public final int hashCode() {
		if (!hasHashCode) {
			computeHashCode();
			hasHashCode = true;
		}
		return hashCode;
	}
	
	protected void computeHashCode() {
		hashCode = 1;
		hashCode = hashCodePrime * hashCode + fullName.hashCode();
		hashCode = hashCodePrime * hashCode + Arrays.hashCode(modifiers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		return sigEquals((AbstractSignature) obj);
	}
	
	protected boolean sigEquals(AbstractSignature otherSig) {
		if (!fullName.equals(otherSig.fullName)
				|| !Arrays.equals(modifiers, otherSig.modifiers)
				) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		if (hasViewTags()) {
			sb.append("//+ ");
			for (ViewTag viewTag : viewTags) {
				sb.append(viewTag.toString());
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}
}
