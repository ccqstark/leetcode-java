package 二叉树.No106从中序与后序遍历序列构造二叉树;

import 二叉树.TreeNode;

public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeProcess(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTreeProcess(int[] inOrder, int inLeft, int inRight,
                                     int[] postOrder, int postLeft, int postRight) {

        // 指针重合说明没有节点了
        if (inLeft == inRight) {
            return null;
        }

        // 指针相邻说明只剩一个节点了
        if (inRight - inLeft == 1) {
            return new TreeNode(inOrder[inLeft]);
        }

        // 中间节点一定在后序遍历数组的最后一个
        int rootValue = postOrder[postRight - 1];
        int rootIndex = 0;
        // 在中序列遍历数组中找到中间节点，也就是切割点
        for (int i = inLeft; i < inRight; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // 新建root节点（中间节点）
        TreeNode root = new TreeNode(rootValue);
        // 都遵循左闭右开原则
        // 左节点 中序左数组就是rootIndex的左半部分 后序左数组的右端点就是左端点加上中序左数组的长度（中序和后序对应边数组的长度一致）
        root.left = buildTreeProcess(inOrder, inLeft, rootIndex, postOrder, postLeft, postLeft + (rootIndex - inLeft));
        // 右节点 中序有数组就是rootIndex的右半部分 后序右数组就是后序左数组的右端点，到结尾-1（去掉rootValue节点）
        root.right = buildTreeProcess(inOrder, rootIndex + 1, inRight, postOrder, postLeft + (rootIndex - inLeft), postRight - 1);

        // 返回这棵数的root
        return root;
    }


}
