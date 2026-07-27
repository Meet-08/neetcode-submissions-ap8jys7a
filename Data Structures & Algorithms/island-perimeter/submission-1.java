class Solution {
    int ROWS, COLS;
    boolean[][] visit;

    public int islandPerimeter(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visit = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1)
                    return dfs(grid, i, j);
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= ROWS || j >= COLS || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }

        if (visit[i][j])
            return 0;

        visit[i][j] = true;
        int perim = dfs(grid, i, j + 1);
        perim += dfs(grid, i, j - 1);
        perim += dfs(grid, i + 1, j);
        perim += dfs(grid, i - 1, j);

        return perim;
    }
}