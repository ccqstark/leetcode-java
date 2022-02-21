package 数组.剑指Offer03数组中重复的数字;

public class Solution {
    // 法1：直接一个hashset，过于简单不说了
    // 法2：题目说了:长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
    // 所以我们可以把数组下标和元素值进行对应，如果没有重复就可以一一对应，显然这里是会出现一对多的
    // 所以遇到一个nums[i]，通过交换把它放到正确位置nums[nums[i]]上
    // 如果此时发现对应位置上已经放了对应值了，说明发现重复了
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 当前位置的数已经和下标对应了，指针才下移
            if (nums[i] == i) {
                i++;
                continue;
            }
            // 当前位置的数不与下标对应，想交换到对应下标去，发现那边已经放好了对应值了，说明找到重复值了
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            // 交换位置
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp; // 这里注意nums[i]已经改变，原来的nums[i]存在tmp中
        }
        return -1;
    }
}
