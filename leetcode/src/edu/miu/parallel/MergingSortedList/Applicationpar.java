package edu.miu.parallel.MergingSortedList;

import java.util.Arrays;
import java.util.Date;

public class Applicationpar {
    public static final int n = 2000000;

    public static void main(String[] args) {
        int i;
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] Z = new int[2 * n];
        /* input sorted lists X and Y */
        for (i = 0; i < n; i++)
            X[i] = i * 2;
        for (i = 0; i < n; i++)
            Y[i] = 1 + i * 2;
        Date t = new Date();

        System.out.println(Arrays.toString(X));
        System.out.println(Arrays.toString(Y));
        Runnable one = new MergeSortedList(X,Y,Z) ;
        Thread threadOne= new Thread(one);

        Runnable two = new MergeSortedList(Y,X,Z);
        Thread threadTwo= new Thread(two);

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date s = new Date();
        System.out.print("Elapsed Time: ");
        System.out.println(s.getTime() - t.getTime());
        System.out.println(Arrays.toString(Z));
    }


}

class MergeSortedList implements Runnable {
    int[] from;
    int[] on;
    int[] result;

    public MergeSortedList(int[] from, int[] on, int[] result) {
        this.from = from;
        this.on = on;
        this.result = result;
    }

    @Override
    public void run() {

        for(int k=0;k<from.length;k++){
            int rank=0;
            for (int i = 0; i < on.length; i++) {
                if (on[i]<from[k]) {
                    rank++;
                }else {
                    break;
                }
            }
            result[k+rank]=from[k];
        }

    }
}
