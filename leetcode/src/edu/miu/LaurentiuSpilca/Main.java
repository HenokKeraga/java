package edu.miu.LaurentiuSpilca;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list= List.of("AAA","BBBB","CCCC","DDDDD","AAA","AAA");

        List<String> a=list.stream().collect(Collectors.toList());
        Set<String> a1=list.stream().collect(Collectors.toSet());

        TreeSet<String> treeSet=list.stream().collect(Collectors.toCollection(()->new TreeSet<>()));
        TreeSet<String> treeSet1=list.stream().collect(Collectors.toCollection(TreeSet::new));


      //  System.out.println(treeSet1);
        Map<String,Integer> map=list.stream().collect(Collectors.toMap(
                s->s,
                s->1,
                (d,c)->d+c
            )
        );
        //  System.out.println(treeSet1);
        Map<String,Integer> map1=list.stream().collect(Collectors.toMap(
                s->s,
                s->1,
                (d,c)->d+c,
                ()->new TreeMap<>()
                )
        );



       // System.out.println(map);
       // System.out.println(map1);


//        String str=list.stream().collect(Collectors.joining());
//        System.out.println(str);
//        String str1=list.stream().collect(Collectors.joining(","));
//        System.out.println(str1);
//
//        var data = new ArrayList<>(){{add(1);add(2);}};
//        System.out.println(data);



        


    }
}
