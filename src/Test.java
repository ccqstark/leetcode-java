import 二叉树.TreeNode;

import java.rmi.Remote;
import java.util.*;

public class Test {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
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
        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        Test test = new Test();
    }


}
