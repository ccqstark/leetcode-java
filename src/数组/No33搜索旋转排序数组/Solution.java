package 数组.No33搜索旋转排序数组;

public class Solution {
    /**
     * 核心思想就是利用二分的思路找到mid后，mid的左右总有一方是有序的
     * 利用有序的一方来判断target时候在其中，如果不在其中就可以去另一边找
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 前面和常规的二分差不多
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 左边有序
            if (nums[left] <= nums[mid]) {
                // target时候在左边
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1; // 在左边的话就继续往左边找
                } else {
                    left = mid + 1; // 否则找右边
                }
            }
            // 右边有序
            else {
                // target是否在右边
                if (nums[mid + 1] <= target && target <= nums[right]) {
                    left = mid + 1; // 这里和左边有序的情况同理
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
