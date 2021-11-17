package 回溯.No216组合总和III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            if (sum == n && path.size() == k) {
                result.add(new ArrayList<>(path));
            }
            // 这里的剪枝是判断下一个要加上的数是不是比现在距离目标值要小，因为倘若要大，加上了就肯定超了，不可能产生结果集
            if ((n - sum) >= i + 1) {
                backtracking(n, k, i + 1);
            }
            sum -= i;
            path.removeLast();
        }

    }

}
