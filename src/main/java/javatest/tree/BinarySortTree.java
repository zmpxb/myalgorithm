package javatest.tree;

/**
 * Created by xiaozl on 2016/7/5.
 */
public class BinarySortTree {

    private NodeBst root = null;

    public BinarySortTree(){

    }

    public BinarySortTree(int [] array){
        if (array == null){
            return;
        } else {
            for (int i = 0; i < array.length; i++) {
                insertBst(array[i]);
            }
        }
    }

    /**
     * 二叉排序树检索结点是否存在
     * @param key
     * @return
     */
    public boolean searchBst(int key){
        NodeBst current = root;
        while (current != null){
            if (key == current.getValue()){
                return true;
            } else if (key < current.getValue()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    /**
     * 二叉排序树插入节点，插入的结点成为叶子结点
     * @param key
     * @return
     */
    public boolean insertBst(int key){
        NodeBst p = root;
        NodeBst prev = null;
        while (p != null){
            prev = p;
            if (key < p.getValue()){
                p = p.getLeft();
            } else if (key > p.getValue()){
                p = p.getRight();
            } else {
                return false;
            }
        }
        if (root == null){
            root = new NodeBst(key);
        } else if (key < prev.getValue()){
            prev.setLeft(new NodeBst(key));
        } else {
            prev.setRight(new NodeBst(key));
        }
        return true;
    }
}

class NodeBst {

    private NodeBst left;

    private NodeBst right;

    private int value;

    private boolean visited;

    public NodeBst(int value){
        this.value = value;
    }

    public NodeBst getLeft() {
        return left;
    }

    public void setLeft(NodeBst left) {
        this.left = left;
    }

    public NodeBst getRight() {
        return right;
    }

    public void setRight(NodeBst right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
