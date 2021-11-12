package 二叉树.No105从前序与中序遍历序列构造二叉树;

import 二叉树.TreeNode;

/**
 * 此题和106类似，画下图即可出来，不再赘述
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeProcess(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode buildTreeProcess(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {

        if (inLeft == inRight) {
            return null;
        }

        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        int rootValue = preorder[preLeft];
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeProcess(preorder, preLeft + 1, preLeft + 1 + (rootIndex - inLeft), inorder, inLeft, rootIndex);
        root.right = buildTreeProcess(preorder, preLeft + 1 + (rootIndex - inLeft), preRight, inorder, rootIndex + 1, inRight);

        return root;
    }


}
