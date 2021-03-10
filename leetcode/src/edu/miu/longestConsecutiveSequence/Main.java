package edu.miu.longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] a={100,4,200,1,3,2};
        System.out.println(longestConsecutive(a));

    }
    public static  int longestConsecutive(int[] nums) {

        Set<Integer> numSet= new HashSet<>();
        for(int i=0;i<nums.length;i++)
            numSet.add(nums[i]);

        int result=0;
        int count=0;

        for(Integer i:numSet){
            count=1;
            if(!numSet.contains(i-1)){
                while(numSet.contains(i+1)){
                    count++;
                    i+=1;
                }

            }

            result=Math.max(result,count);
        }


        return result;
    }
}
