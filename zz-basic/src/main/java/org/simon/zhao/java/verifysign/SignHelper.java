package org.simon.zhao.java.verifysign;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhou01.zhao on 2016/12/27.
 */
public class SignHelper {
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
}
