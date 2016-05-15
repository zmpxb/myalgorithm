package leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * MergeSortedArray
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note: You may assume that A has enough space (size that is greater or equal to m + n) to hold
 additional elements from B. The number of elements initialized in A and B are m and n respectively

 A和B都已经是排好序的数组， 我们只需要从后往前比较就可以了。
 因为A有足够的空间容纳A + B， 我们使用游标i指向m + n - 1， 也就是最大数值存放的地方， 从后往前遍历
 A， B， 谁大就放到i这里， 同时递减i。
 难点：
 1.该问题假设A数组已经有足够大的空间，在操作数组元素的时，注意越界的问题。
 2.在将B中的元素合并到A中的时候注意元素覆盖的问题。所以我们选择从A的最后一元素开始合并
 *
 * @author xiaozl
 * @date: 2016/5/10
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int [] a = {1,2,2,3,4,4,5,8,10,0,0,0,0,0,0};
        int [] b = {3,4,4,6,7,8};
        mergeSortedArray2(a,9,b,b.length);
    }

    /**
     * 该函数是假设nums1空间不够的情况下，先对nums1的空间进行扩充，再进行合并。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n){
        int [] mergedArray = Arrays.copyOf(nums1,m+n);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                mergedArray[k] = nums1[i];
                i++;
            }else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i<m){
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while (j<n){
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(mergedArray));
    }

    /**
     *
     * @param nums1
     * @param m 指的是数组nums1中参与合并的元素的个数
     * @param nums2
     * @param n 指的是数组nums2中参与合并的元素的个数，这里是将nums2数组合并到nums1中，这样的话n=nums2.length
     */
    public static void mergeSortedArray1(int[] nums1, int m, int[] nums2, int n){
        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        while(i >= 0) {
            if(j >= 0 && k >= 0) {
                if(nums1[j] > nums2[k]) {
                    nums1[i] = nums1[j];
                    j--;
                } else {
                    nums1[i] = nums2[k];
                    k--;
                }
            } else if(j >= 0) {
                nums1[i] = nums1[j];
                j--;
            } else if(k >= 0) {
                nums1[i] = nums1[k];
                k--;
            }
            i--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeSortedArray2(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j]))
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }

}
