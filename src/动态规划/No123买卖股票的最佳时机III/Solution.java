package 动态规划.No123买卖股票的最佳时机III;

public class Solution {
    public int maxProfit(int[] prices) {

        /**
         * 五个状态
         * 0 没有操作
         * 1 第一次买入
         * 2 第一次卖出
         * 3 第二次买入
         * 4 第二次卖出
         */
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        // 除了没有操作之外，其它的都是在"保持前一天现状"与"在前一天的上一种状态下进行当前操作"
        // 这两种选择种取更有利的一种
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        // 最终答案是卖出二次之后的现金
        return dp[prices.length - 1][4];
    }
}
