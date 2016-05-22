package leetcode.array;

/**
 * FindMinimum
 *
 * @author xiaozl
 * @date: 2016/5/19
 */
public class FindMinimum {

    public static void main(String[] args) {
        int [] nums = {6,6,6,6,6,6,6,0,1,2,3,4,5};
        int [] nums1 = {10,1,10,10,10};
        System.out.println(finMinInRotatedArrayII(nums1));
        binarySearch(nums,4);
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

       (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

       Find the minimum element.

       You may assume no duplicate exists in the array.
     思路：
     1.用二分查找的思想查找最小值
     2.关键在于怎么确定查找的时候的分支条件
     * @param nums
     * @return
     */
    public static int finMinInRotatedArray(int [] nums){
        int size = nums.length;
        if (size == 0){
            return 0;
        } else if (size == 1){
            return nums[0];
        } else if (size == 2){
            return Math.min(nums[0],nums[1]);
        }

        int low = 0;
        int high = size-1;

        while (low < high-1){
            if (nums[low] < nums[high]){
                return nums[low];
            }
            int mid = (high + low) / 2;
            // 这里是问题关键
            if (nums[mid] > nums[low]){
                low = mid;
            } else {
                high = mid;
            }
        }
        // 因为while中的条件是low < high-1
        return Math.min(nums[low], nums[high]);
    }

    public static int binarySearch(int [] nums, int elem){
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] == elem){
                return mid;
            }
            if (nums[mid]<elem){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    /**
     * 这个题目的难点在于有重复元素：在遇到重复元素时我们选择的处理方法是start++，而不是start = mid，因为这样会漏掉元素
     * @param nums
     * @return
     */
    public static int finMinInRotatedArrayII(int [] nums){
        int size = nums.length;
        if (size == 0){
            return 0;
        } else if (size == 1){
            return nums[0];
        } else if (size == 2){
            return Math.min(nums[0],nums[1]);
        }

        int low = 0;
        int high = size-1;

        while (low < high-1){
            if (nums[low] < nums[high]){
                return nums[low];
            }
            int mid = (high + low) / 2;
            // 这里是问题关键
            if (nums[mid] > nums[low]){
                low = mid;
            } else if (nums[mid]<nums[low]){
                high = mid;
            } else {
                low++;
            }
        }
        // 因为while中的条件是low < high-1
        return Math.min(nums[low], nums[high]);
    }

}
