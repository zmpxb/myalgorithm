package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozl on 2016/9/29.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> pathList = new ArrayList<Integer>();
        if (root == null){
            return resultList;
        }
        DFS(sum,0,root,resultList,pathList);
        return resultList;
    }

    public void DFS(int target,
                       int sum,
                       TreeNode root,
                       List<List<Integer>> resultList,
                       List<Integer> pathList){
        if (root != null){
            sum = sum + root.val;
            pathList.add(root.val);
            if (root.left == null
                    && root.right == null){
                if (sum == target){
                    List<Integer> pathList1 = new ArrayList<Integer>();
                    for (Integer value : pathList){
                        pathList1.add(value);
                    }
                    resultList.add(pathList1);
                }
            }
            DFS(target,sum,root.left,resultList,pathList);
            DFS(target,sum ,root.right,resultList,pathList);
            pathList.remove(pathList.size()-1);
        }
    }


}

