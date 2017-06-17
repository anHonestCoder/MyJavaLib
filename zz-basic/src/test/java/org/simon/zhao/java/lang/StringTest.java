package org.simon.zhao.java.lang;

import org.junit.Test;

/**
 * @author Zhaozhou
 * @date 2017/6/13
 */
public class StringTest {
	@Test
	public void testFormat() {
		String vpalMerchantNoCCb = "1234";
		String dateStr = "20170613";
		String name =String.format("SHOP.%s.%s.KJZF.txt", vpalMerchantNoCCb, dateStr);
		System.out.println(name);
	}
}
