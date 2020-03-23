package coding2.l2;


import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/23 23:59
 * @Version 1.0
 */
public class LruCache {

    class LRU extends LinkedHashMap<Integer,Integer>{
        int capacity;

        public LRU(int capacity){
            super(capacity,0.75f,true);
            this.capacity=capacity;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
            return this.size()>capacity;
        }


    }

    private LRU cache;
    public LruCache(int capacity){
        this.cache = new LRU(capacity);
    }

    public int get(int key){
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key,int value){
        cache.put(key,value);
    }


}
