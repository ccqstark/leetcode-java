package 二叉树.No654最大二叉树;

import 二叉树.TreeNode;

/**
 * @author ccqstark
 * @description 感觉代码整体结构有点像【根据中序后序遍历构建二叉树】
 * @date 2021/11/12 19:26
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {

        if (left == right) {
            return null;
        }

        // 只剩下一个节点
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        // 遍历找出最大值
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        // 递归找出构建左右子树
        TreeNode root = new TreeNode(maxValue);
        root.left = buildTree(nums, left, maxIndex);
        root.right = buildTree(nums, maxIndex + 1, right);

        return root;
    }

}
