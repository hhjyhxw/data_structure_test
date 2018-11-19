package com.zhumeng.hash;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 */
public class HashLinkTable {

    private SortedList[] hashArray;
    private int arraySize;

    public HashLinkTable(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i <arraySize ; i++) {
            hashArray[i] = new SortedList();
        }
    }

    /**
     * 哈希函数，目的是获取关键字值的范围，把关键字值转化为数组的下标
     * @param key
     * @return
     */
    public int hash(int key){
        return key%arraySize;
    }

    public void insert(Link theLink){
        int key = theLink.getKey();
        int hashVal = hash(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key){
        int hashVal = hash(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key){
        int hashVal = hash(key);
        return hashArray[hashVal].find(key);
    }
}
