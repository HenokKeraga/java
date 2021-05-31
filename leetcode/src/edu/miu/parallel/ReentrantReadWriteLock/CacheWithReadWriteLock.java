package edu.miu.parallel.ReentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLock {

    private Map<Long, String> cache = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public String put(Long key, String value) {
        writeLock.lock();
        try {
            return cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(Long key) {
        readLock.lock();
        try {
            System.out.println("reade lock");

            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    private void remove(long key) {
        writeLock.lock();
        try{
            System.out.println("Writer lock");
            cache.remove(key);

        }finally {
            writeLock.unlock();
        }


    }

    public static void main(String[] args) {

        CacheWithReadWriteLock cache = new CacheWithReadWriteLock();

        class Producer implements Callable<String> {

            private Random rand = new Random();

            public String call() throws Exception {
                while (true) {
                    long key = rand.nextInt(10);
                    cache.put(key, Long.toString(key));
                    System.out.println("producer " +cache.get(key));

                }
            }
        }
        class Consumer implements Runnable {
            private Random rand = new Random();
            @Override
            public void run() {
                while (true){
                    long key = rand.nextInt(10);
                    if (cache.get(key)!=null){
                        System.out.println("consuming " +cache.get(key));
                        cache.remove(key);
                    }
                }

            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(12);

        System.out.println("Adding value...");


        try  {
            for (int i = 0; i < 6; i++) {
               Future<String> f=executorService.submit(new Producer());
                executorService.submit(new Consumer());

            }
        } finally {
            executorService.shutdown();
        }
    }


}

