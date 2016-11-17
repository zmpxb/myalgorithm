package datastructure.sort;

/**
 * Created by xiaozl on 2016/9/19.
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1};
         mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void merge(int [] array,int low,int mid,int high){
        int i = low,j = mid + 1,p = 0;
        //构造了新的数据
        int [] r = new int [high - low + 1];
        while (i<=mid&&j<=high){
            r[p++] = (array[i]<=array[j])?array[i++]:array[j++];
        }
        while (i<=mid){
            r[p++] = array[i++];
        }
        while (j<=high){
            r[p++] = array[j++];
        }
        //从low到high赋值，把r数组中的值再复制会array中
        for (p = 0,i=low;i<=high;p++,i++){
            array[i] = r[p];
        }
    }

    public static void mergeSort(int [] array,int low,int high){
        if (low<high){
            int mid = (low+high)/2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }


}

