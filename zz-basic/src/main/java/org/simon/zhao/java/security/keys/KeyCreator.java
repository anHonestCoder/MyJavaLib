package org.simon.zhao.java.security.keys;

import org.simon.zhao.utils.Base64Util;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Zhaozhou
 * @date 2017/3/7
 */
public class KeyCreator {

	public static final String HMACSHA256 = "HmacSHA256";
	public static final String HMACSHA1 = "HmacSHA1";
	public static final String DESEDE = "DESede";

	/**
	 *
	 * @return Hmacsha256 key
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateHmacSHA256Key() throws NoSuchAlgorithmException {
		return generateBase64Key(HMACSHA256);
	}

	/**
	 *
	 * @return HMACSHA1 key
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateHmacSHA1Key() throws NoSuchAlgorithmException {
		return generateBase64Key(HMACSHA1);
	}

	/**
	 *
	 * @return
	 */
	public static String generateDESedeKey() throws NoSuchAlgorithmException {
		return generateBase64Key(DESEDE);
	}


	/**
	 * 生成秘钥
	 * @param algorithm 算法
	 * @return Base64编码的秘钥
	 */
	public static String generateBase64Key(String algorithm) throws NoSuchAlgorithmException {
		Key key = generateKey(algorithm);
		String base64Key = Base64Util.byteArrayToBase64(key.getEncoded());
		return base64Key;
	}


	/**
	 * generate key
	 * @param algorithm 算法
	 * @param length 长度
	 * @return Base64编码的秘钥
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateBase64Key(String algorithm, int length) throws NoSuchAlgorithmException {
		Key key = generateKey(algorithm, length);
		String base64Key = Base64Util.byteArrayToBase64(key.getEncoded());
		return base64Key;
	}

	/**
	 * 生成秘钥对象
	 * @param algorithm
	 * @return
	 */
	public static Key generateKey(String algorithm) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator =  KeyGenerator.getInstance(algorithm);
		return keyGenerator.generateKey();
	}

	/**
	 *
	 * @param algorithm
	 * @param length
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Key generateKey(String algorithm, int length) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator =  KeyGenerator.getInstance(algorithm);
		keyGenerator.init(length);
		return keyGenerator.generateKey();
	}

}
