package 二叉树.No501二叉搜索树中的众数;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindMode {

    private List<Integer> result = new ArrayList<Integer>();
    private int maxCount = 0;
    private int count = 0;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        traserval(root);
        // List转为数组
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public void traserval(TreeNode root) {

        if (root == null) {
            return;
        }

        traserval(root.left);

        // 如果pre节点为空说明是第一个节点
        if (pre == null) {
            count = 1;
        } else if (pre != null && pre.val == root.val) {
            // 遇到相同节点了，count+1
            count++;
        } else {
            // 新的节点值
            count = 1;
        }
        pre = root;

        // 出现更大的maxCount需要清空result
        if (count > maxCount) {
            maxCount = count;
            result.clear();
        }
        // 如果count等于最大的就可以加入到结果集中
        if (count == maxCount) {
            result.add(root.val);
        }

        traserval(root.right);
    }

}
