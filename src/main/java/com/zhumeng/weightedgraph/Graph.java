package com.zhumeng.weightedgraph;

/**
 * Created by 512162086@qq.com on 2018/11/19 .
 * 图
 */
public class Graph {
    private final int MAX_VERTS = 20;//最大顶点数
    private final int INFINITY = 1000000;//设置边的权值 大不到的默认值
    private Vertex[] vertxList;//顶点数组
    private int adjMat[][];//邻接矩阵  用于生成边
    private int nVertex;//顶点数组当前元素个数
    private int currentVert;//当前顶点 用于生成最新生成树
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
        //遍历顶点数据，把每个顶点加入 最小生成树中，
        while (nTree<nVertex-1){//当不是所有的顶点都在树中的时候
            vertxList[currentVert].isInTree = true;//把当前顶点放入树中
            nTree++;

            //insert edges adjacent to currentVert into PQ
            //把当前顶点的邻接边加入到 优先队列中
            for (int j = 0; j <nVertex ; j++) {//遍历图中所有顶点
                if(j==currentVert)//比较自身时,跳过
                    continue;
                if(vertxList[j].isInTree)//已在最小树中，跳过
                    continue;
                int distance = adjMat[currentVert][j];//当前顶点与其他顶点的距离
                if(distance==INFINITY)//两顶点没有边,跳过
                    continue;
                putInPQ(j,distance);//加入优先队列
            }
            if(thePQ.size()==0){
                System.out.println("the graph not connected");
                return;
            }
            //remove edge with minimum distance from PQ
            Edge edge = thePQ.removeMin();
            int sourceVert = edge.srcVert;
            currentVert = edge.destVert;
//            System.out.println(vertxList[currentVert].label+"");
            //display edge from source to current
            System.out.println((vertxList[sourceVert].label+"")+(vertxList[currentVert].label)+"");
        }//end while

        //重置顶点 状态
        for (int j = 0; j <nVertex ; j++) {
            vertxList[j].isInTree=false;
        }
    }

    /**
     * 把边 加入优先队列
     * @param newVert 目标顶点在数组中的下标
     * @param newDistance 边长
     */
    private void putInPQ(int newVert, int newDistance) {
        //is there another edge width the same destination vertex;
        //查询是否存在 给定结束顶点位置的边
        int queueIndex = thePQ.find(newVert);//获取边在优先队列中的位置
        if(queueIndex!=-1){//存在给定结束顶点位置的边
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldDisctane = tempEdge.distance;//原来的边的长度
            if(oldDisctane>newDistance){
                //如果给定结束顶点的 旧的边 比 新加入的距离大，那么移除旧的边，加入新的边
                thePQ.removeN(queueIndex);
                Edge newedge = new Edge(currentVert,newVert,newDistance);//创建新的边
                //把新的边加入优先队列
                thePQ.insert(newedge);
            }
        }else{
            Edge newedge = new Edge(currentVert,newVert,newDistance);//创建新的边
            //把新的边加入优先队列
            thePQ.insert(newedge);
        }
    }



    public static void main(String[] args){
        Graph graph = new Graph();
        //添加顶点
        graph.addVertex('A');//index 0
        graph.addVertex('B');//index 1
        graph.addVertex('C');//index 2
        graph.addVertex('D');//index 3
        graph.addVertex('E');//index 4
        graph.addVertex('F');//index 5

        //添加边
//        graph.addEdge(0,1,5);//AB
//        graph.addEdge(0,2,6);//AC
//        graph.addEdge(0,3,12);//AD
//        graph.addEdge(0,4,5);//AE
//        graph.addEdge(1,2,9);//BC
//        graph.addEdge(1,3,3);//BD
//        graph.addEdge(1,4,8);//BE
//
//        graph.addEdge(2,3,7);//CD
//        graph.addEdge(2,4,8);//CE
//        graph.addEdge(2,5,5);//CF
//
//        graph.addEdge(3,5,8);//DF
//        graph.addEdge(4,5,9);//EF

        graph.addEdge(0,1,6);//AB 6
        graph.addEdge(0,3,4);//AD 4
        graph.addEdge(1,2,10);//BC 10
        graph.addEdge(1,3,7);//BD 7
        graph.addEdge(1,4,7);//BE 7
        graph.addEdge(2,3,8);//CD 8
        graph.addEdge(2,4,5);//CE 5
        graph.addEdge(2,5,6);//CF 6
        graph.addEdge(3,4,12);//DE 12
        graph.addEdge(4,5,7);//EF 7

        graph.mstw();
    }
}
