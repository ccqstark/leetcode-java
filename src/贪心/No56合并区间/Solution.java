package 贪心.No56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        // 按左边界进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 记录当前要合并区间的左右端点
        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 超出合并区间右边界，加入结果集同时更新左右端点
            if (intervals[i][0] > right) {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                // 否则只需要更新右端点（取较大的那个）
                right = Math.max(intervals[i][1], right);
            }
        }
        // 记得最后一组要补上
        result.add(new int[]{left, right});

        return result.toArray(new int[result.size()][]);
    }
}
