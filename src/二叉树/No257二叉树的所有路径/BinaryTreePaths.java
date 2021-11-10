package 二叉树.No257二叉树的所有路径;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        tranversal(root, "", result);
        return result;
    }

    public void tranversal (TreeNode root, String path, List<String> result) {
        // 当前节点添加到路径
        path += String.valueOf(root.val);
        // 到达叶子节点
        if (root.left == null && root.right == null){
            // 把当前路径添加到结果集
            result.add(path);
        }
        // 遍历左子树 path + "->" 相当于回溯
        if (root.left != null){
            tranversal(root.left, path + "->", result);
        }
        // 遍历右子树
        if (root.right != null) {
            tranversal(root.right, path + "->", result);
        }
    }
}
