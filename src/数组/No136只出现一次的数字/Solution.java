package 数组.No136只出现一次的数字;

/**
 * 最佳方法：利用异或运算，相同的数异或会等于0，任何数与0异或还是那个数，所以把数据所有数
 * 都异或在一起，最后剩下的那个数就是只出现一次的数，由于异或满足交换律所以顺序不
 * 会影响，相同的数最终都会抵消掉
 * 其它解法：暴力、哈希、排序
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
