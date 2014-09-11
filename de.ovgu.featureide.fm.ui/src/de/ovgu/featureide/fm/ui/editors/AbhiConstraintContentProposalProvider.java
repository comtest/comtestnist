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
 
package de.ovgu.featureide.fm.ui.editors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import de.ovgu.featureide.fm.core.ClassificationFeature;
import de.ovgu.featureide.fm.core.Operator;

/**
 * provides proposals for content assist while typing constraints
 * 
 * @author AbhishekSharma
 

public class AbhiConstraintContentProposalProvider implements
		IContentProposalProvider {
	static final int CURRENT = 0;
	static final int LAST = 1;
	//private Set<String> features;
	
	//Abhi
	private List<ClassificationFeature> features;
	

	public AbhiConstraintContentProposalProvider(List<ClassificationFeature> featureNames) {
		super();
		features = featureNames;
	}

	*//**
	 * Return an array of Objects s representing the valid content proposals for
	 * a field.
	 * 
	 * @param contents
	 *            the current contents of the field
	 * @param position
	 *            the current cursor position within the field
	 * @return the array of Objects that represent valid proposals for the field
	 *         given its current content.
	 *//*
	public IContentProposal[] getProposals(String contents, int position) {

		
		String[] words = getWords(contents, position);
		
		List<ContentProposal> proposalList = getProposalList(words, contents);


		return proposalList
				.toArray(new IContentProposal[proposalList.size()]);

	}

	*//**
	 *  @return all possible feature names or junctors.
	 *  @param words
	 *  		current and previous word of edited string
	 *  @param contents
	 *  		complete string being edited
	 * 
	 *//*
	private List<ContentProposal> getProposalList(String[] words, String contents) {
		List<ContentProposal> proposalList = new ArrayList<ContentProposal>();	
			
		boolean caught = false;
		for (ClassificationFeature feature: features) {
			if (Operator.isOperatorName(feature.getName())||(feature.getName().contains(" ") && feature.getName().toLowerCase().startsWith(contents.substring(contents.lastIndexOf('"') + 1).toLowerCase()))) {
				proposalList.add(new ContentProposal("\"" + feature + "\""));
				caught = true;
			}
		}
		if (!caught) {
			if ("(".equals(words[CURRENT]) || " ".equals(words[CURRENT]) || "".equals(words[CURRENT])) {
				proposalList = getProposalList(words[LAST], features);	
			} else {
				for (ContentProposal proposal : getProposalList(words[LAST], features)) {
					if (proposal.getContent().length() > words[CURRENT].trim().length()
							&& proposal.getContent().substring(0, words[CURRENT].trim().length()).equalsIgnoreCase(words[CURRENT].trim())) {
						proposalList.add(proposal);
					} 
				}
			}
		}
		return proposalList;
	}

	*//**
	 * Returns the word that is being written and the word before it, given the
	 * current content and cursor position
	 * 
	 * @param contents
	 *            the content,i.e. the string which contains the text
	 * @param position
	 *            current position of the cursor, first position is 0
	 * @return Array with two elements: current word and the word before, words
	 *         can be empty String, index: CURRENT, LAST
	 *//*
	static String[] getWords(String contents, int position) {

		String[] words = new String[2];

		int posMarker = position - 1;
		if (position == 0) {
			words[CURRENT] = "";
			words[LAST] = "";
		} else {
			while (posMarker > 0 && contents.charAt(posMarker) != ' ') {
				posMarker--;
			}
			words[CURRENT] = contents.substring(posMarker, position);

			while (posMarker > 0 && contents.charAt(posMarker) == ' ') {
				posMarker--;
			}
			int startBefore = posMarker;
			while (startBefore > 0 && contents.charAt(startBefore) != ' ') {
				startBefore--;
			}
			if (posMarker == 0) {
				if (contents.charAt(0) == '(')
					words[LAST] = "(";
				else
					words[LAST] = "";
			} else
				words[LAST] = contents.substring(startBefore, posMarker + 1);

		}

		if (words[LAST].trim().startsWith("(") && words[LAST].length() > 1) {
			words[LAST] = words[LAST].substring(words[LAST].indexOf('(')+1);

		}
		if (words[CURRENT].trim().startsWith("(")) {
			words[CURRENT]=words[CURRENT].trim();
			words[CURRENT] = words[CURRENT].substring(1);
			words[LAST] = "(";
		}
		if (words[LAST].endsWith(")")) {
			words[LAST] = ")";
			if(contents.charAt(posMarker)==')'){
				words[LAST] = ") ";
			}


		}
		if (words[CURRENT].endsWith(")")) {
			words[LAST] = ")";
			words[CURRENT] = "";

		}

		return words;
	}

	*//**
	 * 
	 * @param wordBefore
	 * 			
	 * @param features
	 * 			set of features
	 * @return 
	 * 		List of proposals, either operators or feature names
	 *//*
	private static List<ContentProposal> getProposalList(String wordBefore,
			Set<String> features) {

		ArrayList<ContentProposal> proposals = new ArrayList<ContentProposal>();
		ArrayList<String> featureList = new ArrayList<String>(features);
		Collections.sort(featureList, String.CASE_INSENSITIVE_ORDER);
		
		
		if (") ".equals(wordBefore) || features.contains(wordBefore.trim()) || wordBefore.trim().endsWith("\"")) {
			proposals.add(new ContentProposal("and"));
			proposals.add(new ContentProposal("iff"));
			proposals.add(new ContentProposal("implies"));
			proposals.add(new ContentProposal("or"));

		} else if(!")".equals(wordBefore)){
			proposals.add(new ContentProposal("not"));

			for (String s : featureList) {
				if (s.contains(" "))
					proposals.add(new ContentProposal("\"" + s + "\""));
				else 
					proposals.add(new ContentProposal(s));
			}
		}
		return proposals;
	}

}*/