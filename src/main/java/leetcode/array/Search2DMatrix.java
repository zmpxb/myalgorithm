package leetcode.array;

/**
 * Search2DMatrix
 *
 * @author xiaozl
 * @date: 2016/5/26
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int [] nums = {1,10,23};
        int [] nums1 = {7,20,50};
        int [][] nums2 = {{1,   3,  5,  7},
                {10, 11, 16, 20},
        {23, 30, 34, 50}};

        //int [][] nums2 = {{1,   3,  5}};
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums2[0].length; j++) {
                System.out.println(searchMatrix1(nums2,nums2[i][j]));
            }
        }


    }

    /**
     * 方法1 看到排序后的数组，想到二分查找，对第一个列向量和最后一个列向量进行二分查找，确定要找的所在的行，再对这一行进行二分查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        } else if (matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int mid,mid1,mid2;
        mid1 = binarySearch1(matrix,target,m);
        mid2 = binarySearch2(matrix,target,m);
        if (matrix[mid1][0]==target || matrix[mid2][n-1]==target){
            return true;
        } else if (matrix[mid1][0]<target){
            int low = 0;
            int high = n - 1;
            mid = (low + high) / 2;
            while (low <= high){
                if (matrix[mid1][mid] == target){
                    return true;
                }
                if (matrix[mid1][mid] < target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                mid = (low + high) / 2;
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * 在第一个列向量中查找元素位置
     * @param nums
     * @param elem
     * @param m
     * @return
     */
    public static int binarySearch1(int [][] nums, int elem,int m){
        int low = 0;
        int high = m - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid][0] == elem){
                return mid;
            }
            if (nums[mid][0]<elem){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    /**
     * 在最后一个列向量中查找元素位置
     * @param nums
     * @param elem
     * @param m
     * @return
     */
    public static int binarySearch2(int [][] nums, int elem,int m){
        int low = 0;
        int high = m - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid][nums[0].length-1] == elem){
                return mid;
            }
            if (nums[mid][nums[0].length-1]<elem){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    /**
     * 利用了矩阵中元素的元素的规律
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        } else if (matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int n = 0,m = column -1;
        while (n<row && m>= 0){
            if (target == matrix[n][m]){
                return true;
            } else if (target < matrix[n][m]){
                m--;
            } else {
                n++;
            }
        }

        return false;
    }


}
