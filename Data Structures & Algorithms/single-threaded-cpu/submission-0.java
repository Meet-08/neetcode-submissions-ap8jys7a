class Solution {
    private record Task(Integer eT, Integer pT, Integer idx) {}

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] ts = new Task[n];

        for (int i = 0; i < n; i++) {
            ts[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(ts, Comparator.comparingInt(Task::eT));

        int[] res = new int[n];
        PriorityQueue<Task> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Task::pT).thenComparingInt(Task::idx));

        int i = 0, k = 0;
        long time = ts[0].eT;

        while (!minHeap.isEmpty() || i < n) {
            while (i < n && time >= ts[i].eT()) {
                minHeap.offer(ts[i]);
                i++;
            }

            if (minHeap.isEmpty()) {
                time = ts[i].eT();
            } else {
                Task t = minHeap.poll();
                time += t.pT();
                res[k++] = t.idx();
            }
        }

        return res;
    }
}