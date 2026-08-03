class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0], c = node[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] != 1) {
                        continue;
                    }

                    grid[row][col] = 2;
                    fresh--;
                    q.offer(new int[] {row, col});
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
