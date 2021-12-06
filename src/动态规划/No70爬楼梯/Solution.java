package 动态规划.No70爬楼梯;

/**
 * @author ccqstark
 * @description 第n层楼梯的爬法数可以由第n-1和n-2层的爬法数之和所得，因为n-1就再爬一层，n-2就再爬两层（最后递推就是斐波那契数列）
 * @date 2021/12/6 22:08
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // stairs[i]表示爬到第i层有多少种方法，因此i等于0时没有任何意义！
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 空间优化
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return dp[2];
    }

}
