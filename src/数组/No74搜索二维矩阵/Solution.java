package 数组.No74搜索二维矩阵;

// 这题是剑指Offer04、No240的简化了一点的版本，想当与二维矩阵里的数按顺序都是递增的
// 那直接把他看成一个一维的数组去二分就行了，只不过需要进行一二维的下标转换
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 关键在这里，通过整除和取模进行转换下标
            int i = mid / m, j = mid % m;
            if (matrix[i][j] == target) return true;
            else if (target > matrix[i][j]) l = mid + 1;
            else r = mid - 1;
            // 一个二分的细节点，如果while条件是l <= r, 那r=mid-1，如果r=mid可能死循环
        }

        return false;
    }
}
