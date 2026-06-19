class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> subsets(
        int[] nums, int i, List<Integer> temp, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return res;
        }

        temp.add(nums[i]);
        subsets(nums, i + 1, temp, res);
        temp.remove(temp.size() - 1);
        subsets(nums, i + 1, temp, res);

        return res;
    }
}
