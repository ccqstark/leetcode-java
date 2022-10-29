package 周赛.No306;

public class One {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                // 遍历 3×3 方块
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        if (grid[ii][jj] > maxLocal[i][j]){
                            maxLocal[i][j] = grid[ii][jj];
                        }
                    }
                }
            }
        }

        return maxLocal;
    }

}
