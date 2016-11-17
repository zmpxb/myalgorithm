package datastructure.list.orderlist;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by xiaozl on 2016/10/10.
 */
public class AarryList {

    // 初始化时最大存储空间
    public static final int MAXSIZE = 20;

    // data用于存放数据
    private Integer [] data;

    // 线性表的长度
    private int length;

    // 初始化线性表
    public AarryList(){
        data = new Integer[MAXSIZE];
        length = 0;
    }

    /**
     * 获取线性表中的元素
     * @param i
     * @return
     */
    public int getElem(int i){
        if (i > length || i < 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        return data[i];
    }

    public void insertElem(int i,Integer e){
        if (i < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (length + 1 <= MAXSIZE){
            if (i == length){
                // 在线性表末尾插入元素，直接插入
                data[i] = e;
                length = length + 1;
            } else {
                // 先移动元素再赋值
                for (int j = length-1; j >= i ; j--) {
                    data[j+1] = data[j];
                }
                data[i] = e;
                length = length + 1;
            }
        } else {
            Integer [] tmp = new Integer[MAXSIZE+20];
            System.arraycopy(data,0,tmp,0,length);
            data = tmp;
            if (i == length){
                // 在线性表末尾插入元素，直接插入
                data[i] = e;
                length = length + 1;
            } else {
                // 先移动元素再赋值
                for (int j = length-1; j >= i ; j--) {
                    data[j+1] = data[j];
                }
                data[i] = e;
                length = length + 1;
            }
        }
    }

    public Integer deleteElem(int i){
        if (length == 0 || i<0 || i>=length){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (i == length-1){
            // 删除最后一个元素
            length = length-1;
            return data[i];
        } else {
            // 先移动元素再赋值
            Integer elem = data[i];
            for (int j = i; j<length-1 ; j++) {
                data[j] = data[j+1];
            }
            length--;
            return elem;
        }
    }

}
