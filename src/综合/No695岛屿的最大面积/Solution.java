package 综合.No695岛屿的最大面积;

/**
 * 岛屿系列题目之一
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    // 更新最大面积
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (!inArea(grid, x, y)) {
            return 0;
        }
        // 为海洋或遍历过的陆地的跳过
        if (grid[x][y] != 1) {
            return 0;
        }
        // 标记为遍历过
        grid[x][y] = 2;

        // 最前面的1是当前这块的面积，然后加上上下左右进行递归
        return 1 + dfs(grid, x - 1, y)
                + dfs(grid, x + 1, y)
                + dfs(grid, x, y - 1)
                + dfs(grid, x, y + 1);
    }

    // 和No200一样是判断数组是否越界的方法
    public boolean inArea(int[][] grid, int x, int y) {
        int xlen = grid.length;
        int ylen = grid[0].length;
        if (0 <= x && x < xlen && 0 <= y && y < ylen) {
            return true;
        }
        return false;
    }

}
