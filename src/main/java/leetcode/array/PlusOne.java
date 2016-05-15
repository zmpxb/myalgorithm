package leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * PlusOne
 *
 * @author xiaozl
 * @date: 2016/5/9
 */

/**
 * 问题：
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 注意：
 1.一个数组的每一个元素拼起来算是一个整数，数组的每个元素，代表整数的每一位。
 2.问题其实就是这个整数加1后如何用数组表示出来，每个元素取值是0-1；
 3.涉及到数组扩容，元素移动，整数加法进位的问题。
 */


public class PlusOne {

    public static void main(String[] args) {
        int [] array = {9,9,9,9};
        plusOne(array);
    }

    public static int[] plusOne(int[] digits) {
        int sum = 0;
        int one = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = one + digits[i];
            // 解决进位的问题
            one = sum / 10;
            digits[i] = sum%10;
        }
        // 如果最高位仍然有进位，需要扩充数组
        if (one > 0) {
            // Arrays.copyOf 返回值是一个新数组。原来的数组仍然存在
            digits = Arrays.copyOf(digits,digits.length+1);
            for (int i = digits.length-2; i >= 0 ; i--) {
                digits[i+1] = digits[i];
            }
            digits[0] = one;
        }
        return digits;
    }

    public static ArrayList<Integer> plusOne1(int[] digits) {

        ArrayList<Integer> result = new ArrayList<Integer>(digits.length);
        int sum = 0;
        int one = 1;
        for (int i = 0; i < digits.length; i++) {
            result.add(0);
        }
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = one + digits[i];
            one = sum / 10;
            result.set(i,sum % 10);
        }
        if (one > 0) {
            result.add(0,one);
        }
        return result;
    }


}
