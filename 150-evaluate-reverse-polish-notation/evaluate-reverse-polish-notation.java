class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    int b = st.pop(), a = st.pop();
                    st.push(a - b);
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    int d2 = st.pop(), d1 = st.pop();
                    st.push(d1 / d2);
                    break;
                default:
                    st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}