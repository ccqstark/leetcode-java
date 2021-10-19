package 二叉树.No107二叉树的层序遍历II;

import 二叉树.TreeNode;

import java.util.*;

public class LevelOrderBottom {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return resultList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> itemList = new ArrayList<>();
            while (len > 0) {
                TreeNode tempNode = queue.poll();
                itemList.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                len--;
            }
            resultList.add(itemList);
        }
        // 前面和普通的层序遍历一样，最后反转一下即可
        Collections.reverse(resultList);
        return resultList;
    }

}
