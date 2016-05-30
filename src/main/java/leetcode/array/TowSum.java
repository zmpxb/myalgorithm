package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TowSum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 UPDATE (2016/2/13):
 The return format had been changed to zero-based indices. Please read the above updated description carefully.

 Subscribe to see which companies asked this question

 思路：其实问题考察的就是时间复杂度和空间复杂度的转换（从n*n 降低到n)
 1. 求出来的坐标值要按序排列。
 3. 这道题目假设是有且只有一组答案符合要求， 这样降低了我们解题的难度。
 4. 给定数组中可能有重复元素（如果题目中没有说明那就是包含特殊情况）
 5. 使用hashMap 降低时间复杂度。
 当算法的时间复杂度比较大的时候可以可以考虑hashmap来降低时间复杂度
 * @author xiaozl
 * @date: 2016/5/11
 */
public class TowSum {

    public static void main(String[] args) {
        int [] nums =  {2, 7, 11, 15};
        int [] test = {2,1,9,4,4,56,90,3};
        System.out.println(Arrays.toString(twoSum(test,8)));
//        int [] test1 = {2,2,2,2};
//        HashMap<Integer , Integer> myMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < test1.length; i++) {
//            myMap.put(test1[i],i);
//        }
//        for (int i = 0; i < test1.length; i++) {
//            System.out.println(myMap.get(test1[i]));
//        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] ret = new int[2];
        if(nums.length <= 1){
            return ret;
        }
        HashMap<Integer , Integer> myMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i) {
            // 这里在赋值的时候时间相同的如果数组元素中有重复元素，那么mymap中只会存储，index比较的大那个值的索引
            myMap.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; ++i) {
            // 对于每一个元素找被减数的值
            int rest_val = target - nums[i];
            // containKey()函数的时间复杂度是O(1)
            if(myMap.containsKey(rest_val)) {
                int index = myMap.get(rest_val);
                if(index == i)
                    continue; //如果是同一个数字， 我们就pass， 是不会取这个值的
                if(index < i){
                    ret[0] = index;
                    ret[1] = i;
                } else {
                        ret[1] = index;
                        ret[0] = i;
                    }
                }
            }
        return ret;
    }

}
