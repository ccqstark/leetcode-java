package 回溯.No77组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 原始方法，未剪枝
     */
    // 回溯函数（递归函数）
    void backtracking(int n, int k, int startIndex) {
        // path当前集合的大小到达了指定的k就将其添加到结果集
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            // 回溯，撤销对节点的处理
            path.removeLast();
        }
    }

    /**
     * 进行剪枝优化
     */
    void backtrackingCutTree(int n, int k, int startIndex) {
        // path当前集合的大小到达了指定的k就将其添加到结果集
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // n - (k - path.size()) + 1 是重点，表示最右的可能的startIndex，因为大于这个index后面的数都不到k个，不可能产生新的结果集
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            // 回溯，撤销对节点的处理
            path.removeLast();
        }
    }

}
