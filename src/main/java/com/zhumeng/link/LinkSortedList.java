package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 有序链表，升序排序
 */
public class LinkSortedList {

    private Link first;

    public LinkSortedList(){
        first = null;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return  (first==null);
    }

    /**
     * 插入在，iData越大 越在链后面
     * @param key
     */
    public void insert(int key){
        Link newlink = new Link(key,key);
        //查找插入节点的位置，previous 前一个节点，后一个节点 current
        Link previous = null;//start at first
        Link current = first;

        //插入的值 比当前值大,
        while (current!=null && key>current.iData){
            previous = current;
            current = current.next;
        }

        if(previous==null){ //第一个节点
            first = newlink;
        }else{
            previous.next = newlink;
        }
        newlink.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }
}
