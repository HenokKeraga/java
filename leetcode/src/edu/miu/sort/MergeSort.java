package edu.miu.sort;

import java.util.Arrays;
/*
* MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = l+ (r-l)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
* */

public class MergeSort {
    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);

        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));



    }

    public  static  void  mergeSort(int[] arr,int left,int right){

        if(left<right){
            int mid =(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n=mid-left+1;
        int m=right-mid;

        int[] L= new int[n];
        int[] R= new int[m];

        for(int i=0;i<n;i++){
            L[i]=arr[i+left];
        }
        for(int j=0;j<m;j++){
            R[j]=arr[j+mid+1];
        }

        int l=0;
        int r=0;
        int k=left;


        while (l<n && r<m){

            if(L[l]<=R[r]){
                arr[k]=L[l];
                l++;
            }else {
                arr[k]=R[r];
                r++;
            }

           k++;

        }

        while (l<n){
            arr[k]=L[l];
            l++;
            k++;

        }
        while (r<m){
            arr[k]=R[r];
            r++;
            k++;
        }

    }


}
