class Solution {
    public int maximumDifference(int[] nums) {
        int small = nums[0];
        int ans = -1;
        for(int i = 1; i < nums.length; i++){
            if(small < nums[i]){
                ans = Math.max(ans, nums[i] - small);
            }else{
                small = nums[i];
            }
        }
        return ans;
    }
}