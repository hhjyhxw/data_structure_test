package com.zhumeng.graph;

/**
 * Created by 512162086@qq.com on 2018/10/17 .
 */
public class Queue {
    private final int SIZE = 20;
    private int[] queneArray;
    private int front;//队头
    private int rear;//队尾

    public Queue(){
        queneArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    /**
     * 从队尾插入，插入前修改队尾指针
     * @param i
     */
    public void insert(int i){
        if(rear==SIZE-1)
            rear = -1;
        queneArray[++rear]=i;
    }

    /**
     * 从队头获取数据，并修改队头指针
     * @return
     */
    public int remove(){
        int temp = queneArray[front++];
        if(front==SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty(){
        //1 队尾指针没变过 2 队尾指针到了SIZE-1位置，font回到0
        return (rear==-1 || front+SIZE-1==rear);
    }
}
