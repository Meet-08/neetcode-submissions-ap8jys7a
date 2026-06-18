class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);
    }

    private int subsetXORSum(int[] nums, int i, int total) {
        if (i == nums.length)
            return total;

        return subsetXORSum(nums, i + 1, total ^ nums[i]) + subsetXORSum(nums, i + 1, total);
    }
}