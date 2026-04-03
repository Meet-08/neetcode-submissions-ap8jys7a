class NumMatrix {

    private final int[][] mat;

    public NumMatrix(int[][] matrix) {
        this.mat = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowStart = row1;
        int colStart = col1;
        int rowEnd = row2;
        int colEnd = col2;
        int res = 0;

        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j++){
                res += mat[i][j];
            }
        }

        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */