package com.zhumeng.tree.tree234;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 * 每个节点最多有4个子节点和三个数据项
 * 1、有一个数据项的节点总是有两个子节点
 * 2、有两个数据项的节点总是有三个子节点
 * 3、有三个数据项的节点总是有四个子节点
 * 公式表：设某节点 子节点的个数 L，数据项个数是 D，那么 L = D + 1;
 *
 * 根是 child0 的子树的所有子节点的关键字值小于key0
 * 根是 child1 的子树的所有子节点的关键字值大于key0小于key1
 * 根是 child2 的子树的所有子节点的关键字值大于key1小于key2
 * 根是 child3 的子树的所有子节点的关键字值大于key2
 */
public class M234Tree {

    private Node root = new Node();


    public Node find(long key){
        Node curNode = root;
        int childNumer = 0;

        while (true){
            if((childNumer=curNode.findItem(key))!=-1){
                return curNode;
            }else if(curNode.isLeaf())//到叶子节点
                return null;
            else
                curNode = getNextChild(curNode,key);
        }
    }

    /**
     * 获取下个子节点
     * @param theNode
     * @param key
     * @return
     */
    public Node getNextChild(Node theNode, long key) {
        int j;
        int numItems = theNode.getNumItems();
        for (j = 0; j <numItems ; j++) {
            if(key<theNode.getDataItem(j).dData){
                return theNode.getChild(j);//return left child
            }
        }
        return theNode.getChild(j);//return right child
    }


    /**
     * 添加数据
     * @param dData
     */
    public void insert(long dData){
        //从根节点开始
        Node curNode = root;
        DataItem tempData = new DataItem(dData);

        while (true){
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode,dData);
            }else if(curNode.isLeaf()){
                break;
            }else{
                curNode = getNextChild(curNode,dData);
            }
        }
        curNode.insertDataItem(tempData);
    }

    /**
     * 节点分裂,节点满了之后，新添加节点 需要分裂
     * @param thisNode
     */
    private void split(Node thisNode) {
        DataItem itemB,itemC;
        Node parent,child2,child3;
        int itemIndex;

        itemC = thisNode.removeDataItem();
        itemB = thisNode.removeDataItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();
        if(thisNode==root){
            root = new Node();
            parent = root;
            root.connectChild(0,thisNode);
        }else{
            parent = thisNode.getParent();
        }
        itemIndex = parent.insertDataItem(itemB);
        int n = parent.getNumItems();
        for (int j = n-1; j>itemIndex ; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j+1,temp);
        }
        parent.connectChild(itemIndex+1,newRight);
        newRight.insertDataItem(itemC);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }
}
