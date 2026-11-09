class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> s = new Stack<>();

        for (String st : tokens) {
            if (st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(compute(op1, op2, st));
            } else {
                s.push(Integer.parseInt(st));
            }
        }

        return s.pop();
    }

    private int compute(int op1, int op2, String operand) {
        switch (operand) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
        }

        return 0;
    }
}
