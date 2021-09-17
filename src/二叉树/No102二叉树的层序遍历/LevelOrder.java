package 二叉树.No102二叉树的层序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
//        useQueue(root);
        recursion(root, 0);
        return resultList;
    }

    // DFS 递归
    public void recursion(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        // 如果还没为该层数建立list
        if (resultList.size() < deep + 1) {
            List<Integer> itemList = new ArrayList<Integer>();
            resultList.add(itemList);
        }
        // 将当前节点加入到对应层数的list中（层数-1才是对应的list索引）
        resultList.get(deep).add(node.val);
        // 左右节点递归
        recursion(node.left, deep + 1);
        recursion(node.right, deep + 1);
    }


    // BFS 借助队列
    public void useQueue(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            // 一层的长度，因为每操作完一层，队列中剩下的就全是下一层的节点
            int len = que.size();
            // 对一层进行操作
            while (len > 0) {
                TreeNode tempNode = que.poll();
                itemList.add(tempNode.val);
                // 每弹出一个添加到结果集中，就把其左右子节点加入队列中
                if (tempNode.left != null) {
                    que.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    que.offer(tempNode.right);
                }
                len--; // 弹出一个就长度-1，用于结束循环
            }
            resultList.add(itemList);
        }
    }

}
