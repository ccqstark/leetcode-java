package 回溯.No39组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int sum = 0;
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先排序，为了更好剪枝
        backtracking(candidates, target, 0);
        return results;
    }

    void backtracking(int[] candidates, int target, int startIndex) {

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            if (sum == target) {
                results.add(new ArrayList<>(path));
            }
            // 目前距离target的差值要大于等于candidates[i]，保证下一个回溯加上之后不会超
            // 剪枝
            if ((target - sum) >= candidates[i]) {
                backtracking(candidates, target, i);
            }
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
