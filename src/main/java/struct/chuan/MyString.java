package struct.chuan;

import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/**
 * MyString
 *
 * @author dujuan
 * @date: 2016/5/2
 */
public final class MyString {

    private  char value[];

    private  int offset;

    private  int count;

    private int hash; // Default to 0

    public MyString(){
        this.offset = 0;
        this.count = 0;
        this.value = new char[0];
    }

    public MyString(char value []){
        this.offset = 0;
        this.count = value.length;
        this.value = Arrays.copyOf(value,value.length);//这种copy的实现实际上是新new 了一个char 数组，
        // 把原始数据拷贝到新new 的数组中，返回新数组的引用,实际上用的System.arraycopy来执行

    }

    public MyString(MyString original){
        int size = original.count;
        char [] originalValue = original.value;
        char [] v;
        if (originalValue.length > size){
            int off = original.offset;
            v = Arrays.copyOfRange(originalValue,off,off+size);
        } else {
            v = originalValue;
        }
        this.offset = 0;
        this.count = size;
        this.value = v;
    }
}
