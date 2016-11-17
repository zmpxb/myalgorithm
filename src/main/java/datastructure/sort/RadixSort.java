package datastructure.sort;

import java.util.Arrays;

/**
 * Created by xiaozl on 2016/9/21.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] data = new int[] { 1100, 192, 221, 12, 23 };
        radixSort(data, 10, 4);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(data));
    }

    /**
     *
     * @param data 待排元素集合
     * @param radix 排序元素进制
     * @param d 最大数据的位数
     */
    public static void radixSort(int [] data,int radix,int d){
        int [] tmp = new int [data.length];
        int [] location = new int[radix];
        int key;
        for (int i = 0,rate = 1;i < d;i++){
            Arrays.fill(location,0);
            System.arraycopy(data,0,tmp,0,data.length);
            // 遍历待排元素进行分组
            for (int j = 0; j < data.length; j++) {
                key = (tmp[j] / rate) % radix;
                location[key]++;
            }

            // 记录每个元素的位置
            for (int j = 1; j < radix; j++) {
                location[j] = location[j] + location[j-1];
            }

            //这里必须倒着来
            for (int j = data.length-1; j > 0; j--) {
                // 之所以要倒着来每个位置的元素我们放的时候是倒着放的
                data[--location[(tmp[j]/rate)%radix]] = tmp[j];
            }
            rate = rate * radix;
        }

    }
}
