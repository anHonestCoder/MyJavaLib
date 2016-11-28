package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhou01.zhao on 2016/11/9.
 */
public class FileMock {
	private String content[];
	private int index;

	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer = new StringBuilder(length);
			for (int j = 0; j < length; j++) {
				int indice = (int) Math.random()*255;
				buffer.append((char)indice);
			}
			content[i] = new String(buffer);
		}
		index = 0;
	}

	public boolean hasMoreLines() {
		return index < content.length;
	}

	public String getLine() {
		if(this.hasMoreLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}

	public static void main(String[] args) {
		FileMock mock = new FileMock(100,10);
		Buffer buffer = new Buffer(20);
		Producer1 producer1 = new Producer1(mock, buffer);
		Thread producerThread = new Thread(producer1, "Producer");


		Consumer1[] consumers = new Consumer1[3];
		Thread consumerThreads[] = new Thread[3];
		for (int i = 0; i < consumers.length; i++) {
			consumers[i] = new Consumer1(buffer);
			consumerThreads[i] = new Thread(consumers[i], "Consumer " + i);
		}

		producerThread.start();
		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i].start();
		}

	}

}

class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.wait();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		lock.lock();
		String line = null;
		try {
			while (buffer.size() == 0) {
				lines.wait();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d \n",Thread.currentThread().getName(), buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}

	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

}

class Producer1 implements Runnable {

	private FileMock mock;
	private Buffer buffer;

	public Producer1(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.setPendingLines(true);
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}
}

class Consumer1 implements Runnable {
	private Buffer buffer;

	public Consumer1(Buffer buffer) {
		this.buffer = buffer;
	}


	@Override
	public void run() {
		while (buffer.hasPendingLines()) {

			String line = buffer.get();
			processLine(line);
		}
	}

	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
