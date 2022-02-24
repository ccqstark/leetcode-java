package 二叉树.No124二叉树中的最大路径和;

import 二叉树.TreeNode;

public class Solution {
    // 全局最大和
    int maxGain = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGainHelper(root);
        return maxGain;
    }

    public int maxGainHelper(TreeNode root) {
        if (root == null) return 0;

        int leftGain = maxGainHelper(root.left); // 左子树的贡献
        int rightGain = maxGainHelper(root.right); // 右子树的贡献
        // 这是还要向上走的路径（分为从左子树向上和从右子树向上），得出左右最大值之后还要与0比较，负值贡献会被摒弃，也就是路径止步于此
        int upPathGain = Math.max(0, Math.max(leftGain + root.val, rightGain + root.val));
        // 这是向下的路径，也就是从左子树经过当前root再向右子树方向，拐弯点就是当前root（因为这时已经出现一条完整的路径，不需要给递归上一层作为子树贡献，所以不用与0比较）
        int downPathGain = root.val + leftGain + rightGain;

        // 更新全部最大值，downPathGain比upPathGain多了一个左/右节点，左/右节点一定>=0，所以downPathGain一定大于等于upPathGain
        // 同时upPathGain最小为0，如果最终答案maxGain是一个负值，那么upPathGain参与比较的话最后maxGain会变成0就出错了
        maxGain = Math.max(maxGain, downPathGain);

        // upPathGain就返回给递归上一层作为子树贡献
        return upPathGain;
    }

}
