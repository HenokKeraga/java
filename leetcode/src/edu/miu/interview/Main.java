package edu.miu.interview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
*
* Given a string, find its first non-repeating character
*
* */

public class Main {


    public static void main(String[] args) {
        String str="arrayy";


       String dd=str.chars().mapToObj(c->new StringBuilder().append((char)c).toString())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
               .entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().orElse("no unique");


        System.out.println(dd);

//        String ss=str.chars().mapToObj(c->new StringBuilder().append((char)c).toString()).filter(s->map.get(s)==1)
//                .findFirst().orElse("no un");


//
//        System.out.println(ss);



    }


}
