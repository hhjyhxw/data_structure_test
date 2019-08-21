package com.zhumeng.sorts;

import com.zhumeng.util.SwapUtil;

/**
 * Created by 512162086@qq.com on 2018/10/7 .
 * 希尔排序,也是插入排序的一种，是简单插入排序改良版，也成缩小增量排序
 * 简单插入排序，每次增量为1
 *
 */
public class ShellSortTest2 {


    public static void main(String[] args){

        int maxSize = 100;
        ShellSortArraySh arr;
        arr = new ShellSortArraySh(maxSize);
        for (int i = 0; i <maxSize ; i++) {
            int n = (int) (Math.random()*99);
            arr.insert(n);
        }
//        arr.display();
//        arr.shellSort();
        int[] arry = arr.getTheArray();
        sellSortAsc(arry);
        for (int i = 0; i <arr.getTheArray().length; i++) {
            System.out.println(arry[i]);
        }
        System.out.println("//////////////////////");
//        arr.display();

    }

    /**
     * 升序排序
     * @param arry
     */
    public static void sellSortAsc(int[] arry){

        int h = 1;//初始增量为1
        while (h<=arry.length/3){
            h = h*3-1;//获取指定大小数据可分的最大增量
        }

        while (h>0){//只要增量大于0，就需要不断排序
            for (int i = h; i <arry.length ; i++) {
                int j=i;//用于跳出while
                int temp = arry[i];
                while (j-h>=0 && arry[j-h]>=temp){//指定位置比前面按增量走过的值小交互位置
                    arry[j]=arry[j-h];
                    j-=h;//增量是h
                }
                arry[j]=temp;
            }
            h=(h-1)/3;//，每一步增量比较完成后，减少增量值，直到增量变为1；当增量小于1时完成排序
        }

    }
}
