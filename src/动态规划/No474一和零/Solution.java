package 动态规划.No474一和零;

/**
 * @author ccqstark
 * @description 这题相当于重量有两个维度的01背包，物品就是这些字符串，背包容量就是m和n，重量的两个维度就分别是0和1的数量
 * @date 2021/12/23 20:37 
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        // dp[i][j]的意思是：在子集有i个0和j个1的情况下，子集的最大长度为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        // 遍历字符串数组
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            char[] chars = str.toCharArray();
            // 计算每个字符串0和1的数量
            for (char c : chars) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 这里内外顺序无所谓，但是要把m对应zeroNum，n对应oneNum不能错，题目是这么定义的
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    // 本质就是遍历每个字符串，然后在一次次迭代中更新dp数组
                    // 这个递推公式也还是内味，一个就是不选当前字符串，一个就是选的（没选之前的最佳情况加上选了之后的value）
                    // 选了的话就是dp[i - zeroNum][j - oneNum]（没选之前的最佳情况）去加上1，也就是子集长度+1
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
