package leetcode.tree;

/**
 * Created by xiaozl on 2016/9/29.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length);
    }

    public TreeNode build(int [] nums,int start,int end){
        if (start == end){
            return null;
        }
        int mid = (start + end -1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums,start,mid);
        node.right = build(nums,mid+1,end);
        return node;
    }


}




