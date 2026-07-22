class Solution {
    private List<String> res = new ArrayList<>();
    private List<String> cur = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, new HashSet<>(wordDict), 0);
        return res;
    }

    private void backtrack(String s, Set<String> wordDict, int i) {
        if (i == s.length()) {
            res.add(String.join(" ", cur));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);

            if (wordDict.contains(w)) {
                cur.add(w);
                backtrack(s, wordDict, j + 1);
                cur.removeLast();
            }
        }
    }
}