package edu.miu.cvs;

import java.util.HashMap;
import java.util.function.BiPredicate;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, BiPredicate<String,String>> prc= new HashMap<>();

        prc.put(1,(str1,str2)->str1.equals(str2));

        BiPredicate<String,String>  biPredicate=prc.getOrDefault(1,(s1,s2)->false);

        System.out.println(biPredicate.test("str",""));
        System.out.println(biPredicate.test("str","str"));
        BiPredicate<String,String>  biPredicate1=prc.getOrDefault(2,(s1,s2)->false);

        System.out.println(biPredicate1.test("str",""));
        System.out.println(biPredicate1.test("str","str"));

    }
}
