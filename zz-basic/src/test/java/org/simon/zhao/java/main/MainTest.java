package org.simon.zhao.java.main;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author Zhaozhou
 * @date 2017/6/7
 */
public class MainTest {

	@Test
	public void testSubString() {
		String s = "0123456789a";
		int length = s.length();

		int start = length - 6;
		System.out.println(StringUtils.substring(s, -15, 100));
		System.out.println(StringUtils.substring(s, -15, 100).length());


		for (int i = 0; i < 10; i++) {
			System.out.println(Math.random());
		}
	}
}
