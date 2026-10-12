class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (m.containsKey(remaining))
                return new int[] {m.get(remaining), i};

            m.put(nums[i], i);
        }

        return null;
    }
}
