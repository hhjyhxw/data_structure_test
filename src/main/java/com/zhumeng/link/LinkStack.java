package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 使用链表 实现栈
 */
public class LinkStack {
    private LinkList linkList;

    public LinkStack(){
        linkList = new LinkList();
    }

    /**
     * 入栈
     * @param j
     */
    public void push(int j){
        linkList.insertFirst(j,j);
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
       Link ling = linkList.deleteFirst();
       return ling.iData;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return linkList.isEmpty();
    }
}
