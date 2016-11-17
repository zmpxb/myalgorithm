package leetcode.tree;


import javatest.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozl on 2016/10/14.
 */
public class GetAllBinarySearchTree {

    public static void main(String[] args) {
        GetAllBinarySearchTree x = new GetAllBinarySearchTree();
        x.generateTrees(3);
        System.out.println();
    }

    List<TreeNode> generateTrees(int n){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(n==0){
            return list;
        }
        build(list,1,n);
        return list;
    }

    public void build(List<TreeNode> list,int nStart,int nEnd){
        if (nStart > nEnd){
            list.add(null);
        } else {
            for (int i = nStart;i<=nEnd;++i){
                List<TreeNode> left = new ArrayList<TreeNode>();
                build(left,nStart,i-1);
                List<TreeNode> right = new ArrayList<TreeNode>();
                build(right,i+1,nEnd);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        list.add(root);
                    }
                }
            }
        }
    }

}


