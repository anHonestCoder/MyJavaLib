package org.simon.zhao.java.security.keys;

import org.junit.Test;

/**
 * @author Zhaozhou
 * @date 2017/3/7
 */
public class KeyPairCreatorTest {

	@Test
	public void testGenerateRsaKeys() throws Exception {
		KeyPairCreator.generateRsaKeys(2048);
	}
}
