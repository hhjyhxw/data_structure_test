package com.zhumeng.tree.huffmanTree;

/**
 * Created by 512162086@qq.com on 2018/11/21 .
 */
public class Node<E> {
    E data;
    double weight;
    Node leftChild;
    Node rightChild;

    public Node(E data, double weight) {
        super();
        this.data = data;
        this.weight = weight;
    }

    public String toString() {
        return "Node[data=" + data + ", weight=" + weight + "]";
    }
}
