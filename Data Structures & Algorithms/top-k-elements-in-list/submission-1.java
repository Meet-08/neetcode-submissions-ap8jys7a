class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        int[] res = new int[k];

        for (int n : nums) m.merge(n, 1, Integer::sum);

        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        for (int key : m.keySet()) {
            int f = m.get(key);

            freq.get(f).add(key);
        }

        int idx = 0;

        for (int i = freq.size() - 1; i >= 0; i--) {
            for (int n : freq.get(i)) {
                res[idx++] = n;

                if (idx == k)
                    return res;
            }
        }

        return res;
    }
}
