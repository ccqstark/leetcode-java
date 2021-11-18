package 贪心.No122买卖股票的最佳时机II;

/**
 * 这道题只需要把两天差为正数的差额加起来即可
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profile = prices[i + 1] - prices[i];
            if (profile > 0) {
                maxprofit += profile;
            }
        }
        return maxprofit;
    }
}
