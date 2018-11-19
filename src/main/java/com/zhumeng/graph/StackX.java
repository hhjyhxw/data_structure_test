package com.zhumeng.graph;

import com.zhumeng.Stack.Stack;

/**
 * Created by 512162086@qq.com on 2018/10/17 .
 */
public class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;//栈顶

    public StackX(){
        st = new int[SIZE];
        top = -1;
    }

    /**
     * 添加
     * @param i
     */
    public void push(int i){
        st[++top]=i;
    }

    /**
     * 取出栈顶数据，并改变栈顶位置
     * @return
     */
    public int pop(){
        return st[top--];
    }

    /**
     * 查看栈顶数据
     * @return
     */
    public int peek(){
        return st[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }
}
