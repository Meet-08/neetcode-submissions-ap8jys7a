class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> countGroups;
    int maxCount;

    public FreqStack() {
        freq = new HashMap<>();
        countGroups = new HashMap<>();
        maxCount = 0;
    }

    public void push(int val) {
        int count = freq.getOrDefault(val, 0) + 1;
        freq.put(val, count);
        maxCount = Math.max(count, maxCount);
        countGroups.computeIfAbsent(count, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        Deque<Integer> group = countGroups.get(maxCount);
        int val = group.pop();
        freq.put(val, freq.get(val) - 1);
        if (group.isEmpty()) {
            countGroups.remove(maxCount);
            maxCount--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */