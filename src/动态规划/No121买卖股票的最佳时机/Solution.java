package 动态规划.No121买卖股票的最佳时机;

public class Solution {

    /**
     * 贪心法
     */
    public int maxProfit1(int[] prices) {
        // 左边的最小值
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]); // 遍历每次都进行比较最低值
            result = Math.max(result, prices[i]-low); // 遍历每次都进行计算，比较最大差值
        }

        return result;
    }

    /**
     * dp法
     */
    public int maxProfit2(int[] prices) {
        // dp[i][0]表示持有股票时拥有的现金
        // dp[i][1]表示不持有股票时拥有的现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有情况：dp[i - 1][0]表示继续持有，-prices[i]表示买入股票
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 不持有情况：dp[i - 1][1]表示继续不持有，prices[i] + dp[i - 1][0]表示卖出股票
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        // 最后不持有的话肯定比持有股票有利
        return dp[prices.length - 1][1];
    }

}
