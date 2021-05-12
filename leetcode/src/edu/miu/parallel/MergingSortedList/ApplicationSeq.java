package edu.miu.parallel.MergingSortedList;

import java.util.Arrays;
import java.util.Date;


public class ApplicationSeq {
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
        // insert your code to create
//
//        System.out.println(Arrays.toString(X));
//        System.out.println(Arrays.toString(Y));
        mergeSort(X,Y,Z);
        mergeSort(Y,X,Z);

        // and start the threads here
        Date s = new Date();
        System.out.print("Elapsed Time: ");
        System.out.println(s.getTime() - t.getTime());
//        System.out.println(Arrays.toString(Z));
    }

    static int[] mergeSort(int[] from, int[] on,int [] result) {

        for(int k=0;k<from.length;k++){
            int rank=binarySearch(on,0,on.length-1,from[k]);

            result[k+rank]=from[k];
        }
        return result ;
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
