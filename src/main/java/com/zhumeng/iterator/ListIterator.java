package com.zhumeng.iterator;

import com.zhumeng.link.DoubleLink;
import com.zhumeng.link.DoubleLinkList;
import com.zhumeng.link.Link;
import com.zhumeng.link.LinkList;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 */
public class ListIterator {
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list){
        this.ourList = list;
        reset();
    }

    /**
     * 重置 链头位置
     */
    public void reset(){
        current = ourList.getFirst();
        previous = null;
    }

    /**
     * 是否已在最后
     * @return
     */
    public boolean atEnd(){
        return  (current.next==null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    /**
     * 获取当前节点
     * @return
     */
    public Link getCurrent(){
        return current;
    }

    /**
     * 在当前节点后面插入
     * @param dd
     */
    public void insertAfter(long dd){
        Link link = new Link(2,dd);
        if(ourList.isEmpty()){
            ourList.setFirst(link);
            current = link;
        }else{
            link.next = current.next;
            current.next = link;
            nextLink();//point to new link
        }
    }

    /**
     * 在当前节点签名插入
     * @param d
     */
    public void insertBefore(long d){
        Link link = new Link(2,d);
        if(previous==null){
            link.next = current;
            ourList.setFirst(link);
            reset();
        }else{
            previous.next = link;
            link.next = current;
            current = link;
        }
    }

    /**
     * 删除当前节点
     * @return
     */
    public long deleteCurrent(){
        Link temp = current;
        long result = current.iData;
        if(previous==null){
//            current = current.next;
            ourList.setFirst(current.next);
            reset();
        }else{
            previous.next = current.next;
            if(atEnd())
                reset();
            else
               current = current.next;
        }
        return result;
    }
}
