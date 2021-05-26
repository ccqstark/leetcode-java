package 数组.No1两数之和;

import java.util.HashMap;
import java.util.Map;

// 两数之和
public class TwoSum {

    // 方法一：暴力枚举
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 方法二：哈希表
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {
                        hashtable.get(target - nums[i]), i
                } ;
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
