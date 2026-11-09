class MinStack {
    record Pair(int first, int second) {}

    Stack<Pair> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(new Pair(val, val));
            return;
        }

        int min = Math.min(val, s.peek().second());
        s.push(new Pair(val, min));
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().first();
    }

    public int getMin() {
        return s.peek().second();
    }
}
