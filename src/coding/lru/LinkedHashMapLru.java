package coding.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapLru<K, V> {
	private final int MAX_CACHE_SIZE;
	private final float LOAD_DEFAULT_FACTORY = 0.75f;
	LinkedHashMap<K, V> map;

	String s1= "123456";
	public LinkedHashMapLru(int cacheSize){
		MAX_CACHE_SIZE = cacheSize;
		int capacity = (int) Math.ceil(MAX_CACHE_SIZE/LOAD_DEFAULT_FACTORY)+1;
		
		
		map = new LinkedHashMap<K,V>(capacity,LOAD_DEFAULT_FACTORY,false){
			
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > MAX_CACHE_SIZE;
			}
		};
	}
	
	public synchronized void put(K key,V value) {
		map.put(key, value);
	}
	
	public synchronized V get(K key) {
	return map.get(key);
	}
	
	public synchronized void remove(K key) {
		map.remove(key);
	}
	
	public synchronized Set<Map.Entry<K,V>> getAll(){
		return map.entrySet();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<K, V> entry: map.entrySet()) {
			stringBuilder.append(String.format("%s:%s ",entry.getKey(),entry.getValue() ));
			
		}
		
		return stringBuilder.toString();
	}
	
	
	//测试
	public static void main(String[] args) {
		LinkedHashMapLru<Integer, Integer> lru1 = new LinkedHashMapLru<>(5);
		lru1.put(1, 1);
		lru1.put(2, 2);
		lru1.put(3, 3);
		System.out.println(lru1);
		System.out.println(lru1.get(1));//近期使用1
		System.out.println(lru1);
		lru1.put(4, 4);
		lru1.put(5, 5);
		lru1.put(6, 6);
		
		System.out.println(lru1);
	}

}
