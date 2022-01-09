package 动态规划.No72编辑距离;

public class Solution {

    public int minDistance(String word1, String word2) {

        // dp[i][j]表示以word1的i-1和word2的j-1下标结尾的字符串，要变成相同的字符串，所需的最少插入、修改、删除步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 经典初始化不多说
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 尾字符相同则不操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /**
                     * 插入的理解是，等于对目标字符串的删除
                     */
                    //                     修改                          删除                 插入
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

}
