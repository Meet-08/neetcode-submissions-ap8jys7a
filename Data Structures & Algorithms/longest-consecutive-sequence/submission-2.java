class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int n : nums) s.add(n);

        int res = 0;

        for (int n : s) {
            if (!s.contains(n - 1)) {
                int next = n;
                int seq = 0;

                while (s.contains(next)) {
                    next++;
                    seq++;
                }

                res = Math.max(res, seq);
            }
        }

        return res;
    }
}
