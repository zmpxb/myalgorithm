package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by xiaozl on 2016/10/17.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses va = new ValidParentheses();
//        System.out.println(va.longestValidParentheses("())()()())"));
        System.out.println(va.longestValidParentheses(")()(())"));
//        System.out.println(va.longestValidParentheses(")"));
    }

    /**
     * Valid Parentheses
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.keySet().contains(curr)){
                stack.push(curr);
            } else if(map.values().contains(curr)){
                if (!stack.empty() && map.get(stack.peek()) == curr){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * Longest Valid Parentheses 求合法匹配的括号的最大长度
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        int start = -1;
        int maxLength = 0;
        Stack stack = new Stack();
        for (int i = 0; i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                if (!stack.empty()){
                    stack.pop();
                    if (stack.empty() == true){
                        maxLength = Math.max(i-start,maxLength);
                    } else {
                        maxLength = Math.max(i- (Integer)stack.peek(),maxLength);
                    }
                } else {
                    start = i;
                }
            }
        }
        return maxLength;
    }
}
