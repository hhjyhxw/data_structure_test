package com.zhumeng.queue;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * ########优先级队列,同过比较大小插入合适位置，每次移除从队头开始(从最大优先及开始，数组下标比较大的一端 值大端优先级)
 * 值小端优先级  和 值大端优先级
 */
public class PriorQueue {
    private int maxSize;//队列最大长度
    private long[] querArray;//队列数组;;以数组为底层的队列，一般开始处理数据从 低位下标开始
    private int nItem;// 队列已存入 元素 总数

    public PriorQueue(int max){
        //arry in sorted order, from max at 0 to min at maxSize-1
        this.maxSize = max;//初始化队列长度
        this.querArray = new long[this.maxSize];
        this.nItem = 0;//初始元素 0 个
    }

    /**
     * 插入优先级队列
     * @param item
     */
    public void insert(long item){
        int j;
       if(nItem==0){//if no item
            querArray[nItem++]=item;  //insert at 0
       }else{
           for (j = nItem-1; j>=0; j--) {//start at end
               if(item>querArray[j]){//if new item larger than
                    querArray[j+1]=querArray[j];//新添加的项比 某个项优先级高，那么该项 后移
               }else{
                   break;//
               }
           }
           querArray[j+1]=item;
           nItem++;
       }
    }
//    F:\20180930intellijidea\data_structure_test

    /**
     * 删除优先级最小项
     * @return
     */
    public long remove(){
     return querArray[--nItem];//返回最最小项;实际上数据还在，只是让其不再有意义
    }

    /**
     * 查看优先级最小项
     * @return
     */
    public long peekMin(){
        return querArray[nItem-1];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return (nItem==0);
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return nItem==maxSize;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        return nItem;
    }

    public static void main(String[] args){
        PriorQueue prQueue = new PriorQueue(20);
        prQueue.insert(20);
        prQueue.insert(60);
        prQueue.insert(20);
        prQueue.insert(50);
        prQueue.insert(30);

        while (!prQueue.isEmpty()){
            long item = prQueue.remove();
            System.out.println("item=="+item);
        }

    }

}
