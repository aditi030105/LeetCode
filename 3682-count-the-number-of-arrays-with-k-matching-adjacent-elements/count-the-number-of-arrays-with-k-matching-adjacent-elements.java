class Solution {
    static final int MOD = (int)1e9 + 7;
    static long[] fact, invFact;

    static long qpow(long x, int n) {
        long result = 1;
        x = x % MOD;
        while (n > 0) {
            if ((n & 1) == 1)
                result = (result * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return result;
    }

    static void init(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[n] = qpow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        init(n); // Dynamic size
        long equalPos = comb(n - 1, k);
        long firstSeg = m;
        long remaining = qpow(m - 1, n - k - 1);
        long result = equalPos * firstSeg % MOD * remaining % MOD;
        return (int) result;
    }
}