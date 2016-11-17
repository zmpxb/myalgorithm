package leetcode.tanxin;

import java.util.Stack;

/**
 * Created by xiaozl on 2016/10/20.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
//        String s = "   a";
//        System.out.println(s.length());
//        s = s.replaceAll(" ","");
//        System.out.println(s.length());
//        System.out.println(s);
        System.out.println(lengthOfLongestSubstring1("ckilbkd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        if (s.replaceAll(" ","").length() == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<Character>();
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || stack.peek() != s.charAt(i)){

                stack.push(s.charAt(i));
                max = Math.max(stack.size(),max);
            } else {
                stack.clear();
                stack.push(s.charAt(i));
            }
        }
        return max;
    }

    /**
     * Longest Substring Without Repeating Characters
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int j = 0;
        int m = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            j = i - 1;
            if (s.charAt(j) == s.charAt(i)){
                start = i;
                end = i;
                continue;
            }
            int tmp = end - start;
            for (int k = start; k < end; k++) {
                m++;
                if (s.charAt(k) == s.charAt(i)){
                    start = k + 1;
                    end = i;
                    break;
                }
            }
            if (m == tmp){
                end = i;
                max = Math.max(max,end-start+1);
            }
            // 注意重置为0
            m = 0;
        }
        return max;
    }


}
