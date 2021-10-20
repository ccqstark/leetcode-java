package 二叉树.No429N叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import 二叉树.Node;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                Node node = queue.pollFirst();
                itemList.add(node.val);

                if (node.children == null || node.children.size() == 0) {
                    len--; // 没有子节点的情况也要记得长度减1，或者用for循环来避免这个问题
                    continue;
                }

                for (Node childNode : node.children) {
                    if (childNode != null) {
                        queue.offerLast(childNode);
                    }
                }
                len--;
            }

            resultList.add(itemList);
        }
        return resultList;
    }

}
