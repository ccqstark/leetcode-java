package 综合.No912排序数组;

import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快排
    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            // partition拿到划分后数组的分界
            int pos = partition(nums, l, r);
            // 对左边继续递归
            quickSort(nums, l, pos - 1);
            // 对右边继续递归
            quickSort(nums, pos + 1, r);
        }
    }

    // 核心方法
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



