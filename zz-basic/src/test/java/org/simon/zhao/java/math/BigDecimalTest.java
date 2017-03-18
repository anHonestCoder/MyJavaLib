package org.simon.zhao.java.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Zhaozhou
 * @date 2017/3/9
 */
public class BigDecimalTest {
	@Test
	public void testSetScale() throws Exception {
		BigDecimal decimal = new BigDecimal(67.78);
		System.out.println(decimal.setScale(5, BigDecimal.ROUND_HALF_UP));

	}
}
