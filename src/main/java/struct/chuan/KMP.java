package struct.chuan;

/**
 * Created by xiaozl on 2016/5/3.
 */
public class KMP {



    void getNext(String pattern, int next[]) {
        int j = 0;
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
                // p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]
                k = next[k];
            }
        }
        System.out.println("");
    }

    int kmp(String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];

        getNext(pattern, next);

        while (i < slen && j < plen) {

            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
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
        String pattern = "agctagca";
        System.out.println(kmp.kmp(str, pattern));
    }

}