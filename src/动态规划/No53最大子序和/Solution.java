package 动态规划.No53最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        // dp[i]的含义就是包含dp[i]作为尾元素的子序列的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            // 以上一个元素结尾的子序列+本元素 or 本元素单个（重启序列）
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 因为dp数组的定义，所以这里要不断去更新最大值
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }
}
