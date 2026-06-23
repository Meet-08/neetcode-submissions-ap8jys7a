class Solution {
    private List<List<Integer>> res;
    private List<Integer> perm;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        perm = new ArrayList<>();

        backtrack(nums, new boolean[nums.length]);

        return res;
    }

    private void backtrack(int[] nums, boolean[] isUsed) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i])
                continue;

            isUsed[i] = true;
            perm.add(nums[i]);
            backtrack(nums, isUsed);
            perm.removeLast();
            isUsed[i] = false;
        }
    }
}
