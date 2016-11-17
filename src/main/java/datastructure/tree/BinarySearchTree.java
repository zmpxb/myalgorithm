package datastructure.tree;

import javatest.tree.Tree;

/**
 * 二叉查找树的一般操作
 * Created by xiaozl on 2016/9/26.
 */
public class BinarySearchTree {

    /**
     * 搜索节点在二叉查找树中的插入位置
     * @param root
     * @param key
     * @return
     */
    public static TreeNode searchInsertLocation(TreeNode root,Integer key){
        TreeNode pre = null,now = root;
        while (now != null){
            pre = now;
            if (key == now.getValue()){
                return null;
            }
            now = key < now.getValue()?now.getLeft():now.getRight();
        }
        return pre;
    }

    /**
     * 在二叉查找树中插入节点
     * @param root
     * @param key
     * @return
     */
    public static TreeNode insertNode(TreeNode root,Integer key){
        if (root == null){
            root = new TreeNode();
            root.setValue(key);
            root.setLeft(null);
            root.setRight(null);
        }

        TreeNode location = searchInsertLocation(root,key);
        if (location == null){
            System.out.println("插入节点已经存在");
        } else {
            if (key < location.getValue()){
                TreeNode insertNode = new TreeNode();
                insertNode.setValue(key);
                insertNode.setLeft(null);
                insertNode.setRight(null);
                location.setLeft(insertNode);
            }
            if (key > location.getValue()){
                TreeNode insertNode = new TreeNode();
                insertNode.setValue(key);
                insertNode.setLeft(null);
                insertNode.setRight(null);
                location.setRight(insertNode);
            }
        }
        return root;
    }

    /**
     * 二叉排序树查找节点
     * @param key
     * @return
     */
    public static TreeNode searchNode(TreeNode root,int key){
        TreeNode current = root;
        while (current != null){
            if (key == current.getValue()){
                return current;
            } else if (key < current.getValue()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current;
    }

    /**
     * 获取值为key的双亲,前提key在二叉查找树里面
     * @param root
     * @param key
     * @return
     */
    public static TreeNode searchParentNode(TreeNode root,int key){
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null){
            if (key == current.getValue()){
                return pre;
            } else if (key < current.getValue()){
                pre = current;
                current = current.getLeft();
            } else {
                pre = current;
                current = current.getRight();
            }
        }
        return pre;
    }

    /**
     * 删除值为key的节点并返回根节点
     * @param root
     * @param key
     * @return
     */
    public static TreeNode delete(TreeNode root,Integer key){
        if (root == null){
            System.out.println("树为空不能删除");
            return null;
        }
        TreeNode deleteNode = searchNode(root,key);
        if (deleteNode == null){
            System.out.println("删除节点不存在");
        }
        // 获取删除节点的父节点
        TreeNode parent = searchParentNode(root,key);
        // 删除节点不是根节点
        if (parent != null) {
            if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
                // 删除的节点的左右子树为空
                if (parent.getLeft() == deleteNode) {
                    parent.setLeft(null);
                }
                if (parent.getRight() == deleteNode) {
                    parent.setRight(null);
                }
            } else if (deleteNode.getLeft() == null || deleteNode.getRight() == null) {
                // 删除节点左右子树有其一不为空
                if (deleteNode.getLeft() == null) {
                    if (parent.getLeft() == deleteNode) {
                        parent.setLeft(deleteNode.getRight());
                    }
                    if (parent.getRight() == deleteNode) {
                        parent.setRight(deleteNode.getRight());
                    }
                } else {
                    if (parent.getLeft() == deleteNode) {
                        parent.setLeft(deleteNode.getLeft());
                    }
                    if (parent.getRight() == deleteNode) {
                        parent.setRight(deleteNode.getLeft());
                    }
                }
            } else {
                // 删除节点的左右子树都不为空，用删除节点的者直接后继来替换当前节点，调整直接后继的位置
                TreeNode rightChild = deleteNode.getRight();
                // 删除节点右孩子的最左节点，删除节点的直接后继
                TreeNode rightChildMostLeft = rightChild;
                while (rightChildMostLeft.getLeft() != null) {
                    rightChildMostLeft = rightChildMostLeft.getLeft();
                }
                TreeNode rightChildMostLeftParent = searchParentNode(root,rightChildMostLeft.getValue());
                deleteNode.setValue(rightChildMostLeft.getValue());
                // 删除直接后继rightChildMostLeft

                if (rightChildMostLeftParent.getLeft() == rightChildMostLeft) {
                    rightChildMostLeftParent.setLeft(rightChildMostLeft.getRight());
                }
                if (rightChildMostLeftParent.getRight() == rightChildMostLeft) {
                    rightChildMostLeftParent.setRight(rightChildMostLeft.getRight());
                }
            }
        } else {
            // 删除节点为根节点
            if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
                return null;
            } else if (deleteNode.getLeft() == null || deleteNode.getRight() == null) {
                if (deleteNode.getLeft() == null) {
                    return deleteNode.getRight();
                } else {
                    return deleteNode.getLeft();
                }
            } else {

                // 删除节点的左右子树都不为空，用删除节点的者直接后继来替换当前节点，调整直接后继的位置
                TreeNode rightChild = deleteNode.getRight();
                // 删除节点右孩子的最左节点，删除节点的直接后继
                TreeNode rightChildMostLeft = rightChild;
                while (rightChildMostLeft.getLeft() != null) {
                    rightChildMostLeft = rightChildMostLeft.getLeft();
                }
                TreeNode rightChildMostLeftParent = searchParentNode(root,rightChildMostLeft.getValue());
                deleteNode.setValue(rightChildMostLeft.getValue());
                // 删除直接后继rightChildMostLeft

                if (rightChildMostLeftParent.getLeft() == rightChildMostLeft) {
                    rightChildMostLeftParent.setLeft(rightChildMostLeft.getRight());
                }
                if (rightChildMostLeftParent.getRight() == rightChildMostLeft) {
                    rightChildMostLeftParent.setRight(rightChildMostLeft.getRight());
                }
            }
        }
        return root;
    }
}
