package javatest.tree;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xiaozl on 2016/6/29.
 */
public class Tree<T> {

    private Node<T> root;

    private int leafNum;

    public Tree() {
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    //创建二叉树
    public void buildTree() {
        Scanner scn = null;
        try {
            scn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        root = createTree(root, scn);
    }

    //先序遍历创建二叉树
    private Node<T> createTree(Node<T> node, Scanner scn) {
        String temp = scn.next();
        if (temp.trim().equals("#")) {
            return null;
        } else {
            node = new Node<T>((T) temp);
            node.setLeft(createTree(node.getLeft(), scn));
            node.setRight(createTree(node.getRight(), scn));
            return node;
        }
    }

    /**
     * 中序遍历(递归算法)
     */
    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    public void inOrderTraverse(Node<T> node){
        if (node != null){
            inOrderTraverse(node.getLeft());
            System.out.println(node.getValue());
            inOrderTraverse(node.getRight());
        }
    }

    /**
     * 中序遍历非递归算法
     */
    public void nrInOrderTraverse(){
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.println(node.getValue());
            node = node.getRight();
        }
    }

    /**
     * 先序遍历
     */
    public void preOrderTraverse(){
        preOrderTraverse(root);
    }

    public void preOrderTraverse(Node<T> node){
        if (node != null){
            System.out.println(node.getValue());
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }

    /**
     * 先序遍历（非递归）
     */
    public void nrPreOrderTraverse() {

        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> node = root;

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                System.out.println(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node = node.getRight();
        }

    }



    /**
     * 后序遍历(递归)
     */
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    public void postOrderTraverse(Node<T> node) {
        if (node != null) {
            postOrderTraverse(node.getLeft());
            postOrderTraverse(node.getRight());
            System.out.println(node.getValue());
        }
    }

    /**
     * 后续遍历(非递归)
     * 每个子树的根节点的访问都是在右子树被访问后进行访问的，用 node.getRight() == preNode进行判断
     */
    public void nrPostOrderTraverse(){
        Stack<Node<T>> stack = new Stack<Node<T>>();

        Node<T> node = root;
        // 最近一次访问的节点
        Node<T> preNode = null;

        while (node != null || !stack.isEmpty()){
            while (node != null){
                // 后序遍历左子树进栈，一直到左子树为空
                stack.push(node);
                node = node.getLeft();
            }
            // 取栈定元素
            node = stack.peek();
            // 若栈顶元素的右子树为空访问，或者右子树是前一个访问结点
            if (node.getRight() == null || node.getRight() == preNode){
                System.out.println(node.getValue());
                node = stack.pop();
                preNode = node;
                node = null;
            } else {
                node = node.getRight();
            }
        }
    }


    /**
     * 按层次遍历
     */
    public void levelTraverse() {
        levelTraverse(root);
    }

    public void levelTraverse(Node<T> node) {
        Queue<Node<T>> queue = new LinkedBlockingQueue<Node<T>>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            if (temp != null) {
                System.out.println(temp.getValue());
                queue.add(temp.getLeft());
                queue.add(temp.getRight());
            }

        }

    }

    /**
     * 获取树的深度
     * @return
     */
    public int getDepth(){
        return getMaxDepth(root);
    }

    public int getMaxDepth(Node<T> root){
        if (root == null){
            return 0;
        } else {
            int left = getMaxDepth(root.getLeft());
            int right = getMaxDepth(root.getRight());
            return 1 + Math.max(left,right);
        }
    }

    /**
     * 获取树的宽度
     * @return
     */
    public int getWidth(){
        return getMaxWidth(root);
    }

    public int getMaxWidth(Node<T> root){
        int maxWitdth = 1;
        if (root == null){
            return 0;
        } else {
            Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
            queue.add(root);

            while (true){
                int len = queue.size();
                if (len == 0){
                    break;
                }
                while (len > 0){
                    Node<T> t = queue.poll();
                    len--;
                    if (t.getLeft() != null){
                        queue.add(t.getLeft());
                    }
                    if (t.getRight() != null){
                        queue.add(t.getRight());
                    }
                    maxWitdth = Math.max(maxWitdth,queue.size());
                }
            }
        }
        return maxWitdth;
    }

    /**
     * 统计叶子结点个数
     * @return
     */
    public int getLeafNum(){
        leafNum = 0;
        countLeaf(root);
        return leafNum;
    }

    public void countLeaf(Node<T> node){
        if (node != null){
            inOrderTraverse(node.getLeft());
            if (node.getLeft() == null && node.getRight() == null){
                leafNum++;;
            }
            inOrderTraverse(node.getRight());
        }
    }

    /**
     * 非递归算法交换二叉树的左右孩子
     * @param root
     */
    public void swapTree(Node<T> root){
        if(root == null){
            return;
        }

        Node<T> temp = null;
        Stack<Node<T>> stack = new Stack<Node<T>>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node<T> node = stack.peek();
            if (node.getLeft() == null && node.getRight() == null){
                node.setVisited(true);
                stack.pop();
                continue;
            }

            if (node.getLeft() != null) {
                if (!node.getLeft().isVisited()) {
                    stack.push(node.getLeft());
                }
            }

            if ((node.getLeft() == null || node.getLeft().isVisited()) && node.getRight() != null) {
                if (!node.getRight().isVisited()) {
                    stack.push(node.getRight());
                }
            }

            // 这里先判断了左右孩子是否为空，避免了空指针异常
            if ((node.getLeft() == null || node.getLeft().isVisited())
                    && (node.getRight() == null || node.getRight().isVisited())) {
                temp = node.getLeft();
                node.setLeft(node.getRight());
                node.setRight(temp);
                node.setVisited(true);
                stack.pop();
            }
        }
    }

    /**
     * 交换二叉树左右子树递归实现
     * @param t
     * @return
     */
    public Node<T> swapTreeRe(Node<T> t){
        Node<T> p = null;
        if (t == null || (t.getLeft()==null && t.getRight()==null)){
            return t;
        }
        p = t.getLeft();
        t.setLeft(t.getRight());
        t.setRight(p);
        if (t.getLeft() != null){
            t.setLeft(swapTreeRe(t.getLeft()));
        }
        if (t.getRight() != null){
            t.setRight(swapTreeRe(t.getRight()));
        }
        return t;
    }
}

class Node<T> {

    private Node<T> left;

    private Node<T> right;

    private T value;

    private boolean visited;

    public Node() {

    }

    public Node(Node<T> left, Node<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(T value) {
        this(null, null, value);
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}