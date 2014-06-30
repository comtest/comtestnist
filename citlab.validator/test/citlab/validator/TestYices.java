package citlab.validator;

import org.junit.Test;

import citlab.validator.yices.YicesLibrary;

import com.sun.jna.Pointer;

public class TestYices {
	

	@Test
	public void test() {
		// ho un problema con due enumerativiu
		// e un constraint
		YicesLibrary lib = YicesLibrary.INSTANCE;
		// crea contesto
		Pointer ctx = lib.yices_mk_context();
		// lib.y
		
	}

}
