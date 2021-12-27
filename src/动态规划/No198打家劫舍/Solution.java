package 动态规划.No198打家劫舍;

public class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // dp[i - 1]表示第i间房不偷，所以可以考虑[1,i-1]间房
            // dp[i - 2] + nums[i]表示第i间要偷，所以i-1就不能偷了，只能是[1,i-2]，然后再加上第i间的收获
            // 所以就是第i间偷与不偷两种情况中的最大值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

}
