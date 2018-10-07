package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 双向链表 节点;
 */
public class DoubleLink {

    public long dData;
    public DoubleLink next;
    public DoubleLink previous;//

    public DoubleLink(long dData){
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println("dData--"+dData);
    }
}
