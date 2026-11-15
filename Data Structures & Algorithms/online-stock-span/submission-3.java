class StockSpanner {
    record Entry(Integer val, Integer span) {}

    Stack<Entry> s;

    public StockSpanner() {
        s = new Stack<>();
    }

    public int next(int price) {
        int res = 1;

        while (!s.isEmpty() && price >= s.peek().val()) {
            res += s.pop().span();
        }

        s.push(new Entry(price, res));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */