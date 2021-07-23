package 哈希表.No15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // 哈希法（较差）



    // 排序+双指针法（较优）
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 首位大于0的直接返回
            if (nums[i] > 0) {
                return result;
            }

            // i的去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            // 循环
            while (right > left) {
                // 计算此时的三数之和
                int sum = nums[i] + nums[left] + nums[right];
                // 三种情况
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // 找到一种答案添加到结果集
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    // 找到一个答案后两边指针都收缩
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}
