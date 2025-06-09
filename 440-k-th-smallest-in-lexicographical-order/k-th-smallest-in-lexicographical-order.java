class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1;

        while(k > 0){
            long count = getCount(curr, n);
            if(count <= k){
                curr += 1;
                k -= count;
            }else{
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }
    long getCount(long curr, int n){
        long next = curr + 1;
        long count = 0;

        while(curr <= n){
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}