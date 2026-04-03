class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> st = new Stack<>();

        for(var s : operations){
            if(s.equals("C")){
                st.pop();
            }else if(s.equals("D")){
                st.push(st.peek() * 2);
            }else if(s.equals("+")){
                int num1 = st.pop();
                int num2 = st.peek();

                st.push(num1);
                st.push(num1 + num2);
            }else{
                st.push(Integer.parseInt(s));
            }
        }

        for (int score : st) {
            res += score;
        }

        return res;
    }
}