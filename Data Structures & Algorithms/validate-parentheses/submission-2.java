class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!pair.containsKey(c)) {
                st.push(c);
            } else {
                if (st.isEmpty())
                    return false;
                if (st.peek() != pair.get(c))
                    return false;

                st.pop();
            }
        }

        return st.isEmpty();
    }
}
