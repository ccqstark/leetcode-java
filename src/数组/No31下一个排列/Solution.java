package 数组.No31下一个排列;

/**
 * 思路就是从后往前找到一个「较小数」，位置设为i，它比自己相邻右边的数略小
 * 再从后往前找到一个「较大数」，它是从后往前的第一个比nums[i]大的数，位置设为j
 * 交换i和j位置的元素
 * 反转i+1到数组末尾这一段序列
 * 💥理解：i+1到length-1这段序列是降序的，在字典序中其实就是该段子排序的最后一个了
 * 类比数的进位，就比如2999这个数，999就是i+1到length-1，2就是i，999下一位就进位了，进到2上变成了3000
 * 用j与i交换其实就是我们进位的话，就是原本i的位置进一位，就是还下一个比它大一点的数
 * 那为了保证整体字典序变动小，那这个大一点的数我们不能在左边的高位找，而应该是在右边低位找
 * 所以就又再次从后往前找第一个比nums[i]大的数，因为i+1开始就是降序所以第一个比nums[i]大的数就是刚好大一点的
 * 换到位置i上之后就必须把后面反转，因为交换位置后依然保持降序，反转之后就变成排好序的升序，而升序在字典中就是就小的
 * 类比上面的2999进一位变成3000，就类似3000后面3个零就是最小的体现，整体上就表现为整个序列字典序往后了一位
 * 直接看官方题解的"「较小数」尽量靠右，而「较大数」尽可能小"表述还是比较难懂的，所以我用"数的进位"来类比字典序会好理解很多
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前，找到「较小数」，第一个nums[i]<nums[i+1]的数，注意相等的也不行
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 注意i要大于0才行，否则说明整个序列就是字典序中的最后一位，直接到下面整体反转为字典序最小的了
        if (i >= 0) {
            int j = nums.length - 1;
            // 注意：相等的也不行
            while (nums[i] >= nums[j]) {
                j--;
            }
            // 交换i和j位置
            swap(nums, i, j);
        }
        // 最后反转i+1到数组末尾的序列
        reverse(nums, i + 1);
    }

    // 交换数组中两个位置的元素
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 反转指定位置到数组末尾这一段的序列，用双指针和swap实现就行，不用再排序了
    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
