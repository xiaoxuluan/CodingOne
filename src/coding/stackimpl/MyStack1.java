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
            throw  new IllegalArgumentException("栈的初始容量不能小于0:"+size);
        }
        this.elementData = new Object[size];
        this.top = -1;
        this.size  = size;
    }

    //压入元素
    public Object push(Object item){
        //是否需要扩容
        isGrow(top+1);
        elementData[++top] = item;
        return item;
    }

    //弹出栈顶元素
    public Object pop(){
        Object object = peek();
        remove(top);
        return object;
    }

    //获取栈顶元素
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }

        return elementData[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //删除栈顶元素
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
