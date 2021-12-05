package 回溯.No51N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 先用二维char数组操作比较方便，之后再转成题目要求的List<List<String>>
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            // 全部先填充上'.'
            Arrays.fill(c, '.');
        }
        backtracking(n, 0, chessboard);

        return result;
    }

    // row是当前行
    void backtracking(int n, int row, char[][] chessboard) {
        // 到底了
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }

        // 在一行中遍历，一个个位置尝试
        for (int i = 0; i < n; i++) {
            // 放置皇后
            chessboard[row][i] = 'Q';
            // 如果当前位置有效再递归回溯，相当于一个剪枝了
            if (isValid(n, row, i, chessboard)) {
                // 下一行
                backtracking(n, row + 1, chessboard);
            }
            // 取消放置
            chessboard[row][i] = '.';
        }
    }

    // 工具方法，把数组转成List<String>
    List<String> Array2List(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (char[] c : chessboard) {
            // String.copyValueOf(char[]) 用于把char数组转成String
            res.add(String.copyValueOf(c));
        }

        return res;
    }

    boolean isValid(int n, int row, int col, char[][] chessboard) {
        // 检查行
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

}
