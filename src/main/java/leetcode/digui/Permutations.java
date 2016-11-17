package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozl on 2016/10/14.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations d = new Permutations();
        int [] num = {1,2,3};
        d.permute1(num);
        System.out.println("x");
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]){
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == nums[i]
                            || nums[k] == nums[j]){
                        continue;
                    }
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }



    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null
                || nums.length == 0){
            return result;
        }
        dfs(0,nums,result);
        return result;
    }

    public void dfs(int i,int [] num,List<List<Integer>> result){
        if (i == num.length){
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j++) {
                tmp.add(num[j]);
            }
            result.add(tmp);
        }
        for (int j = i;j<num.length;j++){
            int tmp = num[i];
            num[i]  = num[j];
            num[j]  = tmp;
            dfs(i+1,num,result);
            tmp = num[i];
            num[i]  = num[j];
            num[j]  = tmp;
        }
    }

}
