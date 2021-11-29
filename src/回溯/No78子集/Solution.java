package 回溯.No78子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        // 每一个节点都加入到结果集中
        result.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }
        // 这里树的第一层就是元素数只有1个的子集，第二层就是元素数为2个的子集，以此类推。。。
        // 层数表示子集的元素个数，第n层的横向遍历就是在选择子集中的第n个元素（在第n层时path已经有n-1元素了）
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
