package 动态规划.No115不同的子序列;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 这里是子串为空，母串不为空的初始化，母串全删了可以得到空串子串，所以有一种变换方法
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        // 空串变空串，有且只有一种情况
        dp[0][0] = 1;
        // 如果母串为空，子串不为空，那母串必不包含子串的，所以dp[0][j]都为0，这里省略初始化

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 这里两种情况
                // 1. 如果当前的字符相同，则当前的dp[i][j] = 利用最后这个字符匹配 + 不用最后这个字符匹配
                // 2. 如果当前这个字符不相同，那就不能利用最后这个字符匹配了，所以只能使用dp[i - 1][j]，也就是相当于子串相同情况下，母串删掉最后一个不影响结果
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
