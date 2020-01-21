package coding2.review;

import coding.producerconsumer.Consumer;

import java.util.Arrays;
import java.util.List;

/**
 * @author luanyanxu
 */
public class StreamDemo {

    public static void printValue(String str){
        System.out.println("print value :" +str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a","b","c","d");
        al.forEach(StreamDemo::printValue);
    }
}
