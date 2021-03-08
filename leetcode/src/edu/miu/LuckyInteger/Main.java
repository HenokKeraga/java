package edu.miu.LuckyInteger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] a={2,2,3,4};

        System.out.println(findLucky(a));

    }
    public static int findLucky(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<arr.length;i++){
           if(map.containsKey(arr[i]))
               map.computeIfPresent(arr[i],(k, v) -> v+1);
           else
               map.put(arr[i],1);
        }


        Set<Integer> key= map.keySet();
        int result=-1;

        for(Integer k:key){
            if(map.get(k)==k)
                result=Math.max(result,k);
        }


        return result;

    }
}
