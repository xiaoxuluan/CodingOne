package coding.stackimpl;

/**
 * @Author: alenlyx
 * @Date: 2019/10/9 16:16
 * @Version 1.0
 */
public class MyStack {

    /**
     * 栈初步实现 1.不能自动扩容 2.数据类型固定
     */

    private int [] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据
    public void push(int value){
        if(top<maxSize-1){
            array[++top]= value;
        }
    }

    //弹出栈顶数据
    public int pop(){
        return array[top--];
    }

    //访问栈顶数据
    public int peek(){
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.peek());

        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }

}
