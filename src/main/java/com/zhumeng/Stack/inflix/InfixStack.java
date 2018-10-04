package com.zhumeng.Stack.inflix;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * 栈 中缀表达式 转为后缀表达式
 */
public class InfixStack {

    private int maxSize;// size of stack arry,栈数组最大长度
    private char[] stackArray;
    private int top;// top of stack; 栈顶角标；类似c++或者c中的栈顶指针

    //初始化指定高度 栈
    public InfixStack(int max){
        this.maxSize = max;
        this.stackArray = new char[this.maxSize];
        top=-1;//初始化栈顶位置为-1，表示没有栈没有数据
    }

    /**
     * 入栈
     * @param j
     */
    public void push(char j){
        stackArray[++top] = j;//定位栈顶位置，并放入数据
    }

    /**
     * 出栈
     * @return
     */
    public char pop(){
        return stackArray[top--];//返回栈顶 数据，并重定位栈顶位置
    }

    /**
     * 查看栈顶数据
     * @return
     */
    public char peek(){
        return stackArray[top];//返回栈顶数据
    }

    /**
     * 判断是否有数据
     * @return
     */
    public boolean isEmpty(){
        return (top==-1);//top =-1  栈顶位置是-1，没有数据，返回true；
    }

    /**
     * 判断栈是否已满
     * @return
     */
    public boolean isFull(){
        return (top==stackArray.length-1);//栈顶的位置 等于数据最大长度
    }

    /**
     * 栈内元素
     * @return
     */
    public int size(){
        return top+1;
    }

    public char peekN(int n){
        return stackArray[n];
    }

    public void displayInfixStack(String s){
        System.out.println(s);
        System.out.println("Stack (bottom-->top): ");
        for (int i = 0; i <size() ; i++) {
            System.out.println(peekN(i));
        }
    }
}
