package 贪心.No714买卖股票的最佳时机含手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {

        int result = 0;
        int miniPrices = prices[0]; // 记录买入点

        for (int i = 1; i < prices.length; i++) {
            // 更新买入点（即买入）
            if (prices[i] < miniPrices) {
                miniPrices = prices[i];
            }
            // 判断到当前价格减去买入点再减去手续费还有收益
            if (prices[i] > miniPrices && prices[i] - miniPrices - fee > 0) {
                // 收益增加
                result += prices[i] - miniPrices - fee;
                // 这一步很重要
                // 通过将新的买入点设置为prices[i] - fee，来应对是否把这个收益区间分2段买还是合成一段买
                // 假设要分成2段买，那在更新买入点的时候当前价格就要比这个还要低，说明我多买一段的收益可以抵扣（大于）多买一次的代价（fee），此时多买一次总收益更多
                // 假设在此收益区间中没能再更新买入点，那就是合成一段买，这里-fee还保证了下一次算增加收益的时候不会多扣一次手续费，因为已经合成一段买了
                // 所以这里非常巧妙
                miniPrices = prices[i] - fee;
            }
        }

        return result;
    }
}
