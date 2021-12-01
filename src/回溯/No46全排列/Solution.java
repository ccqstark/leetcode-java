package 回溯.No46全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new int[nums.length]);
        return result;
    }

    public void backtracking(int[] nums, int[] used) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 每次循环都是从0开始，因为是全排列，所以结果是包括所有元素的
        for (int i = 0; i < nums.length; i++) {
            // 使用过的就跳过
            if (used[i] == 1) {
                continue;
            }

            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used);
            path.removeLast();
            used[i] = 0; // 回溯记得used数据也有置为0
        }

    }

}
