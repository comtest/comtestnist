package citlab.model.rnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * generates a random model
 * 
 */
public class RndModelGenerator {

	private int nParameters;
	private int domainSize;

	
	/**
	 * 
	 * @param nParameters
	 * @param domainSize : every parameter will have this number of values
	 */
	public RndModelGenerator(int nParameters, int domainSize) {
		this.nParameters = nParameters;
		this.domainSize = domainSize;
	}

	public StringBuffer getRndModel() {
		//
		StringBuffer result = new StringBuffer();
		result.append("Model " + "random_"+nParameters + "_" + domainSize).append("\n");
		// paramters
		result.append("Parameters:\n");
		List<String> parameters = new ArrayList<>();
		for (int i = 1; i <= nParameters; i++) {
			String param = "parameter" + i;
			parameters.add(param);
			result.append("Range ").append(param).append("[1 .. " +domainSize + "];\n"); 
		}
		// constraints
		result.append("end\nConstraints:\n");
		// add the constraints
		Random rnd = new Random();
		// introduce from 2 to nParamters forbiden tuples
		for (int npc = 2; npc <= nParameters; npc++) {
			//System.out.println("constrained parameters " + npc);
			//npc = number of parameters in constraints
			// get the first i parameters

			// take n = nParameters -j constraints
			for (int nC = 1; nC <= nParameters - npc +1; nC++) {
				result.append("//constraint " + nC + " forbidden size " + npc + "\n");
				Collections.shuffle(parameters);
				result.append("# ");
				boolean first = true;
				for (int j = 0; j <npc; j++) {
					String param = parameters.get(j);
					int value = rnd.nextInt(domainSize) + 1;
					System.out.println(param + "!=" + value);
					if (first){
						first = false;
					} else{
						result.append(" or ");
					}
					result.append(param + "!=" + value);					
				}
				result.append("#\n");					
			}
		}
		result.append("end\n");
		return result;
	}

}
