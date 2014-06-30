package citlab.validator;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

import citlab.validator.yices.YicesLibrary;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;

public class YicesTest {

	static YicesLibrary yices = YicesLibrary.INSTANCE;

	@Test
	public void test1() {
		/*
		 * #include"yices_c.h"
		 * 
		 * int main() {
		 * 
		 * yices_context ctx = yices_mk_context(); yices_del_context(ctx);
		 * return 0; }
		 */
		Pointer ctx = YicesLibrary.INSTANCE.yices_mk_context();
		YicesLibrary.INSTANCE.yices_del_context(ctx);

	}

	@Test
	public void testEx2Eq() {
		/*
		 * #include<stdio.h> #include"yices_c.h"
		 * 
		 * int main() { yices_context ctx = yices_mk_context(); yices_expr e1 =
		 * yices_mk_fresh_bool_var(ctx); yices_expr e2 =
		 * yices_mk_fresh_bool_var(ctx); yices_expr eq1 = yices_mk_eq(ctx, e1,
		 * e2); yices_assert(ctx, eq1); yices_dump_context(ctx);
		 * switch(yices_check(ctx)) { case l_true: printf("satisfiable\n");
		 * yices_model m = yices_get_model(ctx); printf("e1 = %d\n",
		 * yices_get_value(m, yices_get_var_decl(e1))); printf("e2 = %d\n",
		 * yices_get_value(m, yices_get_var_decl(e2))); yices_display_model(m);
		 * break; case l_false: printf("unsatisfiable\n"); break; case l_undef:
		 * printf("unknown\n"); break; } yices_del_context(ctx); return 0; }
		 */
		Pointer ctx = yices.yices_mk_context();
		Pointer e1 = yices.yices_mk_fresh_bool_var(ctx);
		Pointer e2 = yices.yices_mk_fresh_bool_var(ctx);
		// e1 eq e2
		Pointer eq1 = yices.yices_mk_eq(ctx, e1, e2);
		yices.yices_assert(ctx, eq1);
		//
		// yices.yices_dump_context(ctx);
		switch (yices.yices_check(ctx)) {
		case YicesLibrary.lbool.l_true:
			System.out.println("satisfiable");
			Pointer m = yices.yices_get_model(ctx);
			int val1 = yices.yices_get_value(m, yices.yices_get_var_decl(e1));
			// System.out.println(val1);
			int val2 = yices.yices_get_value(m, yices.yices_get_var_decl(e2));
			// System.out.println(val2);
			Assert.assertEquals(val1, val2);
			break;
		default:
			fail("????");
		}
		;
		yices.yices_del_context(ctx);

	}

	@Test
	public void testAnd() throws Exception {
		Pointer ctx = yices.yices_mk_context();
		//Pointer e1 = yices.yices_mk_fresh_bool_var(ctx);
		//Pointer e2 = yices.yices_mk_fresh_bool_var(ctx);
		Pointer e1 = yices.yices_mk_bool_var(ctx,"e1");
		Pointer e3 = yices.yices_mk_bool_var(ctx,"e1");
		Pointer e2 = yices.yices_mk_bool_var(ctx,"e2");
		// e1 and e2
		Pointer[] e12 = { e1, e2, e3 };
		Pointer e1ande2 = yices.yices_mk_and(ctx, e12, 2);
		yices.yices_assert(ctx, e1ande2);
		//
		// yices.yices_dump_context(ctx);
		int res = yices.yices_check(ctx);
		assertEquals(YicesLibrary.lbool.l_true, res);
		Pointer m = yices.yices_get_model(ctx);
		int val1 = yices.yices_get_value(m, yices.yices_get_var_decl(e1));
		assertEquals(YicesLibrary.lbool.l_true, val1);
		int val2 = yices.yices_get_value(m, yices.yices_get_var_decl(e2));
		assertEquals(YicesLibrary.lbool.l_true, val2);
		System.out.println(val2);
		yices.yices_del_context(ctx);

	}

	//crashes !!!
	// @Test
	public void testAndPointerRef() throws Exception {
		Pointer ctx = yices.yices_mk_context();
		Pointer e1 = yices.yices_mk_fresh_bool_var(ctx);
		Pointer e2 = yices.yices_mk_fresh_bool_var(ctx);
		// e1 and e2
		Pointer[] e12 = { e1, e2 };
		PointerByReference ptr = new PointerByReference(e12[0]);
		Pointer e1ande2 = yices.yices_mk_and(ctx,ptr, 2);
		yices.yices_assert(ctx, e1ande2);
		//
		// yices.yices_dump_context(ctx);
		int res = yices.yices_check(ctx);
		assertEquals(YicesLibrary.lbool.l_true, res);
		Pointer m = yices.yices_get_model(ctx);
		int val1 = yices.yices_get_value(m, yices.yices_get_var_decl(e1));
		assertEquals(YicesLibrary.lbool.l_true, val1);
		int val2 = yices.yices_get_value(m, yices.yices_get_var_decl(e2));
		assertEquals(YicesLibrary.lbool.l_true, val2);
		System.out.println(val2);
		yices.yices_del_context(ctx);

	}

