package 二叉树.No113路径总和ii;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            path.add(root.val);
            traversal(root, targetSum - root.val);
        }
        return result;
    }

    public void traversal(TreeNode root, int count) {

        if (root.left == null && root.right == null && count == 0) {
            // 这里用构造方法浅拷贝，将当前这个符合条件的path添加到结果集中
            result.add(new ArrayList<>(path));
            return;
        }

        // 左右子树遍历
        if (root.left != null) {
            // 回溯
            path.add(root.left.val);
            traversal(root.left, count - root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, count - root.right.val);
            path.remove(path.size() - 1);
        }

    }

}
