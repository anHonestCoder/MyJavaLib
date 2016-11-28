package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

import java.util.*;

/**
 * Created by zhou01.zhao on 2016/11/9.
 */
public class Producer_Consumer {
	public static void main(String[] args) {
		Storage storage = new Storage(10);
		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

class Storage {
	int maxSize;
	LinkedList<Date> data;

	public Storage(int maxSize) {
		this.maxSize = maxSize;
		this.data = new LinkedList<Date>();
	}

	public synchronized  void set() {
		while (data.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		data.add(new Date());
		System.out.printf("Set: %d\n",data.size());
		notifyAll();
	}

	public synchronized void get() {
		while (data.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s\n", data.size(), data.poll());
		notifyAll();
	}

}

class Producer implements Runnable {

	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		for (int i = 0; i< 100; i++) {
			storage.set();
		}
	}
}

class Consumer implements Runnable {
	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i ++) {
			storage.get();
		}
	}
}
