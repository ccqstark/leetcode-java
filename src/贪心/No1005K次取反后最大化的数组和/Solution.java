package 贪心.No1005K次取反后最大化的数组和;

import java.util.Arrays;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

        if (nums.length == 0) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        int index = 0;
        // 先把尽量能转正的负数转了
        while (index < nums.length && k > 0 && nums[index] < 0) {
            nums[index] = -nums[index];
            k--;
            index++;
        }
        // 如过k为偶数，那对结果没有影响，因为经历偶数次变化符号结果不变
        // 如果此时k为奇数（暗含k此时还大于0，此时数组内已无负数事实）
        // 那应该找一个最小的进行加负号，可以再次对数组排序，但性能不好，下面是优化做法
        if (k % 2 == 1) {
            // 可以利用之前的index，有三种情况，index为0，index==nums.length，0<index<nums.length
            // 由于index用于前面的负数转正，所以在这个全是非负数的数组里，最小值可能在index也可能在index-1
            // 因为index-1是最后一个被转正的负数，它和index的绝对值不好说，要比较一下
            int minIndex = index;
            if (index == nums.length) {
                minIndex = index - 1;
            } else if (minIndex > 0 && minIndex < nums.length && nums[index - 1] < nums[index]) {
                minIndex = index - 1;
            }
            nums[minIndex] = -nums[minIndex];
        }

        // 最后求数组之和进行返回
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
