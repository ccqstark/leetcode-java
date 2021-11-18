package 回溯.No40组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 同一个组合中可以用到所给待选数中的重复的元素，但是最后组合不能重复，也就是说相同的元素
 * 如果出现在不同组合中，只能出现一次
 */
public class Solution {

    int sum = 0;
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 法1：用while循环去重
     * 所以在同一树枝上不用管，只要在同一树层上进行去重，也就是在同个循环中进行去重
     * 就是最后那个while循环
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                backtracking(candidates, target, i + 1);
            }
            sum -= candidates[i];
            path.removeLast();
            // 就多加了这里一个同一层树的去重
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }

    /**
     * 法2：用一个used数组来去重
     * used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
     * used[i - 1] == false，说明同一树层candidates[i - 1]使用过
     */
    boolean[] used;

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        used = new boolean[candidates.length]; // 初始值全为false
        Arrays.sort(candidates); // 先排序，为了更好剪枝，这里还是为了去重
        backtracking2(candidates, target, 0);
        return results;
    }

    void backtracking2(int[] candidates, int target, int startIndex) {

        for (int i = startIndex; i < candidates.length; i++) {
            // 遇到本数与上一个数相同，且是同一树层用过的
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i-1] == false) {
                continue;
            }

            sum += candidates[i];
            path.add(candidates[i]);
            if (sum == target) {
                results.add(new ArrayList<>(path));
            }
            // 剪枝
            if ((target - sum) >= candidates[i]) {
                used[i] = true; // 到下一层因为是同一树枝，所以置为true
                backtracking(candidates, target, i + 1);
            }
            used[i] = false; // 同一树层重置为false
            sum -= candidates[i];
            path.removeLast();
        }
    }

}
