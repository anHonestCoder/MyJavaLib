package org.simon.zhao.java.java7ConcurrencyCookbook.ch4.phase2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhaozhou
 * @date 2017/4/1
 */
public class Server {
	private ThreadPoolExecutor executor;

	public Server() {
		this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	public void executeTask( Task task ) {
		System.out.printf("Server: A new task has arrived \n");
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
	}

	public void awaitServer() {
		try {
			executor.awaitTermination(15, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void endServer() {
		executor.shutdown();
	}

}
