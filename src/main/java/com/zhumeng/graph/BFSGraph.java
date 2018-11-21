package com.zhumeng.graph;

/**
 * Created by 512162086@qq.com on 2018/10/17 .
 * 图;图的表示法有 邻接矩阵法，链表法
 */
public class BFSGraph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList = null;//arry of vertices 顶点列表
    private int[][] adjMat;//邻接矩阵，表示顶点关系
    private int nVerts;//顶点数
    private Queue theQueue;//搜索队列


    public BFSGraph(){
         vertexList =  new Vertex[MAX_VERTS];
         adjMat = new int[MAX_VERTS][MAX_VERTS];
         nVerts = 0;
        for (int i = 0; i<MAX_VERTS ; i++) {
            for (int j = 0; j<MAX_VERTS ; j++) {
                adjMat[i][j] = 0;
            }
        }
        theQueue =  new Queue();
    }

    /**
     * 添加点
     * @param lab
     */
    public void addVertex(char lab){
        //nVerts++ 先赋值 再累加
        vertexList[nVerts++]=new Vertex(lab);
    }

    /**
     * 增加顶点关系
     * @param start
     * @param end
     */
    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    /**
     * 获取某点  相邻的未访问的点的位置坐标
     * @param v
     * @return
     */
    public int getAdjUnivisitedVertex(int v){
        for (int i = 0; i <nVerts ; i++) {
            if(adjMat[v][i]==1 && vertexList[i].wasVisited==false){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从顶点开始 广度搜索 节点 breath-first search
     * 规则1:访问下一个未访问的邻接点(如果存在),这个顶点必须是当前顶点的邻接点,标记他 并把它插入队列中
     * 规则2:如果因为没有了未访问的顶点而不能执行规则1,那么从队列头取一个顶点(如果存在),并使其成为当前的顶点.
     * 规则3:如果因为队列为空,而不能执行规则2,搜索结束
     *
     */
    public void bfs(){
        vertexList[0].wasVisited=true;//begin at vertex 0 标志位以访问
        displayVertex(0);//mark it
        theQueue.insert(0);//加入队列
        int v2;

        //循环搜索
        while (!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            //
            while ((v2=getAdjUnivisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                theQueue.insert(v2);
            }//
        }//

        //重置节点访问情况
        for (int i = 0; i <nVerts; i++) {
            vertexList[i].wasVisited=false;
        }
    }

    public static void main(String[] args){
        BFSGraph graph = new BFSGraph();
        graph.addVertex('A');//0
        graph.addVertex('B');//1
        graph.addVertex('C');//2
        graph.addVertex('D');//3
        graph.addVertex('E');//4

        //添加点的相邻关系
        graph.addEdge(0,1);//AB
        graph.addEdge(1,2);//AB
        graph.addEdge(0,3);//AD
        graph.addEdge(3,4);//DE

        //搜索访问
//        graph.bfs();


//       System.out.println("123456".substring(0, 5));
    }
}
