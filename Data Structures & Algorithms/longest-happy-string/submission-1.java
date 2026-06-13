class Solution {
    private record Pair(Character ch, Integer cnt) {}

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>(Comparator.comparingInt(Pair::cnt).reversed());

        if (a > 0)
            maxHeap.offer(new Pair('a', a));
        if (b > 0)
            maxHeap.offer(new Pair('b', b));
        if (c > 0)
            maxHeap.offer(new Pair('c', c));

        while (maxHeap.size() > 0) {
            Pair p = maxHeap.poll();

            if (res.length() > 1 && res.charAt(res.length() - 1) == p.ch
                && res.charAt(res.length() - 2) == p.ch) {
                if (maxHeap.size() == 0)
                    break;

                Pair p2 = maxHeap.poll();
                res.append(p2.ch);
                int cnt2 = p2.cnt - 1;
                if (cnt2 > 0)
                    maxHeap.offer(new Pair(p2.ch, cnt2));

                maxHeap.offer(p);
            } else {
                res.append(p.ch);
                int cnt = p.cnt - 1;

                if (cnt > 0)
                    maxHeap.offer(new Pair(p.ch, cnt));
            }
        }

        return res.toString();
    }
}