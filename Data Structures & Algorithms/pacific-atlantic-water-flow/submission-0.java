class Solution {
    int ROWS, COLS;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, ROWS - 1, c, atl, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, COLS - 1, atl, heights[r][COLS - 1]);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visit, int prevHeight) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visit[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visit[r][c] = true;

        dfs(heights, r + 1, c, visit, heights[r][c]);
        dfs(heights, r - 1, c, visit, heights[r][c]);
        dfs(heights, r, c + 1, visit, heights[r][c]);
        dfs(heights, r, c - 1, visit, heights[r][c]);
    }
}
