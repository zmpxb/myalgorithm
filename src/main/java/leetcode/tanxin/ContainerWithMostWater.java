package leetcode.tanxin;

/**
 * Created by xiaozl on 2016/10/20.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int [] height = {1,2,3,4,5,6,7,8};
//        System.out.println(maxArea(height));
        float a = 23.3F;
        double b = 23.3;
        double c = 1/3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int result = Integer.MIN_VALUE;
        while (start<end){
            int area = Math.min(height[end],height[start]*(end - start));
            result = Math.max(result,area);
            if (height[start] <= height[end]){
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

}
