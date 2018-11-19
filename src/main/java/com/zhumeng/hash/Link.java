package com.zhumeng.hash;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 */
public class Link {
    public int iData;
    public Link next;

    public Link(int iData){
        this.iData = iData;
    }

    public int getKey(){
        return iData;
    }

    public void display(){
        System.out.println("iData====="+iData);
    }
}
