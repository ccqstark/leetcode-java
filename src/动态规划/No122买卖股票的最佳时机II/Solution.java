package 动态规划.No122买卖股票的最佳时机II;

/**
 * @author ccqstark
 * @description 这题之前贪心做过
 * @date 2021/12/27 22:21
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        /**
         * 与No121买卖股票的最佳时机的区别只在于能不能多次交易
         */
        for (int i = 1; i < prices.length; i++) {
            // 持有情况：dp[i - 1][0]表示继续持有，dp[i-1][1]-prices[i]表示买入股票
            /**
             * 所以与第一版的区别只在于买入股票变成了dp[i - 1][1] - prices[i]
             * 因为可以有多次交易，所以买入时可能之前已经积累了现金dp[i - 1][1]
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 不持有情况：dp[i - 1][1]表示继续不持有，prices[i] + dp[i - 1][0]表示卖出股票
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        // 最后不持有的话肯定比持有股票有利
        return dp[prices.length - 1][1];
    }
}
