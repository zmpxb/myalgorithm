package leetcode.array;

/**
 * Created by xiaozl on 2016/5/29.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int [] nums = {1,2};
        System.out.println(findPeakElement(nums));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] == target){
                System.out.println(mid);
                return mid;
            }
            if (nums[mid]<target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (nums[mid]>target){
            if (mid == 0){
                return mid;
            } else {
                return mid-1;
            }
        }else {
                return mid+1;
        }

    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1){
            return 0;
        }
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (low <= high){
            mid = (low + high)/2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                    (mid == n - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid>0 && nums[mid-1] > nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

//
//    [1,3,5,6], 5 → 2
//            [1,3,5,6], 2 → 1
//            [1,3,5,6], 7 → 4
//            [1,3,5,6], 0 → 0


}
