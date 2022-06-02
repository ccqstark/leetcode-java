package 二叉树.No230二叉搜索树中第K小的元素;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {

    // 法1：中序遍历(迭代法)
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root!=null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    // 法2：利用节点数量
    public int kthSmallest2(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }

    // 自己封装一个带有节点数量的类
    class MyBst {

        // BST的root节点
        private TreeNode root;
        // 节点数量map（包括子节点和当前节点在内的节点总数）
        private HashMap<TreeNode, Integer> nodeNum = new HashMap<>();

        // 构造函数，会计算出所有节点数量
        MyBst(TreeNode root) {
            this.root = root;
            countNodeNum(root);
        }

        // 求出第k小的数
        public int kthSmallest(int k) {
            if (root == null) return 0;
            while (root != null) {
                // 先求出左子节点的节点数量
                int leftNum = getNodeNum(root.left);
                if (k - 1 > leftNum) {
                    // 左边节点数量不够k-1个，所以第k个数出现在右子树中
                    root = root.right;
                    // 注意这里由于算上了leftNum和当前root节点，在右子数中就找第(k - leftNum - 1)个数就行
                    k = k - leftNum - 1;
                } else if (k - 1 == leftNum) {
                    // 左边节点数量等于k-1个，所以第k个数就是当前root节点
                    break;
                } else {
                    // 左边节点数量大于k-1个，所以第k个数出现在左子树中
                    root = root.left;
                }
            }
            return root.val;
        }

        public int countNodeNum(TreeNode node) {
            if (node == null) return 0;
            // 注意，是包括自身节点+左右子节点数量
            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return nodeNum.get(node);
        }

        // 获取某一节点的节点数量
        public int getNodeNum(TreeNode node) {
            if (node == null) return 0;
            return nodeNum.get(node);
        }

    }
}
