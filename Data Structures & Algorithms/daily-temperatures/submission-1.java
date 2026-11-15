class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (!s.isEmpty() && temps[i] > temps[s.peek()]) {
                int idx = s.pop();
                res[idx] = i - idx;
            }
            s.push(i);
        }

        return res;
    }
}
