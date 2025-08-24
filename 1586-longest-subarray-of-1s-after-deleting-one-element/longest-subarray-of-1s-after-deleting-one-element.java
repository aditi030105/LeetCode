class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int lastZeroIdx = -1;
        int result = 0;
        
        while (j < nums.length) {
            if (nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            result = Math.max(result, j - i);
            j++;
        }
        
        return result;
    }
}