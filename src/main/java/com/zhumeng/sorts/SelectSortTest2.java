package com.zhumeng.sorts;

import com.zhumeng.util.SwapUtil;

/**
 * Created by 512162086@qq.com on 2018/11/22 .
 * 从前面或者后面开始每个元素与后面的每个元素比较
 * 交换次数 很多的 选择排序
 */
public class SelectSortTest2 {

    public static void main(String[] args) {
        int[] array = {5, 6, 63, 30, 20, 63, 95, 15};
        selectSortAsc2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 升序排序
     * @param arry
     */
    public static void selectSortAsc(int[] arry){
        for (int i = 0; i <arry.length ; i++) {
            for (int j = i+1; j <arry.length ; j++) {
                if(arry[j]<arry[i]){
                    SwapUtil.swap(arry,j,i);
                }
            }
        }
    }

    /**
     * 升序排序2
     * @param arry
     */
    public static void selectSortAsc2(int[] arry){
        for (int i = arry.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(arry[j]>arry[i]){
                    SwapUtil.swap(arry,j,i);
                }
            }
        }
    }
    /**
     * 降序排序
     * @param arry
     */
    public static void selectSortDesc(int[] arry){
        for (int i = 0; i <arry.length ; i++) {
            for (int j = i+1; j <arry.length ; j++) {
                if(arry[j]>arry[i]){
                    SwapUtil.swap(arry,j,i);
                }
            }
        }
    }


}
