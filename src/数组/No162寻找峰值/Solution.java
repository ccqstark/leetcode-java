package 数组.No162寻找峰值;

// 题目要求时间复杂度O(logn)，所以我们直接想到二分，这几乎要成为一个简单反射了
// 这题思路利用二分，一直往高处走就行了，因为nums[0]和nums[nums.length]都相当于-∞，所以峰值也可能出现在头尾处
// 整体代码也是二分的模版
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 比较mid与mid+1位置的大小关系
            if (nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
