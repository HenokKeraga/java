package edu.miu.Substring;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        List<String>  ans= new ArrayList<>();

        printPermutation("abc","", ans);

        System.out.println(ans);

        ans.stream().distinct().forEach(System.out::println);// no need use set

    }

    public static void printPermutation(String string, String prefix,List<String> ans){

        if(string.length()==0){
            ans.add(prefix);
            return;
        }

        for (int i=0;i<string.length();i++){
            char pf=string.charAt(i);
            String str=string.substring(0,i)+string.substring(i+1);
            printPermutation(str,prefix+pf,ans);

        }

    }
}
