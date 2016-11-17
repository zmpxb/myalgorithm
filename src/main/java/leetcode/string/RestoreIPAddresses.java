package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozl on 2016/10/14.
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses er = new RestoreIPAddresses();
        er.restoreIpAddresses1("101023");
        System.out.println("xiao");
    }

    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<String>();
        /**
         * 初始传入的字符串长度只能为4-12
         */
        addDot(s,"",3);

        return list;
    }
    /**
     *
     * @param s 需要处理的字符串
     * @param result 装载结果的字符串
     * @param k 当前还有几个"."
     */
    private void addDot(String s,String result, int k){

        //传入字符串必须合法
        if(s.length() <= k){
            return;
        }
        if(s.length() > 3*(k+1)){
            return;
        }
        if(k == 0){//最后一段，判断小于256
            if((s.charAt(0) == '0' && s.length() > 1 ) || Integer.parseInt(s) >= 256)
                return;
            list.add(result + "." + s);
            return;
        }
        //遍历前面3位，如果小于256，则参与递归
        for(int i = 1; i <= s.length(); i++){
            String temp = s.substring(0,i);//当前段小于256，表示合法，可以继续
            if(Integer.parseInt(temp) < 256){
                String str = s.substring(i);
                //分情况，如果result为空，则前面不加"."
                if(result.length() > 0){
                    temp = result + "." + temp;
                }
                addDot(str,temp, k-1);
                //如果第一个数字为0，则不再继续循环
                if(s.charAt(0) == '0'){
                    break;
                }
            }else{
                break;
            }
        }
    }

    public List<String> restoreIpAddresses1(String s) {
        List<String> list = new ArrayList<String>();
        if (s.length() < 3
                || s.length()>12){
            return list;
        }
        try {
            for (int i = 0; i < 3; i++) {
                int z = i + 3;
                if (z>s.length()){
                    z = s.length();
                }
                for (int j = i + 1; j <= z; j++) {
                    int n = j + 3;
                    if (n>s.length()){
                        n = s.length();
                    }
                    for (int k = j + 1; k <= n; k++) {
                        int m = k + 3;
                        if (m>s.length()){
                            m = s.length();
                        }
                        for (int l = k + 1; l <= m; l++) {
                            String ip1 = s.substring(0, j);
                            String ip2 = s.substring(j, k);
                            String ip3 = s.substring(k, l);
                            String ip4 = s.substring(l, s.length());
                            System.out.println("xiao");
                            if (check(ip1) && check(ip2) && check(ip3) && check(ip4)) {
                                String ip = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
                                if (!list.contains(ip)) {
                                    list.add(ip);
                                }
                            }
                        }

                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static boolean check(String ip)
    {
        if (ip.equals("")){
            return false;
        }
        int value = Integer.valueOf(ip);
        if(ip.charAt(0) == '0')
        {
            return (ip.length() == 1);
        } else {
            if(value <= 255)
                return true;
            else
                return false;
        }
    }
}
