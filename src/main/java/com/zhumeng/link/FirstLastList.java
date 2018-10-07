package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 双端链表,只有一个节点时，first，last指向同一个节点
 *
 * 可以使用双端链表实现队列
 */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 在链头插入
     * @param iData
     * @param dData
     */
    public void insertFirst(int iData,double dData){
        Link newLink = new Link(iData, dData);
        if(isEmpty()){
           last = newLink;// 第一个新节点直接指向链尾
        }
        newLink.next = first;//新建 链节点，原来的头节点后移；
        first = newLink;//新节点作为链头
    }

    /**
     * 在链尾插入
     * @param iData
     * @param dData
     */
    public void inertLast(int iData,double dData){
        Link newLink = new Link(iData, dData);
        if(isEmpty())
            first = newLink;// 新节点直接指向 链头
        else
            last.next = newLink;//原来的最后节点的下一节点是新节点
        last = newLink;//最后节点 为新节点

    }

    /**
     * 删除链头
     * @return
     */
    public Link deleteFirst(){
        Link temp = first;
        if(first.next==null)//只有一个节点
            last = null;
        first = first.next;
        return temp;
    }

    /**
     * 删除链尾
     * @return
     */
    public Link deleteLast(){
        if(first==null){
            return null;
        }
        if(first.next == null){
            return first;
        }
        Link oldLast = null;
        Link temp = first;
        while (temp.next!=null){
            if(temp.next == last){
                oldLast = last;//返回即将需要删除的节点
                last = temp;
                last.next = null;//置空即将成为最后节点的 next
                break;
            }
            temp = temp.next;
        }
        return oldLast;
    }
}
