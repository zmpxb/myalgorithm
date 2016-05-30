package leetcode.array;

/**
 * PalindromeNumber
 * 判断回文数
 * 1.0是回文数
 * 2.5是回文数
 * 3.负数不是回文数
 * @author xiaozl
 * @date: 2016/5/26
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(palindromeNumber(-2147447412));
    }

    public static boolean palindromeNumber(int x){
        int n = 1;
        int m = x;
        if (x < 0){
            return false;
        }
        while (x/10 != 0){
            x = x/10;
            n++;
        }
        int [] array = new int [n];
        if (n==1){
            return true;
        } else {
            for (int i = 0; i < n; i++) {
                array[i] = m % 10;
                m = m/10;
            }
            for (int i = 0; i < n/2; i++) {
                // 对称位置的比较只需要i < length/2
                if (array[i] != array[n-i-1]){
                    return false;
                }
            }
            return true;
        }
    }
}
