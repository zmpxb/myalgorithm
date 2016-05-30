package leetcode.array;

/**
 * MaximalRectangle
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and
 return its area.
 这题是一道难度很大的题目， 至少我刚开始的时候完全不知道怎么做， 也是google了才知道的。
 这题要求在一个矩阵里面求出全部包含1的最大矩形面积， 譬如这个：
 0 0 0 0
 1 1 1 1
 1 1 1 0
 0 1 0 0
 我们可以知道， 最大的矩形面积为6。 也就是下图中虚线包围的区域。 那么我们如何得到这个区域呢？
 0 0 0 0
 |--------|
 |1 1 1 |1
 |1 1 1 |0
 |--------|
 0 1 0 0
 对于上面哪一题， 我们先去掉最下面的一行， 然后就可以发现， 它可以转化成一个直方图， 数据为[2, 2, 2,
 0]， 我们认为1就是高度， 如果碰到0， 譬如上面最右列， 则高度为0， 而计算这个直方图最大矩形面积就很
 容易了， 我们已经在Largest Rectangle in Histogram处理了。
 所以我们可以首先得到每一行的直方图， 分别求出改直方图的最大区域， 最后就能得到结果了
 * @author xiaozl
 * @date: 2a16/5/25
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char [][] matrix = {{'0','0','0','0'},
                {'1','1','1','1'},
                {'1','1','1','0'},
                {'0','1','0','0'}};
        char [][] matrix1 = {{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
        maximalRectangle(matrix1);
    }

    public static int maximalRectangle(char [][] matrix){
        if (matrix.length == 0){
            return 0;
        } else if (matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    // 代表该列值为0，bar高度为0
                    height[i][j] = 0;
                } else {
                    // 当在第一行时，没有前置结果直接赋0，当不在第一行是结果为当前位置上一行的bar高+1
                    height[i][j] = (i == 0) ? 1 : height[i-1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea,LargestRectangleInHistogram.getLargestArea2(height[i]));
        }
        return maxArea;
    }

}
