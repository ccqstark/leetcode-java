package 字符串.剑指Offer61扑克牌中的顺子;

import java.util.Arrays;

// 我的思路和剑指原书中的一样，直接贴原文了
/**
 * 首先把数组排序;
 * 其次统计数组中 0 的个数;
 * 最后统计排序之后的数组中相邻数字之间的空缺总数
 * 如果空缺的总数小千或者等千0的个数，那么这个数组就是连续的;反之则不连续。
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int index = 0;
        while (index < 5) {
            if (nums[index] == 0) {
                index++;
                zero++;
            } else break;
        }
        while (index <= 3) {
            int dis = nums[index + 1] - nums[index];
            if (dis == 0) return false;
            if (dis == 1) {
                index++;
                continue;
            } else {
                if (zero >= dis - 1) {
                    zero -= dis - 1;
                    index++;
                    continue;
                } else return false;
            }
        }

        return true;
    }
}
