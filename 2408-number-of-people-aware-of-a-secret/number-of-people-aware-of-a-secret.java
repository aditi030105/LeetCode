class Solution {
    int MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] t = new int[n + 1];
        t[1] = 1;
        long count = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay > 0) {
                count = (count + t[day - delay]) % MOD;
            }
            if (day - forget > 0) {
                count = (count - t[day - forget] + MOD) % MOD;
            }
            t[day] = (int) count;
        }

        int result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                result = (result + t[day]) % MOD;
            }
        }
        return result;
    }
}