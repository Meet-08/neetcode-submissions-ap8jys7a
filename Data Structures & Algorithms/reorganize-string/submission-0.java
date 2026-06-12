class Solution {
    private record Pair(Integer count, Character ch) {}

    public String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);

        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>(Comparator.comparingInt(Pair::count).reversed());

        for (var key : count.keySet()) {
            maxHeap.offer(new Pair(count.get(key), key));
        }

        Pair prev = null;
        StringBuilder res = new StringBuilder();

        while (maxHeap.size() > 0 || prev != null) {
            if (prev != null && maxHeap.size() == 0)
                return "";

            var p = maxHeap.poll();
            res.append(p.ch);
            int cnt = p.count - 1;

            if (prev != null) {
                maxHeap.offer(new Pair(prev.count, prev.ch));
                prev = null;
            }

            if (cnt != 0) {
                prev = new Pair(cnt, p.ch);
            }
        }

        return res.toString();
    }
}