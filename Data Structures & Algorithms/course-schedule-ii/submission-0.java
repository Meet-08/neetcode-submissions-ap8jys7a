class Solution {
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereq = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new HashSet<>());
        }

        for (int[] p : prerequisites) {
            prereq.get(p[0]).add(p[1]);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prereq, res))
                return new int[] {};
        }

        int[] output = new int[res.size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = res.get(i);
        }

        return output;
    }

    private boolean dfs(int crs, Map<Integer, Set<Integer>> prereq, List<Integer> res) {
        if (cycle.contains(crs))
            return false;

        if (visit.contains(crs))
            return true;

        cycle.add(crs);

        for (int pre : prereq.get(crs)) {
            if (!dfs(pre, prereq, res)) {
                return false;
            }
        }

        cycle.remove(crs);
        visit.add(crs);
        res.add(crs);

        return true;
    }
}
