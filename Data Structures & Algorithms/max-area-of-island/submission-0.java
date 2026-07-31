class Solution {
    int ROWS, COLS;
    boolean[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visit = new boolean[ROWS][COLS];
        int res = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c] || grid[r][c] == 0)
            return 0;

        visit[r][c] = true;
        int res = 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1)
            + dfs(grid, r, c - 1);
        return res;
    }
}
