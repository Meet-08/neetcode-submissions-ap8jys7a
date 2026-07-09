class Solution {
    private boolean[] used;
    private int target;
    private int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0)
            return false;

        target = sum / k;
        used = new boolean[nums.length];

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return backtrack(nums, k, 0, 0);
    }

    private boolean backtrack(int[] nums, int k, int currSum, int i) {
        if (k == 0)
            return true;

        if (currSum == target)
            return backtrack(nums, k - 1, 0, 0);

        for (int j = i; j < nums.length; j++) {
            if (used[j] || currSum + nums[j] > target)
                continue;
            used[j] = true;
            if (backtrack(nums, k, currSum + nums[j], j + 1))
                return true;
            used[j] = false;
        }

        return false;
    }
}
