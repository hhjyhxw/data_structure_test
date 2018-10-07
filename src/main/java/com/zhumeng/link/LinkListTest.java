package com.zhumeng.link;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 */
public class LinkListTest {
    public static void main(String[] args){
        LinkList list = new LinkList();
        list.insertFirst(22,22.5);
        list.insertFirst(21,23.5);
        list.insertFirst(46,5.5);
        list.insertFirst(30,2.5);

        list.displayList();

        while (!list.isEmpty()){
            Link link = list.deleteFirst();
            link.displayLink();
        }
    }
}
