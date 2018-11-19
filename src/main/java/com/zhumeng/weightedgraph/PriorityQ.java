package com.zhumeng.weightedgraph;

/**
 * Created by 512162086@qq.com on 2018/11/19 .
 * 优先队列,
 */
public class PriorityQ {
    //arry in sorted order,from max at 0 to min at size-1
    //有序数据，最大值在下标0位置，最小值在数据最后位置

    private final int SIZE = 20;//数据大小
    private Edge[] queArray;//边 数组
    private int size;//数组存在元素个数

    /**
     * 初始化数组
     */
    public PriorityQ(){
        this.queArray = new Edge[SIZE];
        this.size = 0;
    }

    /**
     * 插入一个元素
     * @param item
     */
    public void insert(Edge item){
        int j;// 插入目标位置

        //寻找目标位置, 边对象的 distance 越大 越在队列前面
        //find place to insert
        for (j = 0; j <size ; j++) {
            if(item.distance>=queArray[j].distance){
                break;
            }
        }
        //把下标大于 j 的元素向后移动一个位置
        //move item up
        for (int k = size-1; k >=j ; k--) {
            queArray[k+1]=queArray[k];
        }

        //在j位置插入 新的元素
        queArray[j] = item;
        size++;
    }

    /**
     * 移除边最小的元素
     * @return
     */
    public Edge removeMin(){
        return queArray[--size];
    }

    /**
     * 移除指定位置元素
     * @param n
     */
    public void removeN(int n) {
        for (int j = n; j <size-1 ; j++) {
            //n后面元素往前移动
            queArray[j]=queArray[j+1];
        }
    }

    /**
     * 获取最小边元素
     * @return
     */
    public Edge peekMin(){
        return queArray[size-1];
    }

    /**
     * 获取优先级队列大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return (size==0);
    }

    /**
     * 获取指定位置 元素
     * @param n
     * @return
     */
    public Edge peekN(int n){
        return queArray[n];
    }

    public int find(int findIndex){
        for (int j = 0; j <size ; j++) {
            if(queArray[j].destVert==findIndex){
                return j;
            }
        }
        return -1;
    }
}
