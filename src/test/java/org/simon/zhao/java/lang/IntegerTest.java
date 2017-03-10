package org.simon.zhao.java.lang;

import org.junit.Test;

/**
 * @author Zhaozhou
 * @date 2017/3/9
 */
public class IntegerTest {

	@Test
	public void testGetInteger() {
		System.out.println(Integer.getInteger("idea.launcher.port"));
	}

	@Test
	public void testReverse() throws Exception {
		int value = 10;
		System.out.println(Integer.toBinaryString(value));
		System.out.println(Integer.toBinaryString(Integer.reverse(value)));
//		System.out.println(Integer.parseInt("11111111111111111111111111111010",2));
	}
}
