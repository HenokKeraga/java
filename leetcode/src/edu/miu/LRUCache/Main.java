package edu.miu.LRUCache;
/*
*https://leetcode.com/problems/lru-cache/
* Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
* If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?
*
* */

public class Main {

    public static void main(String[] args) {
       LRUCache lruCache= new LRUCache(2);
       lruCache.put(1,1);
       lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

//        lruCache.put(2,1);
//        lruCache.put(1,1);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,1);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
       // [null,null,null,1,null,-1,1]
    }
}
