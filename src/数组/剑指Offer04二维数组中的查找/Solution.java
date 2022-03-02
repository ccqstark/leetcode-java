package 数组.剑指Offer04二维数组中的查找;

// 把整个数组逆时针旋转45度，看起来就像一棵二叉搜索树
// 从树的根节点，也就是二维数组的第0行的最后一个元素开始
// 如果目标数较小，i--；若目标数较大，j++，去逼近target，最后超出范围还没有就是找不到了
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = m - 1, j = 0;
        // 注意i和j与n和m的表示的意义，是行还是列
        while (i >= 0 && j < n) {
            if (matrix[j][i] == target) return true;
            else if (matrix[j][i] < target) j++;
            else i--;
        }

        return false;
    }
}
