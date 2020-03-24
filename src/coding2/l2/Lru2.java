package coding2.l2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: alenlyx
 * @Date: 2020/3/24 0:11
 * @Version 1.0
 */
class Lru2 extends LinkedHashMap<Integer,Integer>{

    private int capacity;
    public Lru2(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

    //put get O(1) ø’º‰∏¥‘”∂»O(capacity)
}
