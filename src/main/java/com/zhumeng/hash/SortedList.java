package com.zhumeng.hash;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 * 有序链表
 */
public class SortedList {

    private Link first;

    public SortedList(){
        first = null;
    }

    /**
     * 插入节点，查找
     * @param theLink
     */
    public void insert(Link theLink){
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current!=null && key>current.getKey()){
            previous = current;
            current = current.next;

            if (previous==null)
                first = theLink;
            else
                previous.next=theLink;
            theLink.next=current;
        }
    }

    public void delete(int key){
        Link previous = null;
        Link current = first;

        while (current!=null && key>current.getKey()){
            previous = current;
            current = current.next;

            if (previous==null)
                first = first.next;
            else
                previous.next=current.next;
        }
    }

    public Link find(int key){
        Link current = first;
        while (current!=null && current.getKey()<=key){
           if(current.getKey()==key)
                return current;
           current=current.next;
        }
        return null;
    }
}
