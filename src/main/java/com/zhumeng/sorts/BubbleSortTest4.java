package com.zhumeng.sorts;

import com.zhumeng.util.PrintUtils;

/**
 * 冒泡排序，相邻的两个值比较 交换位置
 */
public class BubbleSortTest4 {

    public static void main(String[] args){
        Integer[] arrys = {9,3,5,8,6,2,0};
        PrintUtils.print(arrys);
        PrintUtils.printLn();

//        bubbleSortAscPositive(arrys);
//        PrintUtils.print(arrys);
//
//        PrintUtils.printLn();
//        bubbleSortDescPositive(arrys);
//        PrintUtils.print(arrys);

        bubbleSortWileDescNegative(arrys);

    }

    /**
     * 升序排序，正向比较
     * @param arry
     */
    public static void bubbleSortAscPositive (Integer[] arry){
        //1、初始值为真
        //2、循环不变值
        //3、终止条件
        /////比较轮数是 arry.length 此，每一次比较得到最大值，排在最后；且每一次比较减少一个比较的数
        for (int i=arry.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(arry[j]>arry[j+1]){
                    int temp = arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                }
            }
        }
    }


    /**
     * 降序排序，正向比较
     * @param arry
     */
    public static void bubbleSortDescPositive (Integer[] arry){
        //1、初始值为真
        //2、循环不变值
        //3、终止条件
        /////比较轮数是 arry.length 此，每一次比较得到最大值，排在最后；且每一次比较减少一个比较的数
        for (int i=arry.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(arry[j]<arry[j+1]){
                    int temp = arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                }
            }
        }
    }


    /**
     * 升序排序，反向比较
     * @param arry
     */
    public static void bubbleSortAscNegative (Integer[] arry){
        //1、初始值为真
        //2、循环不变值   外循环 次数不变
        //3、终止条件
        /////比较轮数是 arry.length 此，每一次比较得到最大值，排在最后；且每一次比较减少一个比较的数
        for (int i=arry.length-1;i>0;i--){
            for (int j=i;j>0;j--){
                if(arry[j-1]>arry[j]){
                    int temp = arry[j];
                    arry[j]=arry[j-1];
                    arry[j]=temp;
                }
            }
        }
    }

    /**
     * 降序排序，反向比较
     * @param arry
     */
    public static void bubbleSortDescNegative (Integer[] arry){
        //1、初始值为真
        //2、循环不变值   外循环 次数不变
        //3、终止条件
        /////比较轮数是 arry.length 此，每一次比较得到最大值，排在最后；且每一次比较减少一个比较的数
        for (int i=arry.length-1;i>0;i--){
            for (int j=i;j>0;j--){
                if(arry[j-1]<arry[j]){
                    int temp = arry[j];
                    arry[j]=arry[j-1];
                    arry[j]=temp;
                }
            }
        }
    }


    //////////////////////////////////////////////////////////////////////////
    //方向正序排序
    public static void bubbleSortWileDescNegative (Integer[] arry){
        //1、初始值为真
        //2、循环不变值   外循环 次数不变
        //3、终止条件
        /////比较轮数是 arry.length 此，每一次比较得到最大值，排在最后；且每一次比较减少一个比较的数
        for (int i=arry.length-1;i>0;i--){
            int j=i;
            int temp=0;
            while (arry[j-1]<arry[j] && j>0){
                temp = arry[j-1];
                arry[j-1]=arry[j];
                arry[j]=temp;
                
            }
        }
    }

}
