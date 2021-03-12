package edu.miu.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> map= new TreeMap<>();

     //   System.out.println(map.compute("1",(k,v)->v==null?new ArrayList<>(): new ArrayList<>(v)));
     //   System.out.println(map.compute("1",(k,v)->v==null?new ArrayList<>():new ArrayList<>(v)));

/*
* Q1 .if you want to give an input null value to a list, how to do it
* List<?> temp= new ArrayList<>() -it only add null
* wildcard
*
* */
        List<?> list= new ArrayList<>();
        list.add(null);
        list.add(null);


        System.out.println(list);



    }

}
