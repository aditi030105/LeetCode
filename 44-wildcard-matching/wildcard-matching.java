class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i=0;
        int j=0;
        int starIndex=-1;
        int matchIndex=0;
        while(i<n){
            if( j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }
            else if(j<p.length() && p.charAt(j)=='*'){
                starIndex=j;
                matchIndex=i;
                j++;
            }
            else if(starIndex!=-1){
                j=starIndex+1;
                matchIndex++;
                i=matchIndex;
            }
            else return false;
        }

        while(j<m){
            if(p.charAt(j)=='*')j++;
            else return false;
        }
        return true;
    }
}