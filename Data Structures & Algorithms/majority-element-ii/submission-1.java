class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length / 3;
        for (int key : freq.keySet()) {
            if (freq.get(key) > n)
                res.add(key);
        }

        return res;
    }
}