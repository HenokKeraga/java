package edu.miu.parallel.syncronize;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyCounter counter = new MyCounter();

        int cores = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            Runnable sensor = new Sensor(counter);
            Thread thread = new Thread(sensor);
            threads[i] = thread;
            thread.start();
        }


        for (int i = 0; i < cores; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {

            }
        }

        System.out.println("number of core = " + cores);
        System.out.println("counter value = " + counter.getCount());


    }
}

class MyCounter {
    private int count = 0;

    public void add(int value) {
        synchronized (this) {
            count += value;
        }

    }

    public void subtract(int value) {
        synchronized (this) {
            count -= value;
        }

    }

    public int getCount() {
        return count;
    }

}

class Sensor implements Runnable {
    private MyCounter counter;

    public Sensor(MyCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.add(1);
        counter.add(1);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
        counter.subtract(2);
    }
}

