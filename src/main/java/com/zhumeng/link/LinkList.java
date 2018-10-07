package com.zhumeng.link;

import com.zhumeng.iterator.ListIterator;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * 链表
 */
public class LinkList
{
    private Link first;

    public LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 在连头插入新对象
     * @param iData
     * @param dData
     */
    public void insertFirst(int iData,double dData){
        Link newLink = new Link(iData, dData);// make new Link.创建新的节点
        newLink.next =  first;//newLink -- > old first,原来的第一个节点后移，
        first = newLink;//新增节点 成为第一个节点
    }

    /**
     * 删除第一个节点
     * @return
     */
    public Link deleteFirst(){
        Link temp = first;//临时存储第一个节点
        first = first.next;//重置下一个节点为第一个节点
        return  temp;//返回已删除的节点
    }

    /**
     * 查找指定节点
     * @param key
     * @return
     */
    public Link findByKey(int key){
        Link current = first;
        while (current.iData!=key){
            if(current.next==null){
                return null;
            }else {
                current = current.next;
            }
        }
        return current;
    }

    public Link deletByKey(int key){
        Link current = first;
        Link previous = first;
        while (current.iData!=key){
            if(current.next==null){
                return null;
            }else {
                previous = current;
                current = current.next;
            }
        }
        if(current==first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
    /**
     * 打印链表数据
     */
    public void displayList() {
        System.out.println("first-->last: ");
        Link current = first;
        while (null != current) {
            current.displayLink();
            current = current.next;
        }

        System.out.println("end");
    }


    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }
}
