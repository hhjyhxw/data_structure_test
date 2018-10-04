package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/9/30 .
 * 插入排序,一个基本有序的数组使用 插入顺序 排序，排序数据约为 O(N),比冒泡排序快一倍；
 * 对应逆序排序 ，时间复杂度 却为 O(N^2),不比冒泡排序快
 */
public class InsertSortTest {

    public static void main(String[] args) {
        int[] array = {5, 6, 63, 30, 20, 63, 95, 15};
        insertSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 数组外循环计数器 ，每比较一下，减一
     * 比较次数 约为 O(N^2/2);交换次数约为 O(N)；一般交换时间更为耗时
     * @param arry
     */
    public static void insertSort(int[] arry){

        //定义out,in
        int out,in,min;
        for(out=1; out<arry.length-1;out++){//以第二个数据为标志位
            int temp =arry[out];
            //依次与前面的位置的数据比较，直到出现比标志位数据小的数据出现
            in = out;
            while(in>0 && arry[in-1]>=temp){
                arry[in]=arry[in-1];
                --in;
            }
           arry[in]=temp;

        }
    }

}
