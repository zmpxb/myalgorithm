package leetcode.tree;

import datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaozl on 2016/9/28.
 */
public class PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {
        TreeNode [] nodes = new TreeNode[7];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new TreeNode();
            nodes[i].setValue(i);
        }

        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);

        nodes[1].setLeft(nodes[3]);
        nodes[1].setRight(nodes[4]);


        nodes[2].setLeft(nodes[5]);
        nodes[2].setRight(nodes[6]);

        populatingNextRightPointersinEachNode(nodes[0]);
        System.out.println("xia");
    }

    /**
     * 利用层次遍历，以及记住每一层的元素
     * @param root
     */
    public static void populatingNextRightPointersinEachNode(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = null;
        TreeNode preNode = root;
        queue.add(root);
        int pre = 1;
        int now = 0;
        System.out.println(pre);
        while (!queue.isEmpty()){
            if (pre == 0){
                preNode.setNext(null);
                pre = now;
                now = 0;

                node = queue.remove();

                preNode = node;
                pre--;
                if (node.getLeft() != null){
                    queue.add(node.getLeft());
                    now++;
                }
                if (node.getRight() != null){
                    queue.add(node.getRight());
                    now++;
                }

            } else {
                node = queue.remove();

                if (preNode == root) {
                    preNode.setNext(null);
                } else {
                    preNode.setNext(node);
                }
                preNode = node;
                pre--;
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                    now++;
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                    now++;
                }
            }
        }
    }

}
