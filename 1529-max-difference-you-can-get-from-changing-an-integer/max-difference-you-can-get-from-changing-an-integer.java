class Solution {
    public int maxDiff(int num) {
        String original = Integer.toString(num);
        String maxStr = original;
        for(int i = 0; i < maxStr.length(); i++){
            if(maxStr.charAt(i) != '9'){
                maxStr = maxStr.replace(maxStr.charAt(i), '9');
                break;
            }
        }
        String minStr = original;
        char firstChar = minStr.charAt(0);
        if(firstChar != '1'){
            minStr = minStr.replace(firstChar, '1');
        }else{
            for(int i = 1; i < minStr.length(); i++){
                if(minStr.charAt(i) != '0' && minStr.charAt(i) != '1'){
                    minStr = minStr.replace(minStr.charAt(i), '0');
                    break;
                }
            }
        }
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}