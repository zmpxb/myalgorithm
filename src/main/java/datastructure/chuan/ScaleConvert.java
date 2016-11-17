package datastructure.chuan;

/**
 * ScaleConvert
 *
 * @author xiaozl
 * @date: 2016/5/7
 */
public class ScaleConvert {

    /**
     * 二进制字符串转10进制
     * @param str
     * @return
     */
    public static int bitStringToDec(String str){
        int result = 0;
        int ch = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='0'&&str.charAt(i)<='1'){
                ch = str.charAt(i)-'0';
            }else {
                System.out.println("输入格式不合法");
                return 0;
            }
            result = result*2 + ch;
        }
        return result;
    }

    /**
     * Created by xiaozl on 2016/3/2.
     * 16进制字符串转10进制整数
     * 输入："ab"
     * 输出：171
     */
    public static int hexStringToDec(String str){
        int result = 0;
        int ch = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                ch = str.charAt(i)-'0';
            }else if (str.charAt(i)>='A'&&str.charAt(i)<='F'){
                ch = str.charAt(i)-'A'+10;
            }else if(str.charAt(i)>='a'&&str.charAt(i)<='f'){
                ch = str.charAt(i)-'a'+10;
            }else {
                System.out.println("输入有问题");
                return 0;
            }
            result = result*16+ch;
        }
        return result;
    }
}
