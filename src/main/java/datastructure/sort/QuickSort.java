package datastructure.sort;

/**
 * Created by xiaozl on 2016/9/19.
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] array = {10,10,8,8,6,5,4,3,3,1};
          quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int [] array,int low,int high){
        if (low < high){
            int l = low;
            int h = high;

            int tmp = array[low];
            while (low < high){
                // 注意在数组中有相同元素必须用array[high] >= tmp 不能用array[high] > tmp
                while (low < high && array[high] >= tmp){
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] < tmp){
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = tmp;
            quickSort(array,l,low - 1);
            quickSort(array,low+1,h);
        }
    }
}
