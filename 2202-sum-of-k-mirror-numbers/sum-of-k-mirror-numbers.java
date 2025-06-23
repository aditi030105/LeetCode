class Solution {
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    private String convertToBaseK(long num, int k){
        if(num == 0) return "0";
        StringBuilder res = new StringBuilder();
        while(num > 0){
            res.append(num % k);
            num /= k;
        }
        return res.toString();
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int length = 1;
        while(n > 0){
            int halfLength = (length + 1) / 2;
            long minNum = (long)Math.pow(10, halfLength - 1);
            long maxNum = (long)Math.pow(10, halfLength) - 1;

            for(long num = minNum; num <= maxNum; num++){
                String firstHalf = Long.toString(num);
                String secondHalf = new StringBuilder(firstHalf).reverse().toString();
                String fullPalindrome = (length % 2 == 0) ?
                    firstHalf + secondHalf :
                    firstHalf + secondHalf.substring(1);

                if(fullPalindrome.length() > 18 || 
                   (fullPalindrome.length() == 18 && fullPalindrome.compareTo("9223372036854775807") > 0)) {
                    continue;
                }

                long palNum = Long.parseLong(fullPalindrome);
                String baseK = convertToBaseK(palNum, k);

                if(isPalindrome(baseK)){
                    sum += palNum;
                    n--;
                    if(n == 0){
                        return sum;
                    }
                }
            }
            length++;
        }
        return sum;
    }
}
