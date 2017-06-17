package org.simon.zhao.java.io;

import org.junit.Test;

import java.io.File;

/**
 * @author Zhaozhou
 * @date 2017/6/13
 */
public class FileTest {
	@Test
	public void testListFiles() {
		File file = new File("E:\\work\\keys\\hmacksha256\\生产环境");
		File[] files = file.listFiles();
		for (File f:files) {
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());
		}
	}
}

