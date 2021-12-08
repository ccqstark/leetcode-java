package 动态规划.No63不同路径II;

/**
 * @author ccqstark
 * @description 与上一题区别在于多了个路障，路障位置dp为0表示不可达即可
 * @date 2021/12/8 10:07
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // m为行数，n为列数
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp数组代表从起始点走到dp[i][j]有几种路径
        int[][] dp = new int[m][n];
        // 这里遇到路障就结束循环，因为路障后面的不可达，dp值就为默认0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 填充dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 同样遇到路障就跳过，路障不可达dp为0
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                // 递推公式，到达某一个位置可以从其左边或者上边走过来
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 最后返回终点位置即可
        return dp[m - 1][n - 1];
    }
}
