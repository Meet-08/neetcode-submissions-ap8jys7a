class Solution {
    List<List<Integer>> res;
    List<Integer> perm;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        perm = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        dfs(nums, count);

        return res;
    }

    private void dfs(int[] nums, Map<Integer, Integer> count) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (var n : count.keySet()) {
            if (count.get(n) > 0) {
                perm.add(n);
                count.put(n, count.get(n) - 1);

                dfs(nums, count);

                count.put(n, count.get(n) + 1);
                perm.removeLast();
            }
        }
    }
}