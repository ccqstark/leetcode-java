package 动态规划.No714买卖股票的最佳时机含手续费;

/**
 * @author ccqstark
 * @description 本题贪心时也写过，同时在动规系列中和股票II区别只是多了一个手续费而已
 * 代码上除了多了个-fee之外其它都一样
 * @date 2022/1/4 00:47
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        // 买入时就支付手续费(这里不要漏)
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            // 买入时就支付手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            // 如果是卖出时才支付手续费，那就只需在这里-fee就行
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
