package 周赛.No305;

import java.util.HashSet;
import java.util.Set;

public class One {
    int cnt = 0;

    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]+diff) && set.contains(nums[i] + diff * 2)) {
                cnt++;
            }
        }
        return cnt;
    }
}
