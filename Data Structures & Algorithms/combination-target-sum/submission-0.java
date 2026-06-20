class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return combinationSum(nums, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> combinationSum(
        int[] nums, int target, int i, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return res;
        }

        if (target < 0 || i == nums.length)
            return res;

        temp.add(nums[i]);
        combinationSum(nums, target - nums[i], i, temp, res);
        temp.removeLast();
        combinationSum(nums, target, i + 1, temp, res);

        return res;
    }
}
