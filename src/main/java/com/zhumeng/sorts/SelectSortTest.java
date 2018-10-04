package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/9/30 .
 * 选择排序
 * 不变性：下标
 */
public class SelectSortTest {

    public static void main(String[] args) {
        int[] array = {5, 6, 63, 30, 20, 63, 95, 15};
        selectSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 数组外循环计数器 ，每比较一下，减一
     * 比较次数 约为 O(N^2/2);交换次数约为 O(N)；一般交换时间更为耗时
     * @param arry
     */
    public static void selectSort(int[] arry){

        //定义out,in 最小值的角标为min
        int out,in,min;
        //每比较一轮，得到一个最大值角标，减少一轮比较
        for(out=0; out<arry.length-1;out++){
            min=out;
            //没比较一轮获取一个最大值角标，然后判断是否需交互位置
            for(in= out+1;in<arry.length;in++){
//                //大的放到前面
//                if(arry[in]>arry[min]){
//                    min = in;
//                }
                //大的放到后面
                if(arry[in]<arry[min]){
                    min = in;
                }
            }
            swap(arry,out,min);

        }
//        return arry;
    }

    public static void swap(int[] arry,int a,int b){
        int temp = arry[a];
        arry[a]=arry[b];
        arry[b]=temp;
//        return arry;
    }
}
