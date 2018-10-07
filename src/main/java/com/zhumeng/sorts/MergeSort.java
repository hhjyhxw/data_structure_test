package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/10/5 .
 * 归并排序,需要差不多双倍的内存;二分查找
 */
public class MergeSort {


    public static void main(String[] args){
        int[] arryA = {23,47,81,95};
        int[] arryB = {1,49,82,83};
        int[] arryC = new int[10];
        merge(arryA,arryB,arryC);
        display(arryC);
    }

    /**
     * merge arryA and arryB into arryC
     * @param arryA
     * @param arryB
     * @param arryC
     */
    public static void merge( int[] arryA,int[] arryB,int[] arryC){
        int aIndex=0,bIndex=0,cIndex=0;
        while (aIndex<arryA.length && bIndex<arryB.length){
            if(arryA[aIndex]<arryB[bIndex])
                arryC[cIndex++]=arryA[aIndex++];
            else
                arryC[cIndex++]=arryB[bIndex++];
        }
        while (aIndex<arryA.length)
            arryC[cIndex++]=arryA[aIndex++];
        while (bIndex<arryB.length)
            arryC[cIndex++]=arryB[bIndex++];

    }


    public static void display(int[] arry){
        for (int i = 0; i <arry.length ; i++) {
            System.out.println(arry[i]);
        }
    }
}
