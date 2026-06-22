class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList(), res);
        return res;
    }

    private void dfs(int n, int k, int i, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i > n)
            return;

        cur.add(i);
        dfs(n, k, i + 1, cur, res);
        cur.removeLast();
        dfs(n, k, i + 1, cur, res);
    }
}