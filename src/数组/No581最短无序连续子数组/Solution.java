package 数组.No581最短无序连续子数组;

// 分为左、中、右三段，中段就是最小需要排序的子数组
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        // 从左到右维护一个max，从右到左维护一个min
        int min = nums[n - 1];
        int max = nums[0];
        // begin和end分别是中段的左右边界
        int begin = 1, end = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                // 最后一个小于当前max的位置，就是右边界
                end = i;
            }

            if (nums[n - 1 - i] <= min) {
                min = nums[n - 1 - i];
            } else {
                // 最后一个大于当前min的位置，就是左边界
                begin = n - 1 - i;
            }
        }
        // 为保证当中段就是整个数组的情况结果为0，所以初始化如上所示（如果是这种情况那么begin和end从头到尾没修改过）
        return end - begin + 1;
    }
}
