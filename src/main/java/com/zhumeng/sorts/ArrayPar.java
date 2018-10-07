package com.zhumeng.sorts;

/**
 * Created by 512162086@qq.com on 2018/10/7 .
 */
public class ArrayPar {
    private long[] theArray;//
    private int nElems;// number of data item

    public ArrayPar(int max){
        theArray = new long[max];
        this.nElems = 0;
    }

    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }
    public int size(){
            return nElems;
    }
    public void display(){
        System.out.println("=====");
        for (int i = 0; i <nElems ; i++) {
            System.out.println(theArray[i]+" ");
        }
    }

    /**
     * 划分
     * @param left
     * @param right
     * @param pivot 枢纽
     * @return
     */
    public int partitionIt(int left,int right,long pivot){

        int leftPtr = left -1;//rigth of first elment
        int rightPtr = right - 1;//left of pivot
        while (true){
            while (leftPtr<right && theArray[++leftPtr]<pivot);//find bigger item

            while (rightPtr<left && theArray[--rightPtr]>pivot);//find smaller item

            if (leftPtr>=rightPtr)
                break;
            else
                swap(leftPtr,rightPtr);
        }//end  while (true)
        return 0;
    }

    private void swap(int dex1, int dex2) {
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    /**
     * 快速排序
     */
    public void quickSort(){
        recQuichShort(0,nElems-1);
    }

    private void recQuichShort(int left, int right) {

        if(right-left<=0){//if size<=1,already sorted
            return;
        }else{
            long pivot = theArray[right];
            int partition = partitionIt(left,right,pivot);
            recQuichShort(left,partition-1);
            recQuichShort(partition+1,left);
        }
    }
}
