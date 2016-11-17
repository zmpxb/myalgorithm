package datastructure.sort;

/**
 * 最好的情况下，就是正序，所以只要比较一次就行了，复杂度O(n)，执行一次后发现数据没有交换，则为n次比较
 最坏的情况下，就是逆序，要比较n^2次才行，复杂度O(n^2)
 总结：稳定的排序方法，时间复杂度O(n^2)，空间复杂度O(1)，当待排序列有序时，效果比较好。
 做这种题一定要先模拟算法执行过程，然后再编程
 * Created by xiaozl on 2016/9/18.
 */
public class BubbleSort {

    public static void main(String[] args) {

        int [] array = {10,9,8,7,6,5,4,3,2,1};
        array = bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 从后面往前排，把小数往前冒泡
     * @param array
     * @return
     */
    public static int [] bubbleSort(int [] array){

        int n = array.length;
        int temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = n-1; j > i; j--) {
                if (array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 从前往后冒泡，大数往后冒泡
     * @param array
     */
    public static void bubbleSort1(int [] array){
        int tmp;
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length-1-i ; j++) {
                if (array[j]>array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
