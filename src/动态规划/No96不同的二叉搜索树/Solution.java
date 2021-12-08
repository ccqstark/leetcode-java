package 动态规划.No96不同的二叉搜索树;

public class Solution {
    public int numTrees(int n) {

        // dp[n]表示从1到n的n个数组成的二叉搜索树的种类树（其实n个不一样的递增的数都适用）
        int[] dp = new int[n + 1];
        // 避免乘0，所以初始化为1
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // 遍历每一个节点作为顶点的情况
            for (int j = 1; j <= i; j++) {
                // 左右子树不同种类去组合搭配，所以用乘法
                // 因为dpn个不一样的递增的数都适用，就是不一定这些数要1到n，所以可以利用之前计算的结果，尽管右子树不是1到n（实际上是j+1到n）
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
