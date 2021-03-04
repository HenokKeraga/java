package edu.miu.findMedianSortedArrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a={0,0,0,0,0};
        int[]b={-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static  double findMedianSortedArrays(int[] num1, int[] num2) {
        double result=0.0;

        int[] total= new int [num1.length+num2.length];

        int i=0;
        int j=0;
        int t=0;

        while(i<num1.length&&j<num2.length ){

            if(num1[i]<=num2[j]){
                total[t]=num1[i];
                i++;
                t++;

            }else{
                total[t]=num2[j];
                j++;
                t++;
            }

        }

        while(i<num1.length){
            total[t]=num1[i];
            i++;
            t++;
        }
        while(j<num2.length){
            total[t]=num2[j];
            j++;
            t++;
        }

        if(total.length%2 ==0){

            result=(total[(total.length/2)-1]+total[total.length/2])/2;

            System.out.println(total[(total.length/2)-1]);
            System.out.println(total[total.length/2]);

            System.out.println((double)(total[(total.length/2)-1]+total[total.length/2])/2);

        }else{
            result=total[total.length/2];

        }

        System.out.println(Arrays.toString(total));

        return result;

    }
}
