package 二叉树.No958二叉树的完全性检验;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 法1：bfs
    public boolean isCompleteTree1(TreeNode root) {
        List<Anode> list = new ArrayList<>();
        list.add(new Anode(root, 1));
        int i = 0;
        // 将不为空的左右子节点放入list
        while (i < list.size()) {
            Anode p = list.get(i++);
            // 左：code * 2 右：code * 2 + 1
            if (p.node.left != null) list.add(new Anode(p.node.left, p.code * 2));
            if (p.node.right != null) list.add(new Anode(p.node.right, p.code * 2 + 1));
        }
        // 判断最后一个节点的编号是否和列表长度（节点个数相同）
        return list.get(i - 1).code == list.size();
    }

    // 加一个编号，可以再封一个类，这个思路之后可以借鉴
    class Anode {
        TreeNode node;
        int code;

        public Anode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    // 法2：dfs
    int cnt = 0, max = 0;

    public boolean isCompleteTree2(TreeNode root) {
        // 其实和bfs本质上一样，比较节点数量和最大节点编号是否相同，只不过遍历方式不同而已
        dfs(root, 1);
        return cnt == max;
    }

    void dfs(TreeNode node, int k) {
        if (node == null) return;
        cnt++;
        max = Math.max(max, k);
        dfs(node.left, k * 2);
        dfs(node.right, k * 2 + 1);
    }
}
