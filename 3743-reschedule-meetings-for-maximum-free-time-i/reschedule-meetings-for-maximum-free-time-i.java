class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gapArr = new int[n+1];
        gapArr[0] = startTime[0];
        
        for(int i = 1; i < n; i++){
            gapArr[i] = startTime[i] - endTime[i-1];
        }
        gapArr[n] = eventTime - endTime[n - 1];

        int windowSize = k + 1;

        int currSum = 0;
        for(int i = 0; i < windowSize; i++){
            currSum += gapArr[i];
        }
        int ans = currSum;
        for(int i = windowSize; i <= n; i++){
            currSum += gapArr[i] - gapArr[i - windowSize];

            ans = Math.max(currSum, ans);
        }
        return ans;
    }
}