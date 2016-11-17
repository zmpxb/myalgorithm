package leetcode.tanxin;

/**
 * Jump Game
 * Created by xiaozl on 2016/10/18.
 */
public class JumpGame {

    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};

    }

    /**
     * 跳的最大的层数不等于，一定要跳到x，在1位置可以跳两层，那么我可以跳一层也可以调两层
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 记录能够跳到的最大位置，每次跳跃都必须在最大位置（包括）之前起跳，再判断能够到达的最大位置
        int reach = 1; //最右能够到达的位置
        for (int i = 0; i < reach && reach < nums.length; i++) {
            reach = Math.max(reach,i+1+nums[i]);
        }
        return reach >= nums.length;
    }

    /**
     * Jump Game II
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     Your goal is to reach the last index in the minimum number of jumps.
     For example: Given array A = [2,3,1,1,4]
     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps
     to the last index.)
     主要判断对象为step（到底要跳多少步才能够到达最后的位置），我们step依次递增，
     我们从0开始判断，每次判断当前最小情况的可能性，然后，在改变条件递增步数
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // step 表示最小步数
        int step = 0;
        // [left,right]表示当前覆盖的区域。能够达到和起跳的位置
        int left = 0;
        int right = 0;
        if (nums.length == 1){
            return 0;
        }
        // 从最右边开始搜索，走一步、走两步、、走n步，当条件满足最小时停止
        while (left <= right){ // 每次尝试从每一层跳最远，如果能够到达结束跳跃返回值
            ++step;
            final int old_right = right;
            for (int i = left; i <= old_right; i++){
                int new_right = i + nums[i];
                if (new_right >= nums.length - 1) return step;
                if (new_right > right) right = new_right;
            }
            left = old_right + 1;
        }
        return 0;
    }
}
