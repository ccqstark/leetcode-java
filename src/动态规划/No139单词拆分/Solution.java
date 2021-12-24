package 动态规划.No139单词拆分;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // 注意，这里dp[i]表示的是"长度为i"的字符串是否可以拆分，而不是下标从0到i的字符串
        boolean[] dp = new boolean[s.length() + 1];
        // 这里初始化要为true，否则后面都不可能出现true
        dp[0] = true;

        // 这里的思路就是，遍历长度，每一个长度再用一个j指针进行切分
        // 判断：如果dp[j]为true（即下标[0,j-1]的字符串可以拆分），且下标为[j,i-1]的字符串是词典中有的词
        // 则说明dp[i]为true（即长度为i（下标为[0,i-1]）的字符串可以拆分）
        // 本质上还是要遍历然后一点点去切分去判断，只不过判断的过程中有dp数组辅助，一刀两段后左边用dp判断，右边看词典
        for (int i = 1; i <= s.length(); i++) {
            // 这里比较容易想绕的就是i和j表示的都是长度，而非下标
            // j是当前切分后，左半段的长度（即[0,j-1]的字符串）
            for (int j = 0; j < i; j++) {
                // 这个substring切出的word是右半段，即[j,i-1]的字符串（substring方法是左闭右开的）
                String word = s.substring(j, i);
                if (wordDict.contains(word) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
