package 动态规划.No322零钱兑换;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        // 由于要求的是最小值，所以下面用min，为了防止被初始值覆盖，所以这里要初始为最大的int值
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 0元需要0个硬币，这也是后面产生正常数据的起点
        dp[0] = 0;

        // 由于求的是组合数，所以是外层物品内层容量
        for (int i = 0; i < coins.length; i++) {
            // 硬币无限，完全背包，从前往后
            for (int j = coins[i]; j <= amount; j++) {
                // 注意这里要判断一下，不然dp[j - coins[i]] + 1会超出int范围变为负数，然后因为求min而填入dp
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    // 求最少组合数，用min
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        // 没有任何一种硬币组合能组成总金额，返回 -1
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
