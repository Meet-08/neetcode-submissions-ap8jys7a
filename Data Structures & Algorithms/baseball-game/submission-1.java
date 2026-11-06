class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> score = new Stack<>();

        for (String s : operations) {
            switch (s) {
                case "+":
                    int last = score.pop();
                    int second = score.peek();
                    int newScore = second + last;
                    score.push(last);
                    score.push(newScore);
                    break;
                case "D":
                    int top = score.peek();
                    score.push(2 * top);
                    break;
                case "C":
                    score.pop();
                    break;
                default:
                    score.push(Integer.parseInt(s));
            }
        }

        int res = 0;

        while (!score.isEmpty()) {
            res += score.pop();
        }

        return res;
    }
}