package 动态规划.No494目标和;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 核心在于，定义附上加号的为left，减号的为right，则:
        // left - right = target
        // right = sum - left
        // 所以: left - (sum - left) = target
        // 变换一下得 left = (sum + target) / 2
        // 我们的目标就是为了找到哪些元素加起来等于left，有点类似组合总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 目标值绝对值比所有元素之和都大，那就一种答案都没有
        if (Math.abs(target) > sum) {
            return 0;
        }
        // 这里说明left为奇数，也是没有答案
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        // 为偶数，求出我们的left
        int left = (sum + target) / 2;
        // 背包容量为left，初始化dp数组，代表容量为j的背包，有dp[j]种方法
        int[] dp = new int[left + 1];
        // 这里必须让dp[0]初始化为1，因为只有0种物品一种装法，这里初始化为1才能保证最后结果不是都为0
        dp[0] = 1;

        // 外层是物品
        for (int i = 0; i < nums.length; i++) {
            // 内层是背包容量，一维的，所以要从后往前
            for (int j = left; j >= nums[i]; j--) {
                // 为了比较好解释，写成二维的形式：
                // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
                // 当前用1到i种物品达到容量j的方法 =
                // 用1到i-1种物品达到j容量的方法数(即没选nums[i]的情况) +
                // 达到j-nums[i]容量的方法数(即选了nums[i]的情况,因为这种情况选了nums[i]就刚好达到j了)
                dp[j] += dp[j - nums[i]];
            }
        }
        // 答案就在left处，因为我们就是在找和为left的组合数
        return dp[left];
    }
}
