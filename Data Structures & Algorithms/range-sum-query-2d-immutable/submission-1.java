class NumMatrix {

    Integer rows, cols;
    int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        sumMat = new int[rows + 1][cols + 1];

        for(int r = 1; r <= rows; r++){
            int prefix = 0;
            for(int c = 1; c <= cols; c++){
                prefix += matrix[r - 1][c - 1];
                var above = sumMat[r - 1][c];
                sumMat[r][c] = prefix + above;
            }
        }


    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //OFFSET of 1
        row1++;
        col1++;
        row2++;
        col2++;

        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1 - 1][c2];
        int left = sumMat[row2][c1 - 1];
        int topLeft = sumMat[r1 - 1][c1 - 1];

        return bottomRight - above - left + topLeft;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */