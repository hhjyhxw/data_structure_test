package com.zhumeng.sorts;

import com.zhumeng.util.PrintUtils;

/**
 *插入排序，固定某一边为以排序，另一边为未排序又：
 * 未排序的 每一轮拿一个与已排序的比较，然后交换位置
 *
 * 不变值：那已排序的序列分别与下一个 未排序的值比较，找出合适的位置然后
 */
public class InsertSortTest3 {

    public static void main(String[] args){
        Integer[] arrys = {9,3,5,8,6,2,0};
        PrintUtils.print(arrys);
        PrintUtils.printLn();
        System.out.println(arrys.length);
        inserSortN(arrys);
        PrintUtils.print(arrys);
    }

    //返序向 比较 ,升序排序
    public static void inserSortN(Integer[] arry){
        //外循环 未排序,内循环已排序
        for(int i=1;i<arry.length;i++){
            int temp = arry[i];
            int j=i;
           while (j>0  && arry[j-1]>temp){
               arry[j]=arry[j-1];//前面的数值比后面的大，先前移位
               j--;
           }
            arry[j]=temp;
        }

    }

}
