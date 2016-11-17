package leetcode.tree;

import datastructure.tree.BinaryTree;
import datastructure.tree.TreeNode;

/**
 * Created by xiaozl on 2016/9/26.
 */
public class JudgeBalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[6];
        for (int i = 0; i < 6; i++) {
            nodes[i] = new TreeNode();

        }
        nodes[0].setValue(10);
        nodes[1].setValue(7);
        nodes[2].setValue(15);
        nodes[3].setValue(4);
        nodes[4].setValue(13);
        nodes[5].setValue(18);


        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);

        nodes[1].setLeft(nodes[3]);

        nodes[2].setLeft(nodes[4]);
        nodes[2].setRight(nodes[5]);

        System.out.println(BinaryTree.isBalanced(nodes[0]));
    }

}
