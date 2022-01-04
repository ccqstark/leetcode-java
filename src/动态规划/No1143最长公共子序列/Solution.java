package 动态规划.No1143最长公共子序列;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // dp[i][j]的含义就是字符串1的0到i-1下标，和字符串2的0到j-1下标，最长的公共子序列
        // 注意，和之前很多题不同的是，这里不再一定包含尾元素，所以最后答案是在右下角，而不是用一个result变量一直去更新为最大值
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // 如果相等，那就是左上角的+1了(因为dp[i-1][j]和dp[i][j-1]最大也就和dp[i-1][j-1]+1一样大，所以这里不用再考虑它们俩)
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不想等的话，就是上边和左边的取最大的那个
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
