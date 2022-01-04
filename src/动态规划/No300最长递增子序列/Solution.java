package 动态规划.No300最长递增子序列;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 初始化至少为1，因为单调子序列长度最小为1
        // dp[i]表示i之前包括i的最长上升子序列的长度，注意是包括i的
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            // 遍历当前桶位之前的每个桶位
            for (int j = 0; j < i; j++) {
                // 遇到比当前数小的
                if (nums[i] > nums[j]) {
                    // 进行一个比较（保持当前 or 之前桶位值+1）
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 保持result是dp中最大的元素，也就是最长的子序列
            // 因为dp数组的含义，最长子序列不一定包括最后一个元素，所以答案不是dp[nums.length-1]
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }
}
