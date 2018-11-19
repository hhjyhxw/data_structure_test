package com.zhumeng.hash;

/**
 * Created by 512162086@qq.com on 2018/10/8 .
 */
public class DataItem {
    private int iData;

    public DataItem(int iData){
        this.iData = iData;
    }

    public int getKey(){
        return iData;
    }
}
