package org.simon.zhao.java.io;

import org.junit.Test;

import java.io.File;

/**
 * Created by zhou01.zhao on 2016/10/26.
 */
public class DirectoryOperatorTest {
	@Test
	public void testCopyDirectoryRecursion() {
		File sourceDir = new File("D:\\workspace");
		File destDir = new File("G:\\");
		long start = System.currentTimeMillis();
		DirectoryOperator.copyFolder(sourceDir, destDir);
		long end = System.currentTimeMillis();
		sourceDir.length();
		System.out.println("Copy " + sourceDir.getAbsolutePath() + "to " + destDir.getAbsolutePath() + ". Spends " + (end-start) + "ms.");
	}

	@Test
	public void testDeleteDirectory() {
		DirectoryOperator.deleteDirectory("G:\\workspace");
	}

}
