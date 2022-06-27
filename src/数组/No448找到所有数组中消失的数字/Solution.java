package 数组.No448找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用O(1)的空间复杂度：
 * 利用原数组，把nums[i]的元素置为负数表示i+1出现过了
 * 最后再次遍历数组，如果nums[i]>0,说明i+1这个数没有出现过，记录在ans中
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = num > 0 ? num - 1 : -num - 1;
            nums[x] = nums[x] > 0 ? -nums[x] : nums[x];
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
