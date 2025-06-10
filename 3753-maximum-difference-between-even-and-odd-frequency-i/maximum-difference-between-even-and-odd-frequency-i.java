class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        int minE = n;
        int maxO = 1;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                continue;
            }else if(freq[i] % 2 == 0){
                minE = Math.min(minE, freq[i]);
            }else{
                maxO = Math.max(maxO, freq[i]);
            }
        }
        return maxO - minE;
    }
}