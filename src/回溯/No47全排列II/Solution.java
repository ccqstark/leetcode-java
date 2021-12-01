package 回溯.No47全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 经典去重前先排序
        Arrays.sort(nums);
        backtracking(nums, new boolean[nums.length]);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used){

        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 多一项去重判断，如果当前元素与上一个一样，且上一个元素的used状态为false（就是同一层用过了而不是同一树枝），就去重
            if (used[i] == true || i > 0 && nums[i] == nums[i-1] && used[i-1]==false){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }

    }

}
