package tree;

import datastructure.tree.BinarySearchTree;
import datastructure.tree.BinaryTree;
import datastructure.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xiaozl on 2016/9/22.
 */
public class BinaryTreeTest {

    @Test
    /**
     * 1234567
     * 先序遍历递归
     */
    public void testPreOrderTraverse(){
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
        BinaryTree.preOrderTraverse(nodes[0]);
    }

    @Test
    /**
     * 先序遍历非递归算法
     */
    public void testPreOrderTraverseNotRecurse(){
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
        BinaryTree.preOrderTraverseNotRecurse(nodes[0]);
    }

    @Test
    /**
     *  中序遍历递归算法
     */
    public void testInOrderTraverse(){
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
        BinaryTree.inOrderTraverse(nodes[0]);
    }

    @Test
    /**
     * 中序遍历二叉树非递归
     */
    public void testInOrderTraverseNotR(){
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
        BinaryTree.inOrderTraverseNotRecurse(nodes[0]);
    }

    /**
     * 后序遍历二叉树递归
     * 4365271
     */
    @Test
    public void testPostOrderTraverse(){
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
        BinaryTree.postOrderTraverse(nodes[0]);
    }

    /**
     * 后序遍历二叉树递归
     * 4365271
     */
    @Test
    public void testPostOrderTraverseNotR(){
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
        BinaryTree.postOrderTraverseNotRecurse1(nodes[0]);
    }

    @Test
    /**
     * 获取树的高度
     */
    public void testGetDepth(){
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
        TreeNode n = new TreeNode();
        nodes[3].setRight(n);
        System.out.println(BinaryTree.getDepth(nodes[0]));

    }

    @Test
    /**
     * 测试树的层次遍历
     */
    public void testLevelTraverse(){
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
        BinaryTree.levelOrderTraverse(nodes[0]);
    }

    @Test
    /**
     * 层次遍历获取每一层元素的个数
     */
    public void testPrintEverLevelNumOfTree(){
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
        BinaryTree.printEverLevelNumOfTree(nodes[0]);
    }

    @Test
    /**
     * 获取二叉树每一层的元素
     */
    public void getLevelOrderList(){
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
        BinaryTree.getLevelOrderList(nodes[0]);

        System.out.println("xioa");
    }

    @Test
    /**
     * 在二叉查找树中插入节点
     */
    public void insertNodeInBinarySearchTree(){
        TreeNode [] nodes = new TreeNode[6];
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


        BinaryTree.inOrderTraverse(nodes[0]);
        BinarySearchTree.insertNode(nodes[0],14);
        BinaryTree.inOrderTraverse(nodes[0]);
    }

    @Test
    public void deleteNodeInBinarySearchNode(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        TreeNode [] nodes = new TreeNode[6];
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



        BinarySearchTree.delete(nodes[0],10);
        BinaryTree.inOrderTraverse(nodes[0]);
        System.out.println("-- " +nodes[0].getRight().getValue());
        System.out.println("-- " +nodes[0].getRight().getLeft().getValue());
    }
}
