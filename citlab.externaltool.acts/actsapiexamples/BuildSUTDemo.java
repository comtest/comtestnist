/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
import edu.uta.cse.fireeye.common.*;

import edu.uta.cse.fireeye.service.engine.IpoEngine;

import java.util.ArrayList;

/**
 * This test class shows how to use the API interface of ACTS to build a test
 * set.
 * 
 */
public class BuildSUTDemo {
	public static void main(String[] argv) {
		// build a system configuration
		SUT sut = new SUT("TCAS");

		// it is recommended to create a new parameter from the SUT object
		// doing so will assign the parameter with an ID automatically
		Parameter cur_vertical_sep = sut.addParam("Cur_Vertical_Sep");

		// all the parameter values are originally string values
		// but they may be interpreted differently based on parameter type
		// when processing constraints
		cur_vertical_sep.addValue("299");
		cur_vertical_sep.addValue("300");
		cur_vertical_sep.addValue("601");
		cur_vertical_sep.setType(Parameter.PARAM_TYPE_INT);

		Parameter high_confidence = sut.addParam("High_Confidence");
		high_confidence.addValue("true");
		high_confidence.addValue("false");
		high_confidence.setType(Parameter.PARAM_TYPE_BOOL);

		Parameter two_of_three_reports_valid = sut
				.addParam("Two_of_Three_Reports_Valid");
		two_of_three_reports_valid.addValue("true");
		two_of_three_reports_valid.addValue("false");
		two_of_three_reports_valid.setType(Parameter.PARAM_TYPE_BOOL);

		Parameter own_tracked_alt = sut.addParam("Own_Tracked_Alt");
		own_tracked_alt.addValue("1");
		own_tracked_alt.addValue("2");
		own_tracked_alt.setType(Parameter.PARAM_TYPE_INT);

		Parameter other_tracked_alt = sut.addParam("Other_Tracked_Alt");
		other_tracked_alt.addValue("1");
		other_tracked_alt.addValue("2");
		other_tracked_alt.setType(Parameter.PARAM_TYPE_INT);

		Parameter own_tracked_alt_rate = sut.addParam("Own_Tracked_Alt_Rate");
		own_tracked_alt_rate.addValue("600");
		own_tracked_alt_rate.addValue("601");
		own_tracked_alt_rate.setType(Parameter.PARAM_TYPE_INT);

		Parameter alt_layer_value = sut.addParam("Alt_Layer_Value");
		alt_layer_value.addValue("0");
		alt_layer_value.addValue("1");
		alt_layer_value.addValue("2");
		alt_layer_value.addValue("3");
		alt_layer_value.setType(Parameter.PARAM_TYPE_INT);

		Parameter up_separation = sut.addParam("Up_Separation");
		up_separation.addValue("0");
		up_separation.addValue("399");
		up_separation.addValue("400");
		up_separation.addValue("499");
		up_separation.addValue("500");
		up_separation.addValue("639");
		up_separation.addValue("640");
		up_separation.addValue("739");
		up_separation.addValue("740");
		up_separation.addValue("840");
		up_separation.setType(Parameter.PARAM_TYPE_INT);

		Parameter down_separation = sut.addParam("Down_Separation");
		down_separation.addValue("0");
		down_separation.addValue("399");
		down_separation.addValue("400");
		down_separation.addValue("499");
		down_separation.addValue("500");
		down_separation.addValue("639");
		down_separation.addValue("640");
		down_separation.addValue("739");
		down_separation.addValue("740");
		down_separation.addValue("840");
		down_separation.setType(Parameter.PARAM_TYPE_INT);

		Parameter other_rac = sut.addParam("Other_RAC");
		other_rac.addValue("NO_INTENT");
		other_rac.addValue("DO_NOT_CLIMB");
		other_rac.addValue("DO_NOT_DESCEND");
		other_rac.setType(Parameter.PARAM_TYPE_ENUM);

		Parameter other_capability = sut.addParam("Other_Capability");
		other_capability.addValue("TCAS_TA");
		other_capability.addValue("OTHER");
		other_capability.setType(Parameter.PARAM_TYPE_ENUM);

		Parameter climb_inhibit = sut.addParam("Climb_Inhibit");
		climb_inhibit.addValue("true");
		climb_inhibit.addValue("false");
		climb_inhibit.setType(Parameter.PARAM_TYPE_BOOL);

		// create relations
		Relation r = new Relation(3);
		r.addParam(cur_vertical_sep);
		r.addParam(up_separation);
		r.addParam(down_separation);

		// add this relation into the sut
		sut.addRelation(r);

		// add the default relation
		sut.addDefaultRelation(2);

		// create constraints
		ArrayList<Parameter> params = new ArrayList<Parameter>();
		params.add(cur_vertical_sep);
		params.add(other_capability);
		Constraint c1 = new Constraint(
				"Cur_Vertical_Sep != 299 => Other_Capability != \"OTHER\"",
				params);

		// add this constraint into the sut
		sut.addConstraint(c1);

		// print out the sut
		System.out.println(sut);

		// set the test generation profile
		// randomize don't care values
		TestGenProfile.instance().setRandstar(TestGenProfile.ON);

		// Create an IPO engine object
		IpoEngine engine = new IpoEngine(sut);

		// build a test set
		engine.build();

		// get the resulting test set
		TestSet ts = engine.getTestSet();

		// print out the test set
		TestSetWrapper wrapper = new TestSetWrapper(ts, sut);

		// print into the standard out
		wrapper.outputInCSVFormat();

		// print into a file
		wrapper.outputInCSVFormat("tcas-output.txt");
	}
}
