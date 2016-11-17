package leetcode.tree;

import datastructure.tree.BinaryTree;
import datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaozl on 2016/9/23.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode [] nodes = new TreeNode[7];
//        for (int i = 0; i < 7; i++) {
//            nodes[i] = new TreeNode();
//            nodes[i].setValue(i+1);
//        }

        nodes[0] = new TreeNode();
        nodes[0].setValue(1);

        nodes[1] = new TreeNode();
        nodes[1].setValue(null);

        nodes[2] = new TreeNode();
        nodes[2].setValue(2);

        nodes[3] = new TreeNode();
        nodes[3].setValue(3);

        nodes[4] = new TreeNode();
        nodes[4].setValue(4);

        nodes[5] = new TreeNode();
        nodes[5].setValue(4);

        nodes[6] = new TreeNode();
        nodes[6].setValue(3);

        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);

        nodes[1].setLeft(nodes[3]);
        nodes[1].setRight(nodes[4]);

        nodes[2].setLeft(nodes[5]);
        nodes[2].setRight(nodes[6]);

        System.out.println(isSymmetric(nodes[0]));

        System.out.println("xioa");
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        List<List<Integer>> resuts = new ArrayList<List<Integer>>();
        ArrayList<Integer> countLevelNumList = new ArrayList<Integer>();
        ArrayList<Integer> levelTraverseResultList = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.add(root);
        int pre = 1;
        int now = 0;

        countLevelNumList.add(1);
        while (!queue.isEmpty()){
            if (pre == 0){
                countLevelNumList.add(now);
                pre = now;
                now = 0;
            }
            node = queue.remove();
            if (node != null) {
                levelTraverseResultList.add(node.getValue());
            } else {
                levelTraverseResultList.add(null);
            }
            pre--;
            if (node != null) {
                queue.add(node.getLeft());
                now++;
                queue.add(node.getRight());
                now++;
            }
        }
        int tmp = 0;
        for (int i = 0; i < countLevelNumList.size(); i++) {
            List<Integer> rs = new ArrayList<Integer>();
            for (int j = tmp; j < countLevelNumList.get(i)+tmp;j++){
                rs.add(levelTraverseResultList.get(j));
            }
            tmp = tmp + countLevelNumList.get(i);
            resuts.add(rs);
        }

        for (int i = 0; i < countLevelNumList.size(); i++) {
            List<Integer> tests = resuts.get(i);
            if (tests.size() == 0){
                continue;
            }
            for (int j = 0; j < tests.size()/2; j++) {
                if (tests.get(j) != tests.get(tests.size()-1-j)){
                    return false;
                }
            }
        }

        return true;
    }

}
