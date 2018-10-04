package com.zhumeng.arry;

import java.util.Arrays;

/**
 * Created by 512162086@qq.com on 2018/9/30 .
 * 二分查找 示例
 */
public class BinarySearchTest {

    public static void main(String[] args){

        int[] array = {5,6,8,30,42,63,95,100};
        int[] arrays = {95,63,42,30,8,6,5};
        System.out.println(isExitsSearchBytow(array,8));
        System.out.println(isExitsSearchBytow(array,6));
        System.out.println(Arrays.binarySearch(array,63));

    }

    public static  int[] sortArray(int[] arry){

        return null;
    }

    /**
     * 二分查找
     * @param arry
     * @param key
     * @return
     */
    public static int isExitsSearchBytow(int[] arry,int key){
        int beginIndex = 0;
        int lastIndex = arry!=null?arry.length-1:0;

        while(true){
            int middleIndex = getDichotomia(lastIndex,beginIndex);
            if(arry[middleIndex]==key){
                return key;
            }else if(beginIndex>lastIndex){
                //当起始的角标大于 最大的角标，没找到匹配值，程序退出,返回-1
                return -1;
            }else{
                if(key<arry[middleIndex]){
                    //查找值小于当前中间值，把查找的最大角标改成 中间角标-1
                    lastIndex = middleIndex-1;
                }else{
                    //当查找的值大于中间值，把查找的起始的角标改成 中间值角标+1
                    beginIndex = middleIndex+1;
                }
            }
        }
    }

    /**
     * 二分查找 改良版
     * @param arry
     * @param key
     * @return
     */
    public static int isExitsSearchBytow2(int[] arry,int key){
        int beginIndex = 0;
        int lastIndex = arry!=null?arry.length-1:0;

        while(beginIndex<=lastIndex){
            int middleIndex = lastIndex+beginIndex>>>1;
            int midleVal = arry[middleIndex];
            if(midleVal<key){
                //当查找的值大于中间值，把查找的起始的角标改成 中间值角标+1
                beginIndex = middleIndex+1;
            }else if(midleVal>key){
                //查找值小于当前中间值，把查找的最大角标改成 中间角标-1
                lastIndex = middleIndex-1;
            }else{
                return midleVal;
            }
        }
        return -1;
    }


    public static int getDichotomia(int a,int b){
        return (a+b)/2;
    }
}
