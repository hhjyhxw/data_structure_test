package com.zhumeng.heap;


/**
 * Created by 512162086@qq.com on 2018/10/8 .
 * 堆:
 *  1、它是完全二叉树
 *  2、常用数据实现
 *  3、每个节点的关键字都大于（或者等于）这个节点的子节点的关键字
 *
 * 基于数据的堆有一下特点
 * 节点的索引（下标）为X时：
 *      他的父节点下标为：（X-1）/2
 *      他的左子节点的下标为：2*X+1
 *      他的右子节点的下标为：2*X+2
 */
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int size){
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return (currentSize==0);
    }

    public boolean insert(int key){
        if(currentSize==maxSize)
            return false;
        Node newnode = new Node(key);
        heapArray[currentSize] = newnode;
        trickleUp(currentSize++);
        return true;
    }

    /**
     * 什么意思?????????
     * @param index
     */
    public void trickleUp(int index) {
        int parent = (index-1)/2;
        Node bottom = heapArray[index];
        while (index>0 && heapArray[parent].getKey()<bottom.getKey()){
            heapArray[index] = heapArray[parent];//move it down
            index = parent;
            parent = (parent-1)/2;
        }
        heapArray[index] = bottom;
    }

    public Node remove(){
        Node root = heapArray[0];
        heapArray[0]=heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largeChild;
        Node top = heapArray[index];
        while (index<currentSize/2){
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            if(rightChild<currentSize && heapArray[leftChild].getKey()<heapArray[rightChild].getKey())
                largeChild = rightChild;
            else
                largeChild = leftChild;

            if(top.getKey()>=heapArray[largeChild].getKey())
                break;
            heapArray[index] =heapArray[largeChild];
            index = largeChild;
        }//end while
        heapArray[index]=top;
    }

    public boolean change(int index,int newValue){
        if(index<0 || index>=currentSize)
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if(oldValue<newValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }
}
