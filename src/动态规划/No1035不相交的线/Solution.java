package 动态规划.No1035不相交的线;

/**
 * @author ccqstark
 * @description 这题就是求最长公共子序列，代码和No1143一模一样
 * @date 2022/1/5 15:55
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
