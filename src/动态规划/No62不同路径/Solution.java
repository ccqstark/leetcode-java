package 动态规划.No62不同路径;

// 本题用深搜会超时，除了dp是可以用数论（组合）
public class Solution {
    // m是列，n是行
    public int uniquePaths(int m, int n) {
        // dp数组代表从起始点走到dp[i][j]有几种路径
        int[][] dp = new int[n][m];
        // 一直在2个方向直走的都只有一种走法
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        // 填充dp数组
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 递推公式，到达某一个位置可以从其左边或者上边走过来
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // 最后返回终点位置即可
        return dp[n-1][m-1];
    }
}
