package edu.miu.interview;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
//        int a[] = {5,2,6,8,6,7,5,2,8};
//
//        LinkedHashSet<Integer> set= new LinkedHashSet<>();
//
//        for(int i=0;i<a.length;i++){
//            set.add(a[i]);
//        }
//        System.out.println(set);
//        HashMap<Integer,Integer> map= new HashMap<>();
//        for(int j=0;j<a.length;j++){
//            map.put(a[j],map.getOrDefault(a[j],0)+1);
//        }
//        System.out.println(map);
//        System.out.println(map.keySet());

        // Remove character from String

        String str="abcdfjdjfdsfj";
        char rmv='c';

    String  ans=str.chars().filter(c->rmv!=c).mapToObj(c->new StringBuilder().append((char)c)).collect(Collectors.joining());
        System.out.println(ans);




    }


}
