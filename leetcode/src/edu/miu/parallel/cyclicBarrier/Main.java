package edu.miu.parallel.cyclicBarrier;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
/*
 *   how many 5 value have
 * */

public class Main {
    public static void main(String[] args) {
        int[] result = new int[5];
        MockFillArray mockFillArray = new MockFillArray(1000);

        Grouper grouper= new Grouper(result);
        CyclicBarrier barrier= new CyclicBarrier(5,grouper);
        ExecutorService service= Executors.newFixedThreadPool(6);
        for (int i=0;i<5;i++) {
           Runnable searcher= new Searcher(mockFillArray.getData(),result,i*200,(i*200)+200,barrier);
         //  Thread thread= new Thread(searcher) ;
        //   thread.start();
            service.submit(searcher);
        }
        service.shutdown();

    }
}


class MockFillArray {
    private int[] data;

    public MockFillArray(int n) {
        this.data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            this.data[i] = random.nextInt(10);
        }
    }

    public int[] getData() {
        return data;
    }
}

class Grouper implements Runnable {
    private int[] result;

    public Grouper(int[] result) {
        this.result = result;
    }

    @Override
    public void run() {
        int total = 0;

        for (int i = 0; i < result.length; i++) {
            total += result[i];
        }
        System.out.println(Arrays.toString(result));
        System.out.println("Total  5 value is = " + total);

    }
}

class Searcher implements Runnable {
    private int[] data;
    private int[] result;
    private int from;
    private int end;
    CyclicBarrier barrier;

    public Searcher(int[] data, int[] result, int from, int end, CyclicBarrier barrier) {
        this.data = data;
        this.result = result;
        this.from = from;
        this.end = end;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = from; i < end; i++) {

            if (data[i] == 5) {
                count++;
            }
        }
        result[from / 200] = count;

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}










