class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie(String[] words) {
        root = new TrieNode();
        for (var w : words) {
            var cur = root;
            for (var c : w.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }

                cur = cur.children.get(c);
            }
            cur.endOfWord = true;
        }
    }
}

class Solution {
    Map<Integer, Integer> dp = new HashMap<>();

    public int minExtraChar(String s, String[] dictionary) {
        dp.put(s.length(), 0);
        TrieNode trieRoot = new Trie(dictionary).root;
        return dfs(s, trieRoot, 0);
    }

    private int dfs(String s, TrieNode root, int i) {
        if (dp.containsKey(i))
            return dp.get(i);

        int res = 1 + dfs(s, root, i + 1);
        TrieNode cur = root;

        for (int j = i; j < s.length(); j++) {
            if (!cur.children.containsKey(s.charAt(j)))
                break;
            cur = cur.children.get(s.charAt(j));
            if (cur.endOfWord)
                res = Math.min(res, dfs(s, root, j + 1));
        }

        dp.put(i, res);
        return res;
    }
}