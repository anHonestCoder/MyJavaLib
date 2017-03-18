package org.simon.zhao.java.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created by zhou01.zhao on 2016/10/26.
 */
public class DirectoryOperatorTest {
	@Test
	public void testCopyDirectoryRecursion() {
		File sourceDir = new File("D:\\workspace");
		File destDir = new File("J:\\office2016");
		long start = System.currentTimeMillis();
		DirectoryOperator.copyFolder(sourceDir, destDir);
		long end = System.currentTimeMillis();
		sourceDir.length();
		System.out.println("Copy " + sourceDir.getAbsolutePath() + "to " + destDir.getAbsolutePath() + ". Spends " + (end-start) + "ms.");
	}

	@Test
	public void testDeleteDirectory() {
		DirectoryOperator.deleteDirectory("J:\\GitDemo");
	}

	@Test
	public void testCopyFile() {
		Path sourcePath = Paths.get("G:\\old.20160303.zip");
		Path destinationPath = Paths.get("E:\\old.20160303.zip");
		if(Files.notExists(destinationPath)) {
			try {
				Files.createFile(destinationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long start = System.currentTimeMillis();
		DirectoryOperator.copyFile(sourcePath, destinationPath);
		long end = System.currentTimeMillis();
		System.out.println(String.format("Copy %s to %s Spends %d ms", sourcePath, destinationPath, end-start));
	}

}
