package leetcode.bithandle;

/**
 * Created by xiaozl on 2016/6/6.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int [] nums = {0,1,2,3,4,5,7,8,9};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int x =0;
        for (int i = 0; i <= nums.length; i++) {
            x = x^i;
        }
        for (int i = 0; i < nums.length; i++) {
            x = x^nums[i];
        }
        return x;
    }

}
