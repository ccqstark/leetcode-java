package 动态规划.No674最长连续递增序列;

import java.util.Arrays;

/**
 * @author ccqstark
 * @description 本题是No300最长递增子序列的连续版本，只需在原来的基础上改下递推公式和循环就可以了
 * @date 2022/1/4 14:25
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            // 原本的两层循环这里只需要一层，由于是连续的，之前的j就改成i-1即可
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }
}
