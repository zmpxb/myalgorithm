package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * PascalTriangle
 *
 * @author xiaozl
 * @date: 2016/5/9
 */
/**
问题：
        Given numRows, generate the first numRows of Pascal's triangle.

        For example, given numRows = 5,
        Return

        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]
        Subscribe to see which companies asked this question

        思路：
        1.观察规律。
        规律1：
        要得到一个帕斯卡三角， 我们只需要找到规律即可。
        第k层有k个元素
        每层第一个以及最后一个元素值为1
        对于第k（ k > 2） 层第n（ n > 1 && n < k） 个元素A[k][n]， A[k][n] = A[k-1][n-1] + A[k-1][n]
        规律2：每个元素对称位置上的元素值是相等的，这个规律对我们求解 PascalTriangle II 很有帮助
        2.我们用集合来存储数组元素
        3.关键在于如何对n-1数组进行遍历“求和”，计算出n数组每个位置的元素值
*/
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        generate(5);
        getRow1(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        // List类型是一个抽象数据类型（abstract）不能new ，所以只能用以下的方式构造
        // 不能用List<List<Integer>> triangle = new List<List<Integer>>();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0){
                //在已知集合大小的时候最好对集合大小进行指定
                ArrayList<Integer> list = new ArrayList<Integer>(1);
                list.add(1);
                triangle.add(list);
            }else if (i == 1){
                ArrayList<Integer> list = new ArrayList<Integer>(2);
                list.add(1);
                list.add(1);
                triangle.add(list);
            }
            if (i > 1) {
                List<Integer> preList = triangle.get(i - 1);
                ArrayList<Integer> list = new ArrayList<Integer>(i+1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        list.add(preList.get(j - 1) + preList.get(j));
                    }
                }
                triangle.add(list);
            }
        }
        return triangle;
    }

    public ArrayList<ArrayList<Integer>> generate1(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                triangle.add(list);
            }else if (i == 1){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(1);
                triangle.add(list);
            }
            if (i > 1) {
                ArrayList<Integer> preList = triangle.get(i - 1);
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        list.add(preList.get(j - 1) + preList.get(j));
                    }
                }
                triangle.add(list);
            }
        }
        return triangle;
    }

    /**
     * 问题：Pascal's Triangle II
     * Given an index k, return the kth row of the Pascal's triangle.
       For example, given k = 3, Return [1,3,3,1].
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        if (rowIndex == 0) {
            // [1]
            list.add(1);
        } else if (rowIndex == 1) {
            // [1,1]
            list.add(1);
            list.add(1);
        } else {
            // [1,1]
            list.add(1);
            list.add(1);
            int temp = 0;
            int preTemp = 0;
            int k = 0;
            for (int i = 1; i < rowIndex; i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.size() == 2) {
                        // 仅用于[1,1]---->[1,2],跳出循环后再[1,2]后面添加元素1，结果为[1,2,1]
                        list.set(j + 1, list.get(j) + list.get(j + 1));
                    } else {
                        // 这里关键在于用preTemp和变量temp存储被覆盖后的值。
                        if (k < 1) {
                            preTemp = list.get(j);
                            temp = list.get(j + 1);
                            list.set(j + 1, preTemp + temp);
                            k++;
                        } else {
                            preTemp = temp;
                            temp = list.get(j + 1);
                            list.set(j + 1, preTemp + temp);
                        }
                    }
                }
                list.add(1);
                k = 0;
            }
        }
        return list;
    }

    /**
     * 问题：Pascal's Triangle II
     * Given an index k, return the kth row of the Pascal's triangle.
       For example, given k = 3, Return [1,3,3,1].
       思路：
       1.我们能够使用的空间复杂度变成O(n)了所以增加了难度。
       2.在求解过程中我们会遇到元素值覆盖的问题
            解决办法：（1）新开辟空间来存储元素
                    （2）在原有空间上存储，或者是利用相同的值。本题就是运用了Pascal's triangle 的对称性，从而从后往前计算问题的结果
     * @param rowIndex
     * @return
     */
    public static int [] getRow1(int rowIndex) {
        int [] res = new int[rowIndex+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        for (int i = 0; i < rowIndex+1; i++) {
            for (int j = i-1; j >=1 ; j--) {
                res[j] = res[j] + res[j-1];
            }
        }
        return res;
    }
}
