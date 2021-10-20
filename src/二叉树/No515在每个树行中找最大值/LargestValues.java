package 二叉树.No515在每个树行中找最大值;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int max = queue.peekFirst().val;
            int len = queue.size();
            while (len>0){
                TreeNode node = queue.pollFirst();
                if (node.val > max){
                    max = node.val;
                }
                if (node.left != null ){
                    queue.offerLast(node.left);
                }
                if (node.right!=null){
                    queue.offerLast(node.right);
                }

                len--;
            }
            resultList.add(max);
        }
        return resultList;
    }
}
