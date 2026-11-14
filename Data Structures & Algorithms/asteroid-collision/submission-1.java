class Solution {
    public int[] asteroidCollision(int[] asts) {
        Stack<Integer> s = new Stack<>();

        for (int ast : asts) {
            boolean isDestroyed = false;

            while (!s.isEmpty() && s.peek() > 0 && ast < 0) {
                int top = s.peek();

                if (top < -ast) {
                    s.pop();
                } else if (top == -ast) {
                    isDestroyed = true;
                    s.pop();
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed)
                s.push(ast);
        }

        return s.stream().mapToInt(e -> e).toArray();
    }
}