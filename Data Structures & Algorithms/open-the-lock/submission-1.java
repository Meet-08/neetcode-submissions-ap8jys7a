class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> visit = new HashSet<>(Set.of(deadends));

        if (visit.contains("0000"))
            return -1;

        int turns = 0;
        q.offer("0000");
        visit.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String lock = q.poll();
                if (lock.equals(target))
                    return turns;

                for (var child : children(lock)) {
                    if (visit.contains(child))
                        continue;

                    visit.add(child);
                    q.offer(child);
                }
            }

            turns++;
        }

        return -1;
    }

    private List<String> children(String lock) {
        List<String> result = new ArrayList<>();
        char[] a = lock.toCharArray();

        for (int i = 0; i < a.length; i++) {
            int digit = a[i] - '0';

            // +1
            a[i] = (char) ('0' + (digit + 1) % 10);
            result.add(new String(a));

            // -1
            a[i] = (char) ('0' + (digit + 9) % 10);
            result.add(new String(a));

            // restore
            a[i] = (char) ('0' + digit);
        }

        return result;
    }
}