package com.zhumeng.graph.weightedgraph;

/**
 * Created by 512162086@qq.com on 2018/11/19 .
 * 图中的顶点
 */
public class Vertex {

    public char label;//顶点的名称
    public boolean isInTree;//是否在树中

    public Vertex(char label){
        this.label = label;
        this.isInTree = false;
    }



}
