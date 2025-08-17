class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];
        P[0] = 1.0;
        if(k==0){
            return 1.0;
        }
        double currProbabSum = 1.0;

        for (int i = 1; i <= n; i++) {
            P[i] = currProbabSum / maxPts;

            if (i < k) {
                currProbabSum += P[i];
            }

            if (i - maxPts >= 0 && i - maxPts < k) {
                currProbabSum -= P[i - maxPts];
            }
        }

        double result = 0.0;
        for (int i = k; i <= n; i++) {
            result += P[i];
        }
        return result;
    }
}