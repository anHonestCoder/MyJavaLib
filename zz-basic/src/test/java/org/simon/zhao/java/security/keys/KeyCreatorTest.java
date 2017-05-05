package org.simon.zhao.java.security.keys;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * @author Zhaozhou
 * @date 2017/3/7
 */
public class KeyCreatorTest {

	@Test
	public void testGenerateHmacSHA256Key() throws NoSuchAlgorithmException {
		for (int i = 0; i < 20; i++) {
			String base64Key = KeyCreator.generateHmacSHA256Key();
			System.out.println(base64Key);
		}
	}

	@Test
	public void testGenerateHmacSHA1Key() throws NoSuchAlgorithmException {
		String base64Key = KeyCreator.generateHmacSHA1Key();
		System.out.println("HmacSHA1Key:\t" + base64Key + "\tlength=" + base64Key.length());
	}

	@Test
	public void testGenerateDESedeKey() throws NoSuchAlgorithmException {
		String base64Key = KeyCreator.generateDESedeKey();
		System.out.println("DESedeKey:\t" + base64Key + "\tlength=" + base64Key.length());

	}
}
