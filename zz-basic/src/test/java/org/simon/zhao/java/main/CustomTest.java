package org.simon.zhao.java.main;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * @author Zhaozhou
 * @date 2017/3/8
 */
public class CustomTest {

	@Test
	public void test() {
		String strs[] = {"Returns the Unicode code point before the specified index.", "中华人民共和国", "人", "人民" };
		for (String str : strs) {
			byte[] bytes1 = str.getBytes();
			byte[] bytes2 = str.getBytes(Charset.forName("utf-8"));
			char[] chars = str.toCharArray();
			for (char c:chars) {

				System.out.print(Integer.toHexString(c) + "\t");
			}
			System.out.println();
//			System.out.println(str + " default encoding : " + bytes1.length + "\t utf-8 encoding : " + bytes2.length);
		}
	}

	@Test
	public void testShowAllChars() {
		BigInteger end = new BigInteger("ffff", 16);
		System.out.println(end);
		int endInt = end.intValue();

		for (int i = 0; i < endInt; i++)
		{
			char c = (char) i;
			System.out.print(c + "\t");
			if(i % 100 == 0)
			{
				System.out.println();
			}
		}
	}

	@Test
	public void testChar() {
		String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");
		System.out.println(original);
	}
}
