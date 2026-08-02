class Solution {
    int ROWS;
    int COLS;
    boolean[][] visit;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    visit[i][j] = true;
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0], c = node[1];
                grid[r][c] = dist;

                addRoom(grid, r + 1, c, q);
                addRoom(grid, r - 1, c, q);
                addRoom(grid, r, c + 1, q);
                addRoom(grid, r, c - 1, q);
            }
            dist++;
        }
    }

    private void addRoom(int[][] grid, int r, int c, Queue<int[]> q) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visit[r][c] || grid[r][c] == -1)
            return;

        visit[r][c] = true;
        q.offer(new int[] {r, c});
    }
}
