package leetcode.string;

/**
 * Length of Last Word 获取一个字符串中最后一个单词的长度
 * Created by xiaozl on 2016/10/11.
 */
public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     For example,
     Given s = "Hello World",
     return 5.
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String [] strArray = s.split(" ");
        if (strArray.length == 0){
            return 0;
        } else {
            return strArray[strArray.length-1].length();
        }
    }

    public static void main(String[] args) {
        String sourceStr = "abc,adc,csd,bcs,acb";

        String [] sourceStrArray = sourceStr.split(",");
        longestCommonPrefix(sourceStrArray);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        boolean flag = true;
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                if(i>=strs[j].length()
                        || strs[0].charAt(i)!=strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                return strs[0].substring(0,i);
            }

        }
        return strs[0];
    }
}
