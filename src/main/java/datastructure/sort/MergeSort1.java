package datastructure.sort;

/**
 * Created by xiaozl on 2016/9/20.
 */
public class MergeSort1 {

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1};
        mergeSort1(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int [] a,int low,int mid,int high){
        //i是有序数组x的起点，mid是终点。j是有序数组y的起点，high是终点，p是合并后新数组的起点，终点为p+high-low
        int i = low,j = mid + 1,p = 0;
        int [] r = new int[high - low + 1];

        while (i<=mid && j<=high){
            r[p++] = (a[i]<a[j])?a[i++]:a[j++];
        }

        while (i<=mid){
            r[p++] = a[i++];
        }

        while (j<=high){
            r[p++] = a[j++];
        }

        for (p = 0,i = low;i<=high;i++,p++){
            a[i] = r[p];
        }
    }

    /**
     * 二路归并排序
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSort1(int[] array, int low, int high) {
        if (low < high){
            int mid = (low+high)/2;
            mergeSort1(array,low,mid);
            mergeSort1(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }
}
