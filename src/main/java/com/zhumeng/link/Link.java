package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 */
public class Link {
    public int iData;
    public double dData;
    public Link next;//next link

    public Link(int iData,double dData){
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println("{ "+iData+" , "+dData+" }");

    }

    public void insertFirst(int iData,double dData){
        Link newLink = new Link(iData, dData);
    }
}
