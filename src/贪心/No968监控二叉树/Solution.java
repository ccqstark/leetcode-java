package 贪心.No968监控二叉树;

import 二叉树.TreeNode;

public class Solution {
    // 需要用到的摄像头数量
    private int result = 0;

    public int minCameraCover(TreeNode root) {
        int rootState = traverse(root);
        // 根节点需要额外检查一下
        if (rootState == 0) {
            result++;
        }

        return result;
    }

    /**
     * 0 未覆盖
     * 1 装摄像头
     * 2 已被覆盖（不带摄像头）
     */
    int traverse(TreeNode root) {
        // null节点直接视为已覆盖
        if (root == null) {
            return 2;
        }

        // 这里的遍历是后序遍历
        // 获得左右子节点的状态
        int left = traverse(root.left);
        int right = traverse(root.right);

        //如果左右子节点都被覆盖了，那么本节点是未覆盖的（摄像头在孙节点）
        if (left == 2 && right == 2) {
            return 0;
        }

        // 如果子节点中有一个未覆盖，那么此节点需要装摄像头
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        // 如果子节点中有一个已经装了摄像头，那么本节点就是被覆盖的
        // 注意，由于这种情况在最后，所以左右子节点一个为1一个为0的情况归属于上面那种情况
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }

}
