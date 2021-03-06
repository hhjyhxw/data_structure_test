package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/9/30 .
 * 插入排序,一个基本有序的数组使用 插入顺序 排序，排序数据约为 O(N),比冒泡排序快一倍；
 * 对应逆序排序 ，时间复杂度 却为 O(N^2),不比冒泡排序快
 *
 * 类似于手上的扑克牌;左手上的是已排序的牌，桌面上是未排序的牌
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

        //定义out (out表示未排序的数据项),in （已排序的数据项）
        int out,in,min;
        for(out=1; out<arry.length-1;out++){//以第二个数据为标志位，每循环一次，获取下一个数与前面已排序的数据比较
            int temp =arry[out];
            //依次与前面的位置的数据比较，直到出现比标志位数据小的数据出现
            in = out;
            while(in>0 && arry[in-1]>=temp){//只要前面已排序的数据项 比 out项数据大，被比较的已排序数据项（in-1） 后移一位,到达in
                arry[in]=arry[in-1];
                --in;
            }
           arry[in]=temp;//插入前面腾出的位置
        }
    }

}
