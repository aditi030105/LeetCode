class Solution {
    public int minMaxDifference(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        char[] maxDigits = digits.clone();
        for (int i = 0; i < maxDigits.length; i++) {
            if (maxDigits[i] != '9') {
                char target = maxDigits[i];
                for (int j = 0; j < maxDigits.length; j++) {
                    if (maxDigits[j] == target) {
                        maxDigits[j] = '9';
                    }
                }
                break;
            }
        }

        char[] minDigits = digits.clone();
        char target = minDigits[0];
        for (int j = 0; j < minDigits.length; j++) {
            if (minDigits[j] == target) {
                minDigits[j] = '0';
            }
        }

        int maxNum = Integer.parseInt(new String(maxDigits));
        int minNum = Integer.parseInt(new String(minDigits));
        return maxNum - minNum;
    }
}
