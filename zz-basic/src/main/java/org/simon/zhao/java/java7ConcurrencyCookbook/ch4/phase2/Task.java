package org.simon.zhao.java.java7ConcurrencyCookbook.ch4.phase2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhaozhou
 * @date 2017/4/1
 */
public class Task implements Runnable {

	private Date initDate;
	private String name;

	public Task(String name) {
		initDate = new Date();
		this.name = name;
	}
	@Override
	public void run() {
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
		try {
			Long duration = ( long) ( Math.random()*10 );

			TimeUnit.SECONDS.sleep(duration);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
