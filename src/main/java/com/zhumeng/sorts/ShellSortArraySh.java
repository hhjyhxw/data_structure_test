package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/10/7 .
 * 希尔排序
 */
public class ShellSortArraySh {
    private long[] theArray;//
    private int nElems;// number of data item

    public ShellSortArraySh(int max){
        theArray = new long[max];
        this.nElems = 0;
    }

    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    public void display(){
        System.out.println("=====");
        for (int i = 0; i <nElems ; i++) {
            System.out.println(theArray[i]+" ");
        }
    }

    /**
     * 希尔排序
     */
    public void shellSort(){

        int inner,outer;
        long temp;

        int h=1;// find initial  value of h;初始化插入排序的标志位
        while (h<=nElems/3){
            h = h*3+1;
        }

        while (h>0){
            for (outer = h; outer<nElems ; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner>h-1 && theArray[inner-h]>=temp){
                    theArray[inner] = theArray[inner-h];
                    inner-=h;
                }
                theArray[inner] = temp;
            }//end for
            h = (h-1)/3;
        }//end  while (h>0)
    }//end shellSort()


    public static void main(String[] args){

        int maxSize = 10;
        ShellSortArraySh arr;
        arr = new ShellSortArraySh(maxSize);
        for (int i = 0; i <maxSize ; i++) {
            long n = (long) (Math.random()*99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        System.out.println("//////////////////////");
        arr.display();

    }
}
