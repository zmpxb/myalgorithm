package javastring;

/**
 * Created by xiaozl on 2016/10/11.
 */
public class TestSplit {

    public static void main(String[] args) {
        String sourceStr = "1,2,3,4,5";
        System.out.println(sourceStr.substring(0,4));
        String [] sourceStrArray = sourceStr.split(",");
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[i]);
        }
        // 最多分割出3个字符串
        int maxSplit = 3;
        sourceStrArray = sourceStr.split(",", maxSplit);
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[i]);
        }
    }

}
