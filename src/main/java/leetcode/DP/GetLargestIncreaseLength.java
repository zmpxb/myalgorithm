package leetcode.DP;

/**
 * Created by xiaozl on 2016/10/24.
 */
public class GetLargestIncreaseLength {

    public static void main(String[] args) {
        int [] a = {5,3,4,8,6,7};
       getLength(a,6);
    }


    public static int getLength(int A[],int n){
        int [] d = new int[n];
        int len = 1;
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0;j < i;++j){
                // 到这一步时d[i]的初始值为1
                if (A[j]<=A[i] && d[j]+1>d[i]){
                    d[i] = d[j] + 1;
                }
            }
            if (d[i] > len){
                len = d[i];
            }
        }
        for (int z : d){
            System.out.println(z);
        }
        return len;
    }

}

class xiao{

}