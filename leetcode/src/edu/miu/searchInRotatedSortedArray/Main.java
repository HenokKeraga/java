package edu.miu.searchInRotatedSortedArray;

public class Main {

    public static void main(String[] args) {

        int[] a={5,1,3};
        System.out.println(search(a,1));
    }

    public  static int search(int[] nums, int target) {

        int pivot =findPivot( nums);

        int left=0;
        int right=nums.length-1;
        int mid;

        if(target>=nums[pivot] && target<=nums[right])
            left=pivot;
        else
            right =pivot;

        while(left<=right){
            mid=(left+right)/2;

            if(target==nums[mid])
                return mid;
            else if(target >nums[mid])
                left=mid+1;
            else
                right=mid-1;
        }


        return -1;

    }
    public static int findPivot(int[] nums){
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else
                right=mid;

        }
        return left;

    }

}
