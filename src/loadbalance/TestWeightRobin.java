package loadbalance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestWeightRobin {
    //    1.map, key-ip,value-weight
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",2);
        ipMap.put("192.168.13.3",4);
 
 
    }
    Integer pos=0;
    public String WeightRobin(){
        Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);
 
        Set<String> ipSet=ipServerMap.keySet();
        Iterator<String> ipIterator=ipSet.iterator();
 
        //����һ��list������server
        ArrayList<String> ipArrayList=new ArrayList<String>();
 
        //ѭ��set������set�еĿ���ȥ��֪map�е�value����list����Ӷ�Ӧ���ֵ�server����
        while (ipIterator.hasNext()){
            String serverName=ipIterator.next();
            Integer weight=ipServerMap.get(serverName);
            for (int i = 0;i < weight ;i++){
                ipArrayList.add(serverName);
            }
        }
        String serverName=null;
        if (pos>=ipArrayList.size()){
            pos=0;
        }
        serverName=ipArrayList.get(pos);
        //��ѯ+1
        pos ++;
 
 
        return  serverName;
    }
 
    public static void main(String[] args) {
        TestWeightRobin testWeightRobin=new TestWeightRobin();
        for (int i =0;i<10;i++){
            String server=testWeightRobin.WeightRobin();
            System.out.println(server);
        }
 
 
    }
}