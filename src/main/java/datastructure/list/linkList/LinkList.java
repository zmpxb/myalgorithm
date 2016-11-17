package datastructure.list.linkList;

/**
 * Created by xiaozl on 2016/10/10.
 */
public class LinkList {

    private int size = 0;

    // 头结点
    Node head = null;

    Node tail = null;

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 建立带头结点的空链表
     * head == tail 表示没有存在元素，但是链表的结构是存在的
     */
    public LinkList(){
        head = new Node();
        tail = head;
    }

    /**
     * 尾插法建立指定大小的链表
     * @param size
     */
    public  void createLinkListByTail(int size){
        this.size = size;
        head = new Node();
        tail = head;
        for (int i = 0; i < size; i++) {
            Node node = new Node();
            tail.setNext(node);
            tail = node;
        }
    }

    /**
     * 头插法建立单链表
     * @param size
     */
    public void createLinkListByHead(int size){
        this.size = size;
        head = new Node();
        Node node = null;
        for (int i = 0; i < size; i++) {
            node = new Node();
            node.setNext(head.getNext());
            head.setNext(node);
        }
        tail = node;
    }

    /**
     * 获取指定位置的数据
     * @param index
     * @return
     */
    public Node get(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node curNode = head;
        for (int i = 0; i <= index; i++) {
            curNode = curNode.getNext();
        }
        return curNode;
    }


    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     * @return
     */
    public boolean insert(int index, Integer e) {
        validateIndex(index);
        // 将要插入的值封装成一个节点。
        Node newNode = new Node(e);
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        newNode.setNext(p.getNext());
        p.setNext(newNode);
        // 表尾插入元素时特殊处理
        if (size == index){
            tail=newNode;
        }
        size++;
        return true;
    }

    /**
     * 验证下标值是否合法，非法时抛出异常。
     * @param index 待验证的下标值
     */
    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("无效的下标：" + index);
        }
    }

    /**
     * 删除指定位置的结点
     * 下标从1开始
     * @param index 待删除结点的下标
     * @return
     */
    public Node delete(int index) {
        if (index < 0 || index > size-1) {
            throw new RuntimeException("无效的下标：" + index);
        }
        Node curNode = head;
        Node preNode = null;
        for (int i = 0; i <= index; i++) {
            preNode = curNode;
            curNode = curNode.getNext();
        }
        preNode.setNext(curNode.getNext());
        size--;
        return curNode;
    }

    /**
     * 更新指定位置的元素
     * @param index
     * @param e
     */
    public void update(int index, Integer e){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node curNode = head;
        for (int i = 0; i <= index ; i++) {
            curNode = curNode.getNext();
        }
        curNode.setE(e);
    }

    /**
     * 在链表的尾部插入数据
     * @param e
     * @return
     */
    public boolean addToTail(Integer e){
        try {
            Node node = new Node(e);
            tail.setNext(node);
            tail = tail.getNext();
            size++;
        }catch (Exception h){
            return false;
        }
        return true;
    }

    /**
     * 链表长度
     * @return
     */
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        if (size == 0){
            return "";
        }else {
            StringBuilder str = new StringBuilder("");
            Node curNode = head.getNext();
            for (int i = 0; i < size; i++) {
                str.append(curNode.getE().toString() + ",");
                curNode = curNode.getNext();
            }
            int len = str.length();
            // 删除的元素不包括len-1 从1开始计数，但是包括len位置的元素
            return str.delete(len - 1 , len).toString();
        }
    }
}

class Node{

    private Integer e;

    private Node next = null;

    public Node(){

    }

    public Node(Integer e){
        this.e = e;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}