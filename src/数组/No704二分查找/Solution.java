package 数组.No704二分查找;

public class Solution {

    public int search(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    // 递归法
    public int binSearch(int[] nums, int l, int r, int target) {
        int mid = (r - l) / 2 + l;
        if (target == nums[mid]) {
            return mid;
        }
        if (l >= r) {
            return -1;
        }
        if (target < nums[mid]) {
            return binSearch(nums, l, mid - 1, target);
        } else {
            return binSearch(nums, mid + 1, r, target);
        }
    }

    // 非递归法
    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l<=r){
            int mid = (r-l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
