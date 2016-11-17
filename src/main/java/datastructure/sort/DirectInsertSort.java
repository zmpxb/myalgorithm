package datastructure.sort;

/**
 * 直接插入排序：
 * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 插入排序方法分直接插入排序和折半插入排序两种，这里只介绍直接插入排序，折半插入排序留到“查找”内容中进行。
 * Created by xiaozl on 2016/9/18.
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1};
        array = directInsertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int [] directInsertSort(int [] array){
        int n = array.length;
        int tmp;
        int now;
        int j;
        for (int i = 1; i < n; i++) {
            for (j = i - 1 ; j >= 0 ; j--){
                if (array[i] > array[j]){
                    break;
                }
            }
            now = array[i];
            for (int k = i-1; k > j; k--) {
                array[k + 1] = array[k];
            }
            array[j + 1] = now;
        }
        return array;
    }

}
