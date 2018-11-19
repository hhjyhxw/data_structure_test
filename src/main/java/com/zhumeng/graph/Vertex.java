package com.zhumeng.graph;

/**
 * Created by 512162086@qq.com on 2018/10/17 .
 * 顶点
 */
public class Vertex {
    public char label;
    public boolean wasVisited;//

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
    }



}
