package 二叉树.No235二叉搜索树的最近公共祖先;

import 二叉树.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        // 发现当前节点在p和q的范围内，这个节点就是最近公共祖先
        if ((p.val <= root.val && root.val <= q.val) || (p.val >= root.val && root.val >= q.val)) {
            return root;
        }
        // 如果都小于p和q，则向右寻找
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果都大于p和q，则向左寻找
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return null;
    }
}
