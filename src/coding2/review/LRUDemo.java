package coding2.review;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: alenlyx
 * @Date: 2019/9/7 16:26
 * @Version 1.0
 */
public class LRUDemo<K,V> {

    private final int MAX_CACHE_SZIE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    private LinkedHashMap<K,V> map;

    private LRUDemo(int cacheSize) {
        MAX_CACHE_SZIE = cacheSize;
        int capacity = (int ) Math.ceil(MAX_CACHE_SZIE/DEFAULT_LOAD_FACTORY)+1;

        map = new LinkedHashMap<K,V>(capacity,DEFAULT_LOAD_FACTORY,true){


            @Override
            public boolean removeEldestEntry(Map.Entry<K,V> eldest){
                return size()>MAX_CACHE_SZIE;
            }
        };

    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    private synchronized void remove(K key){
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getAll(){
        return map.entrySet();
    }

    @Override
    public String toString() {
        return "LRUDemo{" +
                "MAX_CACHE_SZIE=" + MAX_CACHE_SZIE +
                ", DEFAULT_LOAD_FACTORY=" + DEFAULT_LOAD_FACTORY +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        LRUDemo<Integer,Integer> lrudemo = new LRUDemo<>(3);
        lrudemo.put(1,101);
        lrudemo.put(2,102);
        lrudemo.put(3,103);
        System.out.println(lrudemo);
        lrudemo.put(4,104);
        System.out.println(lrudemo);
        lrudemo.remove(4);
        System.out.println(lrudemo);
    }



}
