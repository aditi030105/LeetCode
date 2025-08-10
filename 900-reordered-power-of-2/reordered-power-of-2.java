class Solution {
    private int[] getCountVector(int n) {
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return count;
    }

    public boolean reorderedPowerOf2(int n) {
        int[] inputCount = getCountVector(n);

        for (int p = 0; p <= 29; p++) {
            if (Arrays.equals(inputCount, getCountVector(1 << p))) {
                return true;
            }
        }

        return false;
    }
}