package datastructure.list.stack;

/**
 * 顺序栈，使用线性表的顺序结构实现
 * Created by xiaozl on 2016/10/14.
 */
public class ArrayStack {

    private int max = 10;

    private int [] data;

    private int top;

    public ArrayStack(){
        initStack();
    }

    /**
     * 栈初始化
     * 当top = -1表示栈空
     */
    public void initStack(){
        data = new int[max];
        top = -1;
    }

    /**
     * 入栈
     * @param e
     */
    public void push(int e){
        top++;
        if(top<max){
            data[top] = e;
        } else {
            // 容量不够时进行扩容
            int [] tmp = new int[max + 10];
            System.arraycopy(data,0,tmp,0,max);
            max = max + 10;
            data = tmp;
        }
    }

    public Integer pop(){
        if (isEmpty()){
            System.out.println("栈已经为空无法出栈 ！");
            return null;
        } else {
            int del = data[top];
            top--;
            return del;
        }
    }

    /**
     * 判断栈师范为空
     * @return
     */
    public boolean isEmpty() {
        if(top == -1) return true;
        else return false;
    }

}
