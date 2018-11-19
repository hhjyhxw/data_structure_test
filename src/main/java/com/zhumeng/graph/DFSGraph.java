package com.zhumeng.graph;

/**
 * Created by 512162086@qq.com on 2018/10/17 .
 * 图;图的表示法有 邻接矩阵法，链表法
 */
public class DFSGraph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList = null;//arry of vertices 顶点列表
    private int[][] adjMat;//邻接矩阵，表示顶点关系
    private int nVerts;//顶点数
    private StackX theStackX;//搜索栈


    public DFSGraph(){
         vertexList =  new Vertex[MAX_VERTS];
         adjMat = new int[MAX_VERTS][MAX_VERTS];
         nVerts = 0;
        for (int i = 0; i<MAX_VERTS ; i++) {
            for (int j = 0; j<MAX_VERTS ; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStackX =  new StackX();
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

    public void displayVertexLine(int v,int p){
        System.out.println(vertexList[v].label+"---"+vertexList[p].label);
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
     * 从顶点开始 深度搜索 节点 depth-first search
     * 规则1:访问一个邻接的未访问顶点,标志它,并把它放入栈中.
     * 规则2：当不能执行规则1时，如果栈不空，就从栈中弹出一个顶点
     * 规则3：如果不能执行规则1和规则2，完成搜索
     */
    public void dfs(){
        vertexList[0].wasVisited=true;//begin at vertex 0 标志位以访问
        displayVertex(0);//mark it
        theStackX.push(0);//入栈

        //循环搜索
        while (!theStackX.isEmpty()){
            int currentVertex = theStackX.peek();
            //查找未访问过的相邻的节点
            int v = getAdjUnivisitedVertex(theStackX.peek());
            //没有相邻的 未访问节点
            if(v==-1){
                theStackX.pop();//已查找完所有相邻 未访问节点；出栈
            }else {
                //找到相邻的未访问节点
                vertexList[v].wasVisited=true;//标志找到的节点
                displayVertexLine(currentVertex,v);
//                displayVertex(currentVertex);
//                displayVertex(v);
                theStackX.push(v);//入栈
            }
        }

        //重置节点访问情况
        for (int i = 0; i <nVerts; i++) {
            vertexList[i].wasVisited=false;
        }
    }

    /**
     * 最小生产树
     */
    public void mst(){

    }

    public static void main(String[] args){
        DFSGraph graph = new DFSGraph();
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
        graph.dfs();
    }
}
