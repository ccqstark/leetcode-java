package 二叉树.No559N叉树的最大深度;

import 二叉树.Node;

public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxSubDepth = 0;
        for (Node node : root.children) {
            maxSubDepth = Math.max(maxDepth(node), maxSubDepth);
        }

        return maxSubDepth + 1;
    }
}
