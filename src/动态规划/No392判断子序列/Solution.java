package 动态规划.No392判断子序列;

public class Solution {
    public boolean isSubsequence(String s, String t) {

        // 这题是"编辑距离"的缩减版，相当于只有删除
        // 但是前面的思路和最长子序列很像
        // dp数组的含义就是示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 长度这里依旧是+1，减少第0行和第0列的初始化工作

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 这里就是经典操作了，子序列长度+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这里就是"删除"，这样理解：
                    // 由于s下标i-1和下标j-1的字符不一样，所以dp[i][j]其实是和dp[i][j-1](也就是和t去删除一个字母的结果是一样的)
                    // 也就是最后这个字母没有影响，因为都不相等，不影响最长子序列长度
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // 最后判断s是否为t的子序列就是判断最右下角的元素，是否等于s的长度，也就是最长子序列的长度是不是就是s的长度
        return dp[s.length()][t.length()] == s.length();
    }
}
