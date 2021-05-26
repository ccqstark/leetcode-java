package 数组.No209长度最小的子数组;

import java.util.Arrays;

public class MinSubArrayLen {

    // 滑动窗口
    public int minSubArrayLen1(int target, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int s = nums[0];
        int windowLen = Integer.MAX_VALUE;

        while (right < nums.length - 1) {
            // 右指针
            while (s < target && right < nums.length - 1) {
                right++;
                s += nums[right];
            }
            // 左指针
            while (s >= target) {
                windowLen = Math.min(windowLen, right - left + 1);
                s -= nums[left];
                left++;
            }
        }

        return windowLen == Integer.MAX_VALUE ? 0 : windowLen;
    }

    // 前缀+二分搜索
    public int minSubArrayLen2(int target, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int windowLen = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 前i个数之和
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int s = target + sums[i];
            // 二分搜索
            int bound = Arrays.binarySearch(sums, s);
            // bound为负数表示找不到，返回的是插入位置，且从1开始
            if (bound < 0) {
                bound = -bound - 1;
            }
            // 找到最小的
            if (bound <= n) {
                windowLen = Math.min(windowLen, bound - i);
            }
        }
        return windowLen == Integer.MAX_VALUE ? 0 : windowLen;
    }

}
