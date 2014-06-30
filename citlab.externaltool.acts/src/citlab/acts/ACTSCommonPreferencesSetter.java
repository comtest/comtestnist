package citlab.acts;

import java.util.Arrays;
import java.util.List;

import citlab.core.genprefs.CitlabBooleanPreference;
import citlab.core.genprefs.CitlabEnumPreference;
import citlab.core.genprefs.CitlabPreferncesSet;

/**
 * set the preferences for ACTS
 * 
 * 
 */
public class ACTSCommonPreferencesSetter {
	public static void set(TSGeneratorByACTS ts, String nodeName) {
		CitlabPreferncesSet genProperties = new CitlabPreferncesSet(nodeName);
		CitlabBooleanPreference randomize = new CitlabBooleanPreference("RANDOMIZE_VALUE");
		randomize.setMyValue(true);
		genProperties.add(randomize);
		List<String> domain = Arrays.asList(new String[] { "CSP","Forbidden tuples" });
		CitlabEnumPreference constraintHandler = new CitlabEnumPreference(
				"CONSTRAINT_HANDLER", domain);
		constraintHandler.setMyValue("CSP");
		genProperties.add(constraintHandler);
		// load - if no prop is stored, take the default value
		genProperties.loadPrefs();
		// store the prferences
		genProperties.storePrefs();
		ts.setGenProperties(genProperties);
	}

}
