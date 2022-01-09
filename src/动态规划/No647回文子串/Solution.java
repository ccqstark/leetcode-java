package 动态规划.No647回文子串;

public class Solution {
    public int countSubstrings(String s) {

        // dp[i][j]表示下标为i到j的字符串是否为回文串（左闭右闭）
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 表示回文子串的数量
        int result = 0;

        // 因为下面用到了dp[i + 1][j - 1]，也就是"去头去尾"了，所以要从下到上，从左到右遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            // 因为j一定是大于i的，所以j的初始值为i
            for (int j = i; j < s.length(); j++) {
                // 首尾不一致时dp一定为false，因为初始化就为false所以这里就省略了
                // 首尾一致时
                if (s.charAt(i) == s.charAt(j)) {
                    // 情况一：i和j相差小于等于1，也就是a和aa类型
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        // 如果是长度为3以上，那么就看看"去头去尾"之后的子串是否回文
                        // 是的话i到j也是回文
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return result;
    }
}
