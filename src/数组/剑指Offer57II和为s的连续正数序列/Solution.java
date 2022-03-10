package 数组.剑指Offer57II和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口典型题，好好掌握
 * 左右都从起点开始，都只能向右，根据当前和与
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        // 这题不用专门搞一个数组，但是如果题目改为传入一个升序数组也可以用滑动窗口
        // 当前和
        int sum = 0;
        // 左闭右开
        int i = 1, j = 1;
        // 数组类型list
        List<int[]> ret = new ArrayList<>();
        // 到一半就够了
        while (i <= target / 2) {
            // 加入到答案集中
            if (sum == target) {
                int[] ans = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    ans[k] = i + k;
                }
                ret.add(ans);
            }
            // 如果偏小，右区间扩大
            if (sum < target) {
                sum += j;
                j++;
            } else {
                // 如果偏大，或者相等，左区间收缩
                sum -= i;
                i++;
            }
        }
        // list<int[]>转为int[][]的方法，要牢记
        return ret.toArray(new int[ret.size()][]);
    }
}
