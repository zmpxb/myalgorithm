package leetcode.array;

/**
 * SearchforRange
 *
 * @author xiaozl
 * @date: 2016/5/27
 */
public class SearchforRange {

    public static void main(String[] args) {
        int [] nums = {2,2};
        searchRange(nums,1);
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] result = {-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;;
        while (low <= high){
            if (nums[mid]>=target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        if (low >= nums.length || nums[low]!=target){
            return result;
        }
        result[0] = low;
        high = nums.length - 1;
        mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid]<=target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        result[1] = high;
        return result;
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

}
