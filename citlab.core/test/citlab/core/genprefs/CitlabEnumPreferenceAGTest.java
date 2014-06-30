package citlab.core.genprefs;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CitlabEnumPreferenceAGTest {

	@Test
	public void testSetMyValueString() {
		CitlabEnumPreferenceAG<MyEnum> myPref = new CitlabEnumPreferenceAG<>("myenum", Arrays.asList(MyEnum.values()));
		myPref.setMyValue(MyEnum.A);
		assertEquals(MyEnum.A,myPref.getMyValue());
	}

}

enum MyEnum {A,B,C;}