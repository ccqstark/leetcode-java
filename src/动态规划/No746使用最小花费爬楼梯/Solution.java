package 动态规划.No746使用最小花费爬楼梯;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 这道题表述有点问题，可以直接理解为第一步是需要花费体力，最后一步是不用的
        // 到达了非楼顶的第i层楼都要先花费cost[i]的体力，再去想走一步还是两步
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            // 所以这里最后是加cost[i]
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        // 最后一步不需要花费，所以看最后走一步的划算还是走两步的划算
        return Math.min(dp[n-1], dp[n-2]);
    }
}