	@Test
	public void testOr() throws Exception {
		Pointer ctx = yices.yices_mk_context();
		Pointer e1 = yices.yices_mk_fresh_bool_var(ctx);
		Pointer e2 = yices.yices_mk_fresh_bool_var(ctx);
		// e1 and e2
		Pointer[] e12 = { e1, e2 };
		Pointer e1ande2 = yices.yices_mk_or(ctx, e12, 2);
		yices.yices_assert(ctx, e1ande2);
		//
		// yices.yices_dump_context(ctx);
		int res = yices.yices_check(ctx);
		assertEquals(YicesLibrary.lbool.l_true, res);
		Pointer m = yices.yices_get_model(ctx);
		int val1 = yices.yices_get_value(m, yices.yices_get_var_decl(e1));
		int val2 = yices.yices_get_value(m, yices.yices_get_var_decl(e2));
		assertTrue(YicesLibrary.lbool.l_true == val1
				|| YicesLibrary.lbool.l_true == val2);
		yices.yices_del_context(ctx);

	}

	@Test
	public void testScalarNamedType() throws Exception {
		String values[] = { "a1", "a2" };
		String typeName = "pair";
		for (String val : values) {
			// a = {a1,a2}
			Pointer ctx = yices.yices_mk_context();
			int res = yices.yices_parse_command(ctx,
					"(define-type "+ typeName +" (scalar a1 a2))");
			assertEquals(yices.yices_get_last_error_message(), 1, res);
			Pointer type = yices.yices_mk_type(ctx, typeName);
			assertNotNull(yices.yices_get_last_error_message(), type);
			Pointer adecl = yices.yices_mk_var_decl(ctx, "a", type);
			Pointer a = yices.yices_mk_var_from_decl(ctx, adecl);
			Pointer a1 = yices.yices_parse_expression(ctx, val);
			// get the model for a = val
			Pointer aeqa1 = yices.yices_mk_eq(ctx, a, a1);
			yices.yices_assert(ctx, aeqa1);
			// get the model
			res = yices.yices_check(ctx);
			assertEquals(YicesLibrary.lbool.l_true, res);
			Pointer model = yices.yices_get_model(ctx);
			// use new functions
			assertEquals(val, yices.yices_get_scalar_value_name(model, adecl));
			// System.out.println(string.flag);
			yices.yices_display_model(model);
			yices.yices_dump_context(ctx);
			yices.yices_del_context(ctx);
		}

	}
	

	@Test
	public void testSubrangeType() throws Exception {
		int res;
		// a = [0,7]
		Pointer ctx = yices.yices_mk_context();
		//int res = yices.yices_parse_command(ctx,
		//		"(define-type range1 (subrange 0 7))");
		//		Pointer type = yices.yices_mk_type(ctx, "range1");
		Pointer type = yices.yices_parse_type(ctx, "(subrange 0 7)");
		assertNotNull(yices.yices_get_last_error_message(), type);
		Pointer adecl = yices.yices_mk_var_decl(ctx, "a", type);
		Pointer a = yices.yices_mk_var_from_decl(ctx, adecl);
		// get the model for a = val
		assertNotNull(yices.yices_get_last_error_message(), a);
		Pointer n4 = yices.yices_mk_num(ctx, 4);
		// a = 4
		Pointer eq1 = yices.yices_mk_eq(ctx, a, n4);
		yices.yices_assert(ctx, eq1);
		res = yices.yices_check(ctx);
		yices.yices_dump_context(ctx);
		assertEquals(YicesLibrary.lbool.l_true, res);
		Pointer m = yices.yices_get_model(ctx);
		// non funziona da qui
		NativeLongByReference val = new NativeLongByReference();
		int val1 = yices.yices_get_int_value(m, adecl,val);
		assertEquals(YicesLibrary.lbool.l_true,val1);
		assertEquals(4,val.getValue().intValue());
		yices.yices_del_context(ctx);
	}
	@Test
	public void testNumbers() throws Exception{
		Pointer ctx = yices.yices_mk_context();
		Pointer type = yices.yices_parse_type(ctx, "(subtype (n::int) (or (= n 2) (= n 8) ))");
		assertNotNull(yices.yices_get_last_error_message(), type);
		Pointer adecl = yices.yices_mk_var_decl(ctx, "a", type);
		Pointer a = yices.yices_mk_var_from_decl(ctx, adecl);
		Pointer n2 = yices.yices_mk_num(ctx, 2);
		// a = 2
		Pointer eq1 = yices.yices_mk_eq(ctx, a, a);
		yices.yices_assert(ctx, eq1);
		int res = yices.yices_check(ctx);
		assertEquals(YicesLibrary.lbool.l_true, res);
		yices.yices_dump_context(ctx);
		NativeLongByReference val = new NativeLongByReference();
		Pointer m = yices.yices_get_model(ctx);
		yices.yices_display_model(m);
//		int val1 = yices.yices_get_int_value(m, adecl,val);
//		
//		assertEquals(YicesLibrary.lbool.l_true,val1);
	//	assertEquals(2,val.getValue().intValue());
		yices.yices_del_context(ctx);
	}

}
