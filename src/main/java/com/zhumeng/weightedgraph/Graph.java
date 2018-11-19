package com.zhumeng.weightedgraph;

/**
 * Created by 512162086@qq.com on 2018/11/19 .
 * 图
 */
public class Graph {
    private final int MAX_VERTS = 20;//最大顶点数
    private final int INFINITY = 1000000;//??????? 最大值
    private Vertex[] vertxList;//顶点数组
    private int adjMat[][];//邻接矩阵
    private int nVertex;//顶点数组当前元素个数
    private int currentVert;//当前顶点
    private PriorityQ thePQ;//优先队列
    private int nTree;//树中的顶点个数

    public Graph(){
        vertxList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVertex  = 0;
        for (int j = 0; j <MAX_VERTS ; j++) {
            for (int k = 0; k <MAX_VERTS ; k++) {
                adjMat[j][k]=INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }

    /**
     * 图中添加顶点
     */
    public void addVertex(char lab){
        vertxList[nVertex++]=new Vertex(lab);
    }

    /**
     * 图中添加边
     */
    public void addEdge(int start,int end,int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    /**
     * 打印顶点名称
     * @param v
     */
    public void dispalyVertex(int v){
        System.out.println(vertxList[v].label);
    }

    /**
     * 最小生成树
     */
    public void mstw(){
        currentVert = 0;//start at 0

        while (nTree<nVertex-1){//当不是所有的顶点都在树中的时候
            vertxList[currentVert].isInTree = true;//把当前顶点放入树中
            nTree++;

            //insert deges adjacent to currentVert into PQ
        }
    }
}
