package com.zhumeng.link;

import com.zhumeng.iterator.ListIterator;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 双向链表
 */
public class DoubleLinkList {

    private DoubleLink first;
    private DoubleLink last;

    public DoubleLinkList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    /**
     * 表头插入
     * @param dd
     */
    public void insertFirst(long dd){
        DoubleLink newlink = new DoubleLink(dd);
        if(isEmpty())
            last = newlink;
        else
            first.previous = newlink;//old first set prvious
        newlink.next =  first;//new first set next
        first = newlink;//new first to first
    }

    /**
     * 表尾插入
     * @param dd
     */
    public void insertLast(long dd){
        DoubleLink newlink = new DoubleLink(dd);
        if(isEmpty())
            first = newlink;
        else {
            last.next = newlink;//old last set next
            newlink.previous = last;//new set previous
        }
        last = newlink;//new to last
    }


    /**
     * 在某个Key 后面插入
     * @param key
     * @param dData
     * @return
     */
    public boolean insertAfter(long key,long dData){
        DoubleLink current = first;
        while (current!=null && current.dData!=key){
            current = current.next;
            if(current==null){
                return false;
            }
        }
        DoubleLink newlink = new DoubleLink(dData);
        //判断是否是最后节点;最后节点 没有向后引用
        if(current==last){
            newlink.next = null;
            last = newlink;
        }else{
            //设置新节点的后节点
            newlink.next = current.next;
            //设置原后面节点的前节点
            current.next.previous = newlink;
        }
        //设置新节点的 前引用
        newlink.previous = current;
        current.next = newlink;
        return true;
    }

    /**
     * 删除链头
     * @return
     */
    public long deleteFirst(){
        DoubleLink temp  = first;
        if(first.next==null){//only item
            last = null;
        }else {
            first.next.previous = null;//置空新表头的 前节点
        }
        first = first.next;
        return temp.dData;
    }

    /**
     * 删除链尾
     * @return
     */
    public DoubleLink deleteLast(){
        DoubleLink temp = last;
        if(last.previous==null){
            first = null;
        }else{
            last.previous.next = null;//置空即将成为链尾的 后节点
        }
        last = last.previous;
        return temp;
    }

    /**
     * 根据关键字删除节点
     * @param key
     * @return
     */
    public DoubleLink deleteByKey(long key){
        DoubleLink current = first;
        while (current.dData!=key){
            //如果当前节点值与传入关键字不匹配,继续比较下一个节点
            current = current.next;
            //遍历到链尾也没找到 与 关键字对应的 节点,返回空
            if(current==null){
                return null;
            }
        }
        //判断是否为 首节点
        if(current==first){
            first = current.next;
            first.previous = null;
            return current;
        }
        //判断是否为 尾节点
        if(current==last){
            last = current.previous;
            last.next=null;
            return current;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        return current;
    }


    public void displayForward(){
        System.out.println("List (first -- >last): ");
        DoubleLink current =  first;
        while (current!=null){
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackForward(){
        System.out.println("List (last -- >first): ");
        DoubleLink current =  last;
        while (current!=null){
            current.displayLink();
            current = current.previous;
        }
    }



    public static void main(String[] args){
        DoubleLinkList dlist = new DoubleLinkList();
        dlist.insertFirst(6);
        dlist.insertFirst(67);
        dlist.insertFirst(89);
        dlist.insertFirst(2);
        dlist.insertFirst(5);

//        dlist.displayBackForward();
//        dlist.displayForward();

//        dlist.deleteByKey(89);
        dlist.insertAfter(2,63);
        dlist.displayForward();
    }

    public DoubleLink getFirst() {
        return first;
    }

    public void setFirst(DoubleLink first) {
        this.first = first;
    }

//
//    public ListIterator getIterator(){
//        return new ListIterator(this);
//    }
}
