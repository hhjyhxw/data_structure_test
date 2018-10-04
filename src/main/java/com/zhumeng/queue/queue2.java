package com.zhumeng.queue;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * 没有 nItem 的队列
 */
public class queue2 {
    private int maxSize;//队列最大长度
    private long[] querArray;//队列数组;;以数组为底层的队列，一般开始处理数据从 低位下标开始
    private int rear;//插入数据的队尾位置
    private int front;//移除数据的 队头指针（位置）
//    private int nItem;// 队列已存入 元素 总数

    public queue2(int max){
        this.maxSize = max+1;//初始化队列长度
        this.querArray = new long[this.maxSize];
        this.rear = -1;//队尾 待插入位置 -1表示还没有数据
        this.front = 0;//队头
//        this.nItem = 0;//初始元素 0 个
    }

    /**
     * 插入队列
     * @param j
     */
    public void insert(long j){
        //判断队列是否已满
        if(isFull()) {
             throw new RuntimeException("队列已满");
        }
        //判断队尾位置是否达到 队列容量最大位置，如果是，重置队尾位置
        if(rear==querArray.length-1){
            rear = -1;
        }
        querArray[++rear]=j;//先移动队尾位置，再插入值
    }

    /**
     * 获取并删除队头元素
     * @return
     */
    public long remove(){
        //判断队列是否为空
        if(isEmpty()) {
            return -1;
        }
        long temp = querArray[front++];//先取出队头元素，再向下移动队头位置
        //如果队头位置到达最大值，重置队头位置
        if(front==maxSize)
            front=0;
        return temp;
    }

    /**
     * 查看队头元素
     * @return
     */
    public long peekFront(){
        return querArray[front];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        //队尾在起始位置，队头也在起始位置 ；
        return (rear+1==front || front+maxSize-1==rear);
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return (rear+2==front || front+maxSize-2==rear);
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        if(rear>front){
            return rear-front+1;
        }else {
            return (maxSize-front)+(rear+1);
        }
    }

}
