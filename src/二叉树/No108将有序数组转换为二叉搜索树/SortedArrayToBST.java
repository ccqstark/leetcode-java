package 二叉树.No108将有序数组转换为二叉搜索树;

import 二叉树.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursion(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTRecursion(int[] nums, int left, int right) {
        // 数组终点
        if (left > right ){
            return null;
        }
        // 取中间就可以保证构造出来的树平衡
        // 取当前区间的中间节点作为当前root,这样写是为了防止超出数值范围（原来那种(left+right)/2会有这个问题）
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        // 左右子树递归，范围都是左闭右闭
        root.left = sortedArrayToBSTRecursion(nums,left, mid - 1);
        root.right = sortedArrayToBSTRecursion(nums,mid + 1, right);
        return root;
    }
}
