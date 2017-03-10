package org.simon.zhao.java.security.encryption;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.util.Base64;

/**
 * Created by zhou01.zhao on 2017/1/10.
 */
public class HMACSHA1Test {
	@Test
	public void hmacsha1Encrypt() throws Exception {
		/*byte[] cipher = HMACSHA1.HmacSHA1Encrypt("textddd", "keyddd");
		byte[] cipher2 = HMACSHA1.HmacSHA1Encrypt("textddd", "keyddd");
		System.out.println(new String(cipher, "utf-8").equals(new String(cipher2, "utf-8")));
		System.out.println(cipher.length);*/

		KeyGenerator keyGenerator = KeyGenerator.getInstance(HMACSHA1.MAC_NAME);
		for (int i = 0 ; i < 5 ; i++) {
			String key = Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());
			System.out.println(key);
		}

	}
}
