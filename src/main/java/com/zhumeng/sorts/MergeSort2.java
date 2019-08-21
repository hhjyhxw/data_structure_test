package com.zhumeng.sorts;

public class MergeSort2 {


    public static void main(String args[]){
        Integer[] test = {9,2,6,3,5,7,10,11,12};
        mergeSort(test,0,test.length-1);
        for(int i=0; i<test.length;i++){
            System.out.print(test[i] + " ");
        }
    }

    public static Integer[] mergeSort(Integer[] arry,int left,int right){
       //初始判断
        if(arry==null || arry.length<2){
            return arry;
        }
        //拆分子序列
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arry,left,mid);//左边归并排序，使得左子序列有序
            mergeSort(arry,mid+1,right);//右边归并排序，使得右子序列有序
            merge(arry,left,mid,right);//合并两个子序列
        }

        return null;
    }

    //考虑终极拆分情况，每个子数组只剩下两个元素，且排好序
    public static void merge(Integer[] arr,int left,int mid,int right){
        int[] temp = new int[right - left + 1];//ps：也可以从开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存
        int i = left;
        int j = mid+1;
        int k = 0;

        //比较两个数组中哪个值最小，放到临时数组
        while(i<=mid && j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }

        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }
}
