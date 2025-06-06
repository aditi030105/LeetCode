class Solution {
    public String shortestPalindrome(String s) {
        int length = s.length();
        if(length == 0) return s;
        int left = 0;
        for(int right = length-1; right >= 0; right--){
            if(s.charAt(left) == s.charAt(right)){
                left++;
            }
        }
        if(left == length) return s;

        String suffix = s.substring(left);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String middle = shortestPalindrome(s.substring(0, left));

        return prefix + middle + suffix;
    }
}