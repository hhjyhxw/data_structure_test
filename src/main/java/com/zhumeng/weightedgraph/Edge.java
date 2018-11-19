package com.zhumeng.weightedgraph;

/**
 * Created by 512162086@qq.com on 2018/11/19 .
 * 带权(权：有大小的意思)图的边
 */
public class Edge {
    public int srcVert  ;//index of a vertex starting edge//边的开始顶点的下标
    public int destVert;//index of a vertex ending edge//边的结束地点的下标
    public int distance;//两点间的距离

    public Edge(int sv,int dv,int d){
        this.srcVert = sv;
        this.destVert = dv;
        this.distance = d;
    }
}
