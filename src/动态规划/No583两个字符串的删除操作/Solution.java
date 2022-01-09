package 动态规划.No583两个字符串的删除操作;

public class Solution {
    public int minDistance(String word1, String word2) {

        // dp[i][j]表示以word1的i-1和word2的j-1下标结尾的字符串，要变成相同的字符串，所需的最少删除步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化，要变成空字符串，自然要删除对应非空字符串的长度
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 尾字符相同，不用操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /**
                     * 这里3种情况
                     * 1. 删除i的最后一个 dp[i - 1][j] + 1
                     * 2. 删除j的最后一个 dp[i][j - 1] + 1
                     * 3. 两边都删最后一个 dp[i - 1][j - 1] + 2
                     */
                    // 当前要删除步骤就是后面的+1和+2，然后转换为上一个状态就可以用上一个状态的转换步骤了
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
