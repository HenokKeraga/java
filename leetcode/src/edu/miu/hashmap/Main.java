package edu.miu.hashmap;


import java.util.*;

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
        System.out.println(Collections.EMPTY_LIST);
        /*
     *
     * @. sort characters of a string using Java 8
     * */
        String s="dshfldskhfkjda";

      StringBuilder sb=  s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        System.out.println(sb.toString());



  /*
  *
  *
  *
  * */



    }

}
