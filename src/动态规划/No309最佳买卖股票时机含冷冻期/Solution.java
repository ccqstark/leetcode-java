package 动态规划.No309最佳买卖股票时机含冷冻期;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // 4个状态4列
        int[][] dp = new int[n][4];
        // 初始化，买入状态金钱为负值
        dp[0][0] = -prices[0];

        /**
         * 0. 买入状态（可能是保持买入这个状态也就是之前买入的，也可能是当天买入）
         * 1. 卖出状态，此时已经度过冷冻期
         * 2. 卖出状态，今日卖出
         * 3. 冷冻状态
         */
        for (int i = 1; i < n; i++) {
            // 保持买入的状态 or 今日进行买入(状态1进行买入 or 状态3进行买入)
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            // 保持卖出状态(状态1 or 状态3)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 今日卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷冻期
            dp[i][3] = dp[i - 1][2];
        }

        // 最后一定是非买入状态，所以其它3个状态中取最大
        return Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3]));
    }
}
