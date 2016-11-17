package datastructure.tree;

/**
 * int类型树的节点
 * Created by xiaozl on 2016/9/22.
 */
public class TreeNode {

    private static final int LH = 1;	//左高
    private static final int EH = 0;    //等高
    private static final int RH = -1;	//右高

    private TreeNode left;

    private TreeNode right;

    private TreeNode parent;

    private TreeNode next;

    private boolean visited = false;

    private Integer balance = EH;

    private Integer value;

    public TreeNode(){

    }

    public TreeNode(TreeNode left, TreeNode right, Integer value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }
}
