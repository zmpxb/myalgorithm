package leetcode.tree;

import datastructure.tree.BinaryTree;
import datastructure.tree.TreeNode;
import javatest.tree.Tree;
import sun.security.tools.PathList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaozl on 2016/9/25.
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode [] nodes = new TreeNode[7];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new TreeNode();
            nodes[i].setValue(i+1);
        }

        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[6]);

        nodes[1].setLeft(nodes[2]);
        nodes[1].setRight(nodes[4]);

        nodes[2].setRight(nodes[3]);
        nodes[4].setLeft(nodes[5]);


        System.out.println(isSameTree(nodes[0],nodes[1]));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q ==null){
            return true;
        } else if (p == null || q == null){
            return false;
        }
        if (p.getValue() == q.getValue()){
            boolean left = isSameTree(p.getLeft(),q.getLeft());
            boolean right = isSameTree(p.getRight(),q.getRight());
            return left&&right;
        }
        return false;
    }

}
