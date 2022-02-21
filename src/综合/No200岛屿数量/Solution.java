package 综合.No200岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 遍历这个网格，遇到陆地才进入dfs
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    // 深度优先遍历
    public void dfs(char[][] grid, int x, int y) {
        if (!inArea(grid, x, y)) {
            return;
        }
        if (grid[x][y] != '1') {
            return;
        }
        // 搜索过的要置为2，避免重复遍历
        grid[x][y] = '2';

        // 上下左右四个方向递归
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

    // 用来判断数组是否越界
    public boolean inArea(char[][] grid, int x, int y) {
        int xlen = grid.length;
        int ylen = grid[0].length;
        if (0 <= x && x < xlen && 0 <= y && y < ylen) {
            return true;
        }
        return false;
    }
}
