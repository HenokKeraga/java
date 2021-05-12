package edu.miu.parallel.MergingSortedList;

import java.util.Date;

public class ApplicationparBS {
    public static final int n = 2000000;
//    public static final int n = 20;

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

//        System.out.println(Arrays.toString(X));
//        System.out.println(Arrays.toString(Y));
        Runnable one = new MergeSortedListBS(X,Y,Z) ;
        Thread threadOne= new Thread(one);

        Runnable two = new MergeSortedListBS(Y,X,Z);
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
//        System.out.println(Arrays.toString(Z));
    }


}

class MergeSortedListBS implements Runnable {
    int[] from;
    int[] on;
    int[] result;

    public MergeSortedListBS(int[] from, int[] on, int[] result) {
        this.from = from;
        this.on = on;
        this.result = result;
    }

    @Override
    public void run() {

        for(int k=0;k<from.length;k++){
            int rank=binarySearch(on,0,on.length-1,from[k]);
            result[k+rank]=from[k];
        }

    }

    public static int binarySearch(int[] array, int left, int right, int elem) {
        if (left > right) {
            return left;
        } else {
            int middle;
            middle = (left + right) / 2;
            if (left == right) {
                return left;
            } else if (elem > array[middle]) {
                return binarySearch(array, middle + 1, right, elem);
            } else if ((elem < array[middle])) {
                return binarySearch(array, left, middle, elem);
            } else {
                return middle;
            }
        }
    }


}
