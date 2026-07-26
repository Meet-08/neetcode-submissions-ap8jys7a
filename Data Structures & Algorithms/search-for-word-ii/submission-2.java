class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }

    void addWord(String word) {
        var cur = this;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }
}

class Solution {
    int ROWS, COLS;
    List<String> res = new ArrayList<>();
    boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            root.addWord(w);
        }

        ROWS = board.length;
        COLS = board[0].length;
        visit = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(board, i, j, root, new StringBuilder());
            }
        }

        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, StringBuilder word) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || visit[r][c]
            || !node.children.containsKey(board[r][c]))
            return;

        visit[r][c] = true;

        node = node.children.get(board[r][c]);
        word.append(board[r][c]);

        if (node.endOfWord) {
            res.add(word.toString());
            node.endOfWord = false;
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
        word.deleteCharAt(word.length() - 1);
    }
}
