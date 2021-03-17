package edu.miu.CountOfVowel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {



        String test="aeiou";


        Predicate<String> p= c->test.contains(c);


        String str=" henokkeraga";



        char[] ch=str.toCharArray();

       long count= str.chars().filter(d->test.contains(String.valueOf((char) d))).count();
        System.out.println(count);

       long count2=str.chars().mapToObj(f->new StringBuilder().append((char)f).toString()).filter(d->test.contains(d)).count();

        System.out.println(count2);


    }

    
}
