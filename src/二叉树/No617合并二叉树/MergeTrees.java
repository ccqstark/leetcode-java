package 二叉树.No617合并二叉树;

import 二叉树.TreeNode;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 如果有一方为null，直接返回另一方，不用进行下面的递归，因为说明这一层以下都为null了，直接用另外一边的就行
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 都有值就相加
        int value = root1.val + root2.val;
        TreeNode root = new TreeNode(value);
        // 进行递归，左左右右对应
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
