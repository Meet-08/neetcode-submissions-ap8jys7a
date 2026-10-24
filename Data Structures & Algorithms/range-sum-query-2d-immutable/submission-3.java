class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length + 1;
        int col = matrix[0].length + 1;

        sum = new int[row][col];

        for (int i = 1; i < row; i++) {
            int prefix = 0;
            for (int j = 1; j < col; j++) {
                prefix += matrix[i - 1][j - 1];
                sum[i][j] = prefix + sum[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1]
            + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */