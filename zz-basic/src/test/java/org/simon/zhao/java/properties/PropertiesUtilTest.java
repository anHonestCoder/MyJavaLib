package org.simon.zhao.java.properties;

import org.junit.Test;

import java.util.Properties;

/**
 * Created by zhou01.zhao on 2016/12/27.
 */
public class PropertiesUtilTest {

	@Test
	public void testtRaverseProps()
	{
		Properties properties = PropertiesUtil.loadPropsFromClsPath("properties/jdbc.properties");
		PropertiesUtil.traverseProps(properties);
	}

	@Test
	public void printSysEnv()
	{
		Properties properties = System.getProperties();
		PropertiesUtil.traverseProps(properties);
	}
}
