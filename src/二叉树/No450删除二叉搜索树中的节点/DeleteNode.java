package 二叉树.No450删除二叉搜索树中的节点;

import 二叉树.TreeNode;

public class DeleteNode {

    private TreeNode pre; // 记录上一个节点
    private TreeNode realRoot; // 记录真正的根节点

    /**
     * 一开始没有考虑处理返回值写的很乱的逻辑，做个记录，之后要尽量规避
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // 初始化pre和realRoot，在遍历第一个节点时执行
        if (pre == null) {
            pre = new TreeNode(0);
            pre.left = root;
            realRoot = root;
            // 如果要删除根节点，而且整棵树只有根节点时，返回null
            if (realRoot.val == key && realRoot.left == null && root.right == null) {
                return null;
            }
        }

        if (root != null && root.val == key) {
            // 两个节点都为空
            if (root.left == null && root.right == null) {
                if (pre.left == root) {
                    pre.left = null;
                } else {
                    pre.right = null;
                }
            }

            // 只有左节点
            else if (root.left != null && root.right == null) {
                if (pre.left == root) {
                    pre.left = root.left;
                } else {
                    pre.right = root.left;
                }
                // 如果为当前为根节点
                if (realRoot == root) {
                    realRoot = root.left;
                }
            }

            // 只有右节点
            else if (root.left == null && root.right != null) {
                if (pre.left == root) {
                    pre.left = root.right;
                } else {
                    pre.right = root.right;
                }
                // 如果当前为根节点
                if (realRoot == root) {
                    realRoot = root.right;
                }
            } else {
                // 两个节点都有
                // 获得左节点的最右下节点
                TreeNode leftRightest = root.left;
                while (leftRightest.right != null) {
                    leftRightest = leftRightest.right;
                }
                // 把左节点的最右下节点指向当前节点的右节点
                leftRightest.right = root.right;
                if (pre.left == root) {
                    pre.left = root.left;
                    // 当前节点为根节点的话需要将realRoot更新下
                    if (realRoot == root) {
                        realRoot = root.left;
                    }
                } else {
                    pre.right = root.left;
                }
            }
            // 检测到一次就可以直接返回了，无需进行以下遍历
            return realRoot;
        }

        // 因为pre是类的成员变量，所以在遍历右节点的时候可能已经被左子树的其他节修改了，所以遍历右子树前要重置下
        pre = root;
        deleteNode(root.left, key);
        pre = root;
        deleteNode(root.right, key);

        // 最后还是返回真正的根节点即可
        return realRoot;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // 利用二叉搜索树的特性寻找key
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 返回不为null的那一边
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 巧妙的地方，用右子树最左下角的值覆盖当前值，然后去把它原来所在的节点删除
            // 本质上就是用下面那个节点替换当前节点
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val;
            root.right = deleteNode(root.right, tmp.val);
        }

        return root;
    }

}
