package leetcode.array;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;

/**
 * ThreeSum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 问题解析：
 1. 每个答案组里面的三个数字是要从大到小排列起来的。
 2. 每个答案不可以和其他的答案相同

 思路：
 1. 根据第一点要求： 因为要求每个答案数组中的元素是升序排列的， 所以在开头我们要对数组进行排
 序。
 2. 根据第二点要求： 因为不能包含重复的答案数组， 所以我们要在代码里面做一切去掉重复的操作， 对
 于数组， 这样的操作是相同的。 最开始我做leetcode的时候是把所有满足条件的答案数组存起来， 之后
 再用map进行处理， 感觉那样太麻烦了， 所以这次给出的答案是不需要额外空间的。
 时间复杂度分析：
 对于这道题， 因为是要找三个元素， 所以怎样都要O(n2)的时间复杂度， 目前我没有想出来O(n)时间复杂度
 的解法。
 归根结底， 其实这是two pointers的想法， 定位其中两个指针， 根据和的大小来移动另外一个。 解题中所要
 注意的就是一些细节问题。 好了， 上代码吧。

 评价：问题巧妙的地方就是在于去重，本题先对问题数组进行排序(很重要)，使得元素重复率降低，同时使用两个while过滤重复元素。

 * @author xiaozl
 * @date: 2016/5/16
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int [] nums = {-1,0,1,2,-1,-4};
        int [] nums = {-12,12,-5,-4,-12,11,9,-11,13,1,12,-1,8,1,-9,-11,-13,-4,10,-9,-6,-11,1,-15,-3,4,0,-15,3,6,-4,7,3,-2,10,-2,-6,4,2,-7,12,-1,7,6,7,6,2,10,-13,-3,8,-12,2,-5,-12,6,6,-5,6,-5,-14,9,9,-4,-8,4,2,-7,-15,-11,-7,12,-4,8,-5,-12,-1,12,5,1,-5,-1,5,12,9,0,3,0,3,-14,2,-4,2,-4,0,1,7,-13,9,-1,13,-12,-11,-6,11,-1,-10,-5,-3,10,3,7,-6,-15,-4,10,1,14,-12};
        int [] nums1 = {0,0,0};
        int [] s = {-2,0,0,3,3,-1};
        fourSum(s,5);
        threeSumCloset(nums1,1);
    }

    /**
     * 这种解法会产生重复结果，虽然后来处理了，但是会开辟额外空间，且时间赋复杂度较高。
     * 这种解法的思路是先用辅助数组，存储tartget - num[i],然后找两数之和为target的值。最后去重。利用了2sum的结论
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int [] assist = new int[nums.length];
        for (int i = 0; i < assist.length; i++) {
            assist[i] = 0 - nums[i];
        }

        HashMap<Integer , Integer> myMap = new HashMap<Integer, Integer>();
        for(int j = 0; j < nums.length; ++j) {
            // 这里在赋值的时候时间相同的如果数组元素中有重复元素，那么mymap中只会存储，index比较的大那个值的索引
            myMap.put(nums[j],j);
        }

        for (int i = 0; i < assist.length; i++) {
            for(int k = 0; k < nums.length; ++k) {
                int rest_val = assist[i] - nums[k];
                // containKey()函数的时间复杂度是O(1)
                if(myMap.containsKey(rest_val)) {
                    int index = myMap.get(rest_val);
                    if(index == k || i == index || i == k)
                        continue; //如果是同一个数字， 我们就pass， 是不会取这个值的
                    if (i!=k && i!=index){
                        List<Integer> ret = new ArrayList<Integer>(3);
                        ret.add(nums[i]);
                        ret.add(nums[index]);
                        ret.add(nums[k]);
                        Collections.sort(ret);
                        result.add(ret);
                    }
                }
            }

        }
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        sets.addAll(result);
        result.clear();
        result.addAll(sets);
        return result;

    }

    public static List<List<Integer>> threeSum1(int [] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;
            // while循环里面的条件有效的防止了数组越界，同时限定了加数的范围
            while (j<k){
                List<Integer> curr = new ArrayList<Integer>(3);
                if (nums[i]+nums[j]+nums[k] == 0){
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    Collections.sort(curr);
                    result.add(curr);
                    j++;
                    --k;
                    //去掉重复值
                    while (j<k && nums[j-1] == nums[j]){
                        j++;
                    }
                    //去掉重复值
                    while (j<k && nums[k] == nums[k+1]){
                        k--;
                    }
                } else if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                } else {
                    k--;
                }
                // 这里之所以是i<nums.length-1 防止 nums[i+1]越界
                while (i<nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }

            }
        }
        return result;
    }

    /**
     * 问题：求数组中3个数之和（sum)最靠近target的sum
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

       For example, given array S = {-1 2 1 -4}, and target = 1.

       The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
       Subscribe to see which companies asked this question

     思路：利用用threeSum1的解法。
     1.当距离等于0时直接返回target
     2.利用java Integer的最大最小值Integer.MAX_VALUE;Integer.MIN_VALUE;在求解过程中不断的存储距离最小值。
     3.主要考察数组多个游标得使用和进行计算时对数组预处理（排序）
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumCloset(int [] nums,int target){
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while (j<k){
                List<Integer> curr = new ArrayList<Integer>(3);
                if (nums[i]+nums[j]+nums[k]-target == 0){
                      return target;
                } else if (nums[i]+nums[j]+nums[k]-target< 0){
                    if (nums[i]+nums[j]+nums[k]-target>min){
                        min = nums[i]+nums[j]+nums[k]-target;

                    }
                    j++;
                } else {
                    if (nums[i]+nums[j]+nums[k]-target<max){
                        max = nums[i]+nums[j]+nums[k]-target;
                    }
                    k--;
                }
                while (i<nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        if (min != Integer.MIN_VALUE && Math.abs(min)<max){
            return target + min;
        } else {
            return target + max;
        }
    }

    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

     Note:
     Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     The solution set must not contain duplicate quadruplets.
     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

     A solution set is:
     (-1,  0, 0, 1)
     (-2, -1, 1, 2)
     (-2,  0, 0, 2)
     思路：1.利用3Sum的结论，注意超时（条件判断，continue减少越界），越界
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int [] nums, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            // 我的代码用了while时间，使用while的时候在极端的情况下，{-1，-1，-1，-1，-1，1,0,2}，
            // while语句块中的代码会执行nums.length - 3次，增加了时间复杂度
            // 这里使用if+continue，减少了这些执行
//            while (i<nums.length-1 && nums[i]==nums[i+1]){
//                i++;
//            }
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int m = j + 1;
                int k = nums.length - 1;
                while (m<k){
                    List<Integer> curr = new ArrayList<Integer>(4);
                    if (nums[i]+nums[j]+nums[m]+nums[k] == target){
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[m]);
                        curr.add(nums[k]);
                        Collections.sort(curr);
                        result.add(curr);
                        m++;
                        k--;
                        while (m<k && nums[m-1]==nums[m]){
                            m++;
                        }
                        while (m<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                    if (m<k && nums[i]+nums[j]+nums[m]+nums[k] < target){
                        m++;
                    }
                    if (m<k && nums[i]+nums[j]+nums[m]+nums[k] > target){
                        k--;
                    }
                }
            }
        }
        return result;
    }

}
