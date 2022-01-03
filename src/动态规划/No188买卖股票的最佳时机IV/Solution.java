package 动态规划.No188买卖股票的最佳时机IV;

/**
 * @author ccqstark
 * @description 和No123买卖股票的最佳时机III区别就在于交易的次数是传入参数k，我们用这个k来构造dp数组
 * @date 2022/1/3 22:03
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {

        // 股票长度为0，收益就为0
        if (prices.length == 0) {
            return 0;
        }

        // 初始化dp数组，列的数量就是交易次数*2加上无操作的1
        // 这里的意思是奇数列代表买入操作，偶数列代表卖出操作，而0就是无操作
        int[][] dp = new int[prices.length][2 * k + 1];

        // 初始化，所有奇数也就是买入操作，剩余现金都是负数，也就是买入了0号商品
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        // 外层遍历股票，内层就是不同的操作
        for (int i = 1; i < prices.length; i++) {
            // 注意这里是(2 * k + 1) -2 = 2 * k - 1
            for (int j = 0; j < 2 * k - 1; j += 2) {
                // 买入操作
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // 卖出操作
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }

        // 结果就在最右下角
        return dp[prices.length - 1][2 * k];
    }
}
