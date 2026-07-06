class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;

        backtrack(digits, 0, new StringBuilder());

        return res;
    }

    private void backtrack(String digits, int i, StringBuilder curStr) {
        if (curStr.length() == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            curStr.append(c);
            backtrack(digits, i + 1, curStr);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
