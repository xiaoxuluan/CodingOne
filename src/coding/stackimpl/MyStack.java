package coding.stackimpl;

/**
 * @Author: alenlyx
 * @Date: 2019/10/9 16:16
 * @Version 1.0
 */
public class MyStack {

    /**
     * ջ����ʵ�� 1.�����Զ����� 2.�������͹̶�
     */

    private int [] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //ѹ������
    public void push(int value){
        if(top<maxSize-1){
            array[++top]= value;
        }
    }

    //����ջ������
    public int pop(){
        return array[top--];
    }

    //����ջ������
    public int peek(){
        return array[top];
    }

    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return (top == -1);
    }

    //�ж�ջ�Ƿ�����
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
