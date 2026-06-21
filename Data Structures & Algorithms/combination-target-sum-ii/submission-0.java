class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(
        int[] candidates, int target, int i, List<Integer> can, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(can));
            return;
        }

        if (target < 0 || i == candidates.length)
            return;


        can.add(candidates[i]);
        dfs(candidates, target - candidates[i], i + 1, can, res);

        while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]){
            i++;
        }

        can.removeLast();
        dfs(candidates, target, i + 1, can, res);
    }
}
