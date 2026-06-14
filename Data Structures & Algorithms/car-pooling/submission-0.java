class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int curPass = 0;

        for (int[] t : trips) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= t[1]) {
                curPass -= minHeap.poll()[1];
            }

            curPass += t[0];

            if (curPass > capacity)
                return false;

            minHeap.offer(new int[] {t[2], t[0]});
        }

        return true;
    }
}