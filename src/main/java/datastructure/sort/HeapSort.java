package datastructure.sort;

/**
 * Created by xiaozl on 2016/9/19.
 */
public class HeapSort {

    public static void main(String[] args) {
        try {
            int [] array = {10,10,8,7,6,5,4,3,2,1};
            int [] goal = new int[11];
            System.arraycopy(array,0,goal,1,10);
            heapSort(goal);
            for (int i = 1; i < goal.length; i++) {
                System.out.println(goal[i]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 堆排序算法
     * @param array
     */
    public static void heapSort(int [] array){
        int n = array.length;
        int tmp;
        for (int i = 1; i < array.length; i++) {
            ajustMaxHeap(array,n-1);
            tmp = array[array.length-i];
            array[array.length-i] = array[1];
            array[1] = tmp;
            n--;
        }
    }

    /**
     * 大顶堆
     * @param array
     * @param length
     */
    public  static void ajustMaxHeap(int [] array,int length){
        int father = length / 2;
        int tmp;
        int maxIndex;
        while (father > 0){
            if (father * 2 < length){
                // 当父亲节点有右孩子时
                if (array[father*2] > array[father*2 + 1]){
                    maxIndex = father*2;
                } else {
                    maxIndex = father*2+1;
                }
            } else {
                // 当父节点只有左孩子时
                if (array[father*2] > array[father]){
                    maxIndex = father*2;
                } else {
                    maxIndex = father;
                }
            }
            if (array[maxIndex]>array[father]){
                tmp = array[father];
                array[father] = array[maxIndex];
                array[maxIndex] = tmp;
            }
            father--;
        }
    }

}
