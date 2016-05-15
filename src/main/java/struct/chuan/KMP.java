package struct.chuan;

/**
 * Created by xiaozl on 2016/5/3.
 */
public class KMP {

    void getNext(String pattern, int next[]) {
        int j = 0;
        // k其实代表的是要比较的前缀字符串的索引：abca 当k = 0 ，i=3时
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {

                j++;
                k++;
                next[j] = k;
            } else {

                // 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
                // p[0——k-1]的前缀和后缀的最长共有长度也是当前遍历的j应该和哪个元素比较，所接下来可以直接比较p[next[k]]和p[j]
                // j 取值len-1的时候是j++取得的，如果while的判断条件是len下标会越界
                k = next[k];
            }
            System.out.println(j);
        }
        System.out.println("");
    }

    int kmp(String s, String pattern) {
        int i = 0;
        // 模式串的下标
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];

        getNext(pattern, next);

        while (i < slen && j < plen) {

            if (s.charAt(i) == pattern.charAt(j)) {
                // i值增加只会在有元素匹配的时候，或者是元素需要从pattern的第一个字符开始匹配的时候
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    // j值赋0的原因是，取得pattern串的第一个元素
                    j = 0;
                } else {
                    // j决定的是下一步被匹配串S从什么位置和匹配串T比较
                    j = next[j];
                }

            }

            if (j == plen) {
                // 如果匹配返回匹配的位置
                return i - j;
            }
        }
        // 不匹配返回1
        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KMP kmp = new KMP();
        String str = "agctagcbdbagtagctagca";
        String pattern = "abgabgbc";
        System.out.println(kmp.kmp(str, pattern));
    }

}