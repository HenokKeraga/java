package edu.miu.LRUCache;

import java.util.*;

public class LRUCache {
    Map<Integer,Integer> map;
    Queue<Integer> queue;
    int capacity;

    LRUCache(int capacity){
        this.map =new HashMap<>();
        this.queue= new LinkedList<Integer>();
        this.capacity=capacity;

    }
    int get(int key) {
        int result=-1;
        if(this.queue.contains(key)){
            result=this.map.get(key);
            this.queue.add(key);
            this.queue.remove();
        }


    return result;
    }

    void put(int key, int value) {
        this.queue.add(key);
        this.map.put(key,value);
       removeFromFront();
    }

    private void removeFromFront(){

        while (queue.size()>capacity){
            this.queue.remove();
        }

        System.out.println(this.queue);
        System.out.println(this.map);
    }
}
