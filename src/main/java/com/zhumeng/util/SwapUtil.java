package com.zhumeng.util;

/**
 * Created by 512162086@qq.com on 2018/11/23 .
 */
public class SwapUtil {

    public static void swap(int[] arry,int x,int y){
        int temp = arry[x];
        arry[x]=arry[y];
        arry[y] = temp;
    }

    public static void swapWithOutTemp(int[] arry,int x,int y){
        arry[x]=arry[y]+arry[x];
        arry[y] = arry[x]-arry[y];
        arry[x] = arry[x]-arry[y];
    }
}
