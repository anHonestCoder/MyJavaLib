package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhou01.zhao on 2016/11/8.
 */
public class Main2 {
	public static void main(String[] args) {
		FileSearch searcher = new FileSearch("C:\\", "C:\\Windows\\Help\\Windows\\en-US\\Windows.h1c");
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
