package 动态规划.No718最长重复子数组;

public class Solution {
    /**
     * 二维数组法
     */
    public int findLength(int[] nums1, int[] nums2) {

        // dp[i][j]含义：以下标i-1为结尾的A，和以下标j-1为结尾的B，最长重复子数组长度为dp[i][j].
        // 注意，是一定dp数组的含义就是包含nums1[i-1]和nums2[j-1]的
        // 之所以是i-1和j-1而不是i和j是因为，这样做减少了很多初始化的工作（第0行和第0列的初始化）
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // 相等的话就+1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 在这个if里判断result是否更新而不是在外面判断可以提高效率
                    // 因为最大的值肯定出现在这个if里面，不进入这个if的dp[i][j]都是0（所以下面滚动数组的解法中要注意不相等的时候要赋值为0）
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                    }
                }
            }
        }

        return result;
    }

    /**
     * 滚动数组法（减少空间开销）
     */
    public int findLength2(int[] nums1, int[] nums2) {

        // 这里默认行为nums1，列为nums2
        int[] dp = new int[nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            // 滚动数组的话要从后往前遍历
            for (int j = nums2.length; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    if (dp[j] > result) {
                        result = dp[j];
                    }
                } else {
                    // 注意这里如果不相等要赋值为0
                    dp[j] = 0;
                }
            }
        }

        return result;
    }

}
