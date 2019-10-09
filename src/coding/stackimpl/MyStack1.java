package coding.stackimpl;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/9 16:35
 * @Version 1.0
 */
public class MyStack1 {

    private Object [] elementData;

    private int top;
    private int size;

    public MyStack1(){
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public MyStack1 (int size){
        if(size<0){
            throw  new IllegalArgumentException("ջ�ĳ�ʼ��������С��0:"+size);
        }
        this.elementData = new Object[size];
        this.top = -1;
        this.size  = size;
    }

    //ѹ��Ԫ��
    public Object push(Object item){
        //�Ƿ���Ҫ����
        isGrow(top+1);
        elementData[++top] = item;
        return item;
    }

    //����ջ��Ԫ��
    public Object pop(){
        Object object = peek();
        remove(top);
        return object;
    }

    //��ȡջ��Ԫ��
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }

        return elementData[top];
    }

    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return (top == -1);
    }

    //ɾ��ջ��Ԫ��
    public void remove(int top){
        elementData[top] =null;
        this.top--;
    }


    public boolean isGrow(int minCapacity){
        int oldCapacity = size;
        if(minCapacity >= oldCapacity){
            int newCapacity = 0;
            if((oldCapacity<<1)-Integer.MAX_VALUE>0){
                newCapacity = Integer.MAX_VALUE;
            }else{
                newCapacity = (oldCapacity<<1);
            }
            this.size = newCapacity;
            int [] newArray = new int[size];
            elementData = Arrays.copyOf(elementData,size);
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push("abc");
        System.out.println(myStack1.peek());
    }

}
