class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (i <= j) {
            int m = i + (j - i) / 2;

            if (matrix[m][0] <= target && matrix[m][col] >= target)
                return searchRow(matrix[m], target);

            if (matrix[m][0] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return false;
    }

    public boolean searchRow(int[] row, int target) {
        int i = 0;
        int j = row.length - 1;

        while (i <= j) {
            int m = i + (j - i) / 2;

            if (row[m] == target)
                return true;

            if (row[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return false;
    }
}
