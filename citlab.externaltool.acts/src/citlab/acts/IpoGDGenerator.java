package citlab.acts;

import edu.uta.cse.fireeye.common.TestGenProfile.Algorithm;

public class IpoGDGenerator extends TSGeneratorByACTS {

	public IpoGDGenerator() {
		super("IpoG_D");
		
	}

	@Override
	protected Algorithm getAlgorithm() {
		return Algorithm.ipog_d;
	}

}
