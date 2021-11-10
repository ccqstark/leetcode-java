package 二叉树.No513找树左下角的值;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftValue {

    int maxLen = Integer.MIN_VALUE;
    int lastLeftValue;

    public int findBottomLeftValue1(TreeNode root) {
        traversal(root, 0);
        return lastLeftValue;
    }

    /**
     * 回溯法
     */
    public void traversal(TreeNode root, int leftLen) {
        // 如果深度比当前最大深度大且是叶子节点，就更新一下左下角值，由于前序遍历，所以这个值一定是这一层最左的
        if (root.left == null && root.right == null & leftLen > maxLen) {
            maxLen = leftLen;
            lastLeftValue = root.val;
        }
        // 优先遍历左子树
        if (root.left != null) {
            // leftLen + 1 又用了一次隐藏回溯
            traversal(root.left, leftLen + 1);
        }
        if (root.right != null) {
            traversal(root.right, leftLen + 1);
        }
    }

    /**
     * 迭代法
     */
    public int findBottomLeftValue2(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                // 若为此行第一个
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        return result;
    }

}
