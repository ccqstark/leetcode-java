package 回溯.No37解数独;

public class Solution {
    public void solveSudoku(char[][] board) {
        // 棋盘填充满了的话会自己终止
        backtracking(board);
    }

    boolean backtracking(char[][] board) {
        // 这里行、列双重循环只是为了找到空的位置来填
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 已经有数的就跳过
                if (board[i][j] != '.') {
                    continue;
                }
                // 1-9每个都进行尝试
                for (char k = '1'; k <= '9'; k++) {
                    // 先检查数是否已经在行、列、3乘3的范围内存在，再去决定这个数可不可以放进去
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试过了，都不行
                return false;
            }
        }
        // 整个棋盘都搜索后发现没有空的位置，说明已经找到了答案
        return true;
    }


    boolean isValid(int row, int col, char val, char[][] board) {
        // 行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        // 3乘3范围
        int startRow = (row / 3) * 3; // 这个数3乘3范围的行起始索引
        int startCol = (col / 3) * 3; // 这个数3乘3范围的列起始索引
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }


}
