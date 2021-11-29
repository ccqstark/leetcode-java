package 回溯.No90子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ccqstark
 * @description 这道题和子集I的区别就是出现了重复元素，还是之前那个套路，先排序，然后数同层不能选，同枝叶可以选，这个套路要牢记
 * @date 2021/11/29 22:22
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 判断是否同层选择了重复，注意保证不是顺下来的树枝，而是同层，所以要有条件i > startIndex
            if ( i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
