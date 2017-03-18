package org.simon.zhao.java.verifysign;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou01.zhao on 2016/12/27.
 */
public class SignHelperTest {

	@Test
	public void testGetQueryString() {
		Map<String, String> map = new HashMap<>();
		map.put("id", "8391939kdka+lkdk88ak*-kdkak");
		map.put("name", "赵洲");
		map.put("bingdingID", "0RkNcIi1ksVKnrV+T2Cjvg==");
		System.out.println(SignHelper.getQueryString(map));
	}
}
