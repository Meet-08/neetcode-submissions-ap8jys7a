class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < n; i++){
            int rem = target - nums[i];

            if(m.containsKey(rem)) return new int[] { m.get(rem), i };

            m.put(nums[i], i);
        }

        return null;
    }
}
