package 动态规划.No343整数拆分;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 从2开始初始化，0和1没有意义
        dp[2] = 1;
        // i从3开始直到n
        for (int i = 3; i <= n; i++) {
            // j < i-1 是因为让j最大只能为i-2，这样下面拿到dp[i-j]就最小只能到dp[2]，不会变成无意义的dp[0]和dp[1]
            for (int j = 1; j < i - 1; j++) {
                // j * (i - j) 相当于直接拆成2个数
                // dp[i - j] * j 则是拆成3个及以上，并利用之前计算的结果
                // 因为同一个dp[i]要经历多个j的计算选出最大的，所以比较的时候要带上dp[i]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
            // j不用拆是因为在遍历过程中，j从小到大，其实把他拆的情况转移到dp[i-j]的拆的情况了，其实以及包含在里面了
        }

        return dp[n];
    }
}
