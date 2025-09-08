class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n;
        int b = 0;
        int placeValue = 1;

        while (n > 1) {
            int adjust = 1;

            if (n % 10 == 1) {
                adjust = 2;
            }

            a -= adjust * placeValue;
            b += adjust * placeValue;

            n = (n - adjust) / 10;
            placeValue *= 10;
        }

        return new int[]{a, b};
    }
}