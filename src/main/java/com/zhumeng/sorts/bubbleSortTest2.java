package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/11/22 .
 * （升序）相邻两个元素比较,后面的值小于前面的值，则交换位置;每一外循环完成，得到最大值
 */
public class bubbleSortTest2 {
    public static void main(String[] args) {
        int[] array = {5, 3,2, 63, 30, 20, 63, 95, 15};
        bubbleSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 升序排序
     * @param arry
     * @return
     */
    public static int[] bubbleSort(int[] arry){
        if(arry!=null && arry.length>1){
            for (int i = arry.length-1; i>1; i--) {
                boolean exchange = false;//标记是否扔序排序
                for (int j = 0; j <i ; j++) {
                    if(arry[j+1]<arry[j]){
                        swap(arry,j,j+1);
                        exchange =  true;
                    }
                }
                if(!exchange){
                    break;
                }
            }
        }
        return arry;
    }

    public static void swap(int[] arry,int x,int y){
        int temp = arry[x];
        arry[x] = arry[y];
        arry[y] = temp;
    }
}
