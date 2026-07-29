class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> delta = new HashMap<>();

        for (int[] t : trust) {
            delta.merge(t[1], 1, Integer::sum);
            delta.merge(t[0], -1, Integer::sum);
        }

        for (int i = 1; i < n + 1; i++) {
            if (delta.getOrDefault(i, 0) == n - 1)
                return i;
        }

        return -1;
    }
}