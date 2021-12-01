package 贪心.No435无重叠区间;

import java.util.Arrays;

/**
 * @author ccqstark
 * @description 这道题答案代码整体结构和思路与No452最少箭引爆气球很像，都是这种区间类的，可以归一起复习
 * @date 2021/12/1 16:02
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return 0;
        }

        // 按右边界排序，从左向右遍历，是为了给尽量给右边留更多的空间
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // 这个是不重叠的区间数
        for (int i = 1; i < intervals.length; i++) {
            // 判断如果不重叠，注意接壤不算重叠
            if (intervals[i][0] >= intervals[i - 1][1]) {
                count++;
            }else {
                // 同样更新最小右区间
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }

        // 最少需要移除的区间数 = 总数 - 不重叠的区间数
        return intervals.length - count;
    }
}
