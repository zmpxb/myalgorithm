package leetcode.bithandle;

import sun.rmi.server.InactiveGroupException;

/**
 * 判断整数一个数是不是2的幂
 * Created by xiaozl on 2016/6/8.
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(Integer.bitCount(7));

        // System.out.println(isPowerOfTwo(16));
        // System.out.println(Integer.toBinaryString(i).length());
    }

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        String bit = Integer.toBinaryString(n);
        for (int i = 1; i < bit.length(); i++) {
            if (bit.charAt(i) != '0'){
                return false;
            }
        }
        return true;
    }

//    public static int hammingWeight(int n) {
//
//    }
}
