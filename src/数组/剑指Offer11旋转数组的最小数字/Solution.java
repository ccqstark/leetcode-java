package 数组.剑指Offer11旋转数组的最小数字;

public class Solution {
    public int minArray(int[] numbers) {
        // 二分法
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 如果mid对应值小于右端点值，说明最小值出现在左边，目前处于较小的那段上升区间
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) { // 这是与第一种情况相反的
                l = mid + 1;
            } else {
                // 最后是mid对应值等于右端点值，就只能淘汰掉重复的右端点，因为此时无法判断最小值在哪一边
                // 因为mid和r的值一样，如果最小值就是这个重复的数也有mid可以兜底，r对应的值就不重要了
                r--;
            }
        }

        return numbers[l];
    }
}
