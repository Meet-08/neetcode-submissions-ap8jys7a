class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();

        int res = 0;
        int sum = 0;

        prefix.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += prefix.getOrDefault(sum - k, 0);
            prefix.merge(sum, 1, Integer::sum);
        }

        return res;
    }
}