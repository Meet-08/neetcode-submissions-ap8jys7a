class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            if (i != r && board[i][c] == board[r][c])
                return false;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (j != c && board[r][j] == board[r][c])
                return false;
        }

        int sRow = (r / 3) * 3;
        int sCol = (c / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (i == r && j == c)
                    continue;

                if (board[i][j] == board[r][c])
                    return false;
            }
        }

        return true;
    }
}
