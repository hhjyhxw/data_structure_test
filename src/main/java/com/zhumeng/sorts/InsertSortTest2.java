package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/11/22 .
 * 插入排序
 * （升序）前面的已排序，后面的每一个跟前面的比较，如果前面的比后面的值大，前面的值后移一位,直到找到比他小的或者到了最前面，找到插入位置
 */
public class InsertSortTest2 {

    public static void main(String[] args) {
        int[] array = {5, 6, 63, 30, 20, 63, 95, 15};
        insersort(array);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] insersort(int[] arry){
        int out,in;//out 未排序，in已排序
        for (out = 1; out <arry.length ; out++) {
            int temp = arry[out];
            in = out;
            while (in>0 && arry[in-1]>temp){
                arry[in] = arry[in-1];
                in--;
            }
            arry[in] = temp;
        }
        return arry;
    }
}
