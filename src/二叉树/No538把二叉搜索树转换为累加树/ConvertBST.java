package 二叉树.No538把二叉搜索树转换为累加树;

import 二叉树.TreeNode;

/**
 * @author ccqstark
 * @description 此题和1038相同，这里采用递归写法
 * @date 2021/11/16 19:53
 */
public class ConvertBST {

    private int pre = 0; // 此值实际上就是大于本节点的所有节点值之和

    public TreeNode convertBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        // 递归右中左
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);

        return root;
    }


}
