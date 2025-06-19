class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int subsequence = 1;
        int min_val = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - min_val > k){
                min_val = nums[i];
                subsequence++;
            }
        }
        return subsequence;
    }
}