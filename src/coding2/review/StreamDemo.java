package coding2.review;

import coding.producerconsumer.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luanyanxu
 */
public class StreamDemo {

    public static void printValue(String str){
        System.out.println("print value :" +str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a","b","c","d","a");
        //al.forEach(StreamDemo::printValue);
        String al1 =al.stream().distinct().collect(Collectors.joining(","));
        System.out.println(al1);

        //去重处理
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }
}
