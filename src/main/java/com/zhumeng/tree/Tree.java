package com.zhumeng.tree;

/**
 * Created by 512162086@qq.com on 2018/10/7 .
 * 二叉搜索树，父节点的关键字值比左边子节点的关键字值大，比右边子节点的关键值小
 */
public class Tree {
    private Node root;

    /**
     * 根据关键字查找
     * @param key
     * @return
     */
    public Node find(int key){
        //从根节点开始遍历
        Node current = root;
        while (current.iData!=key){
            if(key>current.iData){
                current = current.rightChild;
            }else{
                current = current.leftChild;
            }
            //找不到key对应的节点，返回空
            if(current==null){
                return null;
            }
        }
        return current;
    }

    /**
     * 插入二叉树
     * @param iData
     * @param ddata
     */
    public void insert(int iData,double ddata){
        Node newnode = new Node(iData,ddata);
        if(root==null){
            root = newnode;
        }else{
            Node current = root;
            Node parent;
            //寻找插入点，寻找父节点
            while (true){
                parent = current;
                if(iData<current.iData){//go to left
                    current = current.leftChild;
                    if(current==null){// if end of the line ,insert on left
                        parent.leftChild = newnode;
                        return;
                    }
                }else{                  //go to right
                    current = current.rightChild;
                    if(current==null){// if end of the line ,insert on right
                        parent.rightChild = newnode;
                        return;
                    }
                }//end go to right

            }//end  while (true)
        }//end if(root==null)
    }

    /**
     * 查找最小值，leftChild最后的叶子节点
     * @return
     */
    public Node findMinmum(){
        Node current;
        Node last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 查找最大值，rightChild最后的叶子节点
     * @return
     */
    public Node findMaxmum(){
        Node current;
        Node last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }
    /**
     * 二叉树遍历；中序遍历
     */
    public void midleInOrder(Node localRoot){
        if(localRoot!=null){
            //1、第一步遍历左边节点
            midleInOrder(localRoot.leftChild);
            //2、第二步处理 节点本身
            System.out.println(localRoot.iData);
            //3、第三步处理右边子节点
            midleInOrder(localRoot.rightChild);
        }
    }
    /**
     * 二叉树遍历；前序遍历
     */
    public void preInOrder(Node localRoot){
        if(localRoot!=null){
            //1、第二步处理 节点本身
            System.out.println(localRoot.iData);
            //2、第一步遍历左边节点
            preInOrder(localRoot.leftChild);
            //3、第三步处理右边子节点
            preInOrder(localRoot.rightChild);
        }
    }

    /**
     * 二叉树遍历；后序遍历
     */
    public void lastInOrder(Node localRoot){
        if(localRoot!=null){
            //1、第一步遍历左边节点
            lastInOrder(localRoot.leftChild);
            //2、第三步处理右边子节点
            lastInOrder(localRoot.rightChild);
            //3、第二步处理 节点本身
            System.out.println(localRoot.iData);
        }
    }


    /**
     * 二叉树 删除
     * 1、删除叶子节点
     * 2、删除有一个 子节点的节点
     * 3、
     */

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData!=key){
            parent = current;
            if(key<current.iData){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current==null){
                return false;
            }
        }//end  while (current.iData!=key)

        /**1、判断是否是叶子节点,是叶子节点，则其父节点的子节点置为空*/
        if(current.leftChild==null && current.rightChild==null){
            //判断是否是跟节点
            if(current==root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        /**2.1、只有右节点*/
        }else if(current.leftChild==null){//2、只有右节点
            //判断是否是跟节点
            if(current==root){
                root = current.rightChild;//如果当前节点是根节点，则把右节点改成根节点
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;//如果当前节点是左节点，那么修改其右子节点为其父的左子节点
            }else{
                parent.rightChild = current.rightChild;//如果当前节点是右节点，那么修改其右子节点为其父的右子节点
            }
            /**2.2、只有一个左节点*/
        }else if(current.rightChild==null){//2、只有一个左节点
            //判断是否是跟节点
            if(current==root){
                root = current.leftChild;//如果当前节点是根节点，则把其左节点改成根节点
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;//如果当前节点是左节点，那么修改其左子节点为其父的左子节点
            }else{
                parent.rightChild = current.leftChild;//如果当前节点是右节点，那么修改其左子节点为其父的右子节点
            }
        }
        /**3、有两个子节点，找其后继（其右边子树中 最左边 最小的值节点）替代*/
        else {
            //寻找后继节点
            Node successor = getSuccessor(current);
            if(current==root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 寻找某个节点的后继节点
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //???????
        if(successor!=delNode.rightChild){
            successorParent = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

}
