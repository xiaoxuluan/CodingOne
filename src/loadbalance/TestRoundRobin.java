package loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestRoundRobin {
    //    1.����map, key-ip,value-weight
    static Map<String, Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1", 1);
        ipMap.put("192.168.13.2", 1);
        ipMap.put("192.168.13.3", 1);

    }

    //    Integer sum=0;
    Integer pos = 0;

    public String RoundRobin() {
        Map<String, Integer> ipServerMap = new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);

        //    2.ȡ����key,�ŵ�set��
        Set<String> ipset = ipServerMap.keySet();

        //    3.set�ŵ�list��Ҫѭ��listȡ��
        ArrayList<String> iplist = new ArrayList<String>();
        iplist.addAll(ipset);

        String serverName = null;

        //    4.����һ��ѭ����ֵ���������set�ʹ�0��ʼ
        synchronized (pos) {
            if (pos >= ipset.size()) {
                pos = 0;
            }
            serverName = iplist.get(pos);
            //��ѯ+1
            pos++;
        }
        return serverName;

    }

    public static void main(String[] args) {
        TestRoundRobin testRoundRobin = new TestRoundRobin();
        for (int i = 0; i < 10; i++) {
            String serverIp = testRoundRobin.RoundRobin();
            System.out.println(serverIp);
        }
    }

}
