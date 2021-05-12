package edu.miu.parallel.ReentrantReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        MyCounter counter = new MyCounter();
        Thread[] readThreads = new Thread[5];


        for (int i = 0; i < 5; i++) {
            Runnable reader = new Reader(counter);
            Thread readThread = new Thread(reader);
            readThreads[i] = readThread;

        }
        Thread[] writeThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Runnable writer = new Writer(counter);
            Thread writeThread = new Thread(writer);
            writeThreads[i] = writeThread;
        }

//        for (int i = 0; i < 5; i++) {
//            writeThreads[i].start();
//        }
        writeThreads[0].start();
        writeThreads[1].start();
        for (int i = 0; i < 5; i++) {
            readThreads[i].start();
        }


    }
}

class MyCounter {
    private int count=1;
    private ReadWriteLock lock= new ReentrantReadWriteLock();

    public int getCount() {
        lock.readLock().lock();
        int result=this.count;
        lock.readLock().unlock();
        return result;
    }

    public void addCounter(int count) {
        lock.writeLock().lock();
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }
        this.count += count;
        lock.writeLock().unlock();
    }
}

class Reader implements Runnable {
    private MyCounter counter;

    public Reader(MyCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("counter value =" + counter.getCount());

    }
}

class Writer implements Runnable {
    private MyCounter counter;

    public Writer(MyCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.addCounter(1);
    }
}
