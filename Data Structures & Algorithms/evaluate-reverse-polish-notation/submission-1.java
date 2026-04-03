class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(var s : tokens){
            if(isOp(s)){
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(calculate(s, num1, num2));
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    private boolean isOp(String s){
        return s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/");
    }

    private int calculate(String s, int n, int m){
        switch(s){
            case "+":
                return n + m;
            case "-":
                return n - m;
            case "*":
                return n * m;
            case "/":
                return n / m;
        }   
        return -1;
    }
}
