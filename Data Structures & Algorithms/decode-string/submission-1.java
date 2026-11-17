class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder curStr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                stringStack.push(curStr);
                curStr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int times = counts.pop();
                StringBuilder decoded = stringStack.pop();
                decoded.append(curStr.toString().repeat(times));
                curStr = decoded;
            } else {
                curStr.append(c);
            }
        }

        return curStr.toString();
    }
}