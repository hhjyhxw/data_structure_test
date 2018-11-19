package com.zhumeng.heap;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 */
public class Node {

    private int iData;

    public Node(int key){
        iData = key;
    }

    public int getKey(){
        return iData;
    }

    public void setKey(int iData){
        this.iData = iData;
    }
}
