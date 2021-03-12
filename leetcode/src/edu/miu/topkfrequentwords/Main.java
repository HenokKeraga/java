package edu.miu.topkfrequentwords;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] str={"i", "love", "leetcode", "i", "love", "coding"};



        System.out.println(topKFrequent(str,2));

    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String>[] lists = new List[words.length + 1];


        for (Map.Entry<String, Integer> e :map.entrySet()) {

            int frequency = e.getValue();

            if (lists[frequency] == null)
                lists[frequency] = new ArrayList<>();
            lists[frequency].add(e.getKey());
        }



        List<String> result = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if(lists[i]!=null){
                List<String> element=lists[i];

                Collections.sort(element);

                for(int g=0;g<element.size();g++){
                    if(result.size()<k){
                        result.add(element.get(g));
                    }

                }

            }
        }

        return result;
    }
}
