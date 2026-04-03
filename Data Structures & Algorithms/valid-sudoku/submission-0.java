class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char c = board[i][j];
                String squareKey = (i / 3) + "," + (j / 3);

                //Create empty set if not present
                rows.computeIfAbsent(i , k -> new HashSet<>());
                cols.computeIfAbsent(j , k -> new HashSet<>());
                squares.computeIfAbsent(squareKey, k -> new HashSet<>());

                if(c == '.') continue;
                if(
                    rows.get(i).contains(c) || 
                    cols.get(j).contains(c) ||
                    squares.get(squareKey).contains(c)   
                ) return false;

                rows.get(i).add(c);
                cols.get(j).add(c);
                squares.get(squareKey).add(c);

            }
        }
        return true;
    }
}
