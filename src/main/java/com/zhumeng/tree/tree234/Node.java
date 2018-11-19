package com.zhumeng.tree.tree234;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 */
public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];

    /**
     * connect child to this node
     * @param childNum
     * @param child
     */
    public void connectChild(int childNum,Node child){
        childArray[childNum] = child;
        if(child != null){
            child.parent = this;
        }
    }

    /**
     * disconnect child from this node,return it;
     * @param childNum
     * @return
     */
    public Node disconnectChild(int childNum){
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    public Node getChild(int childNum){
        return childArray[childNum];
    }

    public Node getParent(){
        return parent;
    }

    /**
     * 是否是叶子节点;
     * @return
     */
    public boolean isLeaf(){
        return (childArray[0]==null);
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getDataItem(int index){
        return itemArray[index];
    }

    /**
     * 判断节点是发是满四个子节点
     * @return
     */
    public boolean isFull(){
        return (numItems==ORDER-1);
    }

    /**
     * 查找数据项下标
     * @param key
     * @return
     */
    public int findItem(long key){
        for (int i = 0; i <ORDER-1 ; i++) {
            if (itemArray[i]==null){
                break;
            }else if(itemArray[i].dData==key){
                return i;
            }
        }
        return -1;
    }

    /**
     * 插入数据项
     * @param newdataItem
     * @return
     */
    public int insertDataItem(DataItem newdataItem){
        //判断节点是否数据项已满
        if(isFull()){
            return -1;
        }
        numItems++;
        long newkey = newdataItem.dData;
        for (int i = ORDER-2; i>=0 ; i--) {//start on right
            if(itemArray[i]==null){//if item is null,go left one cell
                continue;
            }else {
                long itsKey = itemArray[i].dData;
                if(newkey<itsKey){
                    itemArray[i++] = itemArray[i];
                }else{
                    itemArray[i+1] = newdataItem;
                    return i+1;
                }
            }//
        }//end for
        itemArray[0] = newdataItem;
        return 0;
    }

    /**
     * 删除数据项
     * @return
     */
    public DataItem removeDataItem(){
        if(numItems-1>=0){
            DataItem temp = itemArray[numItems-1];
            itemArray[numItems-1]= null;
            numItems--;
            return temp;
        }
        return null;
    }

    public void displayNode(){
        for (int i = 0; i <numItems ; i++) {
            itemArray[i].display();
        }
    }
}
