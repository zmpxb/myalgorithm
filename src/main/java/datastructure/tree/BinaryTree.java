package datastructure.tree;

import javatest.tree.Tree;

import java.util.*;

/**
 * 二叉树的一般操作
 * Created by xiaozl on 2016/9/22.
 */
public class BinaryTree {

    /**
     * 遍历
     * 前序遍历：根节点->左子树->右子树
       中序遍历：左子树->根节点->右子树
       后序遍历：左子树->右子树->根节点
     */

    /**
     * 先序遍历二叉树递归算法
     * @param root
     */
    public static void preOrderTraverse(TreeNode root){
        if (root != null){
            root.setVisited(true);
            System.out.println(root.getValue());
            preOrderTraverse(root.getLeft());
            preOrderTraverse(root.getRight());
        }
    }

    /**
     * 先序遍历二叉树非递归算法
     * 对stack是否为空和node是否为空进行了判断
     * 什么时候进栈，什么时候出栈，
     * @param root
     */
    public static void preOrderTraverseNotRecurse(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node!=null || !stack.isEmpty()){
            while (node !=null ){
                node.setVisited(true);
                System.out.println(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            //这里出栈就可以保证不会重复访问
            node = stack.pop();
            node = node.getRight();
        }

    }

    /**
     * 中序遍历递归算法
     * @param root
     */
    public static void inOrderTraverse(TreeNode root){
        if (root != null){
            inOrderTraverse(root.getLeft());
            root.setVisited(true);
            System.out.println(root.getValue());
            inOrderTraverse(root.getRight());
        }
    }

    /**
     * 中序遍历二叉树非递归
     * @param root
     */
    public static void inOrderTraverseNotRecurse(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (node!=null || !stack.empty()){
            while (node!=null){
                // 只要左左子树不为空，一直进栈
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node.setVisited(true);
            System.out.println(node.getValue());
            node = node.getRight();
        }
    }

    /**
     * 后序遍历二叉树递归
     * @param root
     */
    public static void postOrderTraverse(TreeNode root){
        if (root != null){
            postOrderTraverse(root.getLeft());
            postOrderTraverse(root.getRight());
            root.setVisited(true);
            System.out.println(root.getValue());
        }
    }

    /**
     * 后序遍历二叉树非递归
     * @param root
     */
    public static void postOrderTraverseNotRecurse(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node!=null || !stack.empty()){
            while (node!=null){
                // 只要左左子树不为空，一直进栈
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.peek();
            if (node.getLeft() == null && node.getRight() == null){
                node.setVisited(true);
                System.out.println(node.getValue());
                stack.pop();
                node = null;
                continue;
            }
            if (node.getRight() != null && node.getRight().isVisited() == false){
                node = node.getRight();
                continue;
            }
            if ( node.getRight() != null && node.getRight().isVisited() == true){
                node.setVisited(true);
                System.out.println(node.getValue());
                stack.pop();
                node = null;
                continue;
            }
            if (node.getRight() == null && node.getLeft() != null && node.getLeft().isVisited() == true){
                node.setVisited(true);
                System.out.println(node.getValue());
                stack.pop();
                node = null;
            }
        }
    }

    /**
     * 后序遍历二叉树非递归
     * @param root
     */
    public static void postOrderTraverseNotRecurse1(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode preNode = null;
        while (node != null || !stack.empty()) {
            while (node != null) {
                // 只要左左子树不为空，一直进栈
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.peek();
            // 找到访问结点的条件
            if (node.getRight() == null || node.getRight() == preNode){
                node.setVisited(true);
                System.out.println(node.getValue());
                preNode = node;
                stack.pop();
                node = null;
            } else {
                node = node.getRight();
            }
        }
    }

    /**
     * 树的层次遍历算法
     * 使用队列
     * @param root
     */
    public static void levelOrderTraverse(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.remove();
            node.setVisited(true);
            System.out.println(node.getValue());
            if (node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
            }
        }

    }

    /**
     * 层次遍历
     * 打印每树一层有多少个节点
     * @param root
     */
    public static void printEverLevelNumOfTree(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.add(root);
        int pre = 1;
        int now = 0;
        System.out.println(pre);
        while (!queue.isEmpty()){
            if (pre == 0){
                System.out.println(now);
                pre = now;
                now = 0;
            }
            node = queue.remove();
            pre--;
//            node.setVisited(true);
//            System.out.println(node.getValue());
            if (node.getLeft() != null){
                queue.add(node.getLeft());
                now++;
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
                now++;
            }
        }
    }

    /**
     * 中序遍历返回结果，并将每一层元素存入一个数组里分别输出
     Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
     * @param root
     * @return
     */
    public static List<List<Integer>> getLevelOrderList(TreeNode root){
        if (root == null){
            return null;
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
            levelTraverseResultList.add(node.getValue());
            pre--;
            if (node.getLeft() != null){
                queue.add(node.getLeft());
                now++;
            }
            if (node.getRight() != null){
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
        return resuts;
    }

    /**
     * 获取树的高度使用中序遍历
     * @param root
     * @return
     */
    public static int getDepth(TreeNode root){
        if (root != null){
            int lh = getDepth(root.getLeft());
            int rh = getDepth(root.getRight());
            int h = (lh > rh)?lh:rh;
            return h+1;
        } else {
            return 0;
        }
    }

    private static HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();

    /**
     * 根据树的后序和中序遍历结果建造树
     * @param postOrder
     * @param inOrder
     * @return
     */
    public static TreeNode buildBinaryTreeByPostAndInOrder(int [] postOrder,int [] inOrder){
        if (postOrder == null
                || inOrder == null
                || postOrder.length == 0
                || inOrder.length == 0){
            return null;
        }

        for (int i = 0; i < inOrder.length; i++) {
            m.put(inOrder[i],i);
        }
        return build(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1);
    }

    public static TreeNode build(int [] inOrder,int s0,int e0,
                                 int [] postOrder,int s1,int e1){
        if (s0>e0 || s1 >e1){
            return null;
        }
        TreeNode root = new TreeNode();
        root.setValue(postOrder[e1]);
        int mid = m.get(postOrder[e1]);
        int num = mid - s0;

        root.setLeft(build(inOrder,s0,mid-1,postOrder,s1,s1+num-1));
        root.setRight(build(inOrder,mid+1,e0,postOrder,s1+num,e1-1));
        return root;
    }

    /**
     * 给定先序遍历序列和中序遍历序列，构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildBinaryTreeByPreAndInOrder(int [] preorder,int [] inorder){
        if (preorder == null
                || inorder == null
                || preorder.length == 0
                || inorder.length == 0){
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }

    public static TreeNode buildd(int [] inorder,int s0,int e0,
                                  int [] preorder,int s1,int e1){
        if (s0>e0 || s1 >e1){
            return null;
        }
        TreeNode root = new TreeNode();
        root.setValue(preorder[s1]);
        int mid = m.get(preorder[s1]);
        int num = mid - s0;

        root.setLeft(build(inorder,s0,mid-1,preorder,s1+1,s1+num));
        root.setRight(build(inorder,mid+1,e0,preorder,s1+num+1,e1));
        return root;
    }

    /**
     * 判断一棵树是不是平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (node!=null || !stack.empty()){
            while (node!=null){
                // 只要左左子树不为空，一直进栈
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            int left = getDepth(node.getLeft());
            int right = getDepth(node.getRight());
            if (Math.abs(left-right)>1){
                return false;
            }
            node = node.getRight();
        }
        return true;
    }

}
