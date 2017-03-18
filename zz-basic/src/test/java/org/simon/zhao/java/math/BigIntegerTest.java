package org.simon.zhao.java.math;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Zhaozhou
 * @date 2017/3/9
 */
public class BigIntegerTest {
	@Test
	public void testConstructor() throws Exception {
		BigInteger bi = new BigInteger(8, new Random(10));
		System.out.println(bi);
	}
}
