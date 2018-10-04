package com.zhumeng.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * 利用栈 机构实现单词 逆序
 */
public class WordStack {

    private int maxSize;// size of stack arry,栈数组最大长度
    private char[] stackArray;
    private int top;// top of stack; 栈顶角标；类似c++或者c中的栈顶指针

    //初始化指定高度 栈
    public WordStack(int max){
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


    public static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {

        String input =null;
        String ouput = null;

        while (true){
            System.out.println("Enter a String : **");
            System.out.flush();
            input =getString();

            WordReverser reverser = new WordReverser(input);
            String outString = reverser.doRe();
            System.out.println(outString);
        }

    }
}
