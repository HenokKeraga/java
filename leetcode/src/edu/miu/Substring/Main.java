package edu.miu.Substring;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s="abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s){

        HashMap<Character,Integer> map= new HashMap<>();

        int max_len=0;
        int start=0;
        for (int i=0;i<s.length();i++){

       if(map.containsKey(s.charAt(i))){

           start=Math.max(start,map.get(s.charAt(i))+1);


       }
       System.out.println("loop " + i +" start "  +start);



            map.put(s.charAt(i),i);

            max_len=Math.max(max_len,i-start+1);
        }


        System.out.println(map);
         return max_len;
    }
}
