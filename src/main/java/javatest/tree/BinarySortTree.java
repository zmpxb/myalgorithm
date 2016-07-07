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
    public NodeBst searchBst(int key){
        NodeBst current = root;
        while (current != null){
            if (key == current.getValue()){
                return current;
            } else if (key < current.getValue()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public NodeBst searchFather(int key){
        NodeBst father = null;
        NodeBst current = root;
        while (current != null) {
            if (key < current.getValue()) {
                father = current;
                current = current.getLeft();
            }
            if (key > current.getValue()){
                father = current;
                current = current.getRight();
            }
            if (key == current.getValue()){
                return father;
            }
        }
        return null;
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

    public NodeBst deleteNodeBst(int key){
        if (searchBst(key) == null){
            return null;
        } else {
            return deleteBST(root,null,key);
        }
    }

    public NodeBst deleteNodeBst1(int key){
        NodeBst delteNode = searchBst(key);
        if (delteNode == null){
            return null;
        } else {
            NodeBst f = searchFather(key);
            return  delete(delteNode,f);
        }
    }

    public NodeBst deleteBST(NodeBst t,NodeBst f,int key){
        if (t == null){
            return null;
        } else if (key == t.getValue()){
            delete(t,f);
            return t;
        } else if (key < t.getValue()){
            return deleteBST(t.getLeft(),t,key);
        } else {
            return deleteBST(t.getRight(),t,key);
        }
    }

    public NodeBst delete(NodeBst t,NodeBst f){
        NodeBst l;

        // t既没有左孩子，又没有右孩子，为叶子结点
        if (t.getLeft() == null && t.getRight() == null){
            if (t == root){

            }
            root = null;
            return null;
        } else if (t.getLeft() == null){
            // t只有右孩子
            t.setValue(t.getRight().getValue());
            t.setRight(null);
            return t;
        } else if (t.getRight() == null){
            // t只有左孩子
            t.setValue(t.getLeft().getValue());
            t.setLeft(null);
            return t;
        } else {
            // t既有左孩子，又有右孩子
            // l指向被删除结点的左子树
            l = t.getLeft();

            // 寻找l的最右孩子
            while (l.getRight() != null) {
                l = l.getRight();
            }

            // 把l的右子树接到左子树最右孩子的右子树上。
            l.setRight(t.getRight());
            // t的左子树直接作为t父结点的子树
            if (t == f.getLeft()){
                f.setLeft(t.getLeft());
                return t;
            } else {
                f.setRight(t.getRight());
                return t;
            }

        }

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
