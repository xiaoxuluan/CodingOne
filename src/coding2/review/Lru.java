package coding2.review;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author luanaynxu
 * <p>
 * 2018年12月2日
 */
public class Lru<K, V> {

    /**
     * 初始化最大值
     */
    private final int MAX_CACHE_SIZE;

    //Map扩容因子
    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    LinkedHashMap<K, V> map;

    public Lru(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;
        /*
         * 第三个参数设置为true，代表linkedlist按访问顺序排序，可作为LRU缓存 第三个参数设置为false，代表按插入顺序排序，可作为FIFO缓存
         */
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    private synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Lru<Integer, Integer> lru1 = new Lru<>(5);
        lru1.put(1, 1);
        lru1.put(2, 2);
        lru1.put(3, 3);
        System.out.println(lru1);
        lru1.get(1);// 访问1
        System.out.println(lru1);
        lru1.put(4, 4);
        lru1.put(5, 5);
        lru1.put(6, 6);// 2由于最近没有使用 被淘汰
        System.out.println(lru1);

    }
}
