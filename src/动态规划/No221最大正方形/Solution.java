package 动态规划.No221最大正方形;

/**
 * 其实一开始就想到和正确dp解法相似的思（毕竟矩阵很容易联想到），可惜没有继续想完整下去
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 多加一行一列是为了第0行和第0列不用特判
        int[][] dp = new int[n + 1][m + 1];
        int maxSide = 0; // 表示最长边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 当前格若为1，则以它为右下角的最大正方形的边长为：它的左，上，左上角最小的那个+1（画图才能理解）
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(dp[i + 1][j + 1], maxSide);
                }
            }
        }
        // 最后求的是面积
        return maxSide * maxSide;
    }
}
