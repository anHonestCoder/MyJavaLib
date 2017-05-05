package org.simon.zhao.java.java7ConcurrencyCookbook.ch4.phase2;


import org.junit.Test;

/**
 * @author Zhaozhou
 * @date 2017/4/1
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		new Main().test();
	}

	@Test
	public void test() throws InterruptedException {
		Server server = new Server();
		int size = 10;
		for ( int i = 0; i < size; i++ ) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.awaitServer();
		server.endServer();
		System.out.println("main end");
	}
}
