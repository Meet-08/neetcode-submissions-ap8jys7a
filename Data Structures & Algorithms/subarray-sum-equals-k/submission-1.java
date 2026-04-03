class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> prefix = new HashMap<>();

        prefix.put(0, 1);

        for(int n : nums){
            sum += n;
            int diff = sum - k;

            res += prefix.getOrDefault(diff, 0);
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}