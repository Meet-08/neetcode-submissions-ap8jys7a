class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for(int n : nums){
            maxHeap.offer(n);
        }

        while(k > 1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.poll();
    }
}
