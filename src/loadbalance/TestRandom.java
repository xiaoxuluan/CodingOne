package loadbalance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestRandom {
    //    1.����map, key-ip,value-weight
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",2);
        ipMap.put("192.168.13.3",4);
 
 
    }
    public String Random() {
        Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);
 
        Set<String> ipSet=ipServerMap.keySet();
 
        //����һ��list������server
        ArrayList<String> ipArrayList=new ArrayList<String>();
        ipArrayList.addAll(ipSet);
 
        //ѭ�������
        Random random=new Random();
        //�������list������ȡ��1-list.size��
        int pos=random.nextInt(ipArrayList.size());
        String serverNameReturn= ipArrayList.get(pos);
        return  serverNameReturn;
    }
 
    public static void main(String[] args) {
        TestRandom testRandom=new TestRandom();
        for (int i =0;i<10;i++){
            String server=testRandom.Random();
            System.out.println(server);
        }
 
 
    }
}