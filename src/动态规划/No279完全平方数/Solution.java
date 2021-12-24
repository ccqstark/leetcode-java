package 动态规划.No279完全平方数;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        // 求最小，所以填充最大
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 这里内外无所谓，因为求的最小，这里外层是背包容量方便点
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 没啥好说的，物品就是这些平方数呗
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
