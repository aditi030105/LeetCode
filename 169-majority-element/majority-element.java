class Solution {
    public int majorityElement(int[] nums) {
        int majElement = nums[0];
        int count = 0;
        for(int i : nums){
            if(i == majElement){
                count++;
            }else{
                count--;
                if(count == 0){
                    majElement = i;
                    count++;
                }
            }
        }
        return majElement;
    }
}