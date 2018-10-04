package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/9/30 .
 * 冒泡排序(时间复杂度约为 O(N^2)) 比较慢的
 *
 */
public class BubbleSortTest {
    public static void main(String[] args){
        int[] array = {5,6,63,30,20,63,95,15};
        bubbleSort(array);
        for (int i=0;i<array.length-1;i++){
            System.out.println(array[i]);
        }

    }


    /**
     * 数组外循环计数器 ，每比较一下，减一
     * 比较次数 约为 O(N^2/2);交换次数约为 O(N^2/4)；一般交换时间更为耗时
     * @param arry
     */
    public static void bubbleSort(int[] arry){

        //外循环每比较一轮，得到一个最大值，减少一轮比较
        for(int i=arry.length-1;i>1;i--){
            //内循环没比较一次，可能需要交换一次位置
            for(int j=0;j<i;j++){
//                //大的放到后面
//                if(arry[j]>arry[j+1]){
//                    swap(arry,j,j+1);
//                }
                //大的放到前面
                if(arry[j]<arry[j+1]){
                    swap(arry,j,j+1);
                }
            }

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
