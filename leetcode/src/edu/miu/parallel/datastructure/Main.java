package edu.miu.parallel.datastructure;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)  {
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            service.submit(new Producer(blockingQueue));
            service.submit(new Consumer(blockingQueue));
            service.submit(new Consumer(blockingQueue));
            service.submit(new Consumer(blockingQueue));
            service.submit(new Consumer(blockingQueue));

        } finally {
            service.shutdown();
        }

    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                blockingQueue.put(producer());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Integer producer() {

        System.out.println(Thread.currentThread().getName() + " Producer");

        return new Random().nextInt() % 1000;
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consumer(blockingQueue.take());


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void consumer(Integer take) {
        System.out.println(Thread.currentThread().getName() + " Consumer :" + take);
    }
}
