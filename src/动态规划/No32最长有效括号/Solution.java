package 动态规划.No32最长有效括号;

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        // 特殊长度特判一下
        if (n == 0 || n == 1) return 0;
        char[] arr = s.toCharArray();
        // dp[i]表示以arr[i]结尾的字符串中，最长的有效括号长度
        int[] dp = new int[n];
        // 因为下面动规需要用到i-2，所以初始化到dp[1]
        dp[1] = arr[0] == '(' && arr[1] == ')' ? 2 : 0;
        int max = dp[1]; // 全局最大值

        for (int i = 2; i < n; i++) {
            // (( 或 )( ，直接长度为0
            if (arr[i] == '(') dp[i] = 0;
            // 下面说明arr[i]是 )
            else {
                // 遇到()，就是dp[i-2]加上现在这一个有效括号长度2
                if (arr[i - 1] == '(') dp[i] = dp[i - 2] + 2;
                    //                                    👇
                    // 遇到))，由于前面情况应该是这样   ?((...))
                    // 手指指向i，dp[i-1]表示(...)中的有效括号长度
                    // i - dp[i-1] -1 就是上图中?号右边的那个括号，也就是要和arr[i]进行匹配的那一半括号
                    // ?代表再往前面可能的一些情况
                else {
                    // 前面不够越界了或者不能和arr[i]形成有效括号，dp直接为0
                    if (i - dp[i - 1] - 1 < 0 || arr[i - dp[i - 1] - 1] == ')') dp[i] = 0;
                    // 到下面就说明arr[i - dp[i - 1] - 1]与arr[i]匹配上了
                    // 这里是判断?号位置是否存在，?的下标就是i - dp[i - 1] - 2
                    // 存在那么结果就是三个部分，? + 2 + dp[i-1]，这个2就是arr[i - dp[i - 1] - 1]与arr[i]
                    // 如果小于0越界了，那么结果只有两部分也就是不存在?那部分，就是2 + dp[i - 1]
                    else dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] + 2 + dp[i - 1] : 2 + dp[i - 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
