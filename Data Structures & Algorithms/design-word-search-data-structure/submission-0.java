class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }

        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        var cur = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (var child : cur.children.values()) {
                    if (dfs(word, i + 1, child))
                        return true;
                }

                return false;
            } else {
                if (!cur.children.containsKey(c))
                    return false;
                cur = cur.children.get(c);
            }
        }

        return cur.endOfWord;
    }
}
