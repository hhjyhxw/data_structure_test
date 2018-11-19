package com.zhumeng.hash;

import java.util.HashMap;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 * hash 冲突解决方式 ：开放地址法,链地址法
 * 开发地址法：
 *      1、线性探测（容易产生聚集，降低哈希表性能  ），hash函数计算的原始下标是X,线性探测就是x+1,x+2,x+3......
 *      2、二次探测(容易产生二次聚集) hash函数计算的原始下标是X,二次探测是 x+1,x+2^2,x+3^2,即是线性探测的平方
 *      3、再hash，再次探测 使用的步长 与key有关，不再是有序探测
 */
public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;//

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable(){
        for (int i = 0; i <arraySize ; i++) {
            if(hashArray[i]!=null){
                System.out.println(hashArray[i].getKey());
            }else
                System.out.println("** ");
        }
    }

    public int hash(int key){
        return key%arraySize;
    }

    public int hash2(int key){
        return 5-key%5;
    }

    /**
     * 开放地址法--线性探测
     * @param item
     */
    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hash(key);
        while (hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){
            hashVal++;
            hashVal%=arraySize;
        }
        hashArray[hashVal]=item;
    }

    public void insert2(DataItem item){
        int key = item.getKey();
        int hashVal = hash(key);
        int stepSize = hash2(key);
        while (hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){
            hashVal+=stepSize;
            hashVal%=arraySize;
        }
        hashArray[hashVal]=item;
    }


    private DataItem delete(int key){
        int hashval = hash(key);
        while (hashArray[hashval]!=null){
            if(hashArray[hashval].getKey()==key){
                return hashArray[hashval];
            }
            ++hashval;
            hashval%=arraySize;
        }
        HashMap map = null;
        return null;
    }
}
