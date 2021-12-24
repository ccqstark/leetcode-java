package 动态规划.No377组合总和Ⅳ;

/**
 * @author ccqstark
 * @description 这题就是经典的完全背包+求排列
 * @date 2021/12/24 12:48
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 这里不多解释了，经典操作
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 注意遍历顺序，由于这里求的是排列，所以外层是背包容量，内层才是物品
        for (int i = 0; i <= target; i++) {
            // 完全背包，所以是从前往后
            for (int j = 0; j < nums.length; j++) {
                // 这里要判断一下i够不够减nums[j]
                if (i >= nums[j]) {
                    // 求方案数，用这种递推公式，注意i和j的位置
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
