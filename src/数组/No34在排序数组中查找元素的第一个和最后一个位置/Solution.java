package 数组.No34在排序数组中查找元素的第一个和最后一个位置;

/**
 * 这题考二分的应用（高频），二分条件细节很多，容易蒙，这题需要好好拿下
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 长度为0的特判
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        int first = binSearch(l, r, nums, target, false);
        int last = binSearch(l, r, nums, target, true) - 1; // last返回的是对应位置的右一位，所以要-1

        // 超出边界或者不是目标值，返回找不到
        if (first < l || first > r || nums[first] != target) return new int[]{-1, -1};
        // 否则都是找得到的，尽管只有一个的情况first和last也是相同的，符合答案
        return new int[]{first, last};
    }

    // isLast表示是否要找最后一个，为false就是找的第一个
    int binSearch(int l, int r, int[] nums, int target, boolean isLast) {
        // 注意这里二分的写法，二分细节很多，根据题目不同去调整这些细节
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target || (isLast && nums[mid] <= target)) {
                // 继续向右
                l = mid + 1;
            } else {
                // 继续向左
                r = mid - 1;
            }
        }
        // 都返回左边界
        return l;
    }

}
