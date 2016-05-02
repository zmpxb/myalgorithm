package struct.chuan;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TestMain
 *
 * @author dujuan
 * @date: 2016/5/2
 */
public class TestMain {

    public static void main(String[] args) {
        String str = new String("ab");
        String str1 = new String("cd");
        char [] ch = new char[10];
        char [] ch1 ;
        String str2 = new String(ch);
        System.out.println(str2.length());
        System.out.println(str2.toString());
        ch1 = Arrays.copyOfRange(str.toCharArray(),0,0);
        System.out.println(Arrays.toString(ch1));
        System.arraycopy(str.toCharArray(),0,ch,0,str.toCharArray().length);
        System.arraycopy(str1.toCharArray(),0,ch,str.toCharArray().length,str.toCharArray().length);
        System.out.println(Arrays.toString(ch));
        //System.out.println(str.compareTo());
        str.length();
        char [] value = new char[10];
//        System.out.println(Arrays.toString(value));
//
//        System.out.println(value[0]);


    }

}
