package edu.miu.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(letterCombinations("234"));

        System.out.println(letterCombinationsRecursive("234"));

    }

    public static List<String> letterCombinationsRecursive(String digits) {
        Map<Character, String[]> hm = new HashMap<>();
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        hm.put('2', new String[]{"a", "b", "c"});
        hm.put('3', new String[]{"d", "e", "f"});
        hm.put('4', new String[]{"g", "h", "i"});
        hm.put('5', new String[]{"j", "k", "l"});
        hm.put('6', new String[]{"m", "n", "o"});
        hm.put('7', new String[]{"p", "q", "r", "s"});
        hm.put('8', new String[]{"t", "u", "v"});
        hm.put('9', new String[]{"w", "x", "y", "z"});


        return makeCombination(digits,hm,0,"",new ArrayList<>());
    }

    private static List<String> makeCombination(String digits,Map<Character, String[]> hm ,int i,String sb,List<String> combination) {

      if(i>=digits.length()){
          combination.add(sb);
          System.out.println(combination);
          return combination;
      }


     for (String ch:hm.get(digits.charAt(i))){
         System.out.println(ch);

        combination= makeCombination(digits,hm,i+1,sb+ch,combination);
     }

     return  combination;
    }


    public  static  List<String> letterCombinations(String digits) {
        Map<Character,String[]> hm = new HashMap<>();
        if(digits.isEmpty())
        {
            return new ArrayList<>();
        }
        hm.put('2',new String []{"a","b","c"});
        hm.put('3',new String []{"d","e","f"});
        hm.put('4',new String []{"g","h","i"});
        hm.put('5',new String []{"j","k","l"});
        hm.put('6',new String []{"m","n","o"});
        hm.put('7',new String []{"p","q","r","s"});
        hm.put('8',new String []{"t","u","v"});
        hm.put('9',new String []{"w","x","y","z"});

        char[] d = digits.toCharArray();

        List<String> initial = new ArrayList<>();


        for(String ch : hm.get(d[0]))
        {
            initial.add(ch);
        }

        if(d.length <2)
        {
            return initial;
        }


        for(int i =1;i<d.length;i++)
        {
            List<String> result = new ArrayList<>();
            for(String current: initial)
            {
                for(String comb : hm.get(d[i]))
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(current);
                    sb.append(comb);
                    result.add(sb.toString());
                }
            }

            initial = new ArrayList<>(result);



        }


        return initial;



    }
}
