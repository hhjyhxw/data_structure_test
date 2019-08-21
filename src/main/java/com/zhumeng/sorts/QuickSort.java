package com.zhumeng.sorts;

import com.zhumeng.util.SwapUtil;

/**
 * Created by 512162086@qq.com on 2018/11/23 .
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 6, 63, 30, 20, 63, 95, 15};
//        quickSort(array,0,array.length-1);
        quickSortDesc(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] arry,int left,int right){
        if(right-left<=0){
            return;
        }
        int key = arry[right];
        int index = partionSort(arry,left,right,key);
        quickSort(arry,left,index-1);
        quickSort(arry,index+1,right);
    }

    public static void quickSortDesc(int[] arry,int left,int right){
        if(right-left<=0){
            return;
        }
        int key = arry[right];
        int index = partionSortDesc(arry,left,right,key);
        quickSortDesc(arry,left,index-1);
        quickSortDesc(arry,index+1,right);
    }

    /**
     * 升序排序
     * @param arry
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int partionSort(int[] arry, int left, int right,int key) {
        int leftPtr = left-1;
        int rightPtr = right;
        while (true){
            while (arry[++leftPtr]<key);//左边寻找比key 大的值，找到循环停止
            while (rightPtr>0 && arry[--rightPtr]>key);//右边寻找比key 小的值，找到循环停止

            if(leftPtr>=rightPtr)
                break;
            SwapUtil.swap(arry,leftPtr,rightPtr);
        }
        //调整key的位置
        SwapUtil.swap(arry,leftPtr,right);
        return leftPtr;
    }

    /**
     * 降序排序
     * @param arry
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int partionSortDesc(int[] arry, int left, int right,int key) {
        int leftPtr = left-1;
        int rightPtr = right;
        while (true){
            while (arry[++leftPtr]>key);//左边寻找比key小的值，找到循环停止
            while (rightPtr>0 && arry[--rightPtr]<key);//右边寻找比key大小的值，找到循环停止

            if(leftPtr>=rightPtr)
                break;
            SwapUtil.swap(arry,leftPtr,rightPtr);
        }
        //调整key的位置
        SwapUtil.swap(arry,leftPtr,right);
        return leftPtr;
    }
}
