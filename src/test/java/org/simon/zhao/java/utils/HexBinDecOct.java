package org.simon.zhao.java.utils;

/**
 * @author Zhaozhou
 * @date 2017/3/10
 */

import java.math.BigInteger;

/**
 * 进制转换工具类
 */
public class HexBinDecOct {

	/**
	 * 十进制转二进制
	 * @param val
	 * @return
	 */
	public static String dec2Bin(int val) {
		return Integer.toBinaryString(val);
	}

	/**
	 * 十进制转八进制
	 * @param val
	 * @return
	 */
	public static String dec2Oct(int val) {
		return Integer.toOctalString(val);
	}

	/**
	 * 十进制转十六进制
	 * @param val
	 * @return
	 */
	public static String dec2Hex(int val) {
		return Integer.toHexString(val);
	}

	/**
	 * 二进制转十进制
	 * @param bin
	 * @return
	 */
	public static int bin2Dec(String bin) {
		return new BigInteger(bin, 2).intValue();
	}

	/**
	 * 八进制转十进制
	 * @param oct
	 * @return
	 */
	public static int oct2Dec(String oct) {
		return new BigInteger(oct, 8).intValue();
	}

	/**
	 * 十六进制转十进制
	 * @param hex
	 * @return
	 */
	public static int hex2Dec(String hex) {
		return new BigInteger(hex, 16).intValue();
	}

	/**
	 * 字节数组转十六进制
	 * @param  bytes 字节数组
	 * @return 十六进制
	 */
	public static String bytes2Hex(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuilder hexBuilder = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			hexBuilder.append(hexChars[(b & 0xF0) >> 4]);		//字节高4位
			hexBuilder.append(hexChars[b & 0x0F]);				//字节低4位
		}
		return hexBuilder.toString();
	}

	public static byte[] hex2Bytes(String hex) {
		//如果字符串长度不为偶数，则追加0
		if(hex.length() % 2 !=0){
			hex = "0"+hex;
		}

		byte[] b = new byte[hex.length() / 2];
		byte c1, c2;
		for (int y = 0, x = 0; x < hex.length(); ++y, ++x)
		{
			c1 = (byte)hex.charAt(x);
			if (c1 > 0x60) {
				c1 -= 0x57;
			} else if (c1 > 0x40){
				c1 -= 0x37;
			} else
			{
				c1 -= 0x30;
			}


			c2 = (byte)hex.charAt(++x);
			if (c2 > 0x60) {
				c2 -= 0x57;
			} else if (c2 > 0x40) {
				c2 -= 0x37;
			}else {
				c2 -= 0x30;
			}

			b[y] = (byte)((c1 << 4) + c2);
		}
		return b;
	}
}
