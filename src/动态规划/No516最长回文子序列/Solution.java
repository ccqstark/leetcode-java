package 动态规划.No516最长回文子序列;

public class Solution {
    public int longestPalindromeSubseq(String s) {

        // dp[i][j]表示在区间i到j内(闭区间)最长回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];
        // i==j的说明区间长度为1，一个字符回文子序列长度都为1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // s.length() - 2是因为dp[s.length() - 1][s.length() - 1]已经初始化过了
        for (int i = s.length() - 2; i >= 0; i--) {
            // j = i + 1是因为i==j初始化过了
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 头尾相等则长度为"去头去尾"+2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 头尾不相等则在"单去头"和"单去尾"总选最长的
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // 最终答案就是整个字符串范围的了
        return dp[0][s.length() - 1];
    }
}
