class Solution {
    static final int MOD = (int)1e9 + 7;
    static final int MX = 100000;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static{
        fact[0] = 1;
        for(int i = 1; i < MX; i++){
            fact[i] = (fact[i-1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX-1], MOD-2);
        for(int i = MX - 1; i > 0; i--){
            invFact[i-1] = (invFact[i] * i) % MOD;
        }
    }

    static long qpow(long x, int n){
        if(n == 0) return 1;
        long half = qpow(x, n/2);
        long result = (half * half) % MOD;
        if(n%2 == 1){
            result = (result * x) % MOD;
        }
        return result;
    }

    long comb(int n, int r){
        return(((fact[n] * invFact[r]) % MOD) * invFact[n-r]) %MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        long waysToChooseEqualPositions = comb(n-1, k);
        long firstSegmentChoices = m;
        long remainingSegmentChoices = qpow(m-1, n-k-1);
        long result = (waysToChooseEqualPositions * firstSegmentChoices) % MOD;
        result = (result * remainingSegmentChoices) % MOD;
        return (int)result;
    }
}