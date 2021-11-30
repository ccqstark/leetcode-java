package 回溯.No491递增子序列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {

        // 个数大于等于2个就可以加入结果集，注意不要return，因为后面还可能有元素
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // 因为不能排序，我们用一个数组表示某个数在这一层是否被用过，每一层都new一个数组
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.peekLast() > nums[i] ||
                    used[nums[i] + 100] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = 1; // nums范围[-100，100]，加100映射到0-200
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

}
