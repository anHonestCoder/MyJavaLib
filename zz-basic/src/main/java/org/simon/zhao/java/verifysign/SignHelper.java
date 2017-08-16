package org.simon.zhao.java.verifysign;

import org.springframework.util.StringUtils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhou01.zhao on 2016/12/27.
 */
public class SignHelper {

	/**
	 *
	 * @param base64RSAPrivateKey Base64编码的RSA私钥
	 * @param paramMap 需要加签的参数
	 * @return Base64编码的签名
	 */
	public static String sign(String base64RSAPrivateKey, Map<String, String> paramMap) throws Exception{
		PrivateKey privateKey = getRSAPrviateKey(base64RSAPrivateKey);
		String queryString = getQueryString(paramMap);
		byte[] signBytes = sign(privateKey, queryString);
		return org.apache.axis.encoding.Base64.encode(signBytes);
	}

	/**
	 *
	 * @param privateKey 加签私钥对象
	 * @param queryString	签名原文
	 * @return	签名字节数组
	 */
	public static byte[] sign(PrivateKey privateKey, String queryString) throws Exception{
		Signature signer = Signature.getInstance("SHA1WITHRSA");
		signer.initSign(privateKey);
		byte[] queryStrBytes = queryString.getBytes("utf-8");
		// 用私钥对信息生成数字签名
		signer.update(queryStrBytes);
		return signer.sign();
	}

	public static String getQueryString(Map<String, String> paramMap) {
		if(paramMap == null || paramMap.isEmpty()){
			return "";
		}

		TreeMap<String, String> paramTreeMap = new TreeMap();
		for(Map.Entry<String, String> entry:paramMap.entrySet()){
			paramTreeMap.put(entry.getKey(), entry.getValue());
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (String key : paramTreeMap.keySet()) {
			String value = paramTreeMap.get(key);
			if (!StringUtils.isEmpty(value)) {
				cnt++;
				if (cnt > 1) {
					sb.append("&");
				}
				sb.append(key).append("=").append(paramTreeMap.get(key));
			}
		}
		String queryString = sb.toString();
		return queryString;
	}

	/**
	 *
	 * @param base64RSAPrivateKey Base64编码的RSA私钥
	 * @return PrivateKey
	 * @throws Exception
	 */
	private static PrivateKey getRSAPrviateKey(String base64RSAPrivateKey) throws Exception{
		byte[] decoded = org.apache.axis.encoding.Base64.decode(base64RSAPrivateKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
		RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
		return privKey;
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", "8391939kdka+lkdk88ak*-kdkak");
		map.put("name", "赵洲");
		map.put("bingdingID", "0RkNcIi1ksVKnrV+T2Cjvg==");

		String base64PrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC3fMSwgcp+8pEV9fcuYDZXzCThFZjEmCoUVV4k8gOx6QgnY7CUP4PELPqJRDvegN6sdMTr/zkinCeKSNEzpn44WwdfdrDCrew05TFLkOYPD5c0Jkyd7SrHaDR3d7euB5SdrBhPlYeiwLt0homyQpwuKLaVVnOzxR6xrH9M+0tpwLSGyw0sL9RMXBl0VvjcHyiPSzKRG5T3iRZUZRIxsb4cwxs53BRPXCsV1hk8CH2zgB2I9Z/FpAAPQtNcSWQWHvaIjmtAMveuq4tT3AjgS2lz7adFykwq47x0d0V7OeT7le3/xZuLfwe5lM5O8+qaFukmYC0h7G3n6BlItyCEc1ypAgMBAAECggEANnX1+13KuLtOjPIgl8c+2fhhyd0bJt7zPm3IL7cVmazNGsPgGWBwv72J70wtaPFfJljSSinKz5cBtW2/ilEUja2XFqKn/GCbB2gvpXowjq/V9UiY3RcT53Pqfrst7Z2aYuI9pQGA7LG/8eos3JgguyKibtjmJqmPXrUQY80CqTRkt0I6B0RTuWZ8gNSnjR36sHVFIM3ltIjaLFLft30Qrs4b7x+aLlNzdo4WP/1vEaD41kxRVHEM8CWghpzSVQRcbydpVO/AnrhuS8hO8EvWGpdNVESbLqEdAEudIVtnjwG253nAjt7pGpKDna/kRG12dyRA8PpY48wCziAgGcBasQKBgQDaeCbkGJX/Gdh8ayWC1etBtuFhc3RuGtdoAFHtWISi6vF6+3fBEONvuV7pF+EXzwjQQCyKO78w16GBwNHL3GRBtj0O9K/wSY5KU74/5S9miNpfovUkBqqCN2NHJ6yrv3a94MhPGaoVQ6X0FAcnZgufxGvfoHMr9h+u3LUJl/nP1wKBgQDXAi3Nq3F4J8xyCTsJc8i5b39hHj6tHu/r2haromr1c6NDvBupV3SMsZFktCKROr8S3GEsRSoEG27F8aAC9ckBhyWAxYXMZydLlCpHNZx627zlCuGWb/jZx3eFf9EextFbe5Qr2c68UyQz+5o/A5cek49wVrzF8YH/oo9MwJCnfwKBgQDV0olF8CZGwnYW+AuDrXmPHL4kUgrfhNfVC5Mj+OIATnDAjITd6nifrc+N1fhSBCk9IcI2HVn4JOQHCcCMhY1+ny3NiID2bhec+a+X++lTspgAyI6jjv6taiZ5ywP+KOu/1dRXTugf3dD8PenujrrLyURHYFO48DB8RbnOxPcUiwKBgQDMQfGpldnyQDzliQdg73IdWGM2rDj21pEvCrzGyUG7dOQBkU7mDYNXtcleVhMQzTKAhIR8PiiwRi9yNR3CMiWHIhDqyLtXeBfIoTWY+MFzphVJspClDjLnEavmU4sjJdX2huw4zG6uUn3uNHRQsOR708tM+dnUYp8RcCmazMWfmQKBgQC/OsUg0QOuZSeej0B0+cWdYGdtMTqoq9/2gN9JPnjHJRPTga51+bTux/uXUeD7+lGPMWoUViIcdt0I2GjSQYIVY33l037BgOWw7E9tZCJIAXELdulVAMCmOpyJhpRoXFRnt88YMFhknIht023TjJD/T/nP6Sjh94QVwRPVEZWQng==";
		String base64Sign = SignHelper.sign(base64PrivateKey, map);
		System.out.println(base64Sign);
	}
}
