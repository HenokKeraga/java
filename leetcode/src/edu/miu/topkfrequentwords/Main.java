package edu.miu.topkfrequentwords;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] str={"i", "love", "leetcode", "i", "love", "coding"};



        System.out.println(topKFrequent(str,2));

    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String>[] lists = new List[words.length + 1];

        int [] a= new int[10];


        for (Map.Entry<String, Integer> e : freq.entrySet()) {

            int frequency = e.getValue();

            if (lists[frequency] == null)
                lists[frequency] = new ArrayList<>();
            lists[frequency].add(e.getKey());
        }

        List<String> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if(lists[i]!=null){
                List<String> element=lists[i];

                Collections.sort(element);

                for(int g=0;g<element.size();g++){
                    if(res.size()<k){
                        res.add(element.get(g));
                    }

                }

            }
        }

        return res;
    }
}
