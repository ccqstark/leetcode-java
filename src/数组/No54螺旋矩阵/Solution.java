package 数组.No54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 模拟法
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 定义上下左右边界
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // 直到上下或者左右边界交错
        while (true) {
            // 从左到右，收缩上边界
            for (int i = left; i <= right; i++) ans.add(matrix[up][i]);
            if (++up > down) break;
            // 从上到下，收缩右边界
            for (int i = up; i <= down; i++) ans.add(matrix[i][right]);
            if (--right < left) break;
            // 从右到左，收缩下边界
            for (int i = right; i >= left; i--) ans.add(matrix[down][i]);
            if (--down < up) break;
            // 从下到上，收缩左边界
            for (int i = down; i >= up; i--) ans.add(matrix[i][left]);
            if (++left > right) break;
        }
        return ans;
    }
}
