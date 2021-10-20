package 二叉树.No637二叉树的层平均值;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevels {

    List<Double> resultList  = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int layerSize = len;
            double sum = 0;
            while (len > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                len--;
            }
            // 每层遍历后取个平均值
            resultList.add(sum / layerSize);
        }
        return resultList;
    }

}
