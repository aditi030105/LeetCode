class Solution {
    char[] arr;
    int index = 0;

    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        int sum = 0, operator = 1;

        while (index < arr.length) {
            char c = arr[index];

            if (c == ' ') {
                index++;
            } else if (c == '+') {
                operator = 1;
                index++;
            } else if (c == '-') {
                operator = -1;
                index++;
            } else if (c == '(') {
                index++; // move past '('
                sum += operator * dfs();
            } else if (c == ')') {
                index++; // move past ')'
                return sum;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (index < arr.length && Character.isDigit(arr[index])) {
                    num = num * 10 + (arr[index] - '0');
                    index++;
                }
                sum += operator * num;
            } else {
                index++;
            }
        }

        return sum;
    }
}
