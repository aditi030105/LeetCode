class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int val = arr[i] & 65535;
            if (val >= 1 && val <= n) {
                arr[val - 1] += (1 << 16);
            }
        }
        for (int val = n; val >= 1; val--) {
            if ((arr[val - 1] >> 16) == val) {
                return val;
            }
        }
        return -1;
    }
}