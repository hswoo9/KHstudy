package com.kh.chapter2;

import com.kh.chapter2.sync.Consumer;
import com.kh.chapter2.sync.Producer;
import com.kh.chapter2.sync.Storage;

public class Application {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Thread producer = new Producer(storage);
		Thread consumer = new Thread(new Consumer(storage));
		
		producer.start();
		consumer.start();
	}

}
