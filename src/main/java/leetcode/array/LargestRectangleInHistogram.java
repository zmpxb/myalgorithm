package leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * LargestRectangleInHistogram
 *
 * @author xiaozl
 * @date: 2016/5/22
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
          //int [] nums = {0,9};
         int [] nums = {3,3,1,3};
        getLargestArea2(nums);
    }

    public static int getLargestArea(int [] heights){
        if (heights.length==0){
            return 0;
        }else {
            Arrays.sort(heights);
            int max = heights[0] * heights.length;
            for (int i = 1; i < heights.length; i++) {
                if (heights[i] * (heights.length - i) > max) {
                    max = heights[i] * (heights.length - i);
                }
            }
            return max;
        }
    }
    public static int getLargestArea1(int [] heights){
        if (heights.length==0){
            return 0;
        }
        if (heights.length==1){
            return heights[0];
        }
        int j = 0,k = 0,m = 0,q = 0;
        boolean flag = true;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i]!=0 && flag==true){
                j = i;
                flag = false;
            }
            if (flag==false || i==heights.length-1){
                if (heights[i]==0) {
                    k = i - 1;
                    Arrays.sort(heights, j, k);
                    for (int n = j; n <= k; n++) {
                        if (heights[n] * (k - n + 1) > max) {
                            max = heights[n] * (k - n + 1);
                        }
                    }
                    flag = true;
                } else {
                    k = i;
                    Arrays.sort(heights, j, k);
                    for (int n = j; n <= k; n++) {
                        if (heights[n] * (k - n + 1) > max) {
                            max = heights[n] * (k - n + 1);
                        }
                    }
                    flag = true;
                }
            }
            if (heights[i]!=0){
                q++;
            }
            if (q == heights.length){
                Arrays.sort(heights);
                max = heights[0] * heights.length;
                for (int p = 1; p < heights.length; p++) {
                    if (heights[p] * (heights.length - p) > max) {
                        max = heights[p] * (heights.length - p);
                    }
                }
                return max;
            }
        }
        return max;

    }

    /**
     * 正解
     *
     * Given n non-negative integers representing the histogram's bar height where the width of each bar
     is 1, find the area of largest rectangle in the histogram.
     Largest Rectangle in Histogram
     Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]
     The largest rectangle is shown in the shaded area, which has area = 10 unit.
     For example, Given height = [2,1,5,6,2,3], return 10.

     这道题目算是比较难得一道题目了， 首先最简单的做法就是对于任意一个bar， 向左向右遍历， 直到高度小
     于该bar， 这时候计算该区域的矩形区域面积。 对于每一个bar， 我们都做如上处理， 最后就可以得到最大
     值了。 当然这种做法是O(n2)， 铁定过不了大数据集合测试的。
     从上面我们直到， 对于任意一个bar n， 我们得到的包含该bar n的矩形区域里面bar n是最小的。 我们使用ln
     和rn来表示bar n向左以及向右第一个小于bar n的bar的索引位置。
     譬如题目中的bar 2的高度为5， 它的ln为1， rn为4。 包含bar 2的矩形区域面积为(4 - 1 - 1) * 5 = 10。
     我们可以从左到右遍历所有bar， 并将其push到一个stack中， 如果当前bar的高度小于栈顶bar， 我们pop出
     栈顶的bar， 同时以该bar计算矩形面积。 那么我们如何知道该bar的ln和rn呢？rn铁定就是当前遍历到的bar
     的索引， 而ln则是当前的栈顶bar的索引， 因为此时栈顶bar的高度一定小于pop出来的bar的高度。
     为了更好的处理最后一个bar的情况， 我们在实际中会插入一个高度为0的bar， 这样就能pop出最后一个bar
     并计算了
     难点：
     1.数组中可能出现为0的元素，意为着栅栏会被分割
     2.数组中的元素顺序不允许改变，不能进行排序处理
     3.最后特殊情况要考虑清楚第一个位置最后一个位置
     4.求解的过程中一般到普遍
     *
     * @param heights
     * @return
     */
    public static int getLargestArea2(int [] heights) {
        // 预处理
        heights = Arrays.copyOf(heights,heights.length+1);
        // 增加一位作为结束标记
        heights[heights.length-1] = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int sum = 0;
        while (i < heights.length){
            if (stack.empty() || heights[i]>heights[stack.peek()]){
                stack.push(i);
                i++;
            } else {
                int t = stack.peek();
                stack.pop();
                sum = Math.max(sum,heights[t]*(stack.empty()?i:i-stack.peek()-1));
            }
        }
        return sum;
    }
}
