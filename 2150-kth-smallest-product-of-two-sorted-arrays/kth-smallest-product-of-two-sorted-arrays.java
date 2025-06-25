class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -100_000L * 100_000L;
        long high = 100_000L * 100_000L;

        while (low < high) {
            long mid = low + (high - low)/2;
            if(countPairsLessEqual(nums1, nums2, mid) < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private long countPairsLessEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for(int a : nums1){
            if(a > 0){
                int left = 0, right = nums2.length;
                while(left < right){
                    int mid = left + (right - left)/2;
                    if((long)a * nums2[mid] <= target){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                count += left;
            }else if(a < 0){
                int left = 0, right = nums2.length;
                while(left < right){
                    int mid = left + (right - left)/2;
                    if((long)a * nums2[mid] <= target){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                count += nums2.length - left;
            }else{
                if(target >= 0) count += nums2.length;
            }
        }
        return count;
    }
}