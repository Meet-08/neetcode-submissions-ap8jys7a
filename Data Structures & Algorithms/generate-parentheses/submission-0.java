class Solution {
    List<String> res;

    public Solution() {
        this.res = new ArrayList<>();
    }

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(int n, int openN, int closeN, StringBuilder sb) {
        if (openN == n && closeN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append("(");
            backtrack(n, openN + 1, closeN, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeN < openN) {
            sb.append(")");
            backtrack(n, openN, closeN + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
