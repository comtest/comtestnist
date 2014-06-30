package citlab.acts;

import edu.uta.cse.fireeye.common.TestGenProfile.Algorithm;

public class BaseChoiceGenerator extends TSGeneratorByACTS {

	public BaseChoiceGenerator() {
		super("BaseChoice");
	}

	@Override
	protected Algorithm getAlgorithm() {
		return Algorithm.basechoice;
	}	

}
