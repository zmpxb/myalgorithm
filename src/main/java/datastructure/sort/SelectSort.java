package datastructure.sort;

/**
 * 选择排序
 * Created by xiaozl on 2016/9/18.
 */
public class SelectSort {

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1};
        array = selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int [] selectSort(int [] array){
        int n = array.length;
        int mid;
        int index;
        int tmp;
        for (int i = 0; i < n-1; i++) {
            mid = array[i];
            index = i;
            for (int j = i+1; j < n; j++) {
                if (mid > array[j]){
                    mid = array[j];
                    index = j;
                }
            }
            if (i != index) {
                tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }
        return array;
    }

}
