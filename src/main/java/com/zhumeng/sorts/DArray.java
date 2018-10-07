package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 */
public class DArray {
    private long[] arry;
    private int nElems;

    public DArray(int max){
        arry = new long[max];
        nElems = 0;
    }

    /**
     * 添加元素
     * @param value
     */
    public void insert(long value){
        arry[nElems]=value;
        nElems++;//increment size
    }

    public void dispay(){
        for (int i = 0; i <nElems ; i++) {
            System.out.println(arry[i]);
        }
    }

    public void mergeSort(){
        long[] workspace = new long[nElems];
        recMergeSort(workspace,0,nElems-1);


    }

    /**
     * 递归拆分数据
     * @param workspace 数组
     * @param lowerBound   起始下标
     * @param upperBound   结算下标
     */
    private void recMergeSort(long[] workspace,int lowerBound,int upperBound){
        if(lowerBound==upperBound){
            return;
        }else {
            int mid = (lowerBound+upperBound)/2;
            recMergeSort(workspace,lowerBound,mid);//
            recMergeSort(workspace,mid+1,upperBound);//
            //merge()
        }
    }

    public static void merge(long[] workspace,int lowPtr,int highPtr,int upperBound){

        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr -1;
        int n = upperBound - lowerBound +1;

    }
}
