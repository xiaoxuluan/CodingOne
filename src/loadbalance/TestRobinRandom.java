package loadbalance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestRobinRandom {
 
    //    1.����map, key-ip,value-weight
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",2);
        ipMap.put("192.168.13.3",4);
 
 
    }
    public String RobinRandom(){
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
            for (int i=0;i<weight;i++){
                ipArrayList.add(serverName);
            }
        }
 
        //ѭ�������
        Random random=new Random();
        //�������list������ȡ��1-list.size��
        int pos=random.nextInt(ipArrayList.size());
        String serverNameReturn= ipArrayList.get(pos);
        return  serverNameReturn;
    }
 
    public static void main(String[] args) {
        TestRobinRandom testRobinRandom=new TestRobinRandom();
        for (int i =0;i<10;i++){
            String server=testRobinRandom.RobinRandom();
            System.out.println(server);
        }
 
 
    }
}