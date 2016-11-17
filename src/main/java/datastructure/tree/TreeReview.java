package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xiaozl on 2016/9/25.
 */
public class TreeReview {

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
        System.out.println(getDepth(nodes[0]));

    }

    public static void levelOrderTraverse(TreeNode root){
        if (root == null){
          return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = root;
        queue.add(root);
        int pre = 1;
        int now = 0;
        System.out.println(pre);
        while (!queue.isEmpty()){
                if (pre > 0){
                    node = queue.remove();
                    node.setVisited(true);
//                    System.out.println(node.getValue());
                    pre--;
                    if (node.getLeft() != null){
                        queue.add(node.getLeft());
                        now++;
                    }
                    if (node.getRight() != null){
                        queue.add(node.getRight());
                        now++;
                    }
                } else if (pre == 0){
                    pre = now;
                    System.out.println(pre);
                    now = 0;
                }
        }

    }

    public static int getDepth(TreeNode root){
        if (root == null){
            return 0;
        } else {

            int l = getDepth(root.getLeft());
            int r = getDepth(root.getRight());
            return (l>r?l:r) + 1;
        }
    }

}
