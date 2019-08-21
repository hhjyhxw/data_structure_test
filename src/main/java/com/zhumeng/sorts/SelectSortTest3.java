package com.zhumeng.sorts;

import com.zhumeng.util.PrintUtils;

/**
 * 初始值：设置最大或者最小值
 * 不变式：
 */
public class SelectSortTest3 {

    public static void main(String[] args){
        Integer[] arrys = {9,3,5,8,6,2,0};
        PrintUtils.print(arrys);
        PrintUtils.printLn();

        selectDescSort(arrys);
        PrintUtils.print(arrys);

        PrintUtils.printLn();
        selectAscSort(arrys);
        PrintUtils.print(arrys);
    }

    public static void selectDescSort(Integer[] arry){
        for (int i=0;i<arry.length;i++){
            int max = arry[i];
            int maxIndex = 0;
            for (int j=i+1;j<arry.length;j++){
                if(arry[j]>max){
                    max=arry[j];
                    maxIndex=j;
                }
            }
            if(maxIndex!=0){
                int temp = arry[i];
                arry[i]=max;
                arry[maxIndex]=temp;
            }
        }
    }

    public static void selectAscSort(Integer[] arry){
        for (int i=0;i<arry.length;i++){
            int min = arry[i];
            int minIndex = 0;
            for (int j=i+1;j<arry.length;j++){
                if(arry[j]<min){
                    min=arry[j];
                    minIndex=j;
                }
            }
            if(minIndex!=0){
                int temp = arry[i];
                arry[i]=min;
                arry[minIndex]=temp;
            }
        }
    }




    public static void selectDescSort2(Integer[] arry){
        for (int i=0;i<arry.length;i++){
            int max = i;
            for (int j=i+1;j<arry.length;j++){
                if(arry[j]>arry[max]){
                    max=j;
                }
            }
            if(max!=i){
                int temp = arry[i];
                arry[i]=arry[max];
                arry[max]=temp;
            }
        }
    }
}
