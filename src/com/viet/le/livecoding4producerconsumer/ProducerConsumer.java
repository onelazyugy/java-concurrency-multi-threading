package com.viet.le.livecoding4producerconsumer;

/**
 * consumer and producer pattern
 * if the buffer is empty, the consumer will wait until the producer makes more
 * if the buffer is NOT empty, the consumer takes away from buffer and notify other threads to produce more
 * the same way for producers<br/>
 * without the synchronized, it will produce a race condition<br/>
 * without the wait() and notify(), it will produce a deadlock
 */
public class ProducerConsumer {
	private static Object lock = new Object();
	private static int[] buffer;
	private static int count;

	static class Producer {
		//if buffer == full, wait on the producer so that consumer can consume the buffer
		void produce() {
			synchronized (lock) {
				if (isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}

	static class Consumer {
		//if buffer is empty, consumer will wait so that the producer can produce more
		void consume() {
			synchronized (lock) {
				if (isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				lock.notify();
			}
		}
	}

	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	public static void main(String... strings) throws InterruptedException {
		buffer = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			for (int i = 0 ; i < 50 ; i++) {
				producer.produce();
			}
			System.out.println("Done producing");
		};

		Runnable consumeTask = () -> {
			for (int i = 0 ; i < 45 ; i++) {
				consumer.consume();
			}
			System.out.println("Done consuming");
		};

		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);

		consumerThread.start();
		producerThread.start();

		//wait for 2 thread to complete so that the main thread can finish
		consumerThread.join();
		producerThread.join();

		System.out.println("Data in the buffer: " + count);
	}
}
