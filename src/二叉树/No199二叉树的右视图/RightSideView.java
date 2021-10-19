package 二叉树.No199二叉树的右视图;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public List<Integer> rightSideView(TreeNode root) {
        recursion(root, 0);
        List<Integer> rightList = new ArrayList<>();
        // 在获取层序遍历结果后，取每一层的最后一个即可
        for (List<Integer> layerList : resultList){
            rightList.add(layerList.get(layerList.size()-1));
        }

        return rightList;
    }

    public void recursion(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (resultList.size() < deep + 1) {
            ArrayList<Integer> layerList = new ArrayList<>();
            resultList.add(layerList);
        }
        resultList.get(deep).add(node.val);
        recursion(node.left, deep + 1);
        recursion(node.right, deep + 1);
    }
}
