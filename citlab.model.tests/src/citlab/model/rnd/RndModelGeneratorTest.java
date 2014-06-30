package citlab.model.rnd;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

public class RndModelGeneratorTest {

	public static final String CITLAB_BENCHMARKS_RANDOM5 = "modelsfortests/random5";

	@Test
	public void testRndModelGenerator1() {
		RndModelGenerator rndGenerator = new RndModelGenerator(5, 4);
		StringBuffer res = rndGenerator.getRndModel();
		System.out.println(res);
	}

	@Test
	public void testRndModelGeneratorSet() throws FileNotFoundException {
		File dir = new File(CITLAB_BENCHMARKS_RANDOM5);
		assertTrue(dir.exists() && dir.isDirectory());
		int[] sizes = { 5, 10, 50};//, 100, 500, 1000 };
		for (int i : sizes) {
			RndModelGenerator rndGenerator = new RndModelGenerator(i, 5);
			for (int j = 1; j <= 5; j++) {
				StringBuffer res = rndGenerator.getRndModel();
				//System.out.println(res);
				// save on file
				File f = new File(dir,"random_5_"+i+"_"+j + ".citl");
				PrintWriter writer = new PrintWriter(f);
				writer.write(res.toString());
				writer.flush();
				writer.close();				
			}
		}
	}

}
