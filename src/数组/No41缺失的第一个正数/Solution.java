package 数组.No41缺失的第一个正数;

/**
 * 实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1, N+1] 中。
 * 这是因为如果 [1, N] 都出现了，那么答案是 N+1，否则答案是 [1, N] 中没有出现的最小正整数。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // 我们将数组中所有小于等于0的数修改为N+1，使得不会和后面和负数标记弄混
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 先取得绝对值，因为该位置上的数可能已经被负数标记了
        // 然后如果绝对值在[1,n]范围类，就把对应nums下标的位置标为负数，记得下标先减1
        for (int i = 0; i < n; i++) {
            int absi = Math.abs(nums[i]);
            // nums[absi - 1] > 0 是避免已经为负数的负负得正
            if (absi >= 1 && absi <= n && nums[absi - 1] > 0) {
                nums[absi - 1] *= -1;
            }
        }

        // 最后再遍历一遍，第一个没有被标记为负数的下标+1说明就是最小的正整数了
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 如果全部都被标为负数了，那么最小的正整数就是n+1
        return n + 1;
    }
}
