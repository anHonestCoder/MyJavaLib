package org.simon.zhao.java.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhou01.zhao on 2016/12/27.
 */
public class PropertiesUtil {

	/**
	 * 加载配置文件
	 * @param propFile
	 * @return
	 */
	public static Properties loadPropsFromClsPath(String propFile) {
		Properties props = new Properties();
		InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFile);
		try {
			props.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return props;
	}

	public static void traverseProps(Properties props) {
		String key = "";
		String val = "";
		for (Map.Entry entry : props.entrySet()) {
			key = entry.getKey().toString();
			val = props.getProperty(key);
			System.out.printf("%s = %s\n", key, val);
		}
	}

}
