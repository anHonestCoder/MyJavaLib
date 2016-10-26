package org.simon.zhao.java.io;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by zhou01.zhao on 2016/10/25.
 */
public class DirectoryOperator {

	/**
	 *Use standard io api to copy a directory from one location to another with all it’s sub-folders and files they contain.
	 * @param sourceFile destination Directory
	 * @param destDir source Directory
	 */
	public static void copyDirectoryRecursion(File sourceFile, File destDir){

		String fileName = sourceFile.getName();
		if (sourceFile.isDirectory()){
			File tempDestDir = new File(destDir, fileName);
			tempDestDir.mkdir();
			File[] files = sourceFile.listFiles();
			for(File subFile:files) {
				copyDirectoryRecursion(subFile, tempDestDir);
			}
		} else {
			System.out.println("copy " + sourceFile.getAbsolutePath() + " to " + destDir.getAbsolutePath());
			copyFile(sourceFile, destDir);
		}

	}

	/**
	 * use nio aio to copy a directory from one location to another with all it’s sub-folders and files they contain.
	 * @param sourceFolder
	 * @param destinationFolder
	 * @throws IOException
	 */
	public static void copyFolder(File sourceFolder, File destinationFolder)
	{
		//Check if sourceFolder is a directory or file
		//If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory())
		{
			//Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists())
			{
				destinationFolder.mkdir();
				System.out.println("Directory created :: " + destinationFolder);
			}

			//Get all files from source directory
			String files[] = sourceFolder.list();

			//Iterate over all files and copy them to destinationFolder one by one
			for (String file : files)
			{
				File srcFile = new File(sourceFolder, file);
				File destFile = new File(destinationFolder, file);

				//Recursive function call
				copyFolder(srcFile, destFile);
			}
		}
		else
		{
			//Copy the file content from one place to another
			try {
				Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("File copied :: " + destinationFolder);
		}
	}


	/**
	 * To copy a file to the destination directory.
	 * @param sourceFile the source file
	 * @param destDir the destination directory
	 */
	public static void copyFile(File sourceFile, File destDir) {
		String fileName = sourceFile.getName();
		File destFile = new File(destDir, fileName);
		try(FileInputStream fis = new FileInputStream(sourceFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			FileOutputStream fos = new FileOutputStream(destFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos)
		) {
			int i = -1;
			while((i=dis.read()) != -1) {
				dos.write(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDirectory(String dirStr) {
		Path dir = Paths.get(dirStr);
		try {
			long start = System.currentTimeMillis();
			Files.walkFileTree(dir, new SimpleFileVisitor<Path>(){
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println("Delete file:" + file);
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					System.out.println("Deleting dir: " + dir);
					if (exc == null) {
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					} else {
						throw exc;
					}
				}
			});
			long end = System.currentTimeMillis();
			System.out.println("deleted " + dirStr + ". Spends " + (end-start)/60 + "s.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
