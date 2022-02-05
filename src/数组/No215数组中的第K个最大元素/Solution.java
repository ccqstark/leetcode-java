package 数组.No215数组中的第K个最大元素;

import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 第k大的数，在数组中的下标是nums.length - k
        // 长度为1的数组不用特判，同样适用
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // 基于快排的快速选择，找出nums数组在从小到大排序后下标为n的元素
    public int quickSelect(int[] nums, int l, int r, int n) {
        // partition拿到划分后数组的分界
        int pos = partition(nums, l, r);
        // 如果刚好找到对应位置就直接返回
        if (pos == n) {
            return nums[n];
        } else {
            // pos略大就找左边，pos略小就找右边
            return pos > n ? quickSelect(nums, l, pos - 1, n) : quickSelect(nums, pos + 1, r, n);
        }
    }

    // 快排的核心方法和原来的一模一样
    public int partition(int[] nums, int l, int r) {
        // 随机拿到一个分界值
        int pivot_index = new Random().nextInt(r - l + 1) + l;
        int pivot = nums[pivot_index];
        // 把分界值对应的数和最后一个交换位置，将其放在最右边
        swap(nums, pivot_index, r);
        // 初始化i和j
        // i就是表示下标1到i位置的数都小于（等于）上面选出的中轴数pivot，右边的就是都大于的
        // j是用来遍历的指针
        int i = l - 1, j = l;
        while (j <= r - 1) {
            if (nums[j] <= pivot) {
                i++;
                // 将较小的数换到左边
                swap(nums, i, j);
            }
            j++;
        }
        // 最后将pivot换回中间位置
        swap(nums, i + 1, r);
        // 返回中轴下标
        return i + 1;
    }

    // 交换数组中两个数位置的工具方法
    public void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

}