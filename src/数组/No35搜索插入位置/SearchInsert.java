package 数组.No35搜索插入位置;

public class SearchInsert {

    // 二分搜索法(递归)
    public int searchInsert1(int[] nums, int target) {
        return binSearch(0,nums.length-1,target,nums);
    }

    public int binSearch(int left, int right, int x, int[] nums) {
        if (left > right) return left;
        int mid = (left + right) / 2;
        if (x < nums[mid]) return binSearch(left, mid - 1, x, nums);
        if (x > nums[mid]) return binSearch(mid + 1, right, x, nums);
        if (x == nums[mid]) return mid;
        return -1;
    }

    // 二分搜索法(非递归)
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }


}
