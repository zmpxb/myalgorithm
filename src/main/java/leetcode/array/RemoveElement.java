package leetcode.array;

/**
 * RemoveElement
 *
 *
 * @author xiaozl
 * @date: 2016/5/8
 */

/**
 * 问题：
 * Given an array and a value, remove all instances of that > value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 1.给定一个数组array和一个和数组存储的元素类型相同的元素elem。
 * 2.删除数组中和元素elem值相同的元素并返回删除相同元素后的数组的新长度
 *
 * 思路：游标的思想
 * 方法很简单， 使用两个游标i， j， 遍历数组， 如果碰到了value， 使用j记录位置， 同时递增i， 直到下一个非
 * value出现， 将此时i对应的值复制到j的位置上， 增加j， 重复上述过程直到遍历结束。 这时候j就是新的数组
 * 长度。
 *
 * 注意：in place 表示帮我们不能构建新的数组
 */
public class RemoveElement {

    public static void main(String[] args) {
        int [] array = {1,2,3,3,4,3,5,7};
        System.out.println(removeElement(array,array.length,3));
    }

    public static int removeElement(int [] array, int n, int elem){
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == elem){
                continue;
            }
            array[j] = array[i];
            j++;
        }
        return j;
    }

}
