class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend > 0) ^ (divisor > 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {
            int shift = 0;
            while (dvd >= (dvs << shift)) {
                shift++;
            }
            shift--;
            quotient += 1 << shift;
            dvd -= dvs << shift;
        }
        return negative ? -quotient : quotient;
    }
}