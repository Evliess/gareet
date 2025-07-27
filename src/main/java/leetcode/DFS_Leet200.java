package leetcode;

public class DFS_Leet200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    mark(grid, i, j, row, col);
                }
            }
        }
        return ans;
    }

    public void mark(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col
                || grid[i][j] != '1') return;
        grid[i][j] = '2';
        mark(grid, i - 1, j, row, col);
        mark(grid, i + 1, j, row, col);
        mark(grid, i, j - 1, row, col);
        mark(grid, i, j + 1, row, col);
    }
}
