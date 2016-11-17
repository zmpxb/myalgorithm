package leetcode.tree;

import datastructure.tree.TreeNode;

/**
 * 求根到叶子结点路径上所有数的和是否等于sum
 * Created by xiaozl on 2016/9/26.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;

        }
        return DFS(sum,0,root);
    }

    public boolean DFS(int target,int sum,TreeNode root){
        if (root == null){
            return false;
        }
        sum = sum + root.getValue();
        if (root.getLeft() == null
                && root.getRight() == null){
            if (sum == target){
                return true;
            }
        } else {
            return false;
        }
        boolean leftPart = DFS(target,sum,root.getLeft());
        boolean rightPart = DFS(target,sum ,root.getRight());
        return leftPart || rightPart;
    }


}
