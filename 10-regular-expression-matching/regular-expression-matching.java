class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()];
        return isMatch(s, p, 0, 0, memo);
    }
    private boolean isMatch(String s, String p, int sIndex, int pIndex, Boolean[][]memo){
        if(sIndex == s.length() && pIndex == p.length()) return true;

        if(pIndex >= p.length()) return false;

        if(memo[sIndex][pIndex] != null) return memo[sIndex][pIndex];

        boolean charactersMatch = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        boolean nextOneStar = pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*';
        final boolean isMatch;
        if(charactersMatch){
            if(nextOneStar){
                isMatch = isMatch(s, p, sIndex, pIndex + 2, memo) || isMatch(s, p, sIndex + 1, pIndex, memo);
            }else{
                isMatch = isMatch(s, p, sIndex + 1, pIndex + 1, memo);
            }
        }else{
            if(nextOneStar){
                isMatch = isMatch(s, p, sIndex, pIndex + 2, memo);
            }else{
                isMatch = false;
            }
        }
        memo[sIndex][pIndex] = isMatch;
        return isMatch;
    }
}