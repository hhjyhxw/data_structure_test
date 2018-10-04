package com.zhumeng.Stack;

/**
 * Created by 512162086@qq.com on 2018/10/1 .
 * 用数据为底层 构建 栈
 */
public class StackTest {

    private int maxSize;// size of stack arry,栈数组最大长度
    private long[] stackArray;
    private int top;// top of stack; 栈顶角标；类似c++或者c中的栈顶指针

    //初始化指定高度 栈
    public StackTest(int s){
        this.maxSize = s;
        this.stackArray = new long[this.maxSize];
        top=-1;//初始化栈顶位置为-1，表示没有栈没有数据
    }

    /**
     * 入栈
     * @param j
     */
    public void push(long j){
        stackArray[++top] = j;//定位栈顶位置，并放入数据
    }

    /**
     * 出栈
     * @return
     */
    public long pop(){
        return stackArray[top--];//返回栈顶 数据，并重定位栈顶位置
    }

    /**
     * 查看栈顶数据
     * @return
     */
    public long peek(){
        return stackArray[top];//返回栈顶数据
    }

    /**
     * 判断是否有数据
     * @return
     */
    public boolean ieEmpty(){
        return (top==-1);//top =-1  栈顶位置是-1，没有数据，返回true；
    }

    /**
     * 判断栈是否已满
     * @return
     */
    public boolean isFull(){
        return (top==stackArray.length-1);//栈顶的位置 等于数据最大长度
    }

    public static void main(String[] args){
        StackTest stack = new StackTest(20);
        stack.push(20L);
        stack.push(10L);
        stack.push(30L);
        stack.push(40L);
        stack.push(60L);
        stack.push(80L);

        System.out.println("stack.isFull()======="+stack.isFull());
        System.out.println("stack.ieEmpty()======"+stack.ieEmpty());
        while (!stack.ieEmpty()){
            System.out.println(stack.pop());
        }
    }
}

