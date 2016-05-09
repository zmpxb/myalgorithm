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
        要得到一个帕斯卡三角， 我们只需要找到规律即可。
        第k层有k个元素
        每层第一个以及最后一个元素值为1
        对于第k（ k > 2） 层第n（ n > 1 && n < k） 个元素A[k][n]， A[k][n] = A[k-1][n-1] + A[k-1][n]

        2.我们用集合来存储数组元素
*/
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        // List类型是一个抽象数据类型（abstract）不能new ，所以只能用以下的方式构造
        // 不能用List<List<Integer>> triangle = new List<List<Integer>>();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
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
                List<Integer> preList = triangle.get(i - 1);
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
}
