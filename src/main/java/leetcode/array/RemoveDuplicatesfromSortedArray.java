package leetcode.array;

import java.util.Arrays;

/**
 * RemoveDuplicatesfromSortedArray
 *
 * @author xiaozl
 * @date: 2016/5/8
 */

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int [] array = {1,2,3,3,4,5,7};
        System.out.println(removeDuplicates(array,array.length));
    }

    /**
     问题1：
     Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     思路：1.游标思想的应用：关键是抓住两个游标在相互移动的时候的关系和你要求的问题之间的联系
     2.首先我们需要知道， 对于一个排好序的数组来说， A[N + 1] >= A[N] ， 我们仍然使用两个游标i和j来处
     理， 假设现在i = j + 1， 如果A[i] == A[j]， 那么我们递增i， 直到A[i] != A[j]， 这时候我们再设置A[j + 1] =
     A[i]， 同时递增i和j， 重复上述过程直到遍历结束。
     注意：这个问题是去重不是删除指定的元素
     */
    public static int removeDuplicates(int [] array,int n){
        if (n == 0){
            return 0;
        }
        int i = 0;

        for (int j = 1; j < n; j++) {
            if (array[i] != array[j]){
                array[++i] = array[j];
            }
        }
        return i+1;
    }

    /**问题2：Remove Duplicates from Sorted Array II
    Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
    For example, Given sorted array A = [1,1,1,2,2,3],
    Your function should return length = 5, and A is now [1,1,2,2,3].

     思路：
     1.游标思想的应用，增加了一个计数器。当适当的增加辅助工具（计数器）可以帮我们解决问题）
     2.紧接着上一题， 同样是移除重复的元素， 但是可以允许最多两次重复元素存在。仍然是第一题的思路， 但是我们需要用一个计数器来记录重复的次数， 如果重复次数大于等于2， 我们会按
     照第一题的方式处理， 如果不是重复元素了， 我们将计数器清零。
    */
    public static int removeDuplicates(int [] array){
        if (array.length == 0){
            return 0;
        }
        int j = 0;
        int num = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i]==array[j]){
                num++;
                if (num < 2){
                    array[++j] = array[i];
                }
            } else {
                array[++j] = array[i];
                num = 0;
            }
        }
        return j+1;
    }
}
