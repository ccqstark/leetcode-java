package 数组.No153寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        // 经典二分开场
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 当left和right重合时就找到了最小值
            if (left == right) {
                return nums[left];
            }
            int mid = (left + right) / 2;
            // mid小于right，说明最小值在左边
            if (nums[mid] < nums[right]) {
                right = mid; // 这里不能mid-1，当mid就是最小值时会漏数
            } else {
                // mid大于right时，说明最小值在右边
                left = mid + 1;
            }
        }
        return 0;
    }
}
