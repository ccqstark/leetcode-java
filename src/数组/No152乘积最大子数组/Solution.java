package 数组.No152乘积最大子数组;

public class Solution {
    // 动态规划
    public int maxProduct(int[] nums) {
        // fmax[i]: 以nums[i]结尾的数组的最大乘积
        int[] fmax = new int[nums.length];
        // fmin[i]: 以nums[i]结尾的数组的最小乘积
        int[] fmin = new int[nums.length];
        // 初始化为第一个数
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 三个数中求最大：fmax[i-1]与当前数的乘积；fmin[i-1]与当前数的乘积；当前数
            fmax[i] = Math.max(fmax[i-1] * nums[i], Math.max(fmin[i-1] * nums[i], nums[i]));
            // 更新最大值
            if (fmax[i] > ans) ans = fmax[i];
            // 三个数中求最小：fmax[i-1]与当前数的乘积；fmin[i-1]与当前数的乘积；当前数
            // 求这个最小值是为了防止出现负数，负数乘负数也可能出现最大值
            fmin[i] =  Math.min(fmax[i-1] * nums[i], Math.min(fmin[i-1] * nums[i], nums[i]));
        }

        return ans;
    }

    // 优化存储空间
    public int maxProduct2(int[] nums) {
        int fmax = nums[0];
        int fmin = nums[0];
        int ans = fmax;
        for (int i = 1; i < nums.length; i++) {
            int oldFmax = fmax;
            fmax = Math.max(fmax * nums[i], Math.max(fmin * nums[i], nums[i]));
            if (fmax > ans) ans = fmax;
            fmin =  Math.min(oldFmax * nums[i], Math.min(fmin * nums[i], nums[i]));
        }

        return ans;
    }

}
