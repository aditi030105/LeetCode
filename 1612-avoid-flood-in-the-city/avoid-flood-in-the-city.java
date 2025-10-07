class Solution {
    public int[] avoidFlood(int[] rains) {
        int N = rains.length;
        int[] ans = new int[N];

        Map<Integer, Integer> fullMap = new HashMap<>();

        TreeSet<Integer> zeroSet = new TreeSet<>();
        for ( int ii = 0; ii < N; ii++ ) {
            int lake = rains[ii];
            if ( lake == 0 ) {
                zeroSet.add(ii);
                ans[ii] = 1;
            }
            else {
                ans[ii] = -1;

                Integer idx = fullMap.get(lake);
                if ( idx != null ) {
                    Integer zeroIdx = zeroSet.ceiling(idx);
                    if ( zeroIdx == null ) return new int[0];
                    zeroSet.remove(zeroIdx);
                    ans[zeroIdx] = lake;
                }
                fullMap.put(lake, ii);
            }
        }

        return ans;
    }
}