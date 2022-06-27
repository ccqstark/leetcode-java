package 数组.No287寻找重复数;

/**
 * 这里只写了一种转为找有环链表的环入口的写法，其他写法较复杂，详细见官方题解
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        }

        slow = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
