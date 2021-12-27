package 动态规划.No213打家劫舍II;

/**
 * @author ccqstark
 * @description 与打家劫舍I区别只在于是否成环
 * @date 2021/12/27 17:53
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        /**
         * 这里分2种情况，去头和去尾，同时去掉头尾的情况已经被包含在里面
         * 这2种情况的最大值就是答案
         */
        int noTail = robRanger(nums, 0, nums.length - 2);
        int noHead = robRanger(nums, 1, nums.length - 1);
        return Math.max(noTail, noHead);
    }

    /**
     * 这个是把打家劫舍I的代码封装成方法，接受指定范围
     */
    public int robRanger(int[] nums, int start, int end) {

        int length = end - start + 1;
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

}
