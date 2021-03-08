package edu.miu.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        // Our arr contains 8 elements
//        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        if(nums.length<3)
            return result;

        int left=0;
        int right=0;
        int sum=0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            left=i+1;
            right=nums.length -1;

            if(i>0 && nums[i]==nums[i-1])
                continue;

            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                System.out.println(i +" " + sum);
                if(sum==0){
                    List<Integer> data= new ArrayList<>();
                    data.add(nums[i]);
                    data.add(nums[left]);
                    data.add(nums[right]);
                    result.add(data);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1])
                        left++;
                    while(left<right && nums[right]==nums[right+1])
                        right--;

                }else if(sum<0){
                    left++;

                }else{
                    right--;
                }

            }

        }




        return result;
    }


}
