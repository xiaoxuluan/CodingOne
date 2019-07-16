package coding.topN;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Top100 {
    public static Map<String, Integer> hashMap = new ConcurrentHashMap<String, Integer>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
        //������СΪ5���̳߳�
            ExecutorService service = Executors.newFixedThreadPool(5);
            //����ı��ļ��ĸ�Ŀ¼
            String path = "D:\\testsTop100";
            File[] files = new File(path).listFiles();
            for (File file : files) {
            //�����ļ���ʹ�����̶߳�ȡ
                MyFileUtil f = new MyFileUtil();
                f.filrname = file.getPath();
                service.execute(f);
            }
            service.shutdown();
            while (true) {
            //�ȴ������߳�ִ�����
                if (service.isTerminated()) {
                    getTop100();//��ȡƵ����ߵ�100������
                    break;
                }
                Thread.sleep(1000);
            }
            // �ر��̳߳�
            service.shutdown();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.toString());
        }
    }
    //��ȡƵ����ߵ�100������
    private static void getTop100() {
        // TODO Auto-generated method stub
        Words[] words = null;
        //���ʸ�������100ֱ���������
        if(hashMap.size()<=100){
            words = new Words[hashMap.size()];
            int i = 0;
            for(Entry<String, Integer> entry:hashMap.entrySet()){
                words[i++] = new Words(entry.getKey(),entry.getValue());
            }
            Arrays.sort(words); 
            for(int k =words.length-1;k>0;k--){
                System.out.println(words[k].word+" "+words[k].counts);           
            }
        }else{
        //���򣬹�����С��
            words = new Words[101];
            int i = 1;
            for(Entry<String, Integer> entry:hashMap.entrySet()){
                if(i>100){
                //����Ԫ����Ѷ�Ԫ����ȣ����ڶԶ�Ԫ�����滻���Ѷ�Ԫ��
                    if(entry.getValue()>words[1].counts){
                        words[1].word = entry.getKey();
                        words[1].counts = entry.getValue();
                        //ά�����ѵ�����
                        heapFy(words, 1, 100);
                    }
                }else{
                    words[i++] = new Words(entry.getKey(),entry.getValue());
                    if(i==101){
                        buildMinHeap(words);//������С��
                    }
                }               
            }   
            //�����򣬽���һ��Ԫ���롰���һ��Ԫ�ء�������Ȼ��ά����С�ѵ�����
            for(int k = 1;k<words.length-1;k++){
                exchange(words, 1, words.length-k);
                heapFy(words,1,words.length-1-k);
            }
            for(int k =1 ;k<=words.length-1;k++){
                System.out.println(words[k].word+" "+words[k].counts);           
            }
        }

    }

    //������С��
    private static void buildMinHeap(Words[] words) {
        // TODO Auto-generated method stub
        int length = words.length-1;
        for(int i = length/2;i>=1;i--){
            heapFy(words,i,length);
        }
    }
    //ά����С��
    private static void heapFy(Words[] words, int i, int length) {
        // TODO Auto-generated method stub
        if(i>length){
            return ;
        }

        int left = left(i);
        int right = right(i);
        int minIndex = i;
        //�ҵ����ҽڵ�����С�Ľڵ�
        if(left>=1&&left<=length){
            if(words[left].compareTo(words[minIndex])< 0){
                minIndex = left;
            }
        }
        if(right>=1&&right<=length){
            if(words[right].compareTo(words[minIndex])<0){
                minIndex = right;
            }
        }
        if(minIndex==i){
            return ;
        }else{
            exchange(words,i,minIndex);
            heapFy(words, minIndex, length);
        }
    }
    //��������Ԫ��
    private static void exchange(Words[] words, int i, int maxindex) {
        // TODO Auto-generated method stub
        try {
            Words temp;     
            temp = words[i].clone();
            words[i] = words[maxindex].clone();
            words[maxindex] = temp.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //������ڵ�����
    private static int left(int i) {
        // TODO Auto-generated method stub
        return 2*i;
    }
    //�����ҽڵ�����
    private static int right(int i) {
        // TODO Auto-generated method stub
        return 2*i+1;
    }
    //ʵ��Runnable�Ĺ�����
    static class MyFileUtil implements Runnable {
        public String filrname;

        @Override
        public void run() {
            // TODO Auto-generated method stub
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(filrname);
                br = new BufferedReader(fr);
                String line = "";
                String[] arrs = null;
                while ((line = br.readLine()) != null) {
                    // System.out.println(line);
                    arrs  = line.split(" ");
                    for (String string : arrs) {
                        string = prePro(string);
                        if(string.equals("")){
                            continue;
                        }
                        if (hashMap.containsKey(string.trim())) {
                            hashMap.put(string, hashMap.get(string) + 1);
                        } else {
                            hashMap.put(string, 1);
                        }
                    }                   
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (br != null){
                        br.close();
                    }

                    if (fr != null){
                        fr.close();
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        //���ڲ����ļ���Ӣ��С˵ԭ������������˴����ķ��ţ��������Ԥ����
        private String prePro(String str) {
            // TODO Auto-generated method stub
            StringBuilder sb = new StringBuilder();
            char[] ch = str.trim().toCharArray();
            for (char c : ch) {
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                    sb.append(c);
                }
            }
            return sb.toString();
        }

    }
}
