package 动态规划.No518零钱兑换II;

/**
 * @author ccqstark
 * @description 比较典型的一道完全背包问题
 * @date 2021/12/23 21:28
 */
public class Solution {
    public int change(int amount, int[] coins) {

        // dp[i]表示达到金额i有dp[i]种面值组合
        int[] dp = new int[amount + 1];
        // 这个初始化之前说过（No494目标和），保证不全为0，语义就是达到容量0有1种方法就是放0个物品
        dp[0] = 1;

        // 注意：外层循环是物品，内层是背包容量，就是求组合数
        // 外层是背包容量，内层是物品，求得的是排列数
        for (int i = 0; i < coins.length; i++) {
            // 这里是完全背包，每种物品coin有无限个，所以是从左到右的
            for (int j = coins[i]; j <= amount; j++) {
                // 求的是组合数、方案数就用这种形式的递推，原来那种是求最大值的
                dp[j] += dp[j - coins[i]];
            }
        }

        // 达到金额amount有dp[amount]种面值组合，答案就在dp[amount]处
        return dp[amount];
    }
}
